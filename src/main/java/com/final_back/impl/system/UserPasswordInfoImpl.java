package com.final_back.impl.system;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.service.system.UserPasswordInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserPasswordInfoImpl extends ServiceImpl<UserPasswordInfoMapper, UserPasswordInfo> implements UserPasswordInfoService {
    @Override
    public int addUserPasswordInfo(UserPasswordInfo userPasswordInfo) {

        return 0;
    }
}
