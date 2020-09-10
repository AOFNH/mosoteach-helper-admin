package com.mshelper.dms.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mshelper.dms.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bellamy
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Qualifier("UserDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailService;	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		response.setContentType("application/json;charset=UTF-8");
		try {
			//User  UserDetails 的子类
			User user = (UserInfo)userDetailService.loadUserByUsername(authentication.getName());
			//调用jwtTokenUtils 构建Token
			String token = JwtTokenUtils.TOKEN_PREFIX+JwtTokenUtils.createToken(user, true);
			System.out.println(token);
			
			//重定向
			response.setHeader(JwtTokenUtils.TOKEN_HEADER, token);
			response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.success(token)));
//			response.sendRedirect("/swagger-ui.html");
		} catch (Exception e) {
			response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401, "传Token 失败，请与管理员联系")));
		}
		
	}

}
