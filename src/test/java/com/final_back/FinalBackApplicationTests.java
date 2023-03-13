package com.final_back;

import com.final_back.controller.cultivation.EggProductionRecordController;
import com.final_back.dto.DeathRecordDTO;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.cultivation.*;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.mapper.system.UserPasswordInfoMapper;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.entity.system.UserPasswordInfo;
import com.final_back.service.cultivation.*;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.service.transport.TransportRecordService;
import com.final_back.utils.date.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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
    @Autowired
    UserBasicInfoService userBasicInfoService;

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
        List<Long> idList = feedRecordService.getIdList(null, null, null, null);
        System.out.println(idList);
    }

    @Test
    void test9() {
        List<Long> eggProductionRecordIdList = eggProductionRecordService.getIdList(null, null, null);
        System.out.println(eggProductionRecordIdList);
    }

    @Test
    void test10() {
        List<Long> idList = deathRecordService.getIdList(null, null, 1594944996053143554L);
        System.out.println(idList);
    }

    @Test
    void test11() {
        List<Long> idList = fertilizationRecordService.getIdList(null, null, null);
        System.out.println(idList);
    }

    @Test
    void test12() {
        List<Long> idList = userPasswordInfoService.getIdList(null, null, null, 1L);
        System.out.println(idList);
    }

    @Test
    void test13() {
        List<Long> idList = batchInfoService.getIdList(1594945262135595010L);
        System.out.println(idList);
    }

    @Test
    void test14() {
        UserBasicInfo userBasicInfo = new UserBasicInfo();
        userBasicInfo.setUserBasicInfoId(1597035679850520578L);
        userBasicInfo.setAge(60);
        int i = userBasicInfoService.updateUserBasicInfo(userBasicInfo);
        System.out.println(i);
    }

    @Test
    void test15() {
        List<UserBasicInfo> allPerson = userBasicInfoService.getAllPerson();
        Iterator iterator = allPerson.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void test16() {
        List<UserBasicInfoDTO> allUserAllInfo = userBasicInfoService.getAllUserAllInfo();
        Iterator iterator = allUserAllInfo.iterator();
        while (iterator.hasNext()) {
            UserBasicInfoDTO userBasicInfoDTO = (UserBasicInfoDTO) iterator.next();
            System.out.println(userBasicInfoDTO.getUserBasicInfoId());
        }
    }

    @Test
    void test17() {
        List<DeathRecord> allDeathRecord = deathRecordService.getAllDeathRecord();
        Iterator iterator = allDeathRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void test18() {
        List<IndividualDeathRecord> allIndividualDeathRecord = individualDeathRecordService.getAllIndividualDeathRecord();
        Iterator iterator = allIndividualDeathRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
        }
    }

    @Test
    void test19() {
        List<DosingRecord> allDosingRecord = dosingRecordService.getAllDosingRecord();
        Iterator iterator = allDosingRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void test20() {
        List<EggProductionRecord> allEggProductionRecord = eggProductionRecordService.getAllEggProductionRecord();
        Iterator iterator = allEggProductionRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void test21() {
        List<FeedRecord> allFeedRecord = feedRecordService.getAllFeedRecord();
        Iterator iterator = allFeedRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void test22() {
        List<TransportRecord> allTransportRecord = transportRecordService.getAllTransportRecord();
        System.out.println(allTransportRecord);
    }

    @Test
    void test23() {
        List<TransportRecord> allTransportRecord = transportRecordService.getAllTransportRecord();
        Iterator iterator = allTransportRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void test24() {
        List<IncomingRecord> allIncomingRecord = incomingRecordService.getAllIncomingRecord();
        Iterator iterator = allIncomingRecord.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


    @Test
    void test29() {
        List<IndividualDeathRecord> individualDeathRecordByCondition = individualDeathRecordService.getIndividualDeathRecordByCondition(null, null, null);
        Iterator iterator = individualDeathRecordByCondition.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    void test32() {
        List<TransportRecord> transportRecordByCondition = transportRecordService.getTransportRecordByCondition(null, null, null, null, null, null);
        Iterator iterator = transportRecordByCondition.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }


    @Test
    void test35() {
        List<String> daySevenRange = DateUtils.getDaySevenRangeYYMMDD();

        Date endDate = DateUtils.stringToDate(daySevenRange.get(0));
        Date startDate = DateUtils.stringToDate(daySevenRange.get(6));
        List<DeathRecord> deathRecordByCondition = deathRecordService.getDeathRecordByCondition(null, null, null, null, null, null, null, 7);
        Iterator iterator = deathRecordByCondition.iterator();
        List<String> dateNameList = new ArrayList<>();

        while (iterator.hasNext()) {
            DeathRecord next = (DeathRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "YYYY-MM-dd"));
            System.out.println(next);
        }

        System.out.println(dateNameList);
    }

    @Test
    void test36() {
        List<DosingRecord> dosingRecordByCondition = dosingRecordService.getDosingRecordByCondition(1597441811072995329L, null, null, null, null, null, "dr.record_time", 1, 7);
        Iterator<DosingRecord> dosingRecordIterator = dosingRecordByCondition.iterator();

        List<String> sevenDayTag = new ArrayList<>();

        while (dosingRecordIterator.hasNext()) {
            sevenDayTag.add(DateUtils.dateToString(dosingRecordIterator.next().getRecordTime(), "MM-dd"));
        }

        System.out.println(sevenDayTag);
        HashMap<String, Object> map = new HashMap<>();
        map.put("sevenDayTag", sevenDayTag);
        map.put("dosingRecordByCondition", dosingRecordByCondition);
        System.out.println(map);

    }

    @Test
    void test37() {
        List<String> daySevenRange = DateUtils.getDaySevenRangeYYMMDD();

        Date endDate = DateUtils.stringToDate(daySevenRange.get(0));
        Date startDate = DateUtils.stringToDate(daySevenRange.get(6));
        List<EggProductionRecord> eggProductionRecordByCondition = eggProductionRecordService.getEggProductionRecordByCondition(null, null, null, startDate, endDate, "epr.record_time", 1, 7);
        Iterator<EggProductionRecord> iterator = eggProductionRecordByCondition.iterator();

        List<String> dateNameList = new ArrayList<>();

        while (iterator.hasNext()) {
            EggProductionRecord next = (EggProductionRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "YYYY-MM-dd"));
            System.out.println(next);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", eggProductionRecordByCondition);


    }

    @Test
    void test38() {
        List<String> dateNameList = new ArrayList<>();
        List<FeedRecord> feedRecordByCondition = feedRecordService.getFeedRecordByCondition(null, null, null, null, null, null, "fr.record_time", 1, 7);
        Iterator<FeedRecord> iterator = feedRecordByCondition.iterator();
        while (iterator.hasNext()) {
            FeedRecord next = (FeedRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", feedRecordByCondition);

        System.out.println(map);
    }

    @Test
    void test39() {
        List<String> dateNameList = new ArrayList<>();
        List<FertilizationRecord> fertilizationRecordByCondition = fertilizationRecordService.getFertilizationRecordByCondition(null, null, null, null, null, null, null, "fr.record_time", 1, 7);
        Iterator<FertilizationRecord> iterator = fertilizationRecordByCondition.iterator();
        while (iterator.hasNext()) {
            FertilizationRecord next = (FertilizationRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", fertilizationRecordByCondition);

        System.out.println(map);
    }

    @Test
    void test40() {
        List<String> dateNameList = new ArrayList<>();
        List<IncomingRecord> incomingRecordByCondition = incomingRecordService.getIncomingRecordByCondition(null, null, null, null, null, null, "ir.record_time", 1, 7);
        Iterator<IncomingRecord> iterator = incomingRecordByCondition.iterator();
        while (iterator.hasNext()) {
            IncomingRecord next = (IncomingRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
    }

    @Test
    void test41() {
        List<String> dateNameList = new ArrayList<>();
        List<OutputRecord> outputRecordByCondition = outputRecordService.getOutputRecordByCondition(null, null, null, null, "output_record.record_time", 1, 7);
        Iterator<OutputRecord> iterator = outputRecordByCondition.iterator();
        while (iterator.hasNext()) {
            OutputRecord next = (OutputRecord) iterator.next();
            dateNameList.add(DateUtils.dateToString(next.getRecordTime(), "MM-dd"));
            System.out.println(next);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("xData", dateNameList);
        map.put("yData", outputRecordByCondition);

        System.out.println(map);
    }

}
