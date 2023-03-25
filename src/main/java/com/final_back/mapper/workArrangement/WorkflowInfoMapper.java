package com.final_back.mapper.workArrangement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.workArrangement.WorkflowInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkflowInfoMapper extends BaseMapper<WorkflowInfo> {

    List<WorkflowInfo> getPersonWorkFlowInfo(@Param("workPerson") Long workPerson, @Param("currentDate") Date currentDate);

    List<Long> getPersonWorkFlowInfoIdByCondition(@Param("beginFreeDate") Date beginFreeDate, @Param("endFreeDate") Date endFreeDate);

}
