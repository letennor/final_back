package com.final_back.controller.cultivation;

import com.final_back.entity.cultivation.IndividualDeathRecord;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.service.cultivation.IndividualDeathRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class IndividualDeathRecordController {

    @Autowired
    IndividualDeathRecordService individualDeathRecordService;

    @RequestMapping("/addIndividualDeathRecord")
    public Result<?> addIndividualDeathRecord(@RequestBody IndividualDeathRecord individualDeathRecord){
        int insert = individualDeathRecordService.addIndividualDeathRecord(individualDeathRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllIndividualDeathRecord")
    public Result<?> getAllIndividualDeathRecord(){
        List<IndividualDeathRecord> allIndividualDeathRecord = individualDeathRecordService.getAllIndividualDeathRecord();
        return ResultUtil.success(allIndividualDeathRecord);
    }

    @RequestMapping("/deleteIndividualDeathRecord")
    public Result<?> deleteIndividualDeathRecord(@RequestBody IndividualDeathRecord individualDeathRecord){
        HashMap<String, Object> map = new HashMap<>();
        map.put("individual_death_record_id", individualDeathRecord.getIndividualDeathRecordId());
        int i = individualDeathRecordService.deleteIndividualDeathRecord(map);
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    @RequestMapping("/updateIndividualDeathRecord")
    public Result<?> updateIndividualDeathRecord(@RequestBody IndividualDeathRecord individualDeathRecord){
        int i = individualDeathRecordService.updateIndividualDeathRecord(individualDeathRecord);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

}
