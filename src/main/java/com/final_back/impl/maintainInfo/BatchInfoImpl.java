package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.service.cultivation.DeathRecordService;
import com.final_back.service.cultivation.EggProductionRecordService;
import com.final_back.service.cultivation.FeedRecordService;
import com.final_back.service.cultivation.FertilizationRecordService;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.OutputRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchInfoImpl extends ServiceImpl<BatchInfoMapper, BatchInfo> implements BatchInfoService {
    @Autowired
    BatchInfoMapper batchInfoMapper;
    @Autowired
    FeedRecordService feedRecordService;
    @Autowired
    EggProductionRecordService eggProductionRecordService;
    @Autowired
    DeathRecordService deathRecordService;
    @Autowired
    IncomingRecordService incomingRecordService;
    @Autowired
    FertilizationRecordService fertilizationRecordService;
    @Autowired
    OutputRecordService outputRecordService;


    @Override
    public List<BatchInfo> getAllBatch() {
        return batchInfoMapper.selectList(null);
    }

    @Override
    public int addBatchInfo(BatchInfo batchInfo) {
        return batchInfoMapper.insert(batchInfo);
    }

    @Override
    public int deleteBatchInfoById(Long batchId) {
        //删除投喂记录、产蛋量记录、死亡情况记录、进货情况、受精情况、出苗情况、批次信息表
        //先取得id，然后用byIdList删除
        List<Long> feedRecordIdList = feedRecordService.getIdList(batchId, null, null, null);
        List<Long> eggProductionRecordIdList = eggProductionRecordService.getIdList(batchId, null, null);
        List<Long> deathRecordIdList = deathRecordService.getIdList(batchId, null, null);
        List<Long> outputRecordIdList = outputRecordService.getIdList(batchId, null, null);
        List<Long> fertilizationRecordIdList = fertilizationRecordService.getIdList(batchId, null, null);
        List<Long> incomingRecordIdList = incomingRecordService.getIdList(batchId, null, null, null);

        feedRecordService.deleteFeedRecordByIdList(feedRecordIdList);
        eggProductionRecordService.deleteEggProductionRecordByIdList(eggProductionRecordIdList);
        deathRecordService.deleteDeathRecordByIdList(deathRecordIdList);
        outputRecordService.deleteOutputRecordByIdList(outputRecordIdList);
        fertilizationRecordService.deleteFertilizationRecordByIdList(fertilizationRecordIdList);
        incomingRecordService.deleteIncomingRecordByIdList(incomingRecordIdList);

        int i = batchInfoMapper.deleteById(batchId);

        return i;
    }
}
