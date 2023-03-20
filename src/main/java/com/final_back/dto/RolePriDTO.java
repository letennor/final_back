package com.final_back.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.final_back.entity.system.RolePri;
import lombok.Data;

import java.util.List;

@Data
public class RolePriDTO extends RolePri {
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> privilegeIds;

}
