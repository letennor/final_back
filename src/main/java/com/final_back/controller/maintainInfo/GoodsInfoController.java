package com.final_back.controller.maintainInfo;

import com.final_back.entity.maintainInfo.GoodsInfo;
import com.final_back.mapper.maintainInfo.GoodsInfoMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsInfoController {

    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    @RequestMapping("/getAllGoodsInfo")
    public Result<?> getAllGoodsInfo(){
        List<GoodsInfo> goodsInfoList = goodsInfoMapper.selectList(null);
        return ResultUtil.success(goodsInfoList);
    }

    @RequestMapping("/addGoodsInfo")
    public Result<?> addGoodsInfo(@RequestBody GoodsInfo goodsInfo){
        int insert = goodsInfoMapper.insert(goodsInfo);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

}
