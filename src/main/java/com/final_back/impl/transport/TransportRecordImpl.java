package com.final_back.impl.transport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.transport.TransportRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportRecordImpl extends ServiceImpl<TransportRecordMapper, TransportRecord> implements TransportRecordService {
    @Autowired
    TransportRecordMapper transportRecordMapper;

    @Override
    public int addTransportRecord(TransportRecord transportRecord) {
        return transportRecordMapper.insert(transportRecord);
    }

    @Override
    public List<TransportRecord> getAllTransportRecord() {
        return transportRecordMapper.selectList(null);
    }
}
