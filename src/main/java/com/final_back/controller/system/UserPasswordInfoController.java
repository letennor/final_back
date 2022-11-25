package com.final_back.controller.system;

import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserPasswordInfoController {

    @Autowired
    UserPasswordInfoService userPasswordInfoService;

    @RequestMapping("/getAllUserPasswordInfo")
    public Result<?> getAllUserPasswordInfo(){
        List<UserPasswordInfo> allUserPasswordInfo = userPasswordInfoService.getAllUserPasswordInfo();
        return ResultUtil.success(allUserPasswordInfo);
    }

}
