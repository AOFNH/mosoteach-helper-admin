package com.mshelper.dms.filter;

import com.mshelper.dms.util.JwtTokenUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token过滤器，用来验证token的有效性
 *
 * @author Bellamy
 */
public class JwtTokenFilter extends OncePerRequestFilter{
	
	private static final Logger log = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
	@Qualifier("UserDetailsServiceImpl")
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
		if(token != null && StringUtils.startsWith(token, JwtTokenUtils.TOKEN_PREFIX)) {
			token = StringUtils.substring(token, JwtTokenUtils.TOKEN_PREFIX.length());
		} else {
			filterChain.doFilter(request, response);
			return;
		}
		
		try {
			String username = JwtTokenUtils.getUsername(token);
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				if (JwtTokenUtils.validateToken(token, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetails(request));

					logger.info(String.format("Authenticated userDetail %s, setting security context", username));

					SecurityContextHolder.getContext().setAuthentication(authentication);
				}

			}
		} catch (Exception e) {
			response.getWriter().write("token :" + e.getMessage());
			return;
		}
		
		filterChain.doFilter(request, response);
	}
	
}
