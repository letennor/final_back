package com.final_back.controller.system;

import com.final_back.utils.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolePriController {

    /**
     * 取得所有的角色
     * @return
     */
    @RequestMapping("/getAllRole")
    public Result<?> getAllRole(){
        return null;
    }

    /**
     * 创建角色
     * @return
     */
    @RequestMapping("/createRole")
    public Result<?> createRole(){
        return null;
    }

    /**
     * 编辑角色权限
     * @return
     */
    @RequestMapping("/editRole")
    public Result<?> editRole(){
        return null;
    }

}
