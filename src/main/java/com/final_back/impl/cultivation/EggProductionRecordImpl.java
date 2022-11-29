package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.EggProductionRecord;
import com.final_back.mapper.cultivation.EggProductionRecordMapper;
import com.final_back.service.cultivation.EggProductionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EggProductionRecordImpl extends ServiceImpl<EggProductionRecordMapper, EggProductionRecord> implements EggProductionRecordService {
    @Autowired
    EggProductionRecordMapper eggProductionRecordMapper;

    @Override
    public int addEggProductionRecord(EggProductionRecord eggProductionRecord) {
        return eggProductionRecordMapper.insert(eggProductionRecord);
    }

    @Override
    public List<EggProductionRecord> getAllEggProductionRecord() {
        return eggProductionRecordMapper.selectList(null);
    }

    @Override
    public int deleteEggProductionRecord(Map<String, Object> map) {
        return eggProductionRecordMapper.deleteByMap(map);
    }

    @Override
    public List<Long> getIdList(Long batchId, Long pickEggPerson, Long recordPerson) {
        return eggProductionRecordMapper.getIdList(batchId, pickEggPerson, recordPerson);
    }

    @Override
    public int deleteEggProductionRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            eggProductionRecordMapper.deleteBatchIds(idList);
        }
        return 0;
    }

    @Override
    public int updateEggProductionRecord(EggProductionRecord eggProductionRecord) {
        return eggProductionRecordMapper.updateById(eggProductionRecord);
    }
}
