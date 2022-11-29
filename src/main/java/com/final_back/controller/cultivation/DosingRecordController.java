package com.final_back.controller.cultivation;


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

    @RequestMapping("/addDosingRecord")
    public Result<?> addDosingRecord(@RequestBody DosingRecord dosingRecord){

        Double dosingAmount = dosingRecord.getDosingAmount();
        Long medicineId = dosingRecord.getMedicineId();
        MedicineInfo medicineInfo = medicineInfoService.getMedicineInfoById(medicineId);
        Double leftAmount = medicineInfo.getTotalAmount() - dosingAmount;

        if (leftAmount >= 0){
            medicineInfo.setTotalAmount(leftAmount);
            medicineInfoService.updateMedicineInfo(medicineInfo);
        }else {
            return ResultUtil.success("余量不足");
        }

        int insert = dosingRecordService.addDosingRecord(dosingRecord);

        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllDosingRecord")
    public Result<?> getAllDosingRecord(){
        List<DosingRecord> allDosingRecord = dosingRecordService.getAllDosingRecord();
        return ResultUtil.success(allDosingRecord);
    }

    @RequestMapping("/deleteDosingRecord")
    public Result<?> deleteDosingRecord(@RequestBody DosingRecord dosingRecord){
        HashMap<String, Object> map = new HashMap<>();
        map.put("dosing_record_id", dosingRecord.getDosingRecordId());
        int i = dosingRecordService.deleteDosingRecord(map);
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }


}
