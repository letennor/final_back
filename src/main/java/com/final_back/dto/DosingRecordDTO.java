package com.final_back.dto;

import com.final_back.entity.cultivation.DosingRecord;
import lombok.Data;

import java.util.Date;

@Data
public class DosingRecordDTO extends DosingRecord {

    private Date startDate;

    private Date endDate;

}
