package com.final_back.controller.cultivation;

import com.final_back.entity.cultivation.IndividualDeathRecord;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndividualDeathRecordController {
    @Autowired
    IndividualDeathRecordMapper individualDeathRecordMapper;

    @RequestMapping("/addIndividualDeathRecord")
    public Result<?> addIndividualDeathRecord(@RequestBody IndividualDeathRecord individualDeathRecord){
        int insert = individualDeathRecordMapper.insert(individualDeathRecord);
        if (insert > 0){
            return ResultUtil.success("插入成功");
        }else {
            return ResultUtil.success("插入失败");
        }
    }

}
