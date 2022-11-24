package com.final_back.controller.cultivation;

import com.final_back.entity.cultivation.DeathRecord;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.mapper.cultivation.DeathRecordMapper;
import com.final_back.service.cultivation.DeathRecordService;
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
    DeathRecordService deathRecordService;

    @RequestMapping("/addDeathRecord")
    public Result<?> addDeathRecord(@RequestBody DeathRecord deathRecord){
        int insert = deathRecordService.addDeathRecord(deathRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllDeathRecord")
    public Result<?> getAllDeathRecord(){
        List<DeathRecord> allDeathRecord = deathRecordService.getAllDeathRecord();
        return ResultUtil.success(allDeathRecord);
    }

    @RequestMapping("/deleteDeathRecord")
    public Result<?> deleteDeathRecord(@RequestBody DeathRecord deathRecord){
        Long deathRecordId = deathRecord.getDeathRecordId();
        int i = deathRecordService.deleteDeathRecordById(deathRecordId);

        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

}
