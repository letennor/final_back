package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.RolePri;
import com.final_back.mapper.system.RolePriMapper;
import com.final_back.service.system.RolePriService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePriImpl extends ServiceImpl<RolePriMapper, RolePri> implements RolePriService {

    /**
     * 取得角色权限信息
     * @param roleId
     * @return
     */
    @Override
    public List<RolePri> getRolePriList(Long roleId) {
        return null;
    }

    /**
     * 创建角色
     * @param rolePri
     * @return
     */
    @Override
    public Integer createRole(RolePri rolePri) {
        return null;
    }

    /**
     * 编辑角色权限
     * @param rolePri
     * @return
     */
    @Override
    public Integer editRole(RolePri rolePri) {
        return null;
    }


}
