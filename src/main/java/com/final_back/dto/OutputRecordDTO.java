package com.final_back.dto;

import com.final_back.entity.transport.OutputRecord;
import lombok.Data;

import java.util.Date;

@Data
public class OutputRecordDTO extends OutputRecord {

    private Date startDate;

    private Date endDate;

}
