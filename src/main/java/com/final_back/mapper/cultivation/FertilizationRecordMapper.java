package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.FertilizationRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FertilizationRecordMapper extends BaseMapper<FertilizationRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("operatePerson") Long operatePerson,
                         @Param("recordPerson") Long recordPerson);

    List<FertilizationRecord> getAllFertilizationRecord();

    List<FertilizationRecord> getFertilizationRecordByCondition(@Param("batchId") Long batchId, @Param("fertilizationStartDate") Date fertilizationStartDate, @Param("fertilizationEndDate") Date fertilizationEndDate, @Param("operatePerson") Long operatePerson, @Param("recordPerson") Long recordPerson, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("order") String order, @Param("isDesc") Integer isDesc, @Param("limit") Integer limit);

}
