package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.mapper.maintainInfo.FeedInfoMapper;
import com.final_back.service.maintainInfo.FeedInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedInfoImpl extends ServiceImpl<FeedInfoMapper, FeedInfo> implements FeedInfoService {
    @Autowired
    FeedInfoMapper feedInfoMapper;

    @Override
    public int addFeedInfo(FeedInfo feedInfo) {

        return feedInfoMapper.insert(feedInfo);
    }

    @Override
    public FeedInfo getFeedInfoById(Long feedId) {
        return feedInfoMapper.selectById(feedId);
    }

    @Override
    public int updateFeedInfoById(FeedInfo feedInfo) {
        return feedInfoMapper.updateById(feedInfo);
    }

    @Override
    public List<FeedInfo> getAllFeed() {
        return feedInfoMapper.selectList(null);
    }
}
