package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.FertilizationRecord;

import java.util.List;
import java.util.Map;

public interface FertilizationRecordService extends IService<FertilizationRecord> {
    int addFertilizationRecord(FertilizationRecord fertilizationRecord);

    List<FertilizationRecord> getAllFertilizationRecord();

    int deleteFertilizationRecord(Map<String, Object> map);
}
