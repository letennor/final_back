package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.EggProductionRecord;
import com.final_back.mapper.cultivation.EggProductionRecordMapper;
import com.final_back.service.cultivation.EggProductionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EggProductionRecordImpl extends ServiceImpl<EggProductionRecordMapper, EggProductionRecord> implements EggProductionRecordService {
    @Autowired
    EggProductionRecordMapper eggProductionRecordMapper;

    @Override
    public int addEggProductionRecord(EggProductionRecord eggProductionRecord) {
        return eggProductionRecordMapper.insert(eggProductionRecord);
    }
}
