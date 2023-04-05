package com.final_back.impl.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.service.system.UserPasswordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public List<Long> getIdList(Long userBasicInfoId, Integer state, String userName, Long organizationId) {
        return userPasswordInfoMapper.getIdList(userBasicInfoId, state, userName, organizationId);
    }

    @Override
    public int deleteUserPasswordInfoByIdList(List<Long> idList) {
        if (idList.size() > 0) {
            return userPasswordInfoMapper.deleteBatchIds(idList);
        }

        return 0;
    }

    /**
     * 检查密码是否正确
     *
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Boolean checkPassword(String userName, String password) {
        return null;
    }

    /**
     * 查询账户是否启用
     *
     * @param userBasicInfoId
     * @return
     */
    @Override
    public Boolean checkState(Long userBasicInfoId) {
        return null;
    }

    /**
     * 取得登陆成功后返回前端的所有信息
     *
     * @param userBasicInfoId
     * @return
     */
    @Override
    public Map<String, Objects> getLoginInfo(Long userBasicInfoId) {
        return null;
    }

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @Override
    public Boolean changePassword(String oldPassword, String newPassword) {
        return null;
    }

    /**
     * 改变用户状态
     *
     * @param userId
     * @return
     */
    @Override
    public Integer changeState(Long userId) {
        QueryWrapper<UserPasswordInfo> userPasswordInfoQueryWrapper = new QueryWrapper<>();
        userPasswordInfoQueryWrapper.eq("user_basic_info_id", userId);
        UserPasswordInfo userPasswordInfo = userPasswordInfoMapper.selectOne(userPasswordInfoQueryWrapper);
        if (userPasswordInfo.getState() == 1) {
            userPasswordInfo.setState(0);
        } else {
            userPasswordInfo.setState(1);
        }

        int i = userPasswordInfoMapper.updateById(userPasswordInfo);
        return i;
    }

}
