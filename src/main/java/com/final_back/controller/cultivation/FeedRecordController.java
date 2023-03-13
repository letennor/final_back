package com.final_back.controller.cultivation;


import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.FeedRecordDTO;
import com.final_back.dto.RangeTime;
import com.final_back.entity.cultivation.EggProductionRecord;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.entity.cultivation.FeedRecord;
import com.final_back.mapper.maintainInfo.FeedInfoMapper;
import com.final_back.mapper.cultivation.FeedRecordMapper;
import com.final_back.service.cultivation.FeedRecordService;
import com.final_back.service.maintainInfo.FeedInfoService;
import com.final_back.utils.date.DateUtils;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class FeedRecordController {

    @Autowired
    FeedInfoService feedInfoService;
    @Autowired
    FeedRecordService feedRecordService;


    /**
     * 增加投喂记录
     *
     * @param feedRecord
     * @return
     */
    @RequestMapping("/addFeedRecord")
    public Result<?> addFeedRecord(@RequestBody FeedRecord feedRecord) {

        //更新用料表
        Double feedAmount = feedRecord.getFeedAmount();
        Long feedId = feedRecord.getFeedId();
        FeedInfo feedInfo = feedInfoService.getFeedInfoById(feedId);
        Double restAmount = feedInfo.getTotalAmount() - feedAmount;

        if (restAmount >= 0) {
            feedInfo.setTotalAmount(restAmount);
            feedInfoService.updateFeedInfo(feedInfo);
        } else {
            return ResultUtil.success("用料不足");
        }

        int i = feedRecordService.addFeedRecord(feedRecord);

        if (i > 0) {
            return ResultUtil.success("输入成功");
        } else {
            return ResultUtil.success("输入失败");
        }
    }

    /**
     * 取得所有投喂记录
     *
     * @return
     */
    @RequestMapping("/getAllFeedRecord")
    public Result<?> getAllFeedRecord() {
        List<FeedRecord> allFeedRecord = feedRecordService.getAllFeedRecord();
        return ResultUtil.success(allFeedRecord);
    }

    /**
     * 删除投喂记录
     *
     * @param feedRecord
     * @return
     */
    @RequestMapping("/deleteFeedRecord")
    public Result<?> deleteFeedRecord(@RequestBody FeedRecord feedRecord) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("feed_record_id", feedRecord.getFeedRecordId());
        int i = feedRecordService.deleteFeedRecord(map);
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新投喂记录
     *
     * @param feedRecord
     * @return
     */
    @RequestMapping("/updateFeedRecord")
    public Result<?> updateFeedRecord(@RequestBody FeedRecord feedRecord) {
        int i = feedRecordService.updateFeedRecord(feedRecord);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 取得一段时间内的投药记录
     *
     * @param rangeTime
     * @return
     */
    @RequestMapping("/getRangeTimeFeedRecord")
    public Result<?> getRangeTimeFeedRecord(@RequestBody RangeTime rangeTime) {
        List<FeedRecord> feedRecordList = feedRecordService.getRangeTimeFeedRecord(rangeTime.getStartTime(), rangeTime.getEndTime());
        return ResultUtil.success(feedRecordList);
    }

    /**
     * 通过查询条件获取饲养信息
     *
     * @param feedRecordDTO
     * @return
     */
    @RequestMapping("/getFeedRecordByCondition")
    public Result<?> getFeedRecordByCondition(@RequestBody FeedRecordDTO feedRecordDTO) {
        List<FeedRecord> feedRecordByCondition = feedRecordService.getFeedRecordByCondition(feedRecordDTO.getBatchId(), feedRecordDTO.getFeedPerson(), feedRecordDTO.getRecordPerson(), feedRecordDTO.getStartDate(), feedRecordDTO.getEndDate(), feedRecordDTO.getFeedId(), null, null, null);

        return ResultUtil.success(feedRecordByCondition);
    }

    @RequestMapping("/getFeedRecordChart")
    public Result<?> getFeedRecordChart(@RequestBody FeedRecordDTO feedRecordDTO) {
        List<String> dateNameList = new ArrayList<>();
        List<FeedRecord> feedRecordByCondition = feedRecordService.getFeedRecordByCondition(null, null, null, null, null, feedRecordDTO.getFeedId(), "fr.record_time", 1, 7);
        Iterator<FeedRecord> iterator = feedRecordByCondition.iterator();
        while (iterator.hasNext()) {
            FeedRecord next = (FeedRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", feedRecordByCondition);
        return ResultUtil.success(map);
    }


}
