package com.mshelper.dms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mshelper.dms.dao.SysRoleMapper;
import com.mshelper.dms.po.SysRole;
import com.mshelper.dms.service.SysRoleService;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mshelper.dms.dao.SysRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @author Bellamy
 */
@Service
@Transactional
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> findAllRoles() {

        SelectStatementProvider render = select(roleId, roleDesc, roleName, roleFlag)
                .from(sysRole)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<SysRole> list = roleMapper.selectMany(render);
        return list;
    }

    @Override
    public PageInfo<SysRole> findRoles(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        SelectStatementProvider render = select(roleId, roleDesc, roleName, roleFlag)
                .from(sysRole)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<SysRole> list = roleMapper.selectMany(render);
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public SysRole findRoleById(long roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void saveOrUpdate(SysRole role) {

        if (role.getRoleId() == null) {
            roleMapper.insert(role);
        } else {
            roleMapper.updateByPrimaryKeySelective(role);
        }
    }

    @Override
    public void deleteRoleById(long roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
    }
}
