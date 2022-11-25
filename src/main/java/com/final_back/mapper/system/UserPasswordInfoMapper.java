package com.final_back.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.system.UserPasswordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPasswordInfoMapper extends BaseMapper<UserPasswordInfo> {

    List<Long> getIdList(@Param("userBasicInfoId") Long userBasicInfoId, @Param("state") Integer state,
                         @Param("account") String account, @Param("organizationId") Long organizationId);

}
