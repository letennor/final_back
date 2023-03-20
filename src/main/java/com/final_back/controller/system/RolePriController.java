package com.final_back.controller.system;

import com.final_back.dto.RolePriDTO;
import com.final_back.entity.system.RolePri;
import com.final_back.entity.system.RoleTable;
import com.final_back.service.system.RolePriService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolePriController {

//    /**
//     * 取得所有的角色
//     * @return
//     */
//    @RequestMapping("/getAllRole")
//    public Result<?> getAllRole(){
//        return null;
//    }
//
//    /**
//     * 创建角色
//     * @return
//     */
//    @RequestMapping("/createRole")
//    public Result<?> createRole(){
//        return null;
//    }
//
//    /**
//     * 编辑角色权限
//     * @return
//     */
//    @RequestMapping("/editRole")
//    public Result<?> editRole(){
//        return null;
//    }

    @Autowired
    RolePriService rolePriService;

    @RequestMapping("/getRolePriId")
    public Result<?> getRolePriId(@RequestBody RoleTable roleTable) {
        List<RolePri> rolePriList = rolePriService.getRolePriInfo(roleTable.getRoleId());
        return ResultUtil.success(rolePriList);
    }


    /**
     * 配置角色权限
     *
     * @param rolePriDTO
     * @return
     */
    @RequestMapping("/configRole")
    public Result<?> configRole(@RequestBody RolePriDTO rolePriDTO) {

        Integer integer = rolePriService.configPrivilges(rolePriDTO);
        return ResultUtil.success(integer);
    }

}
