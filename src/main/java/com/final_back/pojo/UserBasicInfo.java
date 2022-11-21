package com.final_back.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserBasicInfo {

    @TableId(value = "user_basic_info_id", type = IdType.ID_WORKER)
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

    @TableField(exist = false)
    private String userName;

    @TableField(exist = false)
    private String password;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
