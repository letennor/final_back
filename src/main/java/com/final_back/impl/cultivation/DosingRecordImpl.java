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

import java.util.Date;
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
        return dosingRecordMapper.getAllDosingRecord();
    }

    @Override
    public int deleteDosingRecord(Map<String, Object> map) {
        return dosingRecordMapper.deleteByMap(map);
    }

    @Override
    public List<Long> getIdList(Long medicineId, Long dosingPerson, Long recordPerson, Long batchId) {
        return dosingRecordMapper.getIdList(medicineId, dosingPerson, recordPerson, batchId);
    }

    @Override
    public int deleteDosingRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            return dosingRecordMapper.deleteBatchIds(idList);
        }
        return 0;
    }

    @Override
    public int updateDosingRecord(DosingRecord dosingRecord) {
        return dosingRecordMapper.updateById(dosingRecord);
    }

    @Override
    public List<DosingRecord> getRangeTimeDosingRecord(Date startTime, Date endTime) {
        return dosingRecordMapper.getRangeTimeDosingRecord(startTime, endTime);
    }

    /**
     * 按查询条件返回投药记录
     * @param medicineId
     * @param batchId
     * @param dosingPerson
     * @param startDate
     * @param endDate
     * @param recordPerson
     * @return
     */
    @Override
    public List<DosingRecord> getDosingRecordByCondition(Long medicineId, Long batchId, Long dosingPerson,
                                                         Date startDate, Date endDate, Long recordPerson) {

        List<DosingRecord> dosingRecordByCondition = dosingRecordMapper.getDosingRecordByCondition(recordPerson, medicineId, dosingPerson, batchId, startDate, endDate);
        return dosingRecordByCondition;
    }
}
