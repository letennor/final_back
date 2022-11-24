package com.final_back.controller.cultivation;

import com.final_back.entity.cultivation.FertilizationRecord;
import com.final_back.mapper.cultivation.FertilizationRecordMapper;
import com.final_back.service.cultivation.FertilizationRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FertilizationRecordController {

    @Autowired
    FertilizationRecordService fertilizationRecordService;

    @RequestMapping("/addFertilizationRecord")
    public Result<?> addFertilizationRecord(@RequestBody FertilizationRecord fertilizationRecord){
        int insert = fertilizationRecordService.addFertilizationRecord(fertilizationRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

}
