package com.final_back.mapper.transport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.transport.TransportRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRecordMapper extends BaseMapper<TransportRecord> {

    List<Long> getIdList(@Param("licensePlate") String licensePlate, @Param("driver") Long driver,
                         @Param("goodsId") Long goodsId, @Param("recordPerson") Long recordPerson);

    List<TransportRecord> getAllTransportRecord();
}
