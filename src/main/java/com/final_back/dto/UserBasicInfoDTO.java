package com.final_back.dto;

import com.final_back.entity.system.UserBasicInfo;
import lombok.Data;

@Data
public class UserBasicInfoDTO extends UserBasicInfo {

    private String account;

    private String password;
}
