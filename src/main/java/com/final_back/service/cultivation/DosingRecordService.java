package com.final_back.service.cultivation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.mapper.cultivation.DosingRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface DosingRecordService extends IService<DosingRecord> {
    int addDosingRecord(DosingRecord dosingRecord);

}
