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
public class IndividualDeathRecord {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "individual_death_record_id", type = IdType.ASSIGN_ID)
    private Long individualDeathRecordId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long deathRecordId;

    private String deathReason;

    private String picture;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    private Date recordTime;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
