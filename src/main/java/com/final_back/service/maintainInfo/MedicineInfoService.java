package com.final_back.service.maintainInfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.maintainInfo.MedicineInfo;

import java.util.List;

public interface MedicineInfoService extends IService<MedicineInfo> {
    MedicineInfo getMedicineInfoById(Long medicineId);

    List<MedicineInfo> getAllMedicine();

    int addMedicineInfo(MedicineInfo medicineInfo);

    int deleteMedicineInfoById(Long medicineId);

    int updateMedicineInfo(MedicineInfo medicineInfo);
}
