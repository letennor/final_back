package com.final_back.service.transport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.transport.OutputRecord;

import java.util.List;

public interface OutputRecordService extends IService<OutputRecord> {
    int addOutputRecord(OutputRecord outputRecord);

    List<OutputRecord> getAllOutputRecord();

    int deleteOutputRecord(OutputRecord outputRecord);
}
