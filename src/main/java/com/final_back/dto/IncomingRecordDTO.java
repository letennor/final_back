package com.final_back.dto;

import com.final_back.entity.transport.IncomingRecord;
import lombok.Data;

import java.util.Date;

@Data
public class IncomingRecordDTO extends IncomingRecord {

    private Date startDate;

    private Date endDate;

    private Integer minAmount;

    private Integer maxAmount;

}
