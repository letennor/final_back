package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.FeedRecord;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.mapper.cultivation.FeedRecordMapper;
import com.final_back.service.cultivation.FeedRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public int deleteFeedRecord(Map<String, Object> map) {
        return feedRecordMapper.deleteByMap(map);
    }

    @Override
    public List<FeedRecord> getAllFeedRecord() {
        return feedRecordMapper.selectList(null);
    }

    @Override
    public List<Long> getIdList(Long batchId, Long feedId, Long feedPerson, Long recordPerson) {
        return feedRecordMapper.getIdList(batchId, feedId, feedPerson, recordPerson);
    }

    @Override
    public int deleteFeedRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            return feedRecordMapper.deleteBatchIds(idList);
        }
        return 0;
    }
}
