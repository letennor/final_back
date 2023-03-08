package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.entity.cultivation.EggProductionRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DosingRecordMapper extends BaseMapper<DosingRecord> {

    List<Long> getIdList(@Param("medicineId") Long medicineId, @Param("dosingPerson") Long dosingPerson,
                         @Param("recordPerson") Long recordPerson, @Param("batchId") Long batchId);

    List<DosingRecord> getRangeTimeDosingRecord(@Param("startTime") Date startTime,
                                                @Param("endTime") Date endTime);

    List<DosingRecord> getAllDosingRecord();

    List<DosingRecord> getDosingRecordByCondition(@Param("recordPerson") Long recordPerson, @Param("medicineId") Long medicineId, @Param("dosingPerson") Long dosingPerson, @Param("batchId") Long batchId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
