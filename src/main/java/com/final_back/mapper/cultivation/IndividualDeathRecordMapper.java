package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.IndividualDeathRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualDeathRecordMapper extends BaseMapper<IndividualDeathRecord> {

    List<Long> getIdList(@Param("deathRecordId") Long deathRecordId, @Param("recordPerson") Long recordPerson);

    List<IndividualDeathRecord> getAllIndividualDeathRecord();
}
