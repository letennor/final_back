package com.final_back.controller.transport;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.mapper.transport.TransportRecordMapper;
import com.final_back.service.transport.TransportRecordService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransportRecordController {
    @Autowired
    TransportRecordService transportRecordService;

    @RequestMapping("/addTransportRecord")
    public Result<?> addTransportRecord(@RequestBody TransportRecord transportRecord) {
        int insert = transportRecordService.addTransportRecord(transportRecord);
        if (insert > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllTransportRecord")
    public Result<?> getAllTransportRecord(){
        List<TransportRecord> transportRecordList = transportRecordService.getAllTransportRecord();
        return ResultUtil.success(transportRecordList);
    }

}
