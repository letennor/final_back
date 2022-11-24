package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.service.system.UserBasicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBasicInfoImpl extends ServiceImpl<UserBasicInfoMapper, UserBasicInfo> implements UserBasicInfoService {
    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;
    @Override
    public int addUser(UserBasicInfo userBasicInfo) {
        int basicInfoInsert = userBasicInfoMapper.insert(userBasicInfo);
        return basicInfoInsert;
    }

    @Override
    public List<UserBasicInfo> getAllPerson() {
        return userBasicInfoMapper.selectList(null);
    }
}
