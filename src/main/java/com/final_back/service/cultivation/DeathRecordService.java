package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.DeathRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DeathRecordService extends IService<DeathRecord> {

    int addDeathRecord(DeathRecord deathRecord);

    List<DeathRecord> getAllDeathRecord();

    int deleteDeathRecordById(Long deathRecordId);

    List<Long> getIdList(Long batchId, Long deathRecordPerson, Long recordPerson);

    int deleteDeathRecordByIdList(List<Long> idList);

    int updateDeathRecord(DeathRecord deathRecord);

    List<DeathRecord> getDeathRecordByCondition(Date recordtartDate, Date recordEndDate, Long batchId, Long recordPerson);

}
