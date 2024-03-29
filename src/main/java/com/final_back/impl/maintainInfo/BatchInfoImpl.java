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

import java.util.Iterator;
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
        return batchInfoMapper.getBatchList();
    }

    @Override
    public int addBatchInfo(BatchInfo batchInfo) {
        //判断是养殖生产线还是孵化生产线，如果是养殖，则放入1637722972147695617，如果是孵化，则放入1637723241820471297

        if (batchInfo.getType().equals("养殖")) {
            batchInfo.setCurrentWork(1637722972147695617L);
        } else if (batchInfo.getType().equals("孵化")) {
            batchInfo.setCurrentWork(1637723241820471297L);
        }

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

    @Override
    public List<Long> getIdList(Long recordPerson) {
        return batchInfoMapper.getIdList(recordPerson);
    }

    @Override
    public int deleteBatchInfoByIdList(List<Long> idList) {
        if (idList.size() > 0) {
            int i = 0;
            Iterator iterator = idList.iterator();
            while (iterator.hasNext()) {
                Long batchId = (Long) iterator.next();
                i += deleteBatchInfoById(batchId);
            }
            return i;
        }
        return 0;
    }

    @Override
    public int updateBatchInfo(BatchInfo batchInfo) {
        return batchInfoMapper.updateById(batchInfo);
    }
}
