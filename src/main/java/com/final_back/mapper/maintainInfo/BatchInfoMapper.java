package com.final_back.mapper.maintainInfo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.maintainInfo.BatchInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchInfoMapper extends BaseMapper<BatchInfo> {
    List<Long> getIdList(@Param("recordPerson") Long recordPerson);
}
