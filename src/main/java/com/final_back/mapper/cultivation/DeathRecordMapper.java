package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.DeathRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeathRecordMapper extends BaseMapper<DeathRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("deathRecordPerson") Long deathRecordPerson,
                         @Param("recordPerson") Long recordPerson);


}
