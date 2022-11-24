package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.FertilizationRecord;

public interface FertilizationRecordService extends IService<FertilizationRecord> {
    int addFertilizationRecord(FertilizationRecord fertilizationRecord);
}
