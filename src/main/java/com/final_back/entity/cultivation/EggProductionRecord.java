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
public class EggProductionRecord {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "egg_production_record_id", type = IdType.ASSIGN_ID)
    private Long eggProductionRecordId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    private Integer eggProductionAmount;

    private Double eggProductionRate;

    private Integer badEggProductionAmount;

    private Double badEggProductionRate;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long pickEggPerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    private Date recordTime;

    @TableField(exist = false)
    private String batchName;

    @TableField(exist = false)
    private String recordPersonName;

    @TableField(exist = false)
    private String eggPickPersonName;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
