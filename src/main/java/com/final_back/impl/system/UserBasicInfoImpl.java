package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.service.cultivation.*;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.service.transport.TransportRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserBasicInfoImpl extends ServiceImpl<UserBasicInfoMapper, UserBasicInfo> implements UserBasicInfoService {
    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    UserPasswordInfoService userPasswordInfoService;
    @Autowired
    FeedRecordService feedRecordService;
    @Autowired
    EggProductionRecordService eggProductionRecordService;
    @Autowired
    DosingRecordService dosingRecordService;
    @Autowired
    DeathRecordService deathRecordService;
    @Autowired
    IndividualDeathRecordService individualDeathRecordService;
    @Autowired
    FertilizationRecordService fertilizationRecordService;
    @Autowired
    OutputRecordService outputRecordService;
    @Autowired
    TransportRecordService transportRecordService;
    @Autowired
    BatchInfoService batchInfoService;


    @Override
    public int addUser(UserBasicInfo userBasicInfo) {
        int basicInfoInsert = userBasicInfoMapper.insert(userBasicInfo);
        return basicInfoInsert;
    }

    @Override
    public List<UserBasicInfo> getAllPerson() {
        return userBasicInfoMapper.selectList(null);
    }

    @Override
    public int deleteUserBasicInfoById(Long userBasicinfoId) {
        //删除用户密码表、用户角色表(暂时不弄)、投喂记录、产蛋记录、投药记录、死亡记录、个体死亡记录、受精情况记录、出苗情况记录、运输记录、批次信息、用户信息表

        List<Long> userPasswordInfoIdList = userPasswordInfoService.getIdList(userBasicinfoId, null, null, null);
        List<Long> feedRecordIdList = feedRecordService.getIdList(null, null, userBasicinfoId, userBasicinfoId);
        List<Long> eggProductionRecordIdList = eggProductionRecordService.getIdList(null, userBasicinfoId, userBasicinfoId);
        List<Long> dosingRecordServiceIdList = dosingRecordService.getIdList(null, userBasicinfoId, userBasicinfoId, null);
        List<Long> deathRecordIdList = deathRecordService.getIdList(null, userBasicinfoId, userBasicinfoId);
        List<Long> individualDeathRecordIdList = individualDeathRecordService.getIdList(null, userBasicinfoId);
        List<Long> fertilizationRecordIdList = fertilizationRecordService.getIdList(null, userBasicinfoId, userBasicinfoId);
        List<Long> outputRecordIdList = outputRecordService.getIdList(null, null, userBasicinfoId);
        List<Long> transportRecordIdList = transportRecordService.getIdList(null, userBasicinfoId, null, userBasicinfoId);
        List<Long> batchInfoIdList = batchInfoService.getIdList(userBasicinfoId);

        userPasswordInfoService.deleteUserPasswordInfoByIdList(userPasswordInfoIdList);
        feedRecordService.deleteFeedRecordByIdList(feedRecordIdList);
        eggProductionRecordService.deleteEggProductionRecordByIdList(eggProductionRecordIdList);
        dosingRecordService.deleteDosingRecordByIdList(dosingRecordServiceIdList);
        deathRecordService.deleteDeathRecordByIdList(deathRecordIdList);
        individualDeathRecordService.deleteIndividualDeathRecordByIdList(individualDeathRecordIdList);
        fertilizationRecordService.deleteFertilizationRecordByIdList(fertilizationRecordIdList);
        outputRecordService.deleteOutputRecordByIdList(outputRecordIdList);
        transportRecordService.deleteTransportRecordByIdList(transportRecordIdList);
        batchInfoService.deleteBatchInfoByIdList(batchInfoIdList);

        int i = userBasicInfoMapper.deleteById(userBasicinfoId);

        return i;

    }

    @Override
    public int updateUserBasicInfo(UserBasicInfo userBasicInfo) {
        return userBasicInfoMapper.updateById(userBasicInfo);
    }

    @Override
    public List<UserBasicInfoDTO> getAllUserAllInfo() {
        return userBasicInfoMapper.getAllUserAllInfo();
    }

    @Override
    public List<UserBasicInfoDTO> getUserAllInfoByCondition(Long roleId, List<Long> matchIdList, Long userId) {
        List<UserBasicInfoDTO> userAllInfoByCondition = userBasicInfoMapper.getUserAllInfoByCondition(roleId, matchIdList, userId);
        return userAllInfoByCondition;
    }

    /**
     * 通过账户取得基本信息
     *
     * @param userName
     * @return
     */
    @Override
    public UserBasicInfo getPersonInfoByUserName(String userName) {
        return null;
    }

    /**
     * 通过userBasicInfoId取得基本信息
     *
     * @param userBasicInfoId
     * @return
     */
    @Override
    public UserBasicInfoDTO getPersonInfoByUserBasicInfoId(Long userBasicInfoId) {
        //需要返回state
        List<UserBasicInfoDTO> userAllInfoByCondition = userBasicInfoMapper.getUserAllInfoByCondition(null, null, userBasicInfoId);
        return userAllInfoByCondition.get(0);
    }

    /**
     * 通过角色、空闲时间查找用户
     *
     * @param roleId
     * @param startFreeDate
     * @param endFreeDate
     * @return
     */
    @Override
    public List<UserBasicInfo> queryUserByCondition(Long roleId, Date startFreeDate, Date endFreeDate) {
        return null;
    }


}
