package com.final_back.controller;


import com.final_back.entity.FeedInfo;
import com.final_back.entity.FeedRecord;
import com.final_back.mapper.FeedInfoMapper;
import com.final_back.mapper.FeedRecordMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedRecordController {

    @Autowired
    FeedRecordMapper feedRecordMapper;
    @Autowired
    FeedInfoMapper feedInfoMapper;

    @RequestMapping("/addFeedRecord")
    public Result<?> addFeedRecord(@RequestBody FeedRecord entity){

        //更新用料表
        Double feedAmount =  entity.getFeedAmount();

        Long feedId = entity.getFeedId();
        FeedInfo feedInfo = feedInfoMapper.selectById(feedId);

        Double restAmount = feedInfo.getTotalAmount() - feedAmount;
        if (restAmount >= 0){
            feedInfo.setTotalAmount(restAmount);
            feedInfoMapper.updateById(feedInfo);
        }else {
            return ResultUtil.success("用料不足");
        }

        int i = feedRecordMapper.insert(entity);

        if (i > 0){
            return ResultUtil.success("输入成功");
        }else {
            return ResultUtil.success("输入失败");
        }
    }

}
