package com.final_back.service.transport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IncomingRecordService extends IService<IncomingRecord> {
    int addIncomingRecord(IncomingRecord incomingRecord);

    List<IncomingRecord> getAllIncomingRecord();

    int deleteIncomingRecord(IncomingRecord incomingRecord);
}
