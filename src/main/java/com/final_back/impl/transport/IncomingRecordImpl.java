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

    @Override
    public List<Long> getIdList(Long batchId, Long goodsId, Long transportRecordId, Long recordPerson) {
        return incomingRecordMapper.getIdList(batchId, goodsId, transportRecordId, recordPerson);
    }

    @Override
    public int deleteIncomingRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            return incomingRecordMapper.deleteBatchIds(idList);
        }
        return 0;
    }

    @Override
    public int updateIncomingRecord(IncomingRecord incomingRecord) {
        return incomingRecordMapper.updateById(incomingRecord);
    }
}
