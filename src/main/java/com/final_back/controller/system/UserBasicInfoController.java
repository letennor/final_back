package com.final_back.controller.system;

import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserBasicInfoController {

    @Autowired
    UserBasicInfoService userBasicInfoService;
    @Autowired
    UserPasswordInfoService userPasswordInfoService;


    @RequestMapping("/addUser")
    public Result<?> addUser(@RequestBody UserBasicInfoDTO userBasicInfoDTO) {

        int basicInfoInsert = userBasicInfoService.addUser(userBasicInfoDTO);

        UserPasswordInfo userPasswordInfo  = new UserPasswordInfo();
        userPasswordInfo.setUserBasicInfoId(userBasicInfoDTO.getUserBasicInfoId());
        userPasswordInfo.setPassword(userBasicInfoDTO.getPassword());
        userPasswordInfo.setAccount(userBasicInfoDTO.getAccount());
        int userPasswordInsert = userPasswordInfoService.addUserPasswordInfo(userPasswordInfo);

        if (basicInfoInsert > 0 && userPasswordInsert > 0){
            return ResultUtil.success("输入成功");
        }else {
            return ResultUtil.success("输入失败");
        }
    }

    @RequestMapping("/getAllPerson")
    public Result<?> getAllPerson(){
        List<UserBasicInfo> userBasicInfoList = userBasicInfoService.getAllPerson();
        return ResultUtil.success(userBasicInfoList);
    }

}
