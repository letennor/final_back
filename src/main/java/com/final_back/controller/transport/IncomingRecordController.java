package com.final_back.controller.transport;

import com.final_back.entity.transport.IncomingRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomingRecordController {

    @Autowired
    IncomingRecordMapper incomingRecordMapper;

    @RequestMapping("/addIncomingRecord")
    public Result<?> addIncomingRecord(@RequestBody IncomingRecord incomingRecord){
        int insert = incomingRecordMapper.insert(incomingRecord);
        if (insert > 0) {

            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

}
