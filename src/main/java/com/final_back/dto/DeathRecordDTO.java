package com.final_back.dto;

import com.final_back.entity.cultivation.DeathRecord;
import lombok.Data;

import java.util.Date;

@Data
public class DeathRecordDTO extends DeathRecord {
    private Date startDate;

    private Date endDate;
}
