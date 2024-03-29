package com.final_back.controller.maintainInfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.mapper.cultivation.*;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.service.workArrangement.WorkItemService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BatchInfoController {

    @Autowired
    BatchInfoService batchInfoService;
    @Autowired
    WorkItemService workItemService;
    @Autowired
    BatchInfoMapper batchInfoMapper;

    /**
     * 取得所有批次信息
     *
     * @return
     */
    @RequestMapping("/getAllBatch")
    public Result<?> getAllBatch() {
        List<BatchInfo> batchInfoList = batchInfoService.getAllBatch();
        return ResultUtil.success(batchInfoList);
    }

    /**
     * 增加批次信息
     *
     * @param batchInfo
     * @return
     */
    @RequestMapping("/addBatchInfo")
    public Result<?> addBatchInfo(@RequestBody BatchInfo batchInfo) {
        int i = batchInfoService.addBatchInfo(batchInfo);
        if (i > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 删除批次信息
     *
     * @param batchInfo
     * @return
     */
    @RequestMapping("/deleteBatchInfo")
    public Result<?> deleteBatchInfo(@RequestBody BatchInfo batchInfo) {
        int i = batchInfoService.deleteBatchInfoById(batchInfo.getBatchId());
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新批次信息
     *
     * @param batchInfo
     * @return
     */
    @RequestMapping("/updateBatchInfo")
    public Result<?> updateBatchInfo(@RequestBody BatchInfo batchInfo) {
        int i = batchInfoService.updateBatchInfo(batchInfo);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }


    /**
     * 取得批次工作flow
     *
     * @param batchInfo
     * @return
     */
    @RequestMapping("/getBatchWorkFlow")
    public Result<?> getBatchWorkFlow(@RequestBody BatchInfo batchInfo) {
        Map<String, Object> batchWorkFlow = workItemService.getBatchWorkFlow(batchInfo.getBatchId());
        return ResultUtil.success(batchWorkFlow);
    }

    /**
     * 取得不同类型的工作
     */
    @RequestMapping("/getTypeBatchInfo")
    public Result<?> getTypeBatchInfo(@RequestBody BatchInfo batchInfo) {
        QueryWrapper<BatchInfo> batchInfoQueryWrapper = new QueryWrapper<>();
        batchInfoQueryWrapper.eq("type", batchInfo.getType());
        List<BatchInfo> batchInfos = batchInfoMapper.selectList(batchInfoQueryWrapper);

        return ResultUtil.success(batchInfos);
    }


}
