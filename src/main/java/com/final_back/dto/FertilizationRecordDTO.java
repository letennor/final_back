package com.final_back.dto;

import com.final_back.entity.cultivation.FertilizationRecord;
import lombok.Data;

import java.util.Date;

@Data
public class FertilizationRecordDTO extends FertilizationRecord {

    private Date startDate;

    private Date endDate;

    private Date fertilizationStartDate;

    private Date fertilizationEndDate;

}
