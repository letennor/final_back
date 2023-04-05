package com.final_back.service.workArrangement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.workArrangement.WorkItem;

import java.util.List;
import java.util.Map;

public interface WorkItemService extends IService<WorkItem> {

    List<WorkItem> getAllWorkItem();

    List<WorkItem> getWorkItemByRole(Long roleId);

    Integer addWorkItem(WorkItem workItem);

    List<WorkItem> getWorkItem();

    Integer deleteWorkItem(Long workItemId);

    Integer updateWorkItem(WorkItem workItem);

    Map<String, Object> getBatchWorkFlow(Long batchId);

    List<WorkItem> getAllElseWork();

}
