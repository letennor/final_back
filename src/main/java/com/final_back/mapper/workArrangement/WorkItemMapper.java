package com.final_back.mapper.workArrangement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.workArrangement.WorkItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkItemMapper extends BaseMapper<WorkItem> {

    List<WorkItem> getWorkItem();

}
