package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.UserPasswordInfo;

public interface UserPasswordInfoService extends IService<UserPasswordInfo> {

    int addUserPasswordInfo(UserPasswordInfo userPasswordInfo);

}
