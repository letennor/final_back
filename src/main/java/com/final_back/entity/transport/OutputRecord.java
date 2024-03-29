package com.final_back.entity.transport;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class OutputRecord {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "output_record_id", type = IdType.ASSIGN_ID)
    private Long outputRecordId;

    private Integer outputAmount;

    private Double outputRate;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long transportRecordId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    private Date recordTime;

    @TableField(exist = false)
    private String batchName;

    @TableField(exist = false)
    private String recordPersonName;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
