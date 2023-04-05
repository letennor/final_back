package com.final_back.controller.workArrangement;

import com.final_back.entity.workArrangement.WorkItem;
import com.final_back.service.workArrangement.WorkItemService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkItemController {

    @Autowired
    WorkItemService workItemService;

    /**
     * 取得所有工作项目
     *
     * @return
     */
    @RequestMapping("/getAllWorkItem")
    public Result<?> getAllWorkItem() {
        return null;
    }

    /**
     * 通过角色取得相对应的工作项目
     *
     * @return
     */
    @RequestMapping("/getWorkItemByRole")
    public Result<?> getWorkItemByRole() {
        return null;
    }

    @RequestMapping("/addWorkItem")
    public Result<?> addWorkItem(@RequestBody WorkItem workItem) {
        Integer integer = workItemService.addWorkItem(workItem);
        if (integer > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getWorkItem")
    public Result<?> getWorkItem() {
        List<WorkItem> workItem = workItemService.getWorkItem();
        return ResultUtil.success(workItem);
    }

    @RequestMapping("/deleteWorkItem")
    public Result<?> deleteWorkItem(@RequestBody WorkItem workItem) {
        Integer integer = workItemService.deleteWorkItem(workItem.getWorkItemId());
        return ResultUtil.success(integer);
    }

    @RequestMapping("/updateWorkItem")
    public Result<?> updateWorkItem(@RequestBody WorkItem workItem) {
        Integer integer = workItemService.updateWorkItem(workItem);
        if (integer > 0) {
            return ResultUtil.success("更新成功");
        } else {
            return ResultUtil.success("更新失败");
        }
    }

    @RequestMapping("/getAllElseWork")
    public Result<?> getAllElseWork() {
        List<WorkItem> allElseWork = workItemService.getAllElseWork();
        return ResultUtil.success(allElseWork);
    }

}
