package com.final_back.controller;


import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.UserPasswordInfo;
import com.final_back.mapper.UserBasicInfoMapper;
import com.final_back.mapper.UserPasswordInfoMapper;
import com.final_back.entity.UserBasicInfo;
import com.final_back.utils.common.SnowFlakeGenerateIdWorker;
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
    UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    UserPasswordInfoMapper userPasswordInfoMapper;

    @RequestMapping("/addUser")
    public Result<?> addUser(@RequestBody UserBasicInfoDTO entity) {

        int basicInfoInsert = userBasicInfoMapper.insert(entity);
        UserPasswordInfo userPasswordInfo  = new UserPasswordInfo();
        userPasswordInfo.setUserBasicInfoId(entity.getUserBasicInfoId());
        userPasswordInfo.setPassword(entity.getPassword());
        userPasswordInfo.setAccount(entity.getAccount());

        int userPasswordInsert = userPasswordInfoMapper.insert(userPasswordInfo);

        if (basicInfoInsert > 0 && userPasswordInsert > 0){
            return ResultUtil.success("输入成功");
        }else {
            return ResultUtil.success("输入失败");
        }
    }

    @RequestMapping("/getAllPerson")
    public Result<?> getAllPerson(){
        List<UserBasicInfo> userBasicInfoList = userBasicInfoMapper.selectList(null);
        return ResultUtil.success(userBasicInfoList);
    }

}
