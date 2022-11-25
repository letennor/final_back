package com.final_back;

import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.service.cultivation.FeedRecordService;
import com.final_back.service.cultivation.IndividualDeathRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class FinalBackApplicationTests {

    @Autowired
    FeedRecordService feedRecordService;
    @Autowired
    IndividualDeathRecordMapper individualDeathRecordMapper;
    @Autowired
    IndividualDeathRecordService individualDeathRecordService;

    @Test
    void testDelete(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("feed_record_id", 1594987064947486721L);
        int i = feedRecordService.deleteFeedRecord(map);
        System.out.println(i);
    }


    @Test
    void test3(){
        List<Long> idList = individualDeathRecordService.getIdList(null, null);
        System.out.println(idList);
    }
}
