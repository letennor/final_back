package com.final_back.impl.transport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.service.transport.IncomingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomingRecordImpl extends ServiceImpl<IncomingRecordMapper, IncomingRecord> implements IncomingRecordService {
    @Autowired
    IncomingRecordMapper incomingRecordMapper;

    @Override
    public int addIncomingRecord(IncomingRecord incomingRecord) {
        return incomingRecordMapper.insert(incomingRecord);
    }

    @Override
    public List<IncomingRecord> getAllIncomingRecord() {
        return incomingRecordMapper.selectList(null);
    }

    @Override
    public int deleteIncomingRecord(IncomingRecord incomingRecord) {
        return incomingRecordMapper.deleteById(incomingRecord.getIncomingRecordId());
    }
}
