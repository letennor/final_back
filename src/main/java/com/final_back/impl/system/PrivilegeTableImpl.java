package com.final_back.impl.system;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.PrivilegeTable;
import com.final_back.mapper.system.PrivilegeTableMapper;
import com.final_back.service.system.PrivilegeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PrivilegeTableImpl extends ServiceImpl<PrivilegeTableMapper, PrivilegeTable> implements PrivilegeTableService {

    @Autowired
    PrivilegeTableMapper privilegeTableMapper;


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
        int insert = privilegeTableMapper.insert(privilegeTable);

        return insert;
    }

    /**
     * 取得所有权限
     * @return
     */
    @Override
    public List<PrivilegeTable> getAllPrivilege() {
        List<PrivilegeTable> privilegeTables = privilegeTableMapper.selectList(null);
        return privilegeTables;
    }

    /**
     * 删除权限
     * @param privilegeId
     * @return
     */
    @Override
    public Integer deletePrivilege(Long privilegeId) {
        int i = privilegeTableMapper.deleteById(privilegeId);
        return i;
    }

    /**
     * 更新权限
     * @param privilegeTable
     * @return
     */
    @Override
    public Integer updatePrivilege(PrivilegeTable privilegeTable) {
        int i = privilegeTableMapper.updateById(privilegeTable);
        return i;
    }
}
