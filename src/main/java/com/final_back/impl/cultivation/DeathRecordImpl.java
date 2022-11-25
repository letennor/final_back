package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.DeathRecord;
import com.final_back.entity.cultivation.IndividualDeathRecord;
import com.final_back.mapper.cultivation.DeathRecordMapper;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.service.cultivation.DeathRecordService;
import com.final_back.service.cultivation.IndividualDeathRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeathRecordImpl extends ServiceImpl<DeathRecordMapper, DeathRecord> implements DeathRecordService {

    @Autowired
    DeathRecordMapper deathRecordMapper;
    @Autowired
    IndividualDeathRecordMapper individualDeathRecordMapper;
    @Autowired
    IndividualDeathRecordService individualDeathRecordService;


    @Override
    public int addDeathRecord(DeathRecord deathRecord) {
        return deathRecordMapper.insert(deathRecord);
    }

    @Override
    public List<DeathRecord> getAllDeathRecord() {
        return deathRecordMapper.selectList(null    );
    }

    @Override
    public int deleteDeathRecordById(Long deathRecordId) {
        //先删除最里面的表：个体死亡记录
        //取出个体死亡表的所有id
        //先删掉这个id子表的所有id，再删这个id

        List<Long> individualDeathRecordServiceAllId = individualDeathRecordService.getIdList(deathRecordId, null);
        individualDeathRecordService.deleteIndividualDeathRecordByIdList(individualDeathRecordServiceAllId);
        deathRecordMapper.deleteById(deathRecordId);

        return 1;
    }
}
