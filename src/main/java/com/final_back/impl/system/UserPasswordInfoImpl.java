package com.final_back.impl.system;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.service.system.UserPasswordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPasswordInfoImpl extends ServiceImpl<UserPasswordInfoMapper, UserPasswordInfo> implements UserPasswordInfoService {

    @Autowired
    UserPasswordInfoMapper userPasswordInfoMapper;

    @Override
    public int addUserPasswordInfo(UserPasswordInfo userPasswordInfo) {
        return userPasswordInfoMapper.insert(userPasswordInfo);
    }

    @Override
    public List<UserPasswordInfo> getAllUserPasswordInfo() {
        return userPasswordInfoMapper.selectList(null);
    }

    @Override
    public List<Long> getIdList(Long userBasicInfoId, Integer state, String account, Long organizationId) {
        return userPasswordInfoMapper.getIdList(userBasicInfoId, state, account,organizationId);
    }

    @Override
    public int deleteUserPasswordInfoByIdList(List<Long> idList) {
        if (idList.size() > 0){
            return userPasswordInfoMapper.deleteBatchIds(idList);
        }

        return 0;
    }

}
