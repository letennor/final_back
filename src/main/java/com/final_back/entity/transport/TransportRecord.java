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
public class TransportRecord {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "transport_record_id", type = IdType.ASSIGN_ID)
    private Long transportRecordId;


    private String start;

    private String end;

    private String licensePlate;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long driver;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long goodsId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
