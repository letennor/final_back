package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.mapper.maintainInfo.FeedInfoMapper;
import com.final_back.service.cultivation.FeedRecordService;
import com.final_back.service.maintainInfo.FeedInfoService;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedInfoImpl extends ServiceImpl<FeedInfoMapper, FeedInfo> implements FeedInfoService {
    @Autowired
    FeedInfoMapper feedInfoMapper;
    @Autowired
    FeedRecordService feedRecordService;

    @Override
    public int addFeedInfo(FeedInfo feedInfo) {

        return feedInfoMapper.insert(feedInfo);
    }

    @Override
    public FeedInfo getFeedInfoById(Long feedId) {
        return feedInfoMapper.selectById(feedId);
    }

    @Override
    public List<FeedInfo> getAllFeed() {
        return feedInfoMapper.selectList(null);
    }

    @Override
    public int deleteFeedInfoById(Long feedId) {
        //删除投喂记录、用料信息表
        List<Long> feedRecordIdList = feedRecordService.getIdList(null, feedId, null, null);
        feedRecordService.deleteFeedRecordByIdList(feedRecordIdList);

        int i = feedInfoMapper.deleteById(feedId);
        return i;
    }

    @Override
    public int updateFeedInfo(FeedInfo feedInfo) {
        return feedInfoMapper.updateById(feedInfo);
    }
}
