package com.final_back.service.workArrangement;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.workArrangement.WorkItem;

import java.util.List;

public interface WorkItemService extends IService<WorkItem> {

    List<WorkItem> getAllWorkItem();

    List<WorkItem> getWorkItemByRole(Long roleId);

}
