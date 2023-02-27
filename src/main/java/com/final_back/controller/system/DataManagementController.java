package com.final_back.controller.system;

import com.final_back.utils.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataManagementController {

    /**
     * 数据备份
     * @return
     */
    @RequestMapping("/dataBackup")
    public Result<?> dataBackup(){
        return null;
    }

    /**
     *数据恢复
     * @return
     */
    @RequestMapping("/dataRecover")
    public Result<?> dataRecover(){
        return null;
    }

}





