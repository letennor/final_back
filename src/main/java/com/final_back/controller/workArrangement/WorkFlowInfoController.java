package com.final_back.controller.workArrangement;

import com.alibaba.fastjson.JSONObject;
import com.final_back.dto.ArrangeWorkDTO;
import com.final_back.dto.UserBasicInfoDTO;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.entity.workArrangement.WorkFlowInfo;
import com.final_back.entity.workArrangement.WorkItem;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.mapper.workArrangement.WorkFlowInfoMapper;
import com.final_back.mapper.workArrangement.WorkItemMapper;
import com.final_back.service.system.UserBasicInfoService;
import com.final_back.service.workArrangement.WorkFlowInfoService;
import com.final_back.utils.common.SnowFlakeGenerateIdWorker;
import com.final_back.utils.date.DateUtils;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RestController
public class WorkFlowInfoController {
    @Autowired
    UserBasicInfoService userBasicInfoService;
    @Autowired
    WorkFlowInfoService workflowInfoService;
    @Autowired
    WorkFlowInfoMapper workflowInfoMapper;
    @Autowired
    BatchInfoMapper batchInfoMapper;
    @Autowired
    WorkItemMapper workItemMapper;

    /**
     * 添加工作流程
     *
     * @param workflowInfo
     * @return
     */
    @RequestMapping("/addWorkflow")
    public Result<?> addWorkflow(@RequestBody WorkFlowInfo workflowInfo) {
        return null;
    }

    /**
     * 取得用户所有没有完成的工作
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/getUserUndoneWork")
    public Result<?> getUserUndoneWork(@RequestBody JSONObject jsonObject) {
        return null;
    }

    /**
     * 改变工作状态
     *
     * @param jsonObject
     * @return
     */
    @RequestMapping("/changeWorkflowState")
    public Result<?> changeWorkflowState(@RequestBody JSONObject jsonObject) {
        return null;
    }

    /**
     * 取得所有今天有工作的人的工作流
     *
     * @return
     */
    @RequestMapping("/getAllPersonWorkFlowCurrentDate")
    public Result<?> getAllPersonWorkFlowCurrentDate() {
        List<UserBasicInfoDTO> allUserAllInfo = userBasicInfoService.getAllUserAllInfo();
        Iterator<UserBasicInfoDTO> iterator = allUserAllInfo.iterator();
        Date currentDate = DateUtils.stringToDate(DateUtils.dateToString(new Date(), "YYYY-MM-dd"));

        //通过workPerson找到某人今天的所有工作
        while (iterator.hasNext()) {
            UserBasicInfoDTO next = iterator.next();
            List<WorkFlowInfo> personWorkFlowInfo = workflowInfoService.getPersonWorkFlowInfo(next.getUserBasicInfoId(), currentDate);
            next.setWorkFlowInfoList(personWorkFlowInfo);
        }
        return ResultUtil.success(allUserAllInfo);
    }

    /**
     * 通过条件取得今天的人的工作流
     *
     * @param userBasicInfoDTO
     * @return
     */
    @RequestMapping("/getPersonWorkFlowCurrentDateByCondition")
    public Result<?> getPersonWorkFlowCurrentDateByCondition(@RequestBody UserBasicInfoDTO userBasicInfoDTO) {
        List<Long> personWorkFlowInfoIdByCondition = workflowInfoService.getPersonWorkFlowInfoIdByCondition(userBasicInfoDTO.getBeginFreeDate(), userBasicInfoDTO.getEndFreeDate());

        if (personWorkFlowInfoIdByCondition.size() != 0) {
            List<UserBasicInfoDTO> userAllInfoByCondition = userBasicInfoService.getUserAllInfoByCondition(userBasicInfoDTO.getRoleId(), personWorkFlowInfoIdByCondition, null);

            Iterator<UserBasicInfoDTO> iterator = userAllInfoByCondition.iterator();
            Date currentDate = DateUtils.stringToDate(DateUtils.dateToString(new Date(), "YYYY-MM-dd"));

            //通过workPerson找到某人今天的所有工作
            while (iterator.hasNext()) {
                UserBasicInfoDTO next = iterator.next();
                List<WorkFlowInfo> personWorkFlowInfo = workflowInfoService.getPersonWorkFlowInfo(next.getUserBasicInfoId(), currentDate);
                next.setWorkFlowInfoList(personWorkFlowInfo);
            }
            return ResultUtil.success(userAllInfoByCondition);
        } else {
            return ResultUtil.success(null);
        }
    }


    @RequestMapping("/arrangeWork")
    public Result<?> arrangeWork(@RequestBody ArrangeWorkDTO arrangeWorkDTO) {
        System.out.println(arrangeWorkDTO);
        SnowFlakeGenerateIdWorker snowFlakeGenerateIdWorker =
                new SnowFlakeGenerateIdWorker(0L, 0L);

        //如果是普通工作

        int insert = 0;
        if (arrangeWorkDTO.getJobType().equals("2")) {
            WorkFlowInfo workflowInfo = new WorkFlowInfo();
            workflowInfo.setWorkItemId(arrangeWorkDTO.getWorkItemId());
            workflowInfo.setWorkPerson(arrangeWorkDTO.getWorkPerson());
            workflowInfo.setWorkDate(arrangeWorkDTO.getWorkDate());
            workflowInfo.setIsFinished(0);
            workflowInfo.setWorkBatch(null);
            insert += workflowInfoMapper.insert(workflowInfo);
        } else {
            BatchInfo batchInfo = batchInfoMapper.selectById(arrangeWorkDTO.getBatchId());
            //先判断是什么类型的流程
            if (arrangeWorkDTO.getType().equals("孵化")) {

                //得到batch的开始时间
                Date batchStartDateFormat = DateUtils.dateToBottom(batchInfo.getStartDate());
                Date job1 = batchStartDateFormat;
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

                //将八条记录放入到这个人的workFlow中
                WorkFlowInfo workflowInfo = new WorkFlowInfo();
                workflowInfo.setWorkBatch(batchInfo.getBatchId());
                workflowInfo.setWorkPerson(arrangeWorkDTO.getWorkPerson());
                workflowInfo.setWorkDate(job1);
                workflowInfo.setWorkItemId(1637723241820471297L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job2);
                workflowInfo.setWorkItemId(1637723277593690114L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job3);
                workflowInfo.setWorkItemId(1637737697346650113L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job4);
                workflowInfo.setWorkItemId(1637723335563165698L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job5);
                workflowInfo.setWorkItemId(1637737731396009985L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job6);
                workflowInfo.setWorkItemId(1637723439745482754L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job7);
                workflowInfo.setWorkItemId(1637723001348440066L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job8);
                workflowInfo.setWorkItemId(1637723492040065025L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);
                //第一次孵化6-检查胚胎0-第二次孵化12-更换孵化容0-第三次孵化3-鉴别健康鸡苗0-打疫苗0-数公母
            } else if (arrangeWorkDTO.getType().equals("养殖")) {
                Date batchStartDateFormat = DateUtils.dateToBottom(batchInfo.getStartDate());
                Date job1 = batchStartDateFormat;
                Date job2 = DateUtils.dateCalculate(job1, 1);
                Date job3 = DateUtils.dateCalculate(job2, 1);
                Date job4 = DateUtils.dateCalculate(job3, 1);
                Date job5 = DateUtils.dateCalculate(job4, 5);


                List<Date> workFlowDate = new ArrayList<>();
                workFlowDate.add(job1);
                workFlowDate.add(job2);
                workFlowDate.add(job3);
                workFlowDate.add(job4);
                workFlowDate.add(job5);


                //将八条记录放入到这个人的workFlow中
                WorkFlowInfo workflowInfo = new WorkFlowInfo();
                workflowInfo.setWorkBatch(batchInfo.getBatchId());
                workflowInfo.setWorkPerson(arrangeWorkDTO.getWorkPerson());
                workflowInfo.setWorkDate(job1);
                workflowInfo.setWorkItemId(1637722972147695617L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job2);
                workflowInfo.setWorkItemId(1637737731396009986L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job3);
                workflowInfo.setWorkItemId(1637723059208863745L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job4);
                workflowInfo.setWorkItemId(1637723116414976002L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);

                workflowInfo.setWorkDate(job5);
                workflowInfo.setWorkItemId(1640546539407208449L);
                workflowInfo.setIsFinished(0);
                workflowInfo.setWorkflowId(Long.parseLong(snowFlakeGenerateIdWorker.generateNextId()));
                workflowInfoMapper.insert(workflowInfo);
                //挑选种鸡1-对挑选回来的鸡打疫苗1-人工取精1-人工授精5-捡鸡蛋
            }

        }

        return ResultUtil.success(insert);
    }

    @RequestMapping("/getPersonUndoneWork")
    public Result<?> getPersonUndoneWork(@RequestBody WorkFlowInfo workFlowInfo) {
        System.out.println("得到的对象：" + workFlowInfo);
        List<WorkFlowInfo> allPersonUndoneWork = workflowInfoService.getPersonUndoneWork(workFlowInfo.getWorkPerson());
        return ResultUtil.success(allPersonUndoneWork);
    }

    @RequestMapping("/finishWork")
    public Result<?> finishWork(@RequestBody WorkFlowInfo workFlowInfo) {
        //首先看完成的是什么任务，如果有workBatch，就是流程任务，否则，就是其他任务。
        int i = 0;
        if (workFlowInfo.getWorkBatch() == null) {
            //是其他任务，则直接把finish改为完成
            workFlowInfo.setIsFinished(1);
            i = workflowInfoMapper.updateById(workFlowInfo);
            return ResultUtil.success("工作已完成");

        } else {
            //是流程任务
            /**
             * 1. 通过batchId取得batchInfo
             * 2. 判断batchInfo的modify的时间
             *  2.1 如果modify的时间小于完成时间，那么向前推进一个批次。
             *  2.2 如果modify的时间大于完成时间，那么不做任何动作
             */

            BatchInfo batchInfo = batchInfoMapper.selectById(workFlowInfo.getWorkBatch());
            Date modifyDate = batchInfo.getGmtModified();
            Date nowDate = new Date();
            if (modifyDate.getTime() <= nowDate.getTime()) {
                //需要往下推进：通过currentWork得到nextWork
                Long currentWorkId = batchInfo.getCurrentWork();
                WorkItem workItem = workItemMapper.selectById(currentWorkId);
                Long nextWork = workItem.getNextWork();

                if (nextWork != null) {
                    //该批次还可以继续往下，则修改该批次的currentWork
                    batchInfo.setCurrentWork(nextWork);
                    batchInfoMapper.updateById(batchInfo);
                    //将该工作设置为完成
                    workFlowInfo.setIsFinished(1);
                    i = workflowInfoMapper.updateById(workFlowInfo);
                } else {
                    workFlowInfo.setIsFinished(1);
                    workflowInfoMapper.updateById(workFlowInfo);
                    return ResultUtil.success("该批次的工作已完成");
                }

            }

        }

        return ResultUtil.success("工作已完成");

    }


    @RequestMapping("/getPersonAllWorkFlow")
    public Result<?> getPersonAllWorkFlow(@RequestBody WorkFlowInfo workFlowInfo) {
        List<WorkFlowInfo> personWorkFlowInfo = workflowInfoMapper.getPersonWorkFlowInfo(workFlowInfo.getWorkPerson(), null, null);
        return ResultUtil.success(personWorkFlowInfo);

    }


}
