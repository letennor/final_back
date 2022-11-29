package com.final_back.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.system.UserBasicInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBasicInfoMapper extends BaseMapper<UserBasicInfo>{

    UserBasicInfo getUserPassword(@Param("userBasicInfoId") Long userBasicInfoId);

    List<UserBasicInfoDTO> getAllUserAllInfo();

}
