package com.final_back.controller;


import com.final_back.entity.MedicineInfo;
import com.final_back.mapper.MedicineInfoMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicineInfoController {

    @Autowired
    MedicineInfoMapper medicineInfoMapper;

    @RequestMapping("/addMedicine")
    public Result<?> addMedicine(@RequestBody MedicineInfo medicineInfo){
        int insert = medicineInfoMapper.insert(medicineInfo);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllMedicine")
    public Result<?> getAllMedicine(){
        List<MedicineInfo> medicineInfoList = medicineInfoMapper.selectList(null);
        return ResultUtil.success(medicineInfoList);
    }

}
