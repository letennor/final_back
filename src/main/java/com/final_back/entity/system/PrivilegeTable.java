package com.final_back.entity.system;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PrivilegeTable {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "privilege_id", type = IdType.ASSIGN_ID)
    private Long privilegeId;

    private String privilegeName;

    private String privilegeCode;

    private String privilegeDescription;

    private String type;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long parentId;

    @TableField(exist = false)
    private List<PrivilegeTable> children;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
