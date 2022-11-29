package com.final_back.service.maintainInfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.maintainInfo.FeedInfo;

import java.util.List;

public interface FeedInfoService extends IService<FeedInfo> {

    int addFeedInfo(FeedInfo feedInfo);
    FeedInfo getFeedInfoById(Long feedId);

    List<FeedInfo> getAllFeed();
    int deleteFeedInfoById(Long feedId);

    int updateFeedInfo(FeedInfo feedInfo);
}
