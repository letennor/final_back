package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.MedicineInfo;
import com.final_back.mapper.maintainInfo.MedicineInfoMapper;
import com.final_back.service.cultivation.DosingRecordService;
import com.final_back.service.maintainInfo.MedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineInfoImpl extends ServiceImpl<MedicineInfoMapper, MedicineInfo> implements MedicineInfoService {

    @Autowired
    MedicineInfoMapper medicineInfoMapper;
    @Autowired
    DosingRecordService dosingRecordService;

    @Override
    public MedicineInfo getMedicineInfoById(Long medicineId) {
        return medicineInfoMapper.selectById(medicineId);

    }

    @Override
    public List<MedicineInfo> getAllMedicine() {
        return medicineInfoMapper.selectList(null);
    }

    @Override
    public int addMedicineInfo(MedicineInfo medicineInfo) {
        return medicineInfoMapper.insert(medicineInfo);
    }

    @Override
    public int deleteMedicineInfoById(Long medicineId) {
        //删除投药情况、药物情况
        List<Long> dosingRecordIdList = dosingRecordService.getIdList(medicineId, null, null, null);
        dosingRecordService.deleteDosingRecordByIdList(dosingRecordIdList);
        int i = medicineInfoMapper.deleteById(medicineId);
        return i;
    }

    @Override
    public int updateMedicineInfo(MedicineInfo medicineInfo) {
        return medicineInfoMapper.updateById(medicineInfo);
    }


}
