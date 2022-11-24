package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.EggProductionRecord;

public interface EggProductionRecordService extends IService<EggProductionRecord> {
    int addEggProductionRecord(EggProductionRecord eggProductionRecord);
}
