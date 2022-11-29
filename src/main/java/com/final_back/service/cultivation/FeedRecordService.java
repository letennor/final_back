package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.FeedRecord;

import java.util.List;
import java.util.Map;

public interface FeedRecordService extends IService<FeedRecord> {
    int addFeedRecord(FeedRecord feedRecord);

    int deleteFeedRecord(Map<String, Object> map);

    List<FeedRecord> getAllFeedRecord();


    List<Long> getIdList(Long batchId, Long feedId, Long feedPerson, Long recordPerson);

    int deleteFeedRecordByIdList(List<Long> idList);

    int updateFeedRecord(FeedRecord feedRecord);
}
