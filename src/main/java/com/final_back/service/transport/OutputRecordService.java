package com.final_back.service.transport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.transport.OutputRecord;

public interface OutputRecordService extends IService<OutputRecord> {
    int addOutputRecord(OutputRecord outputRecord);
}
