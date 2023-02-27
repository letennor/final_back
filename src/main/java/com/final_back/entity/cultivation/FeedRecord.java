package com.final_back.entity.cultivation;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class FeedRecord {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId(value = "feed_record_id", type = IdType.ASSIGN_ID)
    private Long feedRecordId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long batchId;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long feedId;

    private Double feedAmount;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long feedPerson;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long recordPerson;

    private Date recordTime;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
