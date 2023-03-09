package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.IndividualDeathRecord;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.service.cultivation.IndividualDeathRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class IndividualDeathRecordImpl extends ServiceImpl<IndividualDeathRecordMapper, IndividualDeathRecord> implements IndividualDeathRecordService {
    @Autowired
    IndividualDeathRecordMapper individualDeathRecordMapper;

    @Override
    public int addIndividualDeathRecord(IndividualDeathRecord individualDeathRecord) {
        return individualDeathRecordMapper.insert(individualDeathRecord);
    }

    @Override
    public List<IndividualDeathRecord> getAllIndividualDeathRecord() {
        return individualDeathRecordMapper.getAllIndividualDeathRecord();
    }

    @Override
    public int deleteIndividualDeathRecord(Map<String, Object> map) {
        return individualDeathRecordMapper.deleteByMap(map);
    }

    @Override
    public List<Long> getIdList(Long deathRecordId, Long recordPerson) {
        return individualDeathRecordMapper.getIdList(deathRecordId, recordPerson);
    }


    @Override
    public int deleteIndividualDeathRecordByIdList(List<Long> idList) {
        if (idList.size() != 0){
            return individualDeathRecordMapper.deleteBatchIds(idList);
        }else {
            return 0;
        }

    }

    @Override
    public int updateIndividualDeathRecord(IndividualDeathRecord individualDeathRecord) {
        return individualDeathRecordMapper.updateById(individualDeathRecord);
    }

    /**
     * 按查询条件返回个体死亡记录
     * @param recordPerson
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<IndividualDeathRecord> getIndividualDeathRecordByCondition(Long recordPerson, Date startDate,
                                                                           Date endDate) {

        List<IndividualDeathRecord> individualDeathRecordByCondition = individualDeathRecordMapper.getIndividualDeathRecordByCondition(recordPerson, startDate, endDate);
        return individualDeathRecordByCondition;
    }
}
