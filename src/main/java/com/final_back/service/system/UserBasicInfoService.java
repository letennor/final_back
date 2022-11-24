package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.UserBasicInfo;

import java.util.List;

public interface UserBasicInfoService extends IService<UserBasicInfo> {

    //添加用户
    int addUser(UserBasicInfo userBasicInfo);

    List<UserBasicInfo> getAllPerson();

}
