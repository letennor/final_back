package com.final_back.controller.workArrangement;

import com.alibaba.fastjson.JSONObject;
import com.final_back.entity.workArrangement.WorkflowInfo;
import com.final_back.utils.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowInfoController {

    /**
     * 添加工作流程
     * @param workflowInfo
     * @return
     */
    @RequestMapping("/addWorkflow")
    public Result<?> addWorkflow(@RequestBody WorkflowInfo workflowInfo){
        return null;
    }

    /**
     * 取得用户所有没有完成的工作
     * @param jsonObject
     * @return
     */
    @RequestMapping("/getUserUndoneWork")
    public Result<?> getUserUndoneWork(@RequestBody JSONObject jsonObject){
        return null;
    }

    /**
     * 改变工作状态
     * @param jsonObject
     * @return
     */
    @RequestMapping("/changeWorkflowState")
    public Result<?> changeWorkflowState(@RequestBody JSONObject jsonObject){
        return null;
    }

}
