package com.final_back.controller.transport;

import com.final_back.entity.transport.OutputRecord;
import com.final_back.mapper.transport.OutputRecordMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutputRecordController {

    @Autowired
    OutputRecordMapper outputRecordMapper;

    @RequestMapping("/addOutputRecord")
    public Result<?> addOutputRecord(@RequestBody OutputRecord outputRecord){
        int insert = outputRecordMapper.insert(outputRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }

    }

}
