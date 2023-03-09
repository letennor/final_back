package com.final_back.dto;


import com.final_back.entity.cultivation.IndividualDeathRecord;
import lombok.Data;

import java.util.Date;

@Data
public class IndividualDeathRecordDTO extends IndividualDeathRecord {

    private Date startDate;

    private Date endDate;

}
