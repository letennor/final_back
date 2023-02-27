package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.entity.cultivation.EggProductionRecord;
import com.final_back.mapper.cultivation.DosingRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DosingRecordService extends IService<DosingRecord> {
    int addDosingRecord(DosingRecord dosingRecord);

    List<DosingRecord> getAllDosingRecord();

    int deleteDosingRecord(Map<String, Object> map);

    List<Long> getIdList(Long medicineId, Long dosingPerson, Long recordPerson, Long batchId);

    int deleteDosingRecordByIdList(List<Long> idList);

    int updateDosingRecord(DosingRecord dosingRecord);

    List<DosingRecord> getRangeTimeDosingRecord(Date startTime, Date endTime);

    List<DosingRecord> getDosingRecordByCondition(Long medicineId, Long batchId, Long dosingPerson, Date recordStartDate, Date recordEndDate, Long recordPerson);
}
