package com.final_back.dto;

import com.final_back.entity.cultivation.EggProductionRecord;
import lombok.Data;

import java.util.Date;

@Data
public class EggProductionRecordDTO extends EggProductionRecord {
    private Date startDate;

    private Date endDate;
}
