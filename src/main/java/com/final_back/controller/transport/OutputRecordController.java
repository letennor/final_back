package com.final_back.controller.transport;

import com.final_back.dto.OutputRecordDTO;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.service.transport.OutputRecordService;
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
public class OutputRecordController {

    @Autowired
    OutputRecordService outputRecordService;

    /**
     * 添加出苗信息
     *
     * @param outputRecord
     * @return
     */
    @RequestMapping("/addOutputRecord")
    public Result<?> addOutputRecord(@RequestBody OutputRecord outputRecord) {
        int insert = outputRecordService.addOutputRecord(outputRecord);
        if (insert > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有出苗信息
     *
     * @return
     */
    @RequestMapping("/getAllOutputRecord")
    public Result<?> getAllOutputRecord() {
        List<OutputRecord> allOutputRecord = outputRecordService.getAllOutputRecord();
        return ResultUtil.success(allOutputRecord);
    }

    /**
     * 删除出苗信息
     *
     * @param outputRecord
     * @return
     */
    @RequestMapping("/deleteOutputRecord")
    public Result<?> deleteOutputRecord(@RequestBody OutputRecord outputRecord) {
        int i = outputRecordService.deleteOutputRecord(outputRecord);
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新出苗信息
     *
     * @param outputRecord
     * @return
     */
    @RequestMapping("/updateOutputRecord")
    public Result<?> updateOutputRecord(@RequestBody OutputRecord outputRecord) {
        int i = outputRecordService.updateOutputRecord(outputRecord);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    /**
     * @param outputRecordDTO
     * @return
     */
    @RequestMapping("/getOutputRecordByCondition")
    public Result<?> getOutputRecordByCondition(@RequestBody OutputRecordDTO outputRecordDTO) {
        List<OutputRecord> outputRecordByCondition = outputRecordService.getOutputRecordByCondition(outputRecordDTO.getBatchId(), outputRecordDTO.getStartDate(), outputRecordDTO.getEndDate(), outputRecordDTO.getRecordPerson(), null, null, null);
        return ResultUtil.success(outputRecordByCondition);
    }

    @RequestMapping("/getOutputRecordChart")
    public Result<?> getOutputRecordChart() {
        List<String> dateNameList = new ArrayList<>();
        List<OutputRecord> outputRecordByCondition = outputRecordService.getOutputRecordByCondition(null, null, null, null, "output_record.record_time", 1, 7);
        Iterator<OutputRecord> iterator = outputRecordByCondition.iterator();
        while (iterator.hasNext()) {
            OutputRecord next = (OutputRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", outputRecordByCondition);
        return ResultUtil.success(map);
    }


}
