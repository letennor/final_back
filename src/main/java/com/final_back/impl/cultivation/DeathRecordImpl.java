package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.DeathRecord;
import com.final_back.mapper.cultivation.DeathRecordMapper;
import com.final_back.service.cultivation.DeathRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeathRecordImpl extends ServiceImpl<DeathRecordMapper, DeathRecord> implements DeathRecordService {

    @Autowired
    DeathRecordMapper deathRecordMapper;


    @Override
    public int addDeathRecord(DeathRecord deathRecord) {
        return deathRecordMapper.insert(deathRecord);
    }

    @Override
    public List<DeathRecord> getAllDeathRecord() {
        return deathRecordMapper.selectList(null);
    }

    @Override
    public int deleteDeathRecordById(Long deathRecordId) {
        return deathRecordMapper.deleteById(deathRecordId);
    }
}
