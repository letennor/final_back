package com.final_back.controller.maintainInfo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.entity.cultivation.FeedRecord;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.cultivation.FeedRecordMapper;
import com.final_back.mapper.maintainInfo.FeedInfoMapper;
import com.final_back.service.maintainInfo.FeedInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedInfoController {

    @Autowired
    FeedInfoService feedInfoService;

    /**
     * 添加饲料信息
     * @param entity
     * @return
     */
    @RequestMapping("/addFeedInfo")
    public Result<?> addFeedInfo(@RequestBody FeedInfo entity){

        int insert = feedInfoService.addFeedInfo(entity);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有饲料信息
     * @return
     */
    @RequestMapping("/getAllFeed")
    public Result<?> getAllFeed(){
        List<FeedInfo> feedInfoList = feedInfoService.getAllFeed();
        return ResultUtil.success(feedInfoList);
    }

    /**
     * 删除饲料信息
     * @param feedInfo
     * @return
     */
    @RequestMapping("/deleteFeedInfo")
    public Result<?> deleteFeedInfo(@RequestBody FeedInfo feedInfo){
        int i = feedInfoService.deleteFeedInfoById(feedInfo.getFeedId());
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新饲料信息
     * @param feedInfo
     * @return
     */
    @RequestMapping("/updateFeedInfo")
    public Result<?> updateFeedInfo(@RequestBody FeedInfo feedInfo){
        int i = feedInfoService.updateFeedInfo(feedInfo);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

}
