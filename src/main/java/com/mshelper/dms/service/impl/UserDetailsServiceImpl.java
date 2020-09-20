package com.mshelper.dms.service.impl;

import com.mshelper.dms.dto.UserInfo;
import com.mshelper.dms.po.SysRole;
import com.mshelper.dms.po.SysUser;
import com.mshelper.dms.service.SysRoleService;
import com.mshelper.dms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 使用spring security完成自定义登录验证(自定义实现细节)
 */
@Service("UserDetailsServiceImpl")
//该实现类是实现 security 提供的接口 org.springframework.security.core.userdetails.UserDetailsService;
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    //密码加密
    @Autowired
    private PasswordEncoder passwordEncoder;

    //用户名不重复
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户
        SysUser user = null;
        user = userService.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Not user found with ", username));
        }
        String password = user.getUsrPassword();
        /*
         * org.springframework.security.core.userdetails.User;
         * 该类实现了 UserDetails
         */
        SysRole role = roleService.findRoleById(user.getUsrRoleId());
        UserInfo u = new UserInfo(username,
                //passwordEncoder.encode(password),
                //db 中已加密
                password,
                AuthorityUtils.commaSeparatedStringToAuthorityList(role.getRoleName()),
                user.getUsrId(),
                user.getUsrRoleId(),
                user.getUsrFlag()
        );
        return u;
    }

}
