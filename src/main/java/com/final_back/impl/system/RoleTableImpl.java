package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.RoleTable;
import com.final_back.mapper.system.RoleTableMapper;
import com.final_back.service.system.RoleTableService;
import org.springframework.stereotype.Service;

@Service
public class RoleTableImpl extends ServiceImpl<RoleTableMapper, RoleTable> implements RoleTableService {

}
