package com.final_back;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.cultivation.*;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.entity.system.PrivilegeTable;
import com.final_back.entity.system.RolePri;
import com.final_back.entity.transport.IncomingRecord;
import com.final_back.entity.transport.OutputRecord;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.entity.workArrangement.WorkItem;
import com.final_back.entity.workArrangement.WorkFlowInfo;
import com.final_back.handler.MysqlBackup;
import com.final_back.mapper.cultivation.IndividualDeathRecordMapper;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.mapper.system.PrivilegeTableMapper;
import com.final_back.mapper.system.RolePriMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.mapper.workArrangement.WorkFlowInfoMapper;
import com.final_back.service.cultivation.*;
import com.final_back.service.maintainInfo.BatchInfoService;
import com.final_back.service.system.PrivilegeTableService;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.system.UserPasswordInfoService;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.OutputRecordService;
import com.final_back.service.transport.TransportRecordService;
import com.final_back.service.workArrangement.WorkItemService;
import com.final_back.service.workArrangement.WorkFlowInfoService;
import com.final_back.utils.common.TokenUtil;
import com.final_back.utils.date.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;

    @Test
    void test42() {
        UserBasicInfo userBasicInfo = userBasicInfoMapper.selectById(1597441346729988097L);
        System.out.println(userBasicInfo);
        String s = TokenUtil.generateToken(userBasicInfo);
        System.out.println(s);
    }

    @Autowired
    PrivilegeTableMapper privilegeTableMapper;

    @Test
    void test43() {
        List<PrivilegeTable> privilegeTables = privilegeTableMapper.selectList(null);

        List<PrivilegeTable> authList = new ArrayList<>();

        Iterator<PrivilegeTable> iterator = privilegeTables.iterator();
        while (iterator.hasNext()) {
            PrivilegeTable next = (PrivilegeTable) iterator.next();
            authList.add(next);
//            System.out.println(next);
        }
        Iterator<PrivilegeTable> authListIter = authList.iterator();
        while (authListIter.hasNext()) {
            PrivilegeTable next = authListIter.next();
            // 如果parentid是null
            if (next.getParentId() == null) {
                QueryWrapper<PrivilegeTable> wrapper = new QueryWrapper<>();
                wrapper.eq("parent_id", next.getPrivilegeId());
                List<PrivilegeTable> children = privilegeTableMapper.selectList(wrapper);
                next.setChildren(children);
            }
        }


    }

    @Test
    void test44() {
        QueryWrapper<PrivilegeTable> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", 1635926426146115586L);
        List<PrivilegeTable> privilegeTables = privilegeTableMapper.selectList(wrapper);
        Iterator<PrivilegeTable> iterator = privilegeTables.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Autowired
    RolePriMapper rolePriMapper;

    @Test
    void test45() {
        QueryWrapper<RolePri> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", 1636587885578465282L);
        List<RolePri> rolePris = rolePriMapper.selectList(wrapper);
        Iterator<RolePri> iterator = rolePris.iterator();
        List<Long> rolePriId = new ArrayList<>();
        while (iterator.hasNext()) {
            rolePriId.add(iterator.next().getPrivilegeId());
        }
    }

    @Test
    void test46() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        map.remove("1");
        System.out.println(map);
    }

    @Autowired
    WorkItemService workItemService;

    @Test
    void test47() {
        List<WorkItem> workItem = workItemService.getWorkItem();
        Iterator<WorkItem> iterator = workItem.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void test48() {
        Map<String, Object> batchWorkFlow = workItemService.getBatchWorkFlow(1597441931764092929L);
        System.out.println(batchWorkFlow);
    }

    @Autowired
    WorkFlowInfoService workflowInfoService;

    @Test
    void test49() {
        List<UserBasicInfoDTO> allUserAllInfo = userBasicInfoService.getAllUserAllInfo();
        Iterator<UserBasicInfoDTO> iterator = allUserAllInfo.iterator();
        Date currentDate = DateUtils.stringToDate(DateUtils.dateToString(new Date(), "YYYY-MM-dd"));

        //通过workPerson找到某人今天的所有工作
        while (iterator.hasNext()) {
            UserBasicInfoDTO next = iterator.next();
            List<WorkFlowInfo> personWorkFlowInfo = workflowInfoService.getPersonWorkFlowInfo(next.getUserBasicInfoId(), currentDate);
            next.setWorkFlowInfoList(personWorkFlowInfo);
        }
        System.out.println(allUserAllInfo);
    }

    @Test
    void test50() {
        List<UserBasicInfoDTO> allUserAllInfo = userBasicInfoService.getAllUserAllInfo();
        Iterator<UserBasicInfoDTO> iterator = allUserAllInfo.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getUserBasicInfoId());
        }
    }

    @Test
    void test52() {
        List<Long> personWorkFlowInfoIdByCondition = workflowInfoService.getPersonWorkFlowInfoIdByCondition(DateUtils.stringToDate("2023-03-24 00:00:00"), DateUtils.stringToDate("2023-03-25 00:00:00"));
        Iterator<Long> iterator = personWorkFlowInfoIdByCondition.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Autowired
    PrivilegeTableService privilegeTableService;

    @Test
    void test55() {
        List<PrivilegeTable> parentPrivilege = privilegeTableService.getParentPrivilege();
        Iterator<PrivilegeTable> iterator = parentPrivilege.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Autowired
    BatchInfoMapper batchInfoMapper;

    @Test
    void test56() {
        // 通过类型获取不同类型的所有批次，并且要是有效的批次
        QueryWrapper<BatchInfo> batchInfoQueryWrapper = new QueryWrapper<>();
        batchInfoQueryWrapper.eq("type", "养殖");
        List<BatchInfo> batchInfos = batchInfoMapper.selectList(batchInfoQueryWrapper);
        Iterator<BatchInfo> iterator = batchInfos.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    void test57() {
        List<WorkItem> allElseWork = workItemService.getAllElseWork();
        Iterator<WorkItem> iterator = allElseWork.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void test58() {
        System.out.println(DateUtils.dateToBottom(new Date()));

    }

    @Test
    void test59() {
        System.out.println("现在的date: " + new Date());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);

        System.out.println("一天前的date: " + cal.getTime());

    }

    @Test
    void test60() {
        Date job1 = new Date();
        Date job2 = DateUtils.dateCalculate(job1, 6);
        Date job3 = DateUtils.dateCalculate(job2, 0);
        Date job4 = DateUtils.dateCalculate(job3, 12);
        Date job5 = DateUtils.dateCalculate(job4, 0);
        Date job6 = DateUtils.dateCalculate(job5, 3);
        Date job7 = DateUtils.dateCalculate(job6, 0);
        Date job8 = DateUtils.dateCalculate(job7, 0);

        List<Date> workFlowDate = new ArrayList<>();
        workFlowDate.add(job1);
        workFlowDate.add(job2);
        workFlowDate.add(job3);
        workFlowDate.add(job4);
        workFlowDate.add(job5);
        workFlowDate.add(job6);
        workFlowDate.add(job7);
        workFlowDate.add(job8);

        Iterator<Date> iterator = workFlowDate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Autowired
    WorkFlowInfoMapper workFlowInfoMapper;

    @Test
    void test61() {
        List<WorkFlowInfo> personWorkFlowInfo = workFlowInfoMapper.getPersonWorkFlowInfo(1597441346729988097L, null, 0);
        Iterator<WorkFlowInfo> iterator = personWorkFlowInfo.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    void test62() {
        List<WorkFlowInfo> allPersonUndoneWork = workflowInfoService.getPersonUndoneWork(1637396083667378178L);
        System.out.println(allPersonUndoneWork);
        Iterator<WorkFlowInfo> iterator = allPersonUndoneWork.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void test63() {
        MysqlBackup mysqlBackup = new MysqlBackup();
        mysqlBackup.restoreMysql();
    }

    @Test
    void test64() {
        MysqlBackup mysqlBackup = new MysqlBackup();
        mysqlBackup.recoverMysql();
    }

    @Test
    void test65() {
        MysqlBackup mysqlBackup = new MysqlBackup();
        mysqlBackup.restoreMysqlLinux();

    }

    @Test
    void test66(){


    }

}
