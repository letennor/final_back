package com.final_back.entity.system;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class UserBasicInfo {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "user_basic_info_id", type = IdType.ASSIGN_ID)
    private Long userBasicInfoId;

    private Integer gender;

    private String name;

    private Integer age;

    private Integer workYear;

    private Date entryTime;

    private Double salary;

    private String phoneNumber;

    private String wechat;

    private String email;

    private String photo;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
