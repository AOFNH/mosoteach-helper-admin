package com.mshelper.dms.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Bellamy
 *
 * 当其他请求发送来，校验token的过滤器，如果校验成功，就让请求继续执行
 *
 * 类似于 filter。JwtTokenFilter
 *
 */
public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException
    {
        System.out.println(3);

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String jwtToken = req.getHeader("authorization");
        System.out.println(jwtToken);
//        Claims claims = Jwts.parser().setSigningKey("sang@123")
//                .parseClaimsJws(jwtToken.replace("Bearer", ""))
//                .getBody();
//        String username = claims.getSubject();
//        //获取当前登录用户名
//        List<GrantedAuthority> authorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
//        UsernamePasswordAuthenticationToken token
//                = new UsernamePasswordAuthenticationToken(username, null, authorities);
//        SecurityContextHolder.getContext().setAuthentication(token);
        filterChain.doFilter(req, servletResponse);

    }

}
