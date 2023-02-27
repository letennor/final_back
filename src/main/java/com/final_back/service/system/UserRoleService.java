package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.UserRole;

public interface UserRoleService extends IService<UserRole> {

    UserRole getUserRole(Long userBasicInfoId);

}
