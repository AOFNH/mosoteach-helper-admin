package com.mshelper.dms.controller;

import com.github.pagehelper.PageInfo;
import com.mshelper.dms.exception.UserException;
import com.mshelper.dms.po.SysUser;
import com.mshelper.dms.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bellamy
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {

    @Autowired
    private SysUserService userService;


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ApiOperation(value = "用户登录")
//    public Message<String> login(SysUser user){
//
//        return MessageUtil.success("succ");
//
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册")
    public String register(SysUser user){

        try {
            userService.saveOrUpdate(user);
            return "注册成功";
        } catch (UserException e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户信息")
    public String updateUserInfo(SysUser user){

        try {
            userService.saveOrUpdate(user);
            return "更新成功";
        } catch (UserException e) {
            return e.getMessage();
        }

    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有用户")
    public List<SysUser> getAllUsers(){

        List<SysUser> allUser = userService.findAllUsers();
        return allUser;
    }

    @RequestMapping(value = "/getUsers/{pageNum}/{pageSize}}", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询用户")
    public PageInfo<SysUser> getUsers(@PathVariable Integer pageNum, @PathVariable Integer pageSize){

        PageInfo<SysUser> pageInfo = userService.findUsers(pageNum, pageSize);
        return pageInfo;
    }

    @RequestMapping(value = "/getUsersByRoleId/{roleId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据角色Id查询所有用户")
    public List<SysUser> getUsersByRoleId(@PathVariable Long roleId){
        List<SysUser> list = userService.findUsersByRoleId(roleId);
        return list;
    }

    @RequestMapping(value = "/getUsersByRoleId/{roleId}/{pageNum}/{pageSize}", method = RequestMethod.GET)
    @ApiOperation(value = "根据角色id分页查询用户")
    public PageInfo<SysUser> getUsersByRoleId(@PathVariable Long roleId, @PathVariable Integer pageNum, @PathVariable Integer pageSize){
        PageInfo<SysUser> pageInfo = userService.findUsersByRoleId(roleId, pageNum, pageSize);
        return pageInfo;
    }


    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ApiOperation(value = "根据id查询")
    public SysUser getUserById(long userId){

        SysUser user = userService.findUserById(userId);
        return user;
    }

    @RequestMapping(value = "/removeUserById", method = RequestMethod.DELETE)
    @ApiOperation(value = "根据用户id删除用户")
    public String removeUserById(@RequestParam Long userId){

        userService.deleteUserById(userId);
        return "操作成功";
    }





}
