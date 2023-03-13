package com.final_back.impl.transport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.service.transport.OutputRecordService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OutputRecordImpl extends ServiceImpl<OutputRecordMapper, OutputRecord> implements OutputRecordService {
    @Autowired
    OutputRecordMapper outputRecordMapper;

    @Override
    public int addOutputRecord(OutputRecord outputRecord) {
        return outputRecordMapper.insert(outputRecord);
    }

    @Override
    public List<OutputRecord> getAllOutputRecord() {
        return outputRecordMapper.getAllOutputRecord();
    }

    @Override
    public int deleteOutputRecord(OutputRecord outputRecord) {
        return outputRecordMapper.deleteById(outputRecord.getOutputRecordId());
    }

    @Override
    public List<Long> getIdList(Long batchId, Long transportRecordId, Long recordPerson) {
        return outputRecordMapper.getIdList(batchId, transportRecordId, recordPerson);
    }

    @Override
    public int deleteOutputRecordByIdList(List<Long> idList) {
        if (idList.size() > 0) {
            return outputRecordMapper.deleteBatchIds(idList);
        }

        return 0;
    }

    @Override
    public int updateOutputRecord(OutputRecord outputRecord) {
        return outputRecordMapper.updateById(outputRecord);
    }

    /**
     * 按条件获取出苗记录
     *
     * @param batchId
     * @param startDate
     * @param endDate
     * @param recordPerson
     * @return
     */
    @Override
    public List<OutputRecord> getOutputRecordByCondition(Long batchId, Date startDate, Date endDate, Long recordPerson, String order, Integer isDesc, Integer limit) {
        List<OutputRecord> outputRecordByCondition = outputRecordMapper.getOutputRecordByCondition(batchId, recordPerson, startDate, endDate, order, isDesc, limit);

        return outputRecordByCondition;
    }
}
