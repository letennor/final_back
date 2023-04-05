package com.final_back.dto;

import com.final_back.entity.workArrangement.WorkFlowInfo;
import lombok.Data;

import java.util.Date;

@Data
public class WorkFlowInfoDTO extends WorkFlowInfo {

    private Date finishDate;

}
