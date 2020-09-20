package com.mshelper.dms.config;

import com.mshelper.dms.filter.JwtTokenFilter;
import com.mshelper.dms.util.LoginFailHandler;
import com.mshelper.dms.util.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
 * spring security 的 配置类
 * 想 IOC 中注册security 需要用到的对象
 * 没有该类security 不能正常运行
 */

/**
 * @author Bellamy
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("UserDetailsServiceImpl")
    private UserDetailsService userDetailService;

    /**
     * 密码加密算法
     *
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtTokenFilter getauthenticationTokenFilterBean() {
        return new JwtTokenFilter();
    }

    @Bean
    public LoginSuccessHandler getLoginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LoginFailHandler getLoginFailHandler() {
        return new LoginFailHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
//                .loginPage("/authentication/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl("/authentication/form")
//                .defaultSuccessUrl("/swagger-ui.html")
                .successHandler(getLoginSuccessHandler())
                .failureHandler(getLoginFailHandler())
                .and()
                //使用jwt，不需要csrf
                .csrf().disable()
                //基于token，不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 设置允许访问的资源
                .antMatchers("/authentication/login", "/authentication/form", "/login").permitAll()
                // 设置允许访问的资源
                .antMatchers("/webjars/**").permitAll()
                .antMatchers(
                        "/v2/api-docs",
                        "/swagger-resources",
                        "/swagger-resources/**",
                        "/configuration/ui",
                        "/configuration/security",
                        "/swagger-ui.html/**",
                        "/webjars/**"
                ).permitAll()

                .antMatchers("/index/**").permitAll()
                //可对外暴露的API
                .antMatchers(
                        "/hits/**",
                        "/user/login",
                        "/user/register"
                ).permitAll()
                //需要admin角色（或者：admin权限 ）才可访问的API
                .antMatchers(
                        "/function/**",
                        "/role/**",
                        "/user/getAllUsers",
                        "/user/getUserById/**",
                        "/user/getUsers/**",
                        "/user/getUsersByRoleId/**",
                        "/user/removeUserById",
                        "/user/updateUserInfo"
                ).hasAnyAuthority("admin")
                // 所有请求都需要认证
                .anyRequest().authenticated();

//        http.authorizeRequests()
//                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
        http.headers().cacheControl();

        // 添加JWT filter
        http.addFilterBefore(getauthenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

    }


}
