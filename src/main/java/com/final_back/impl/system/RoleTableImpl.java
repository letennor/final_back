package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.RoleTable;
import com.final_back.mapper.system.RoleTableMapper;
import com.final_back.service.system.RoleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleTableImpl extends ServiceImpl<RoleTableMapper, RoleTable> implements RoleTableService {

    @Autowired
    RoleTableMapper roleTableMapper;

    @Override
    public List<RoleTable> getAllRole() {
        List<RoleTable> roleTables = roleTableMapper.selectList(null);

        return roleTables;
    }

    @Override
    public Integer addRole(RoleTable roleTable) {
        int insert = roleTableMapper.insert(roleTable);
        return insert;
    }

    @Override
    public Integer updateRole(RoleTable roleTable) {

        return null;
    }

    @Override
    public RoleTable getRoleInfo(Long roleId) {
        RoleTable roleTable = roleTableMapper.selectById(roleId);
        return roleTable;
    }
}
