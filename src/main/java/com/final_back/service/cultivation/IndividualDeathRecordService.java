package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.IndividualDeathRecord;

public interface IndividualDeathRecordService extends IService<IndividualDeathRecord> {
    int addIndividualDeathRecord(IndividualDeathRecord individualDeathRecord);
}
