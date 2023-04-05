package com.final_back.impl.workArrangement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.workArrangement.WorkFlowInfo;
import com.final_back.mapper.workArrangement.WorkFlowInfoMapper;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.workArrangement.WorkFlowInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkFlowInfoImpl extends ServiceImpl<WorkFlowInfoMapper, WorkFlowInfo> implements WorkFlowInfoService {
    @Autowired
    UserBasicInfoService userBasicInfoService;
    @Autowired
    WorkFlowInfoMapper workflowInfoMapper;

    /**
     * 添加工作流程
     *
     * @param workflowInfo
     * @return
     */
    @Override
    public Integer addWorkflowInfo(WorkFlowInfo workflowInfo) {
        return null;
    }

    /**
     * 改变工作状态
     *
     * @param workflowId
     * @return
     */
    @Override
    public Integer changeWorkflowState(Long workflowId) {
        return null;
    }

    /**
     * 判断员工在选择的日期是否有空
     *
     * @param userId
     * @param workDate
     * @return
     */
    @Override
    public Boolean checkIfFree(Long userId, Date workDate) {
        return null;
    }

    /**
     * 某个人的工作信息流
     *
     * @param workPerosn
     * @return
     */
    @Override
    public List<WorkFlowInfo> getPersonWorkFlowInfo(Long workPerosn, Date currentDate) {
        List<WorkFlowInfo> personWorkFlowInfo = workflowInfoMapper.getPersonWorkFlowInfo(workPerosn, currentDate, 0);
        return personWorkFlowInfo;
    }

    @Override
    public List<UserBasicInfoDTO> getPersonWorkInfo() {

        return null;
    }

    @Override
    public List<Long> getPersonWorkFlowInfoIdByCondition(Date beginFreeDate, Date endFreeDate) {
        List<Long> personWorkFlowInfoIdByCondition = workflowInfoMapper.getPersonWorkFlowInfoIdByCondition(beginFreeDate, endFreeDate);
        return personWorkFlowInfoIdByCondition;
    }

    /**
     * 取得所有未完成的任务
     *
     * @param userId
     * @return
     */
    @Override
    public List<WorkFlowInfo> getPersonUndoneWork(Long userId) {
        List<WorkFlowInfo> personWorkFlowInfo = workflowInfoMapper.getPersonWorkFlowInfo(userId, null, 0);

        return personWorkFlowInfo;
    }


}
