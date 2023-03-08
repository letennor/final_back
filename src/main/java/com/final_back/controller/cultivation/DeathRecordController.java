package com.final_back.controller.cultivation;

import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.DeathRecordDTO;
import com.final_back.entity.cultivation.DeathRecord;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.mapper.cultivation.DeathRecordMapper;
import com.final_back.service.cultivation.DeathRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class DeathRecordController {

    @Autowired
    DeathRecordService deathRecordService;

    /**
     * 添加死亡记录
     * @param deathRecord
     * @return
     */
    @RequestMapping("/addDeathRecord")
    public Result<?> addDeathRecord(@RequestBody DeathRecord deathRecord){
        int insert = deathRecordService.addDeathRecord(deathRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有死亡记录
     * @return
     */
    @RequestMapping("/getAllDeathRecord")
    public Result<?> getAllDeathRecord(){
        List<DeathRecord> allDeathRecord = deathRecordService.getAllDeathRecord();
        return ResultUtil.success(allDeathRecord);
    }

    /**
     * 删除死亡记录
     * @param deathRecord
     * @return
     */
    @RequestMapping("/deleteDeathRecord")
    public Result<?> deleteDeathRecord(@RequestBody DeathRecord deathRecord){
        int i = deathRecordService.deleteDeathRecordById(deathRecord.getDeathRecordId());
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新死亡记录
     * @param deathRecord
     * @return
     */
    @RequestMapping("/updateDeathRecord")
    public Result<?> updateDeathRecord(@RequestBody DeathRecord deathRecord){
        int i = deathRecordService.updateDeathRecord(deathRecord);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * 通过查询条件获取死亡记录
     * @param deathRecordDTO
     * @return
     */
    @RequestMapping("/getDeathRecordByCondition")
    public Result<?> getDeathRecordByCondition(@RequestBody DeathRecordDTO deathRecordDTO) {

        List<DeathRecord> deathRecordByCondition = deathRecordService.getDeathRecordByCondition(deathRecordDTO.getStartDate(), deathRecordDTO.getEndDate(), deathRecordDTO.getBatchId(), deathRecordDTO.getRecordPerson(), deathRecordDTO.getDeathRecordPerson());

        return ResultUtil.success(deathRecordByCondition);
    }


}
