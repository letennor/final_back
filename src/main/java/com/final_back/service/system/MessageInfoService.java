package com.final_back.service.system;


import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.system.MessageInfo;

import java.util.List;

public interface MessageInfoService extends IService<MessageInfo> {

    Integer addMessageInfo(MessageInfo messageInfo);

    List<MessageInfo> getUserMassageInfo(Long userId, Integer state);

    Integer changeMessageState(Long messageId);
}


