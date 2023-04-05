package com.final_back.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class ArrangeWorkDTO {

    private String jobType;//如果是1，则是流程工作，如果是2，则是其他工作

    private String type;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long driver;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long workItemId;
    private Date workDate;
    @JsonSerialize(using = ToStringSerializer.class)

    private Long workPerson;


}
