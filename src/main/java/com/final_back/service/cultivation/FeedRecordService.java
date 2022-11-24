package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.FeedRecord;

import java.util.Map;

public interface FeedRecordService extends IService<FeedRecord> {
    int addFeedRecord(FeedRecord feedRecord);

    int deleteFeedRecordById(Map<String, Object> map);
}
