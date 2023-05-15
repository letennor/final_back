package com.final_back.controller.cultivation;

import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.FertilizationRecordDTO;
import com.final_back.entity.cultivation.FertilizationRecord;
import com.final_back.mapper.cultivation.FertilizationRecordMapper;
import com.final_back.service.cultivation.FertilizationRecordService;
import com.final_back.utils.date.DateUtils;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
public class FertilizationRecordController {

    @Autowired
    FertilizationRecordService fertilizationRecordService;

    /**
     * 增加受精记录
     *
     * @param fertilizationRecord
     * @return
     */
    @RequestMapping("/addFertilizationRecord")
    public Result<?> addFertilizationRecord(@RequestBody FertilizationRecord fertilizationRecord) {
        int insert = fertilizationRecordService.addFertilizationRecord(fertilizationRecord);
        if (insert > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有受精记录
     *
     * @return
     */
    @RequestMapping("/getAllFertilizationRecord")
    public Result<?> getAllFertilizationRecord() {
        List<FertilizationRecord> allFertilizationRecord = fertilizationRecordService.getAllFertilizationRecord();
        return ResultUtil.success(allFertilizationRecord);
    }

    /**
     * 删除受精记录
     *
     * @param fertilizationRecord
     * @return
     */
    @RequestMapping("/deleteFertilizationRecord")
    public Result<?> deleteFertilizationRecord(@RequestBody FertilizationRecord fertilizationRecord) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("fertilization_record_id", fertilizationRecord.getFertilizationRecordId());
        int i = fertilizationRecordService.deleteFertilizationRecord(map);
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新受精记录
     *
     * @param fertilizationRecord
     * @return
     */
    @RequestMapping("/updateFertilizationRecord")
    public Result<?> updateFertilizationRecord(@RequestBody FertilizationRecord fertilizationRecord) {
        int i = fertilizationRecordService.updateFertilizationRecord(fertilizationRecord);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 通过查询条件获取受精记录
     * @param fertilizationRecordDTO
     * @return
     */
    @RequestMapping("/getFertilizationRecordByCondition")
    public Result<?> getFertilizationRecordByCondition(@RequestBody FertilizationRecordDTO fertilizationRecordDTO) {
        List<FertilizationRecord> fertilizationRecordByCondition = fertilizationRecordService.getFertilizationRecordByCondition(fertilizationRecordDTO.getBatchId(), fertilizationRecordDTO.getFertilizationStartDate(), fertilizationRecordDTO.getFertilizationEndDate(), fertilizationRecordDTO.getOperatePerson(), fertilizationRecordDTO.getRecordPerson(), fertilizationRecordDTO.getStartDate(), fertilizationRecordDTO.getEndDate(), null, null, null);
        return ResultUtil.success(fertilizationRecordByCondition);
    }

    @RequestMapping("/getFertilizationRecordChart")
    public Result<?> getFertilizationRecordChart() {
        List<String> dateNameList = new ArrayList<>();
        List<FertilizationRecord> fertilizationRecordByCondition = fertilizationRecordService.getFertilizationRecordByCondition(null, null, null, null, null, null, null, "fr.record_time", 1, 7);
        Iterator<FertilizationRecord> iterator = fertilizationRecordByCondition.iterator();
        while (iterator.hasNext()) {
            FertilizationRecord next = (FertilizationRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", fertilizationRecordByCondition);
        return ResultUtil.success(map);
    }

}
