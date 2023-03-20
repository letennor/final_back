package com.final_back.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.final_back.entity.system.UserBasicInfo;
import lombok.Data;

@Data
public class UserBasicInfoDTO extends UserBasicInfo {

    private String userName;

    private Integer state;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long organizationId;

    private String password;

    private String token;
}
