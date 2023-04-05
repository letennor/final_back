package com.final_back.mapper.workArrangement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.workArrangement.WorkFlowInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WorkFlowInfoMapper extends BaseMapper<WorkFlowInfo> {

    List<WorkFlowInfo> getPersonWorkFlowInfo(@Param("workPerson") Long workPerson, @Param("currentDate") Date currentDate, @Param("isFinished") Integer isFinished);

    List<Long> getPersonWorkFlowInfoIdByCondition(@Param("beginFreeDate") Date beginFreeDate, @Param("endFreeDate") Date endFreeDate);

}
