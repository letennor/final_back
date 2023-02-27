package com.final_back.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.RolePri;

import java.util.List;

public interface RolePriService extends IService<RolePri> {

    List<RolePri> getRolePriList(Long roleId);

    Integer createRole(RolePri rolePri);

    Integer editRole(RolePri rolePri);
}
