package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.UserRole;
import com.final_back.mapper.system.UserRoleMapper;
import com.final_back.service.system.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserRoleImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    /**
     * 取得用户角色信息
     * @param userBasicInfoId
     * @return
     */
    @Override
    public UserRole getUserRole(Long userBasicInfoId) {
        return null;
    }
}
