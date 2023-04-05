package com.final_back.service.workArrangement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.workArrangement.WorkFlowInfo;

import java.util.Date;
import java.util.List;

public interface WorkFlowInfoService extends IService<WorkFlowInfo> {


    Integer addWorkflowInfo(WorkFlowInfo workflowInfo);

    Integer changeWorkflowState(Long workflowId);

    Boolean checkIfFree(Long userId, Date workDate);

    List<WorkFlowInfo> getPersonWorkFlowInfo(Long workPerosn, Date currentDate);

    List<UserBasicInfoDTO> getPersonWorkInfo();

    List<Long> getPersonWorkFlowInfoIdByCondition(Date beginFreeDate, Date endFreeDate);

    List<WorkFlowInfo> getPersonUndoneWork(Long userId);

}
