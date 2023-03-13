package com.final_back.mapper.cultivation;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.final_back.entity.cultivation.DosingRecord;
import com.final_back.entity.cultivation.FeedRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeedRecordMapper extends BaseMapper<FeedRecord> {

    List<Long> getIdList(@Param("batchId") Long batchId, @Param("feedId") Long feedId,
                         @Param("feedPerson") Long feedPerson, @Param("recordPerson") Long recordPerson);

    List<FeedRecord> getRangeTimeFeedRecord(@Param("startTime") Date startTime,
                                                @Param("endTime") Date endTime);


    List<FeedRecord> getAllFeedRecord();

    List<FeedRecord> getFeedRecordByCondition(@Param("batchId") Long batchId, @Param("feedPerson") Long feedPerson, @Param("recordPerson") Long recordPerson, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("feedId") Long feedId,@Param("order") String order, @Param("isDesc") Integer isDesc, @Param("limit") Integer limit);

}
