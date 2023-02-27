package com.final_back.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.PrivilegeTable;

import java.util.List;

public interface PrivilegeTableService extends IService<PrivilegeTable> {
    List<PrivilegeTable> getPrivilegeTableList(List<Long> privilegeTableIdList);

    Integer addPrivilage(PrivilegeTable privilegeTable);
}
