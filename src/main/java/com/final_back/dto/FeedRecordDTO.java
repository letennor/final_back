package com.final_back.dto;

import com.final_back.entity.cultivation.FeedRecord;
import lombok.Data;

import java.util.Date;

@Data
public class FeedRecordDTO extends FeedRecord {

    private Date startDate;

    private Date endDate;

}
