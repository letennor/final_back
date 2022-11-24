package com.final_back.controller.cultivation;

import com.final_back.entity.cultivation.EggProductionRecord;
import com.final_back.mapper.cultivation.EggProductionRecordMapper;
import com.final_back.service.cultivation.EggProductionRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EggProductionRecordController {

    @Autowired
    EggProductionRecordService eggProductionRecordService;

    @RequestMapping("/addEggProductionRecord")
    public Result<?> addEggProductionRecord(@RequestBody EggProductionRecord eggProductionRecord) {
        int insert = eggProductionRecordService.addEggProductionRecord(eggProductionRecord);
        if (insert > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllEggProductionRecord")
    public Result<?> getAllEggProductionRecord() {
        List<EggProductionRecord> allEggProductionRecord = eggProductionRecordService.getAllEggProductionRecord();
        return ResultUtil.success(allEggProductionRecord);
    }

    @RequestMapping("/deleteEggProductionRecord")
    public Result<?> deleteEggProductionRecord(@RequestBody EggProductionRecord eggProductionRecord){
        HashMap<String, Object> map = new HashMap<>();
        map.put("egg_production_record_id", eggProductionRecord.getEggProductionRecordId());
        int i = eggProductionRecordService.deleteEggProductionRecord(map);
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

}
