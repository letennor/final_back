package com.final_back.controller;


import com.final_back.entity.DosingRecord;
import com.final_back.entity.MedicineInfo;
import com.final_back.mapper.DosingRecordMapper;
import com.final_back.mapper.MedicineInfoMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DosingRecordController {

    @Autowired
    DosingRecordMapper dosingRecordMapper;
    @Autowired
    MedicineInfoMapper medicineInfoMapper;

    @RequestMapping("/addDosingRecord")
    public Result<?> addDosingRecord(@RequestBody DosingRecord dosingRecord){

        Double dosingAmount = dosingRecord.getDosingAmount();
        Long medicineId = dosingRecord.getMedicineId();
        MedicineInfo medicineInfo = medicineInfoMapper.selectById(medicineId);
        Double leftAmount = medicineInfo.getTotalAmount() - dosingAmount;

        if (leftAmount >= 0){
            medicineInfo.setTotalAmount(leftAmount);
            medicineInfoMapper.updateById(medicineInfo);
        }else {
            return ResultUtil.success("余量不足");
        }

        int insert = dosingRecordMapper.insert(dosingRecord);

        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }


    }

}
