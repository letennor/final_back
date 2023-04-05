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
public class WorkFlowInfo {

    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "work_flow_id", type = IdType.ASSIGN_ID)
    private Long workflowId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long workItemId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long workPerson;

    private Date workDate;


    private Integer isFinished;

    @TableField(exist = false)
    private String workPersonName;

    @TableField(exist = false)
    private String workName;

    @TableField(exist = false)
    private Integer gender;

    @TableField(exist = false)
    private String roleName;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long workBatch;

    @TableField(exist = false)
    private String batchName;

    @TableField(exist = false)
    private String workDescription;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
