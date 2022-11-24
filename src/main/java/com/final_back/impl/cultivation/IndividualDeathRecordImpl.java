package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.IndividualDeathRecord;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.service.cultivation.IndividualDeathRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndividualDeathRecordImpl extends ServiceImpl<IndividualDeathRecordMapper, IndividualDeathRecord> implements IndividualDeathRecordService {
    @Autowired
    IndividualDeathRecordMapper individualDeathRecordMapper;

    @Override
    public int addIndividualDeathRecord(IndividualDeathRecord individualDeathRecord) {
        return individualDeathRecordMapper.insert(individualDeathRecord);
    }

    @Override
    public List<IndividualDeathRecord> getAllIndividualDeathRecord() {
        return individualDeathRecordMapper.selectList(null);
    }

    @Override
    public int deleteIndividualDeathRecord(Map<String, Object> map) {
        return individualDeathRecordMapper.deleteByMap(map);
    }
}
