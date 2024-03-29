package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.EggProductionRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EggProductionRecordService extends IService<EggProductionRecord> {
    int addEggProductionRecord(EggProductionRecord eggProductionRecord);

    List<EggProductionRecord> getAllEggProductionRecord();

    int deleteEggProductionRecord(Map<String, Object> map);

    List<Long> getIdList(Long batchId, Long pickEggPerson, Long recordPerson);

    int deleteEggProductionRecordByIdList(List<Long> idList);

    int updateEggProductionRecord(EggProductionRecord eggProductionRecord);

    List<EggProductionRecord> getRangeTimeEggProductionRecord(Date startTime, Date endTime);

    List<EggProductionRecord> getEggProductionRecordByCondition(Long batchId, Long pickEggPerson, Long recordPerson, Date startDate, Date endDate, String order, Integer isDesc, Integer limit);
}
