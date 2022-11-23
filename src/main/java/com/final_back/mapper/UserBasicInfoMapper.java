package com.final_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.system.UserBasicInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBasicInfoMapper extends BaseMapper<UserBasicInfo>{

    UserBasicInfo getUserPassword(@Param("userBasicInfoId") Long userBasicInfoId);

}
