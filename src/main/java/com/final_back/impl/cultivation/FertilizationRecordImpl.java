package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.FertilizationRecord;
import com.final_back.mapper.cultivation.FertilizationRecordMapper;
import com.final_back.service.cultivation.FertilizationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FertilizationRecordImpl extends ServiceImpl<FertilizationRecordMapper, FertilizationRecord> implements FertilizationRecordService {
    @Autowired
    FertilizationRecordMapper fertilizationRecordMapper;
    @Override
    public int addFertilizationRecord(FertilizationRecord fertilizationRecord) {
        return fertilizationRecordMapper.insert(fertilizationRecord);
    }

    @Override
    public List<FertilizationRecord> getAllFertilizationRecord() {
        return fertilizationRecordMapper.selectList(null);
    }

    @Override
    public int deleteFertilizationRecord(Map<String, Object> map) {
        return fertilizationRecordMapper.deleteByMap(map);
    }

    @Override
    public List<Long> getIdList(Long batchId, Long operatePerson, Long recordPerson) {
        return fertilizationRecordMapper.getIdList(batchId, operatePerson, recordPerson);
    }

    @Override
    public int deleteFertilizationRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            return fertilizationRecordMapper.deleteBatchIds(idList);
        }

        return 0;
    }
}
