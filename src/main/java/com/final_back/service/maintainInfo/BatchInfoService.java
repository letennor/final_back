package com.final_back.service.maintainInfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.maintainInfo.BatchInfo;

import java.util.List;

public interface BatchInfoService extends IService<BatchInfo> {
    List<BatchInfo> getAllBatch();

    int addBatchInfo(BatchInfo batchInfo);

    int deleteBatchInfoById(Long batchId);
}
