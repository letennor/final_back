package com.final_back.impl.transport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.service.transport.TransportRecordService;
import com.sun.jdi.connect.spi.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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

    @Override
    public List<Long> getIdList(String licensePlate, Long driver, Long goodsId, Long recordPerson) {
        return transportRecordMapper.getIdList(licensePlate, driver, goodsId, recordPerson);
    }

    @Override
    public int deleteTransportRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            //先找出所有的id，然后遍历这些id，然后调用service的接口一个一个删除。因为有联表，所以不能通过deleteBatchIds删除
            Iterator iterator = idList.iterator();
            int i = 0;
            while (iterator.hasNext()){
                Long transportRecordId = (Long) iterator.next();
                i += deleteTransportRecordById(transportRecordId);
            }

            return i;
        }

        return 0;

    }

    @Override
    public int updateTransportRecord(TransportRecord transportRecord) {
        return transportRecordMapper.updateById(transportRecord);
    }
}
