package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.UserBasicInfo;

import java.util.List;

public interface UserBasicInfoService extends IService<UserBasicInfo> {

    //添加用户
    int addUser(UserBasicInfo userBasicInfo);

    List<UserBasicInfo> getAllPerson();

    int deleteUserBasicInfoById(Long userBasicinfoId);

    //通过id修改
    int updateUserBasicInfo(UserBasicInfo userBasicInfo);

    List<UserBasicInfoDTO> getAllUserAllInfo();

}
