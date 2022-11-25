package com.final_back.mapper.cultivation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.DosingRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DosingRecordMapper extends BaseMapper<DosingRecord> {

    List<Long> getIdList(@Param("medicineId") Long medicineId, @Param("dosingPerson") Long dosingPerson,
                         @Param("recordPerson") Long recordPerson, @Param("batchId") Long batchId);
}
