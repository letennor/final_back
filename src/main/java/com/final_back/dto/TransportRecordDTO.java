package com.final_back.dto;

import com.final_back.entity.transport.TransportRecord;
import lombok.Data;

import java.util.Date;


@Data
public class TransportRecordDTO extends TransportRecord {

    private Date startDate;

    private Date endDate;

}
