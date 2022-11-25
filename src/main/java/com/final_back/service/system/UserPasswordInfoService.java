package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.UserPasswordInfo;

import java.util.List;
import java.util.Map;

public interface UserPasswordInfoService extends IService<UserPasswordInfo> {

    int addUserPasswordInfo(UserPasswordInfo userPasswordInfo);

    List<UserPasswordInfo> getAllUserPasswordInfo();

    List<Long> getIdList(Long userBasicInfoId, Integer state, String account, Long organizationId);

    int deleteUserPasswordInfoByIdList(List<Long> idList);

}
