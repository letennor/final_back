package com.final_back.controller;

import com.final_back.entity.BatchInfo;
import com.final_back.mapper.BatchInfoMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatchInfoController {
    @Autowired
    BatchInfoMapper batchInfoMapper;

    @RequestMapping("/getAllBatch")
    public Result<?> getAllBatch(){
        List<BatchInfo> batchInfoList = batchInfoMapper.selectList(null);
        return ResultUtil.success(batchInfoList);
    }

}
