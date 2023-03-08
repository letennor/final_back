package com.final_back.controller.cultivation;


import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.DosingRecordDTO;
import com.final_back.dto.RangeTime;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.entity.maintainInfo.MedicineInfo;
import com.final_back.mapper.cultivation.DosingRecordMapper;
import com.final_back.mapper.maintainInfo.MedicineInfoMapper;
import com.final_back.service.cultivation.DosingRecordService;
import com.final_back.service.maintainInfo.MedicineInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class DosingRecordController {

    @Autowired
    DosingRecordService dosingRecordService;
    @Autowired
    MedicineInfoService medicineInfoService;

    /**
     * 添加投药记录
     * @param dosingRecord
     * @return
     */
    @RequestMapping("/addDosingRecord")
    public Result<?> addDosingRecord(@RequestBody DosingRecord dosingRecord) {

        Double dosingAmount = dosingRecord.getDosingAmount();
        Long medicineId = dosingRecord.getMedicineId();
        MedicineInfo medicineInfo = medicineInfoService.getMedicineInfoById(medicineId);
        Double leftAmount = medicineInfo.getTotalAmount() - dosingAmount;

        if (leftAmount >= 0) {
            medicineInfo.setTotalAmount(leftAmount);
            medicineInfoService.updateMedicineInfo(medicineInfo);
        } else {
            return ResultUtil.success("余量不足");
        }

        int insert = dosingRecordService.addDosingRecord(dosingRecord);

        if (insert > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有投药记录
     * @return
     */
    @RequestMapping("/getAllDosingRecord")
    public Result<?> getAllDosingRecord() {
        List<DosingRecord> allDosingRecord = dosingRecordService.getAllDosingRecord();
        return ResultUtil.success(allDosingRecord);
    }

    /**
     * 删除投药记录
     * @param dosingRecord
     * @return
     */
    @RequestMapping("/deleteDosingRecord")
    public Result<?> deleteDosingRecord(@RequestBody DosingRecord dosingRecord) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("dosing_record_id", dosingRecord.getDosingRecordId());
        int i = dosingRecordService.deleteDosingRecord(map);
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新投药记录
     * @param dosingRecord
     * @return
     */
    @RequestMapping("/updateDosingRecord")
    public Result<?> updateDosingRecord(@RequestBody DosingRecord dosingRecord) {
        int i = dosingRecordService.updateDosingRecord(dosingRecord);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 取得某段时间内投药记录
     * @param rangeTime
     * @return
     */
    @RequestMapping("/getRangeTimeDosingRecord")
    public Result<?> getRangeTimeDosingRecord(@RequestBody RangeTime rangeTime){
        List<DosingRecord> dosingRecordList = dosingRecordService.getRangeTimeDosingRecord(rangeTime.getStartTime(), rangeTime.getEndTime());
        return ResultUtil.success(dosingRecordList);
    }

    /**
     * 通过查询条件获取投药记录
     * @param dosingRecordDTO
     * @return
     */
    @RequestMapping("/getDosingRecordByCondition")
    public Result<?> getDosingRecordByCondition(@RequestBody DosingRecordDTO dosingRecordDTO){
        List<DosingRecord> dosingRecordByCondition = dosingRecordService.getDosingRecordByCondition(dosingRecordDTO.getMedicineId(), dosingRecordDTO.getBatchId(), dosingRecordDTO.getDosingPerson(), dosingRecordDTO.getStartDate(), dosingRecordDTO.getEndDate(), dosingRecordDTO.getRecordPerson());
        return ResultUtil.success(dosingRecordByCondition);
    }

}
