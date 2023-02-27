package com.final_back.impl.cultivation;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.cultivation.DeathRecord;
import com.final_back.entity.cultivation.IndividualDeathRecord;
import com.final_back.mapper.cultivation.DeathRecordMapper;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.service.cultivation.DeathRecordService;
import com.final_back.service.cultivation.IndividualDeathRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class DeathRecordImpl extends ServiceImpl<DeathRecordMapper, DeathRecord> implements DeathRecordService {

    @Autowired
    DeathRecordMapper deathRecordMapper;
    @Autowired
    IndividualDeathRecordMapper individualDeathRecordMapper;
    @Autowired
    IndividualDeathRecordService individualDeathRecordService;


    @Override
    public int addDeathRecord(DeathRecord deathRecord) {
        return deathRecordMapper.insert(deathRecord);
    }

    @Override
    public List<DeathRecord> getAllDeathRecord() {
        return deathRecordMapper.selectList(null    );
    }

    @Override
    public int deleteDeathRecordById(Long deathRecordId) {
        //先删除最里面的表：个体死亡记录
        //取出个体死亡表的所有id
        //先删掉这个id子表的所有id，再删这个id

        List<Long> individualDeathRecordServiceAllId = individualDeathRecordService.getIdList(deathRecordId, null);
        individualDeathRecordService.deleteIndividualDeathRecordByIdList(individualDeathRecordServiceAllId);
        deathRecordMapper.deleteById(deathRecordId);

        return 1;
    }

    @Override
    public List<Long> getIdList(Long batchId, Long deathRecordPerson, Long recordPerson) {
        return deathRecordMapper.getIdList(batchId, deathRecordPerson, recordPerson);
    }

    @Override
    public int deleteDeathRecordByIdList(List<Long> idList) {
        if (idList.size() > 0){
            //因为有联表，遍历之后一个个删除
            int i = 0;

            Iterator iterator = idList.iterator();
            while (iterator.hasNext()){
                Long deathRecordId = (Long) iterator.next();
                i += deleteDeathRecordById(deathRecordId);
            }
            return i;
        }
        return 0;
    }

    @Override
    public int updateDeathRecord(DeathRecord deathRecord) {
        return deathRecordMapper.updateById(deathRecord);
    }

    /**
     * 按查询条件返回死亡记录
     * @param recordtartDate
     * @param recordEndDate
     * @param batchId
     * @param recordPerson
     * @return
     */
    @Override
    public List<DeathRecord> getDeathRecordByCondition(Date recordtartDate, Date recordEndDate, Long batchId,
                                                       Long recordPerson) {
        return null;
    }
}
