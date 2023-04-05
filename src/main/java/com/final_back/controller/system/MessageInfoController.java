package com.final_back.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.final_back.entity.system.MessageInfo;
import com.final_back.entity.system.UserBasicInfo;
import com.final_back.mapper.system.MessageInfoMapper;
import com.final_back.mapper.system.UserBasicInfoMapper;
import com.final_back.service.system.MessageInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@RestController
public class MessageInfoController {

    @Autowired
    MessageInfoService messageInfoService;
    @Autowired
    UserBasicInfoMapper userBasicInfoMapper;
    @Autowired
    MessageInfoMapper messageInfoMapper;

    /**
     * 添加信息
     *
     * @param messageInfo
     * @return
     */
    @RequestMapping("/addMessageInfo")
    public Result<?> addMessageInfo(@RequestBody MessageInfo messageInfo) {
        Integer integer = 0;
        if (messageInfo.getMessageReceiver() == null) {
            // 如果没有接收方，则是发给所有管理员
            //找出所有管理员
            QueryWrapper<UserBasicInfo> userBasicInfoQueryWrapper = new QueryWrapper<>();
            userBasicInfoQueryWrapper.eq("role_id", 1636587885578465282L);
            List<UserBasicInfo> userBasicInfos = userBasicInfoMapper.selectList(userBasicInfoQueryWrapper);
            Iterator<UserBasicInfo> iterator = userBasicInfos.iterator();
            while (iterator.hasNext()) {
                messageInfo.setMessageReceiver(iterator.next().getUserBasicInfoId());
                integer += messageInfoService.addMessageInfo(messageInfo);
            }
        } else {
            integer = messageInfoService.addMessageInfo(messageInfo);
        }

        if (integer > 0) {
            return ResultUtil.success("添加成功");
        } else {
            return ResultUtil.success("添加失败");
        }
    }

    /**
     * 取得用户的信息
     *
     * @param messageInfo
     * @return
     */
    @RequestMapping("/getUserMessageInfo")
    public Result<?> getUserMessageInfo(@RequestBody MessageInfo messageInfo) {
        QueryWrapper<MessageInfo> messageInfoQueryWrapper = new QueryWrapper<>();
        messageInfoQueryWrapper.eq("message_receiver", messageInfo.getMessageReceiver());
        messageInfoQueryWrapper.eq("is_read", 0);
        List<MessageInfo> messageInfos = messageInfoMapper.selectList(messageInfoQueryWrapper);

        return ResultUtil.success(messageInfos);
    }

    @RequestMapping("/confirmMessage")
    public Result<?> confirmMessage(@RequestBody MessageInfo messageInfo) {
        messageInfo.setIsRead(1);
        int i = messageInfoMapper.updateById(messageInfo);
        if (i > 0) {
            return ResultUtil.success("添加成功");
        } else {
            return ResultUtil.success("添加失败");
        }

    }


}
