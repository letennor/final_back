package com.final_back.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.annotation.MyTransactional;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.utils.common.TokenUtil;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPasswordInfoController {

    @Autowired
    UserPasswordInfoService userPasswordInfoService;
    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    UserPasswordInfoMapper userPasswordInfoMapper;

    /**
     * 取得用户账号密码信息
     *
     * @return
     */
    @RequestMapping("/getAllUserPasswordInfo")
    public Result<?> getAllUserPasswordInfo() {
        List<UserPasswordInfo> allUserPasswordInfo = userPasswordInfoService.getAllUserPasswordInfo();
        return ResultUtil.success(allUserPasswordInfo);
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login")
    @MyTransactional
    public Result<?> login(@RequestBody UserPasswordInfo userPasswordInfo) {
        System.out.println("userName:" + userPasswordInfo.getUserName());
        System.out.println("password:" + userPasswordInfo.getPassword());

        //通过userName获取userBasicInfo
        QueryWrapper<UserPasswordInfo> userPasswordInfoQueryWrapper = new QueryWrapper<>();
        userPasswordInfoQueryWrapper.eq("user_name", userPasswordInfo.getUserName());
        userPasswordInfoQueryWrapper.eq("password", userPasswordInfo.getPassword());
        List<UserPasswordInfo> userPasswordInfos = userPasswordInfoMapper.selectList(userPasswordInfoQueryWrapper);

        if (userPasswordInfos.size() == 0) {
            return ResultUtil.success(false);
        }

        UserBasicInfo userBasicInfo = userBasicInfoMapper.selectById(userPasswordInfos.get(0).getUserBasicInfoId());

        String s = TokenUtil.generateToken(userBasicInfo);
        return ResultUtil.success(s);
    }

    @RequestMapping("/logout")
    public Result<?> logout(@RequestBody UserBasicInfoDTO userBasicInfoDTO) {
        TokenUtil.removeUser(userBasicInfoDTO.getToken());
        return ResultUtil.success("已移除token");
    }

    @RequestMapping("/changeState")
    public Result<?> changeState(@RequestBody UserBasicInfoDTO userBasicInfoDTO) {
        Integer integer = userPasswordInfoService.changeState(userBasicInfoDTO.getUserBasicInfoId());
        if (integer > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

}
