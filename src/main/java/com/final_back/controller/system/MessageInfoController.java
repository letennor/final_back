package com.final_back.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.final_back.entity.system.MessageInfo;
import com.final_back.utils.result.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageInfoController {

    /**
     * 添加信息
     * @param messageInfo
     * @return
     */
    @RequestMapping("/addMessageInfo")
    public Result<?> addMessageInfo(@RequestBody MessageInfo messageInfo){
        return null;
    }

    /**
     * 取得用户的信息
     * @param jsonObject
     * @return
     */
    @RequestMapping("/getUserMessageInfo")
    public Result<?> getUserMessageInfo(@RequestBody JSONObject jsonObject){
        return null;
    }

    /**
     * 改变信息状态
     * @param jsonObject
     * @return
     */
    @RequestMapping("/changeMessageState")
    public Result<?> changeMessageState(@RequestBody JSONObject jsonObject){
        return null;
    }

}
