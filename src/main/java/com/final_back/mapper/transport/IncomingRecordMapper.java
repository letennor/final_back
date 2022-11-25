package com.final_back.mapper.transport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.transport.IncomingRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomingRecordMapper extends BaseMapper<IncomingRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("goodsId") Long goodsId,
                         @Param("transportRecordId") Long transportRecordId, @Param("recordPerson") Long recordPerson);

}
