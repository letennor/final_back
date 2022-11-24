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
    public Result<?> getAllBatch(){
        List<BatchInfo> batchInfoList = batchInfoService.getAllBatch();
        return ResultUtil.success(batchInfoList);
    }

}
