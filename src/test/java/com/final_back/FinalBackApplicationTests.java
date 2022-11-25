package com.final_back;

import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.service.cultivation.*;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.service.transport.TransportRecordService;
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
    @Autowired
    IncomingRecordService incomingRecordService;
    @Autowired
    OutputRecordService outputRecordService;
    @Autowired
    DosingRecordService dosingRecordService;
    @Autowired
    TransportRecordService transportRecordService;
    @Autowired
    EggProductionRecordService eggProductionRecordService;
    @Autowired
    DeathRecordService deathRecordService;
    @Autowired
    FertilizationRecordService fertilizationRecordService;
    @Autowired
    UserPasswordInfoService userPasswordInfoService;
    @Autowired
    BatchInfoService batchInfoService;

    @Test
    void testDelete() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("feed_record_id", 1594987064947486721L);
        int i = feedRecordService.deleteFeedRecord(map);
        System.out.println(i);
    }


    @Test
    void test3() {
        List<Long> idList = individualDeathRecordService.getIdList(null, null);
        System.out.println(idList);
    }

    @Test
    void test4() {
        List<Long> idList = incomingRecordService.getIdList(null, null, null, null);
        System.out.println(idList);
    }

    @Test
    void test5() {
        List<Long> idList = outputRecordService.getIdList(null, null, null);
        System.out.println(idList);
    }

    @Test
    void test6() {
        List<Long> idList = dosingRecordService.getIdList(null, null, null, null);
        System.out.println(idList);
    }

    @Test
    void test7() {
        List<Long> idList = transportRecordService.getIdList(null, null, null, null);
        System.out.println(idList);
    }

    @Test
    void test8() {
        List<Long> idList = feedRecordService.getIdList(null, null, null,
                null);
        System.out.println(idList);

    }

    @Test
    void test9(){
        List<Long> eggProductionRecordIdList = eggProductionRecordService.getIdList(null, null, null);
        System.out.println(eggProductionRecordIdList);
    }

    @Test
    void test10(){
        List<Long> idList = deathRecordService.getIdList(null, null, 1594944996053143554L);
        System.out.println(idList);
    }

    @Test
    void test11(){
        List<Long> idList = fertilizationRecordService.getIdList(null, null, null);
        System.out.println(idList);
    }

    @Test
    void test12(){
        List<Long> idList = userPasswordInfoService.getIdList(null, null, null, 1L);
        System.out.println(idList);

    }

    @Test
    void test13(){
        List<Long> idList = batchInfoService.getIdList(1594945262135595010L);
        System.out.println(idList);
    }

}
