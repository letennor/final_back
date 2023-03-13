package com.final_back.controller.transport;

import com.final_back.dto.IncomingRecordDTO;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.mapper.transport.IncomingRecordMapper;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.utils.date.DateUtils;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
public class IncomingRecordController {

    @Autowired
    IncomingRecordService incomingRecordService;

    /**
     * 增加进蛋记录
     *
     * @param incomingRecord
     * @return
     */
    @RequestMapping("/addIncomingRecord")
    public Result<?> addIncomingRecord(@RequestBody IncomingRecord incomingRecord) {
        int insert = incomingRecordService.addIncomingRecord(incomingRecord);
        if (insert > 0) {

            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    /**
     * 取得所有进蛋记录
     *
     * @return
     */
    @RequestMapping("/getAllIncomingRecord")
    public Result<?> getAllIncomingRecord() {
        List<IncomingRecord> allIncomingRecord = incomingRecordService.getAllIncomingRecord();
        return ResultUtil.success(allIncomingRecord);
    }

    /**
     * 删除进蛋记录
     *
     * @param incomingRecord
     * @return
     */
    @RequestMapping("/deleteIncomingRecord")
    public Result<?> deleteIncomingRecord(@RequestBody IncomingRecord incomingRecord) {
        int i = incomingRecordService.deleteIncomingRecord(incomingRecord);
        if (i > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

    /**
     * 更新进蛋记录
     *
     * @param incomingRecord
     * @return
     */
    @RequestMapping("/updateIncomingRecord")
    public Result<?> updateIncomingRecord(@RequestBody IncomingRecord incomingRecord) {
        int i = incomingRecordService.updateIncomingRecord(incomingRecord);
        if (i > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }


    /**
     * 按条件获取进蛋记录
     *
     * @param incomingRecordDTO
     * @return
     */
    @RequestMapping("/getIncomingRecordByCondition")
    public Result<?> getIncomingRecordByCondition(@RequestBody IncomingRecordDTO incomingRecordDTO) {
        List<IncomingRecord> incomingRecordByCondition = incomingRecordService.getIncomingRecordByCondition(incomingRecordDTO.getBatchId(), incomingRecordDTO.getStartDate(), incomingRecordDTO.getEndDate(), incomingRecordDTO.getMinAmount(), incomingRecordDTO.getMaxAmount(), incomingRecordDTO.getGoodsId(), null, null, null);
        return ResultUtil.success(incomingRecordByCondition);
    }

    @RequestMapping("/getIncomingRecordChart")
    public Result<?> getIncomingRecordChart(@RequestBody IncomingRecordDTO incomingRecordDTO) {
        List<String> dateNameList = new ArrayList<>();
        List<IncomingRecord> incomingRecordByCondition = incomingRecordService.getIncomingRecordByCondition(null, null, null, null, null, incomingRecordDTO.getGoodsId(), "ir.record_time", 1, 7);
        Iterator<IncomingRecord> iterator = incomingRecordByCondition.iterator();
        while (iterator.hasNext()) {
            IncomingRecord next = (IncomingRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", incomingRecordByCondition);
        return ResultUtil.success(map);
    }

}
