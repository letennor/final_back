package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.FertilizationRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FertilizationRecordMapper extends BaseMapper<FertilizationRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("operatePerson") Long operatePerson,
                         @Param("recordPerson") Long recordPerson);

}
