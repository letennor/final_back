package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.FertilizationRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FertilizationRecordService extends IService<FertilizationRecord> {
    int addFertilizationRecord(FertilizationRecord fertilizationRecord);

    List<FertilizationRecord> getAllFertilizationRecord();

    int deleteFertilizationRecord(Map<String, Object> map);

    List<Long> getIdList(Long batchId, Long operatePerson, Long recordPerson);

    int deleteFertilizationRecordByIdList(List<Long> idList);

    int updateFertilizationRecord(FertilizationRecord fertilizationRecord);

    List<FertilizationRecord> getFertilizationRecordByCondition(Long batchId, Date fertilizationStartDate, Date fertilizationEndDate, Long operatePerson, Long recordPerson, Date startDate, Date endDate);
}
