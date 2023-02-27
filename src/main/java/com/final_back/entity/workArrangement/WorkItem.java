package com.final_back.entity.workArrangement;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class WorkItem {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "work_item_id", type = IdType.ASSIGN_ID)
    private Long workItemId;

    private String workName;

    private String workDescription;

    private Long privilegeId;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
