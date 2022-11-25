package com.final_back.mapper.cultivation;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.FeedRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRecordMapper extends BaseMapper<FeedRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("feedId") Long feedId,
                         @Param("feedPerson") Long feedPerson, @Param("recordPerson") Long recordPerson);

}
