package com.final_back.impl.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.RolePri;
import com.final_back.entity.system.RoleTable;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.mapper.system.RolePriMapper;
import com.final_back.mapper.system.RoleTableMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.service.system.RolePriService;
import com.final_back.service.system.RoleTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class RoleTableImpl extends ServiceImpl<RoleTableMapper, RoleTable> implements RoleTableService {

    @Autowired
    RoleTableMapper roleTableMapper;
    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    RolePriMapper rolePriMapper;

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

    @Override
    public Integer deleteRole(Long roleId) {
        //删除有关这个角色的所有角色权限信息
        QueryWrapper<RolePri> rolePriQueryWrapper = new QueryWrapper<>();
        rolePriQueryWrapper.eq("role_id", roleId);
        rolePriMapper.delete(rolePriQueryWrapper);

        //先通过role获取所有这个role下的人
        QueryWrapper<UserBasicInfo> userBasicInfoQueryWrapper = new QueryWrapper<>();
        userBasicInfoQueryWrapper.eq("role_id", roleId);
        List<UserBasicInfo> userBasicInfos = userBasicInfoMapper.selectList(userBasicInfoQueryWrapper);
        int i = 0;
        if (userBasicInfos.size() != 0) {
            Iterator<UserBasicInfo> iterator = userBasicInfos.iterator();
            while (iterator.hasNext()) {
                UserBasicInfo next = iterator.next();
                next.setRoleId(1639622923849105409L);
                i += userBasicInfoMapper.updateById(next);
            }
            roleTableMapper.deleteById(roleId);
        } else {
            //直接删除角色
            i = roleTableMapper.deleteById(roleId);
        }
        return i;
    }
}
