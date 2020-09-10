package com.mshelper.dms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mshelper.dms.dao.SysUserMapper;
import com.mshelper.dms.exception.UserException;
import com.mshelper.dms.po.SysUser;
import com.mshelper.dms.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mshelper.dms.dao.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;


/**
 * @author Bellamy
 */

@Service
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SysUser login(String username, String password) {
        return null;
    }

    @Override
    public SysUser findUserById(long userId) {

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public PageInfo<SysUser> findUsers(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider select = select(usrId, usrName, usrPassword, usrRoleId, usrRoleName, usrFlag)
                .from(sysUser)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<SysUser> list = userMapper.selectMany(select);
        return new PageInfo<>(list);
    }

    @Override
    public List<SysUser> findAllUsers() {

        SelectStatementProvider selectStatement =
                select(usrId, usrFlag, usrName, usrPassword, usrRoleId, usrRoleName)
                        .from(sysUser)
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        List<SysUser> users = userMapper.selectMany(selectStatement);
        return users;
    }

    @Override
    public List<SysUser> findUsersByRoleId(long roleId) {
        SelectStatementProvider select = select(usrId, usrName, usrPassword, usrRoleId, usrRoleName, usrFlag)
                .from(sysUser)
                .where(usrRoleId, isEqualTo(roleId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return userMapper.selectMany(select);
    }

    @Override
    public PageInfo<SysUser> findUsersByRoleId(long roleId, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider select = select(usrId, usrName, usrPassword, usrRoleId, usrRoleName, usrFlag)
                .from(sysUser)
                .where(usrRoleId, isEqualTo(roleId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<SysUser> list = userMapper.selectMany(select);
        PageInfo<SysUser> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    @Override
    public void saveOrUpdate(SysUser user) throws UserException {

        if (user.getUsrId() == null) {
            SysUser u = findUserByName(user.getUsrName());
            if(u != null){
                throw new UserException("用户名已存在");
            }
            user.setUsrPassword(passwordEncoder.encode(user.getUsrPassword()));
            user.setUsrFlag(1);
            user.setUsrRoleId(2L);
            user.setUsrRoleName("normal");
            userMapper.insert(user);
        } else {
            if(StringUtils.isNotBlank(user.getUsrPassword())){
                user.setUsrPassword(passwordEncoder.encode(user.getUsrPassword()));
            }
            userMapper.updateByPrimaryKeySelective(user);
        }

    }

    @Override
    public void deleteUserById(long userId) {

        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser findUserByName(String username){
        SelectStatementProvider select = select(usrId, usrName, usrPassword, usrRoleId, usrRoleName, usrFlag)
                .from(sysUser)
                .where(usrName, isEqualTo(username))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        SysUser sysUser = userMapper.selectOne(select);
        return  sysUser;
    }
}