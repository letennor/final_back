package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.UserPasswordInfo;

import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface UserPasswordInfoService extends IService<UserPasswordInfo> {

    int addUserPasswordInfo(UserPasswordInfo userPasswordInfo);

    List<UserPasswordInfo> getAllUserPasswordInfo();

    List<Long> getIdList(Long userBasicInfoId, Integer state, String userName, Long organizationId);

    int deleteUserPasswordInfoByIdList(List<Long> idList);

    Boolean checkPassword(String userName, String password);

    Boolean checkState(Long userBasicInfoId);

    Map<String, Objects> getLoginInfo(Long userBasicInfoId);

    Boolean changePassword(String oldPassword, String newPassword);

    Integer changeState(Long userId);

}
