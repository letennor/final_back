package com.final_back.impl.system;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.PrivilegeTable;
import com.final_back.entity.system.RolePri;
import com.final_back.mapper.system.PrivilegeTableMapper;
import com.final_back.mapper.system.RolePriMapper;
import com.final_back.service.system.PrivilegeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PrivilegeTableImpl extends ServiceImpl<PrivilegeTableMapper, PrivilegeTable> implements PrivilegeTableService {

    @Autowired
    PrivilegeTableMapper privilegeTableMapper;
    @Autowired
    RolePriMapper rolePriMapper;


    /**
     * 通过权限id列表取得权限
     *
     * @param privilegeTableIdList
     * @return
     */
    @Override
    public List<PrivilegeTable> getPrivilegeTableList(List<Long> privilegeTableIdList) {
        return null;
    }

    /**
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
     *
     * @return
     */
    @Override
    public List<PrivilegeTable> getAllPrivilege() {
        List<PrivilegeTable> privilegeTables = privilegeTableMapper.selectList(null);
        return privilegeTables;
    }

    /**
     * 删除权限
     *
     * @param privilegeId
     * @return
     */
    @Override
    public Integer deletePrivilege(Long privilegeId) {
        //先删除角色权限表
        QueryWrapper<RolePri> rolePriQueryWrapper = new QueryWrapper<>();
        rolePriQueryWrapper.eq("privilege_id", privilegeId);
        rolePriMapper.delete(rolePriQueryWrapper);

        int i = privilegeTableMapper.deleteById(privilegeId);
        return i;
    }

    /**
     * 更新权限
     *
     * @param privilegeTable
     * @return
     */
    @Override
    public Integer updatePrivilege(PrivilegeTable privilegeTable) {
        int i = privilegeTableMapper.updateById(privilegeTable);
        return i;
    }

    /**
     * 取得所有权限（用于角色配置）
     *
     * @return
     */
    @Override
    public List<PrivilegeTable> getAuthList() {
        List<PrivilegeTable> privilegeTables = privilegeTableMapper.selectList(null);

        List<PrivilegeTable> authList = new ArrayList<>();

        Iterator<PrivilegeTable> iterator = privilegeTables.iterator();
        while (iterator.hasNext()) {
            PrivilegeTable next = (PrivilegeTable) iterator.next();
            next.setChildren(new ArrayList<>());
            authList.add(next);
//            System.out.println(next);
        }
        Iterator<PrivilegeTable> authListIter = authList.iterator();
        while (authListIter.hasNext()) {
            PrivilegeTable next = authListIter.next();
            // 如果parentid是null
            if (next.getParentId() == null) {
                QueryWrapper<PrivilegeTable> wrapper = new QueryWrapper<>();
                wrapper.eq("parent_id", next.getPrivilegeId());
                List<PrivilegeTable> children = privilegeTableMapper.selectList(wrapper);
                Iterator<PrivilegeTable> childrenIterator = children.iterator();
                while (childrenIterator.hasNext()) {
                    childrenIterator.next().setChildren(new ArrayList<>());
                }
                next.setChildren(children);
            }
        }

        return authList;
    }

    //取得所有父级权限
    @Override
    public List<PrivilegeTable> getParentPrivilege() {

        List<PrivilegeTable> parentPrivilegeList = new ArrayList<>();

        List<PrivilegeTable> allPrivilege = getAllPrivilege();
        Iterator<PrivilegeTable> iterator = allPrivilege.iterator();
        while (iterator.hasNext()) {
            PrivilegeTable next = iterator.next();
            if (next.getParentId() == null) {
                parentPrivilegeList.add(next);
            }
        }
        return parentPrivilegeList;
    }
}
