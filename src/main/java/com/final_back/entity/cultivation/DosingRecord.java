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
public class DosingRecord {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "dosing_record_id", type = IdType.ID_WORKER)
    private Long dosingRecordId;

    private Double dosingAmount;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long medicineId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long dosingPerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
