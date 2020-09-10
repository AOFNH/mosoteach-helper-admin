package com.mshelper.dms.service;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.po.SysRole;

import java.util.List;


/**
 * @author Bellamy
 */
public interface SysRoleService {

    List<SysRole> findAllRoles();

    PageInfo<SysRole> findRoles(int pageNum, int pageSize);

    SysRole findRoleById(long roleId);

    void saveOrUpdate(SysRole role);

    void deleteRoleById(long roleId);
}
