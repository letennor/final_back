package com.final_back.controller.cultivation;


import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.entity.cultivation.FeedRecord;
import com.final_back.mapper.maintainInfo.FeedInfoMapper;
import com.final_back.mapper.cultivation.FeedRecordMapper;
import com.final_back.service.cultivation.FeedRecordService;
import com.final_back.service.maintainInfo.FeedInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FeedRecordController {

    @Autowired
    FeedInfoService feedInfoService;
    @Autowired
    FeedRecordService feedRecordService;


    @RequestMapping("/addFeedRecord")
    public Result<?> addFeedRecord(@RequestBody FeedRecord feedRecord){

        //更新用料表
        Double feedAmount =  feedRecord.getFeedAmount();
        Long feedId = feedRecord.getFeedId();
        FeedInfo feedInfo = feedInfoService.getFeedInfoById(feedId);
        Double restAmount = feedInfo.getTotalAmount() - feedAmount;

        if (restAmount >= 0){
            feedInfo.setTotalAmount(restAmount);
            feedInfoService.updateFeedInfo(feedInfo);
        }else {
            return ResultUtil.success("用料不足");
        }

        int i = feedRecordService.addFeedRecord(feedRecord);

        if (i > 0){
            return ResultUtil.success("输入成功");
        }else {
            return ResultUtil.success("输入失败");
        }
    }

    @RequestMapping("/getAllFeedRecord")
    public Result<?> getAllFeedRecord(){
        List<FeedRecord> allFeedRecord = feedRecordService.getAllFeedRecord();
        return ResultUtil.success(allFeedRecord);
    }

    @RequestMapping("/deleteFeedRecord")
    public Result<?> deleteFeedRecord(@RequestBody FeedRecord feedRecord){
        HashMap<String, Object> map = new HashMap<>();
        map.put("feed_record_id", feedRecord.getFeedRecordId());
        int i = feedRecordService.deleteFeedRecord(map);
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }


}
