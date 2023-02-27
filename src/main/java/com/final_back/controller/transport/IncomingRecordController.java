package com.final_back.controller.transport;

import com.final_back.entity.transport.IncomingRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomingRecordController {

    @Autowired
    IncomingRecordService incomingRecordService;

    /**
     * 增加进蛋记录
     * @param incomingRecord
     * @return
     */
    @RequestMapping("/addIncomingRecord")
    public Result<?> addIncomingRecord(@RequestBody IncomingRecord incomingRecord){
        int insert = incomingRecordService.addIncomingRecord(incomingRecord);
        if (insert > 0) {

            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有进蛋记录
     * @return
     */
    @RequestMapping("/getAllIncomingRecord")
    public Result<?> getAllIncomingRecord(){
        List<IncomingRecord> allIncomingRecord = incomingRecordService.getAllIncomingRecord();
        return ResultUtil.success(allIncomingRecord);
    }

    /**
     * 删除进蛋记录
     * @param incomingRecord
     * @return
     */
    @RequestMapping("/deleteIncomingRecord")
    public Result<?> deleteIncomingRecord(@RequestBody IncomingRecord incomingRecord){
        int i = incomingRecordService.deleteIncomingRecord(incomingRecord);
        if (i > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新进蛋记录
     * @param incomingRecord
     * @return
     */
    @RequestMapping("/updateIncomingRecord")
    public Result<?> updateIncomingRecord(@RequestBody IncomingRecord incomingRecord){
        int i = incomingRecordService.updateIncomingRecord(incomingRecord);
        if (i > 0){
            return ResultUtil.success("修改成功");
        }else {
            return ResultUtil.success("修改失败");
        }
    }


}
