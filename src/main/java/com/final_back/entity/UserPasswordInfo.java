package com.final_back.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class UserPasswordInfo {
    @TableId(value = "user_password_info_id", type = IdType.ID_WORKER)
    private Long UserPasswordInfoId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long userBasicInfoId;

    private Integer state;

    private String account;

    private String password;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long organizationId;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}