package com.final_back.controller.maintainInfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.entity.maintainInfo.FeedInfo;
import com.final_back.entity.maintainInfo.GoodsInfo;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.maintainInfo.GoodsInfoMapper;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.maintainInfo.GoodsInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;

@RestController
public class GoodsInfoController {
    @Autowired
    GoodsInfoService goodsInfoService;

    @RequestMapping("/getAllGoodsInfo")
    public Result<?> getAllGoodsInfo(){
        List<GoodsInfo> goodsInfoList = goodsInfoService.getAllGoodsInfo();
        return ResultUtil.success(goodsInfoList);
    }

    @RequestMapping("/addGoodsInfo")
    public Result<?> addGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        Long goodsId = goodsInfo.getGoodsId();
        int insert = goodsInfoService.addGoodsInfo(goodsInfo);

        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/deleteGoodsInfo")
    public Result<?> deleteGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        int i = goodsInfoService.deleteGoodsInfoById(goodsInfo.getGoodsId());
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    @RequestMapping("/updateGoodsInfo")
    public Result<?> updateGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        int i = goodsInfoService.updateGoodsInfo(goodsInfo);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

}
