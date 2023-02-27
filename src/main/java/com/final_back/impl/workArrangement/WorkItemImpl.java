package com.final_back.impl.workArrangement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.workArrangement.WorkItem;
import com.final_back.mapper.workArrangement.WorkItemMapper;
import com.final_back.service.workArrangement.WorkItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkItemImpl extends ServiceImpl<WorkItemMapper, WorkItem> implements WorkItemService {
    /**
     * 返回所有的工作项目
     * @return
     */
    @Override
    public List<WorkItem> getAllWorkItem() {
        return null;
    }

    /**
     * 通过角色取得相对应的工作项目
     * @return
     */
    @Override
    public List<WorkItem> getWorkItemByRole(Long roleId) {
        return null;
    }
}
