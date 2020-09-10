package com.mshelper.dms.controller;

import com.mshelper.dms.util.Message;
import com.mshelper.dms.util.MessageUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *	发送请求，如果token为空，跳转到这个controller
 * @author Bellamy
 */
@RestController
@RequestMapping("/authentication")
@ApiIgnore
public class SecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    /**
     * 当需要身份认证时，跳转到这里
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Message<String> requireAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        System.out.println(savedRequest);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                //  跳转到登陆页面
                redirectStrategy.sendRedirect(request, response, "/login.html");
            }
        }
        return MessageUtil.error(401,"访问的服务需要身份认证，请引导用户到登录页");
    }
    
}
