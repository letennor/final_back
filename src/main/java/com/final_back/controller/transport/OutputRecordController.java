package com.final_back.controller.transport;

import com.final_back.entity.transport.IncomingRecord;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutputRecordController {

    @Autowired
    OutputRecordService outputRecordService;

    @RequestMapping("/addOutputRecord")
    public Result<?> addOutputRecord(@RequestBody OutputRecord outputRecord){
        int insert = outputRecordService.addOutputRecord(outputRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllOutputRecord")
    public Result<?> getAllOutputRecord(){
        List<OutputRecord> allOutputRecord = outputRecordService.getAllOutputRecord();
        return ResultUtil.success(allOutputRecord);
    }

    @RequestMapping("/deleteOutputRecord")
    public Result<?> deleteOutputRecord(@RequestBody OutputRecord outputRecord){
        int i = outputRecordService.deleteOutputRecord(outputRecord);
        if ( i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    @RequestMapping("/updateOutputRecord")
    public Result<?> updateOutputRecord(@RequestBody OutputRecord outputRecord){
        int i = outputRecordService.updateOutputRecord(outputRecord);
        if ( i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }

}
