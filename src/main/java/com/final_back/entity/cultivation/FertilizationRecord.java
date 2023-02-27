package com.final_back.entity.cultivation;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class FertilizationRecord {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "fertilization_record_id", type = IdType.ASSIGN_ID)
    private Long fertilizationRecordId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    private Double fertilizationRate;

    private Date fertilizationTime;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long operatePerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    private Date recordTime;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
