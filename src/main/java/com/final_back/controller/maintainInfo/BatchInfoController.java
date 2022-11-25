package com.final_back.controller.maintainInfo;

import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.mapper.cultivation.*;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatchInfoController {

    @Autowired
    BatchInfoService batchInfoService;

    @RequestMapping("/getAllBatch")
    public Result<?> getAllBatch() {
        List<BatchInfo> batchInfoList = batchInfoService.getAllBatch();
        return ResultUtil.success(batchInfoList);
    }

    @RequestMapping("/addBatchInfo")
    public Result<?> addBatchInfo(@RequestBody BatchInfo batchInfo) {
        int i = batchInfoService.addBatchInfo(batchInfo);
        if (i > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/deleteBatchInfo")
    public Result<?> deleteBatchInfo(@RequestBody BatchInfo batchInfo) {
        int i = batchInfoService.deleteBatchInfoById(batchInfo.getBatchId());
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }

    }

}
