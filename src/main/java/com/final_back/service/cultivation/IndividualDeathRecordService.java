package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.IndividualDeathRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IndividualDeathRecordService extends IService<IndividualDeathRecord> {
    int addIndividualDeathRecord(IndividualDeathRecord individualDeathRecord);

    List<IndividualDeathRecord> getAllIndividualDeathRecord();


    int deleteIndividualDeathRecord(Map<String, Object> map);


    List<Long> getIdList(Long deathRecordId, Long recordPerson);

    int deleteIndividualDeathRecordByIdList(List<Long> idList);

    int updateIndividualDeathRecord(IndividualDeathRecord individualDeathRecord);

    List<IndividualDeathRecord> getIndividualDeathRecordByCondition(Long recordPerson, Date startDate, Date endDate);
}
