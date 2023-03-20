package com.final_back.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.*;
import com.final_back.mapper.system.PrivilegeTableMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.service.system.*;
import com.final_back.utils.common.TokenUtil;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserBasicInfoController {

    @Autowired
    UserBasicInfoService userBasicInfoService;
    @Autowired
    UserPasswordInfoService userPasswordInfoService;
    @Autowired
    RoleTableService roleTableService;
    @Autowired
    RolePriService rolePriService;
    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    PrivilegeTableService privilegeTableService;
    @Autowired
    PrivilegeTableMapper privilegeTableMapper;


    /**
     * 添加用户
     *
     * @param userBasicInfoDTO
     * @return
     */
    @RequestMapping("/addUser")
    public Result<?> addUser(@RequestBody UserBasicInfoDTO userBasicInfoDTO) {

        int basicInfoInsert = userBasicInfoService.addUser(userBasicInfoDTO);

        UserPasswordInfo userPasswordInfo = new UserPasswordInfo();
        userPasswordInfo.setUserBasicInfoId(userBasicInfoDTO.getUserBasicInfoId());
        userPasswordInfo.setPassword(userBasicInfoDTO.getPassword());
        userPasswordInfo.setUserName(userBasicInfoDTO.getUserName());
        int userPasswordInsert = userPasswordInfoService.addUserPasswordInfo(userPasswordInfo);

        if (basicInfoInsert > 0 && userPasswordInsert > 0) {
            return ResultUtil.success("输入成功");
        } else {
            return ResultUtil.success("输入失败");
        }
    }

    /**
     * 取得所有用户信息
     *
     * @return
     */
    @RequestMapping("/getAllPerson")
    public Result<?> getAllPerson() {
        List<UserBasicInfoDTO> userBasicInfoDTOList = userBasicInfoService.getAllUserAllInfo();
        return ResultUtil.success(userBasicInfoDTOList);
    }

    /**
     * 删除用户基本信息
     *
     * @param userBasicInfo
     * @return
     */
    @RequestMapping("/deleteUserBasicInfo")
    public Result<?> deleteUserBasicInfo(@RequestBody UserBasicInfo userBasicInfo) {
        int i = userBasicInfoService.deleteUserBasicInfoById(userBasicInfo.getUserBasicInfoId());
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新用户基本信息
     *
     * @param userBasicInfo
     * @return
     */
    @RequestMapping("/updateUserBasicInfo")
    public Result<?> updateUserBasicInfo(@RequestBody UserBasicInfo userBasicInfo) {
        int i = userBasicInfoService.updateUserBasicInfo(userBasicInfo);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 通过角色、空闲时间寻找用户
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/queryUserByCondition")
    public Result<?> queryUserByCondition(@RequestBody JSONObject jsonObject) {
        return null;
    }

    /**
     * 改变用户状态（启用或禁用）
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/changeUserState")
    public Result<?> changeUserState(@RequestBody JSONObject jsonObject) {
        return null;
    }


    @RequestMapping("/getUserInfo")
    public Result<?> getUserInfo(@RequestBody UserBasicInfoDTO userBasicInfoDTO) {
        //先通过token，获取到对应的user
        System.out.println(userBasicInfoDTO);
        UserBasicInfo user = TokenUtil.getUser(userBasicInfoDTO.getToken());
        Long id = user.getUserBasicInfoId();
        //需要获取的数据：roleId，privileges，role，userbasicinfo
        Map<String, Object> map = new HashMap<>();

        //userBasicInfo
        UserBasicInfo userBasicInfo = userBasicInfoService.getPersonInfoByUserBasicInfoId(id);
        map.put("user", userBasicInfo);

        RoleTable roleInfo = roleTableService.getRoleInfo(user.getRoleId());
        List<RoleTable> roles = new ArrayList<>();
        roles.add(roleInfo);
        map.put("roles", roles);

        //通过roleid取得所有privileges
        List<RolePri> rolePriInfo = rolePriService.getRolePriInfo(user.getRoleId());
        List<PrivilegeTable> privileges = new ArrayList<>();
        //通过privilegsid获取权限信息
        Iterator<RolePri> roleIterator = rolePriInfo.iterator();
        while (roleIterator.hasNext()) {
            privileges.add(privilegeTableMapper.selectById(roleIterator.next().getPrivilegeId()));
        }
        map.put("privileges", privileges);
        System.out.println(TokenUtil.tokenMap);
        return ResultUtil.success(map);
    }

    @RequestMapping("/testGenerateToken")
    public Result<?> testGenerateToken() {
        UserBasicInfo user = userBasicInfoMapper.selectById(1597441346729988097L);
        String s = TokenUtil.generateToken(user);
        return ResultUtil.success(s);
    }


}
