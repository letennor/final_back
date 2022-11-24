package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.FeedRecord;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.mapper.cultivation.FeedRecordMapper;
import com.final_back.service.cultivation.FeedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeedRecordImpl extends ServiceImpl<FeedRecordMapper, FeedRecord> implements FeedRecordService {
    @Autowired
    FeedRecordMapper feedRecordMapper;

    @Override
    public int addFeedRecord(FeedRecord feedRecord) {
        return feedRecordMapper.insert(feedRecord);
    }

    @Override
    public int deleteFeedRecordById(Map<String, Object> map) {
        return feedRecordMapper.deleteByMap(map);
    }
}
