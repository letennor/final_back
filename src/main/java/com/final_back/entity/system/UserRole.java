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
public class UserRole {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "user_role_id", type = IdType.ASSIGN_ID)
    private Long userRoleId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userInfoId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long roleId;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
