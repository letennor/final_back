package com.final_back.controller.workArrangement;

import com.final_back.utils.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkItemController {

    /**
     * 取得所有工作项目
     * @return
     */
    @RequestMapping("/getAllWorkItem")
    public Result<?> getAllWorkItem(){
        return null;
    }

    /**
     * 通过角色取得相对应的工作项目
     * @return
     */
    @RequestMapping("/getWorkItemByRole")
    public Result<?> getWorkItemByRole(){
        return null;
    }

}
