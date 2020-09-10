package com.mshelper.dms.controller;

import com.mshelper.dms.util.JwtTokenUtils;
import com.mshelper.dms.util.Message;
import com.mshelper.dms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Bellamy
 */
@RestController
@Api(tags="登录验证相关接口")
//@RequestMapping("/authentication")
public class LoginController {

	@Autowired
	@Qualifier("UserDetailsServiceImpl")
	private UserDetailsService userDetailsService;


	@PostMapping("/login")
	@ApiOperation("登录操作")
	public void login(String username, String password) {
		//没有任何方法
	}

	@GetMapping("/getUserDetailByToken")
	@ApiOperation(value = "根据token得到用户信息")
	public Message getUserDetailByToken(HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
		response.setContentType("application/json;charset=UTF-8");
		if (token != null && StringUtils.startsWith(token, JwtTokenUtils.TOKEN_PREFIX)) {
			token = StringUtils.substring(token, JwtTokenUtils.TOKEN_PREFIX.length());
			UserDetails details = null;
			try {
				details = userDetailsService.loadUserByUsername(JwtTokenUtils.getUsername(token));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return MessageUtil.success(details);
		} else {
			return MessageUtil.error(401, "token失效");
		}
	}

}
