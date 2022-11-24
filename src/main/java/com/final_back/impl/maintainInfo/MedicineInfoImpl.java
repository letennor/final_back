package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.MedicineInfo;
import com.final_back.mapper.maintainInfo.MedicineInfoMapper;
import com.final_back.service.maintainInfo.MedicineInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineInfoImpl extends ServiceImpl<MedicineInfoMapper, MedicineInfo> implements MedicineInfoService {

    @Autowired
    MedicineInfoMapper medicineInfoMapper;

    @Override
    public MedicineInfo getMedicineInfoById(Long medicineId) {
        return medicineInfoMapper.selectById(medicineId);

    }

    @Override
    public int updateMedicineInfoById(MedicineInfo medicineInfo) {
        return medicineInfoMapper.updateById(medicineInfo);
    }

    @Override
    public List<MedicineInfo> getAllMedicine() {
        return medicineInfoMapper.selectList(null);
    }

    @Override
    public int addMedicineInfo(MedicineInfo medicineInfo) {
        return medicineInfoMapper.insert(medicineInfo);
    }


}
