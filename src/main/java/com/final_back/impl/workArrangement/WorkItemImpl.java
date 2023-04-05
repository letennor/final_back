package com.final_back.impl.workArrangement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.entity.workArrangement.WorkItem;
import com.final_back.entity.workArrangement.WorkFlowInfo;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.mapper.workArrangement.WorkItemMapper;
import com.final_back.mapper.workArrangement.WorkFlowInfoMapper;
import com.final_back.service.workArrangement.WorkItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkItemImpl extends ServiceImpl<WorkItemMapper, WorkItem> implements WorkItemService {

    @Autowired
    WorkItemMapper workItemMapper;
    @Autowired
    WorkFlowInfoMapper workflowInfoMapper;
    @Autowired
    BatchInfoMapper batchInfoMapper;

    /**
     * 返回所有的工作项目
     *
     * @return
     */
    @Override
    public List<WorkItem> getAllWorkItem() {
        return null;
    }

    /**
     * 通过角色取得相对应的工作项目
     *
     * @return
     */
    @Override
    public List<WorkItem> getWorkItemByRole(Long roleId) {
        return null;
    }

    /**
     * 添加工作项目
     *
     * @param workItem
     * @return
     */
    @Override
    public Integer addWorkItem(WorkItem workItem) {
        int insert = workItemMapper.insert(workItem);
        return insert;
    }

    /**
     * 取得workItem
     *
     * @return
     */
    @Override
    public List<WorkItem> getWorkItem() {
        List<WorkItem> workItem = workItemMapper.getWorkItem();
        return workItem;
    }

    /**
     * 删除workItem
     *
     * @param workItemId
     * @return
     */
    @Override
    public Integer deleteWorkItem(Long workItemId) {
        // 先找出workFlowInfo中的所有记录，删除，然后再删除workItem
        QueryWrapper<WorkFlowInfo> workflowInfoQueryWrapper = new QueryWrapper<>();
        workflowInfoQueryWrapper.eq("work_item_id", workItemId);
        workflowInfoMapper.delete(workflowInfoQueryWrapper);

        int i = workItemMapper.deleteById(workItemId);

        return i;
    }

    /**
     * 更新工作项目
     *
     * @param workItem
     * @return
     */
    @Override
    public Integer updateWorkItem(WorkItem workItem) {
        int i = workItemMapper.updateById(workItem);
        return i;
    }

    /**
     * 取得一个批次的所有工作流
     *
     * @param batchId
     * @return
     */
    @Override
    public Map<String, Object> getBatchWorkFlow(Long batchId) {
        //先取得currentId，然后根据batchId，知道type，根据type知道一开始的workId，然后把这条生产线的所有workItem拿出来，放入到一个list当中
        Long currentWorkId = batchInfoMapper.selectById(batchId).getCurrentWork();
        WorkItem currentWorkItem = workItemMapper.selectById(currentWorkId);

        BatchInfo batchInfo = batchInfoMapper.selectById(batchId);
        String type = batchInfo.getType();
        Long beginWorkId = null;

        if (type.equals("养殖")) {
            beginWorkId = 1637722972147695617L;
        } else {
            beginWorkId = 1637723241820471297L;
        }

        WorkItem beginWorkItem = workItemMapper.selectById(beginWorkId);

        List<WorkItem> batchWorkFlow = new ArrayList<>();
        batchWorkFlow.add(beginWorkItem);

        WorkItem nextWorkItem = new WorkItem();
        //不断地获取下一个工作，直到工作为null
        while (true) {
            nextWorkItem = workItemMapper.selectById(beginWorkItem.getNextWork());
            if (nextWorkItem == null) {
                break;
            } else {
                batchWorkFlow.add(nextWorkItem);
                beginWorkItem = nextWorkItem;
            }
        }

        Map<String, Object> map = new HashMap<>();
        map.put("batchWorkFlow", batchWorkFlow);
        map.put("currentWork", currentWorkItem);

        return map;
    }


    /**
     * 返回所有其他工作
     *
     * @return
     */
    @Override
    public List<WorkItem> getAllElseWork() {
        List<WorkItem> elseWorkList = new ArrayList<>();
        List<WorkItem> workItems = workItemMapper.selectList(null);
        Iterator<WorkItem> iterator = workItems.iterator();
        while (iterator.hasNext()) {
            WorkItem next = iterator.next();
            if (next.getNextWork() == null && next.getPreWork() == null) {
                elseWorkList.add(next);
            }

        }

        return elseWorkList;
    }


}
