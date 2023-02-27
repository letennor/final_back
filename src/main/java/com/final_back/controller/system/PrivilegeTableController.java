package com.final_back.controller.system;

import com.final_back.entity.system.PrivilegeTable;
import com.final_back.utils.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivilegeTableController {

    /**
     * 添加权限
     * @return
     */
    @RequestMapping("/addPrivilege")
    public Result<?> addPrivilege(@RequestBody PrivilegeTable privilegeTable){
        return null;
    }

    /**
     * 编辑权限
     */
    @RequestMapping("/editPrivilege")
    public Result<?> editPrivilege(@RequestBody PrivilegeTable privilegeTable){
        return null;
    }

}
