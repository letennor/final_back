package com.final_back.impl.transport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.service.transport.TransportRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportRecordImpl extends ServiceImpl<TransportRecordMapper, TransportRecord> implements TransportRecordService {
    @Autowired
    TransportRecordMapper transportRecordMapper;
    @Autowired
    IncomingRecordService incomingRecordService;
    @Autowired
    OutputRecordService outputRecordService;

    @Override
    public int addTransportRecord(TransportRecord transportRecord) {
        return transportRecordMapper.insert(transportRecord);
    }

    @Override
    public List<TransportRecord> getAllTransportRecord() {
        return transportRecordMapper.selectList(null);
    }

    @Override
    public int deleteTransportRecordById(Long transportRecordId) {
        //删除出货情况记录、运输情况记录
        List<Long> incomingRecordIdList = incomingRecordService.getIdList(null, null, transportRecordId, null);
        List<Long> outputRecordIdList = outputRecordService.getIdList(null, transportRecordId, null);
        incomingRecordService.deleteIncomingRecordByIdList(incomingRecordIdList);
        outputRecordService.deleteOutputRecordByIdList(outputRecordIdList);

        int i = transportRecordMapper.deleteById(transportRecordId);

        return i;
    }
}
