package com.final_back.controller;

import com.final_back.entity.EggProductionRecord;
import com.final_back.mapper.EggProductionRecordMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EggProductionRecordController {

    @Autowired
    EggProductionRecordMapper eggProductionRecordMapper;

    @RequestMapping("/addEggProductionRecord")
    public Result<?> addEggProductionRecord(@RequestBody EggProductionRecord eggProductionRecord){
        System.out.println(eggProductionRecord);
        int insert = eggProductionRecordMapper.insert(eggProductionRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

}
