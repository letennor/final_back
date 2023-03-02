package com.final_back.controller.system;

import com.final_back.entity.system.PrivilegeTable;
import com.final_back.service.system.PrivilegeTableService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrivilegeTableController {

    @Autowired
    PrivilegeTableService privilegeTableService;

    /**
     * 添加权限
     * @return
     */
    @RequestMapping("/addPrivilege")
    public Result<?> addPrivilege(@RequestBody PrivilegeTable privilegeTable){


        Integer i = privilegeTableService.addPrivilage(privilegeTable);
        return ResultUtil.success(i);
    }

    /**
     * 编辑权限
     */
    @RequestMapping("/editPrivilege")
    public Result<?> editPrivilege(@RequestBody PrivilegeTable privilegeTable){
        return null;
    }

    /**
     * 取得所有权限
     * @return
     */
    @RequestMapping("/getAllPrivilege")
    public Result<?> getAllPrivilege(){
        List<PrivilegeTable> allPrivilege = privilegeTableService.getAllPrivilege();
        return ResultUtil.success(allPrivilege);
    }

    @RequestMapping("/deletePrivilege")
    public Result<?> deletePrivilege(@RequestBody PrivilegeTable privilegeTable){
        Integer integer = privilegeTableService.deletePrivilege(privilegeTable.getPrivilegeId());
        if (integer > 0){
            return ResultUtil.success("删除成功");
        }else {
            return ResultUtil.success("删除失败");
        }
    }

    @RequestMapping("/updatePrivilege")
    public Result<?> updatePrivilege(@RequestBody PrivilegeTable privilegeTable){
        Integer integer = privilegeTableService.updatePrivilege(privilegeTable);
        if (integer > 0){
            return ResultUtil.success("更新成功");
        }else {
            return ResultUtil.success("更新失败");
        }

    }

}
