package com.final_back.controller.maintainInfo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.entity.maintainInfo.GoodsInfo;
import com.final_back.entity.maintainInfo.MedicineInfo;
import com.final_back.mapper.cultivation.DosingRecordMapper;
import com.final_back.mapper.maintainInfo.MedicineInfoMapper;
import com.final_back.service.maintainInfo.MedicineInfoService;
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
    MedicineInfoService medicineInfoService;

    /**
     * 添加药物信息
     * @param medicineInfo
     * @return
     */
    @RequestMapping("/addMedicine")
    public Result<?> addMedicine(@RequestBody MedicineInfo medicineInfo){
        int insert = medicineInfoService.addMedicineInfo(medicineInfo);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有药物信息
     * @return
     */
    @RequestMapping("/getAllMedicine")
    public Result<?> getAllMedicine(){
        List<MedicineInfo> medicineInfoList = medicineInfoService.getAllMedicine();
        return ResultUtil.success(medicineInfoList);
    }

    /**
     * 删除药物信息
     * @param medicineInfo
     * @return
     */
    @RequestMapping("/deleteMedicineInfo")
    public Result<?> deleteMedicineInfo(@RequestBody MedicineInfo medicineInfo){
        int i = medicineInfoService.deleteMedicineInfoById(medicineInfo.getMedicineId());
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }

    }

    /**
     * 更新药物信息
     * @param medicineInfo
     * @return
     */
    @RequestMapping("/updateMedicineInfo")
    public Result<?> updateMedicineInfo(@RequestBody MedicineInfo medicineInfo){
        int i = medicineInfoService.updateMedicineInfo(medicineInfo);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

}
