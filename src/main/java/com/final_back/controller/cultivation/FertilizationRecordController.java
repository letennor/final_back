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

import java.util.HashMap;
import java.util.List;

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

    @RequestMapping("/getAllFertilizationRecord")
    public Result<?> getAllFertilizationRecord(){
        List<FertilizationRecord> allFertilizationRecord = fertilizationRecordService.getAllFertilizationRecord();
        return ResultUtil.success(allFertilizationRecord);
    }

    @RequestMapping("/deleteFertilizationRecord")
    public Result<?> deleteFertilizationRecord(@RequestBody FertilizationRecord fertilizationRecord){
        HashMap<String, Object> map = new HashMap<>();
        map.put("fertilization_record_id", fertilizationRecord.getFertilizationRecordId());
        int i = fertilizationRecordService.deleteFertilizationRecord(map);
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    @RequestMapping("/updateFertilizationRecord")
    public Result<?> updateFertilizationRecord(@RequestBody FertilizationRecord fertilizationRecord){
        int i = fertilizationRecordService.updateFertilizationRecord(fertilizationRecord);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

}
