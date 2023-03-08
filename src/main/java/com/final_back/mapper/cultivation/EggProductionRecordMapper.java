package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.EggProductionRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EggProductionRecordMapper extends BaseMapper<EggProductionRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("pickEggPerson") Long pickEggPerson,
                         @Param("recordPerson") Long recordPerson);

    List<EggProductionRecord> getRangeTimeEggProductionRecord(@Param("startTime") Date startTime,
                                                              @Param("endTime") Date endTime);

    List<EggProductionRecord> getAllEggProductionRecord();

    List<EggProductionRecord> getEggProductionRecordByCondition(@Param("batchId") Long batchId, @Param("pickEggPerson") Long pickEggPerson,@Param("recordPerson") Long recordPerson,  @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
