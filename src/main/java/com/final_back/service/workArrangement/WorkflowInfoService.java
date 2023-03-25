package com.final_back.service.workArrangement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.workArrangement.WorkflowInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WorkflowInfoService extends IService<WorkflowInfo> {

    List<WorkflowInfo> getAllPersonUndoneWork(Long userBasicInfo);

    Integer addWorkflowInfo(WorkflowInfo workflowInfo);

    Integer changeWorkflowState(Long workflowId);

    Boolean checkIfFree(Long userId, Date workDate);

    List<WorkflowInfo> getPersonWorkFlowInfo(Long workPerosn, Date currentDate);

    List<UserBasicInfoDTO> getPersonWorkInfo();

    List<Long> getPersonWorkFlowInfoIdByCondition(Date beginFreeDate, Date endFreeDate);

}
