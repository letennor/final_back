package com.final_back.controller.cultivation;

import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.EggProductionRecordDTO;
import com.final_back.dto.RangeTime;
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

    /**
     * 添加产蛋记录
     * @param eggProductionRecord
     * @return
     */
    @RequestMapping("/addEggProductionRecord")
    public Result<?> addEggProductionRecord(@RequestBody EggProductionRecord eggProductionRecord) {
        int insert = eggProductionRecordService.addEggProductionRecord(eggProductionRecord);
        if (insert > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有产蛋记录
     * @return
     */
    @RequestMapping("/getAllEggProductionRecord")
    public Result<?> getAllEggProductionRecord() {
        List<EggProductionRecord> allEggProductionRecord = eggProductionRecordService.getAllEggProductionRecord();
        return ResultUtil.success(allEggProductionRecord);
    }

    /**
     * 删除产蛋记录
     * @param eggProductionRecord
     * @return
     */
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

    /**
     * 更新产蛋记录
     * @param eggProductionRecord
     * @return
     */
    @RequestMapping("/updateEggProductionRecord")
    public Result<?> updateEggProductionRecord(@RequestBody EggProductionRecord eggProductionRecord){
        int i = eggProductionRecordService.updateEggProductionRecord(eggProductionRecord);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 获得一段时间内产蛋记录
     * @param rangeTime
     * @return
     */
    @RequestMapping("/getRangeTimeEggProductionRecord")
    public Result<?> getRangeTimeEggProductionRecord(@RequestBody RangeTime rangeTime){
        System.out.println(rangeTime);
        List<EggProductionRecord> eggProductionRecordList = eggProductionRecordService.getRangeTimeEggProductionRecord(rangeTime.getStartTime(), rangeTime.getEndTime());
        return ResultUtil.success(eggProductionRecordList);
    }

    /**
     * 通过查询条件获取产蛋量信息
     * @param eggProductionRecordDTO
     * @return
     */
    @RequestMapping("/getEggProductionRecordByCondition")
    public Result<?> getEggProductionRecordByCondition(@RequestBody EggProductionRecordDTO eggProductionRecordDTO){
        List<EggProductionRecord> eggProductionRecordByCondition = eggProductionRecordService.getEggProductionRecordByCondition(eggProductionRecordDTO.getBatchId(), eggProductionRecordDTO.getPickEggPerson(), eggProductionRecordDTO.getRecordPerson(), eggProductionRecordDTO.getStartDate(), eggProductionRecordDTO.getEndDate());
        return ResultUtil.success(eggProductionRecordByCondition);
    }

}
