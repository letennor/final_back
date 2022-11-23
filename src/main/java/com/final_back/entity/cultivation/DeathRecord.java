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
public class DeathRecord {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "death_record_id", type = IdType.ID_WORKER)
    private Long deathRecordId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    private Integer deathNumber;

    private Double deathRate;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long deathRecordPerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
