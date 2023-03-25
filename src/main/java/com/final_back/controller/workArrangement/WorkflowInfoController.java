package com.final_back.controller.workArrangement;

import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.workArrangement.WorkflowInfo;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.workArrangement.WorkflowInfoService;
import com.final_back.utils.date.DateUtils;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
public class WorkflowInfoController {
    @Autowired
    UserBasicInfoService userBasicInfoService;
    @Autowired
    WorkflowInfoService workflowInfoService;

    /**
     * 添加工作流程
     *
     * @param workflowInfo
     * @return
     */
    @RequestMapping("/addWorkflow")
    public Result<?> addWorkflow(@RequestBody WorkflowInfo workflowInfo) {
        return null;
    }

    /**
     * 取得用户所有没有完成的工作
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/getUserUndoneWork")
    public Result<?> getUserUndoneWork(@RequestBody JSONObject jsonObject) {
        return null;
    }

    /**
     * 改变工作状态
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/changeWorkflowState")
    public Result<?> changeWorkflowState(@RequestBody JSONObject jsonObject) {
        return null;
    }

    /**
     * 取得所有今天有工作的人的工作流
     * @return
     */
    @RequestMapping("/getAllPersonWorkFlowCurrentDate")
    public Result<?> getAllPersonWorkFlowCurrentDate() {
        List<UserBasicInfoDTO> allUserAllInfo = userBasicInfoService.getAllUserAllInfo();
        Iterator<UserBasicInfoDTO> iterator = allUserAllInfo.iterator();
        Date currentDate = DateUtils.stringToDate(DateUtils.dateToString(new Date(), "YYYY-MM-dd"));

        //通过workPerson找到某人今天的所有工作
        while (iterator.hasNext()) {
            UserBasicInfoDTO next = iterator.next();
            List<WorkflowInfo> personWorkFlowInfo = workflowInfoService.getPersonWorkFlowInfo(next.getUserBasicInfoId(), currentDate);
            next.setWorkflowInfoList(personWorkFlowInfo);
        }
        return ResultUtil.success(allUserAllInfo);
    }

}
