package com.final_back.impl.system;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.dto.RolePriDTO;
import com.final_back.entity.system.RolePri;
import com.final_back.entity.system.RoleTable;
import com.final_back.mapper.system.RolePriMapper;
import com.final_back.service.system.RolePriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class RolePriImpl extends ServiceImpl<RolePriMapper, RolePri> implements RolePriService {

    @Autowired
    RolePriMapper rolePriMapper;

    @Override
    public List<RolePri> getRolePriInfo(Long roleId) {
        QueryWrapper<RolePri> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", roleId);
        List<RolePri> rolePris = rolePriMapper.selectList(wrapper);

        return rolePris;
    }

    @Override
    public Integer configPrivilges(RolePriDTO rolePriDTO) {
        //先要将这个角色所有的权限清空，然后再放入新的

        Long roleId = rolePriDTO.getRoleId();

        QueryWrapper<RolePri> roleTableQueryWrapper = new QueryWrapper<>();
        roleTableQueryWrapper.eq("role_id", roleId);
        int delete = rolePriMapper.delete(roleTableQueryWrapper);

        List<Long> privilegeIds = rolePriDTO.getPrivilegeIds();

        Iterator<Long> iterator = privilegeIds.iterator();
        RolePri rolePri = null;
        int i = 0;
        while (iterator.hasNext()) {
            rolePri = new RolePri();
            rolePri.setRoleId(roleId);
            rolePri.setPrivilegeId(iterator.next());
            i += rolePriMapper.insert(rolePri);
        }

        return i;
    }

//    /**
//     * 取得角色权限信息
//     * @param roleId
//     * @return
//     */
//    @Override
//    public List<RolePri> getRolePriList(Long roleId) {
//        return null;
//    }
//
//    /**
//     * 创建角色
//     * @param rolePri
//     * @return
//     */
//    @Override
//    public Integer createRole(RolePri rolePri) {
//        return null;
//    }
//
//    /**
//     * 编辑角色权限
//     * @param rolePri
//     * @return
//     */
//    @Override
//    public Integer editRole(RolePri rolePri) {
//        return null;
//    }


}
