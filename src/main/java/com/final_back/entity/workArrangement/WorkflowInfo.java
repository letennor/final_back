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
public class WorkflowInfo {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "workflow_id", type = IdType.ASSIGN_ID)
    private Long workflowId;

    private Long workItemId;

    private Long workPerson;

    private Date workDate;

    private Integer isFinished;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
