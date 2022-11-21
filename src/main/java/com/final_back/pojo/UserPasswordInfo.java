package com.final_back.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserPasswordInfo {
    @TableId(value = "user_password_info_id", type = IdType.ID_WORKER)
    private Long UserPasswordInfoId;

    private Long userBasicInfoId;

    private Integer state;

    private String userName;

    private String password;

    private Long organizationId;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
