package com.final_back.impl.system;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.PrivilegeTable;
import com.final_back.mapper.system.PrivilegeTableMapper;
import com.final_back.service.system.PrivilegeTableService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrivilegeTableImpl extends ServiceImpl<PrivilegeTableMapper, PrivilegeTable> implements PrivilegeTableService {

    /**
     * 通过权限id列表取得权限
     * @param privilegeTableIdList
     * @return
     */
    @Override
    public List<PrivilegeTable> getPrivilegeTableList(List<Long> privilegeTableIdList) {
        return null;
    }

    /**
     *
     * @param privilegeTable
     * @return
     */
    @Override
    public Integer addPrivilage(PrivilegeTable privilegeTable) {
        return null;
    }
}
