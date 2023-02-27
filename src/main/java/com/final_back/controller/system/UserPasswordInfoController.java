package com.final_back.controller.system;

import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.service.system.UserPasswordInfoService;
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

    /**
     * 取得用户账号密码信息
     * @return
     */
    @RequestMapping("/getAllUserPasswordInfo")
    public Result<?> getAllUserPasswordInfo(){
        List<UserPasswordInfo> allUserPasswordInfo = userPasswordInfoService.getAllUserPasswordInfo();
        return ResultUtil.success(allUserPasswordInfo);
    }

    /**
     * 登录
     * @param userPasswordInfo
     * @return
     */
    @RequestMapping("/login")
    public Result<?> login(@RequestBody UserPasswordInfo userPasswordInfo){
        return null;
    }

}
