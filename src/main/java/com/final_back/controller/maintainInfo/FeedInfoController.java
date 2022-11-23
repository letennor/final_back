package com.final_back.controller.maintainInfo;


import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.mapper.maintainInfo.FeedInfoMapper;
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
    FeedInfoMapper feedInfoMapper;

    @RequestMapping("/addFeedInfo")
    public Result<?> addFeedInfo(@RequestBody FeedInfo entity){
        System.out.println(entity);
        int insert = feedInfoMapper.insert(entity);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllFeed")
    public Result<?> getAllFeed(){
        List<FeedInfo> feedInfoList = feedInfoMapper.selectList(null);
        return ResultUtil.success(feedInfoList);
    }

}
