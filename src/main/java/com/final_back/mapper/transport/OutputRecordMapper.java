package com.final_back.mapper.transport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.transport.OutputRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OutputRecordMapper extends BaseMapper<OutputRecord> {
    List<Long> getIdList(@Param("batchId") Long batchId, @Param("transportRecordId") Long transportRecordId,
                         @Param("recordPerson") Long recordPerson);

    List<OutputRecord> getAllOutputRecord();

    List<OutputRecord> getOutputRecordByCondition(@Param("batchId") Long batchId, @Param("recordPerson") Long recordPerson, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("order") String order, @Param("isDesc") Integer isDesc, @Param("limit") Integer limit);
}
