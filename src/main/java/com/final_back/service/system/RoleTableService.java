package com.final_back.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.RoleTable;

import java.util.List;

public interface RoleTableService extends IService<RoleTable> {

    List<RoleTable> getAllRole();

    Integer addRole(RoleTable roleTable);

    Integer updateRole(RoleTable roleTable);

    RoleTable getRoleInfo(Long roleId);

    Integer deleteRole(Long roleId);

}
