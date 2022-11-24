package com.final_back.impl.transport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.service.transport.OutputRecordService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutputRecordImpl extends ServiceImpl<OutputRecordMapper, OutputRecord> implements OutputRecordService {
    @Autowired
    OutputRecordMapper outputRecordMapper;

    @Override
    public int addOutputRecord(OutputRecord outputRecord) {
        return outputRecordMapper.insert(outputRecord);
    }
}
