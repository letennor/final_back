package com.final_back.impl.workArrangement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.workArrangement.WorkflowInfo;
import com.final_back.mapper.workArrangement.WorkflowInfoMapper;
import com.final_back.service.workArrangement.WorkflowInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkflowInfoImpl extends ServiceImpl<WorkflowInfoMapper, WorkflowInfo> implements WorkflowInfoService {
    /**
     * 取得用户所有为完成的工作
     * @param userBasicInfo
     * @return
     */
    @Override
    public List<WorkflowInfo> getAllPersonUndoneWork(Long userBasicInfo) {
        return null;
    }

    /**
     * 添加工作流程
     * @param workflowInfo
     * @return
     */
    @Override
    public Integer addWorkflowInfo(WorkflowInfo workflowInfo) {
        return null;
    }

    /**
     * 改变工作状态
     * @param workflowId
     * @return
     */
    @Override
    public Integer changeWorkflowState(Long workflowId) {
        return null;
    }

    /**
     * 判断员工在选择的日期是否有空
     * @param userId
     * @param workDate
     * @return
     */
    @Override
    public Boolean checkIfFree(Long userId, Date workDate) {
        return null;
    }


}
