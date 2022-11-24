package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.entity.maintainInfo.MedicineInfo;
import com.final_back.mapper.cultivation.DosingRecordMapper;
import com.final_back.mapper.maintainInfo.MedicineInfoMapper;
import com.final_back.service.cultivation.DosingRecordService;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DosingRecordImpl extends ServiceImpl<DosingRecordMapper, DosingRecord> implements DosingRecordService {

    @Autowired
    DosingRecordMapper dosingRecordMapper;
    @Autowired
    MedicineInfoMapper medicineInfoMapper;

    @Override
    public int addDosingRecord(DosingRecord dosingRecord) {
        return dosingRecordMapper.insert(dosingRecord);
    }

    @Override
    public List<DosingRecord> getAllDosingRecord() {
        return dosingRecordMapper.selectList(null);
    }

    @Override
    public int deleteDosingRecord(Map<String, Object> map) {
        return dosingRecordMapper.deleteByMap(map);
    }
}
