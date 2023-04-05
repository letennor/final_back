package com.final_back.controller.system;

import com.final_back.entity.system.RoleTable;
import com.final_back.service.system.RoleTableService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleTableController {

    @Autowired
    RoleTableService roleTableService;

    @RequestMapping("/getAllRole")
    public Result<?> getAllRole() {
        List<RoleTable> allRole = roleTableService.getAllRole();
        return ResultUtil.success(allRole);
    }

    @RequestMapping("/addRole")
    public Result<?> addRole(@RequestBody RoleTable roleTable) {
        Integer integer = roleTableService.addRole(roleTable);
        return ResultUtil.success(integer);
    }

    @RequestMapping("/updateRole")
    public Result<?> updateRole(@RequestBody RoleTable roleTable) {
        return null;
    }

    @RequestMapping("/deleteRole")
    public Result<?> deleteRole(@RequestBody RoleTable roleTable) {
        Integer integer = roleTableService.deleteRole(roleTable.getRoleId());
        if (integer > 0) {
            return ResultUtil.success("删除成功");
        } else {
            return ResultUtil.success("删除失败");
        }
    }

}
