package com.final_back.service.transport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.transport.TransportRecord;

import java.util.List;

public interface TransportRecordService extends IService<TransportRecord> {
    int addTransportRecord(TransportRecord transportRecord);
    List<TransportRecord> getAllTransportRecord();

    int deleteTransportRecordById(Long transportRecordId);

    List<Long> getIdList(String licensePlate, Long driver, Long goodsId, Long recordPerson);

    int deleteTransportRecordByIdList(List<Long> idList);
}
