package com.final_back.entity.maintainInfo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class BatchInfo {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "batch_id", type = IdType.ASSIGN_ID)
    private Long batchId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    private String batchName;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 测试
     */

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
