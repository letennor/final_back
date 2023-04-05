package com.final_back.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.workArrangement.WorkFlowInfo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserBasicInfoDTO extends UserBasicInfo {

    private String userName;

    private Integer state;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long organizationId;

    private String password;

    private String token;

    private String roleName;

    List<WorkFlowInfo> workFlowInfoList;

    private Date beginFreeDate;

    private Date endFreeDate;
}
