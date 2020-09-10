package com.mshelper.dms.controller;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.po.SysRole;
import com.mshelper.dms.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/role")
@Api(tags = "用户角色接口")
public class RoleController {

    @Autowired
    private SysRoleService roleService;

    @RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户角色")
    public List<SysRole> getAllRoles(){
        return roleService.findAllRoles();
    }

    @RequestMapping(value = "/getRoles/{pageNum}/{pageSize}}", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取所有用户角色")
    public PageInfo<SysRole> getRoles(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        return roleService.findRoles(pageNum, pageSize);
    }

    @RequestMapping(value = "/getRoleById/{roleId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据id获取用户角色")
    public SysRole getRoleById(@PathVariable Long roleId){

        SysRole role = roleService.findRoleById(roleId);
        return role;
    }

    @RequestMapping(value = "/removeRoleById", method = RequestMethod.DELETE)
    @ApiOperation( value = "根据id删除角色")
    public String removeRoleById(@RequestParam Long roleId){
        roleService.deleteRoleById(roleId);
        return "删除成功";
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ApiOperation(value = "新增或更新一个用户角色")
    public String saveOrUpdate(SysRole role){
        roleService.saveOrUpdate(role);
        return "操作成功";
    }


}
