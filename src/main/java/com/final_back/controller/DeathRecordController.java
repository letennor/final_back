package com.final_back.controller;

import com.final_back.entity.DeathRecord;
import com.final_back.mapper.DeathRecordMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeathRecordController {

    @Autowired
    DeathRecordMapper deathRecordMapper;

    @RequestMapping("/addDeathRecord")
    public Result<?> addDeathRecord(@RequestBody DeathRecord deathRecord){
        int insert = deathRecordMapper.insert(deathRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllDeathRecord")
    public Result<?> getAllDeathRecord(){
        List<DeathRecord> deathRecordList = deathRecordMapper.selectList(null);
        return ResultUtil.success(deathRecordList);
    }

}
