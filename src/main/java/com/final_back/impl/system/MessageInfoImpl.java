package com.final_back.impl.system;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.system.MessageInfo;
import com.final_back.mapper.system.MessageInfoMapper;
import com.final_back.service.system.MessageInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageInfoImpl extends ServiceImpl<MessageInfoMapper, MessageInfo> implements MessageInfoService {
    /**
     * 添加消息记录
     * @param messageInfo
     * @return
     */
    @Override
    public Integer addMessageInfo(MessageInfo messageInfo) {
        return null;
    }

    /**
     * 取得某一个用户的信息
     * @param userId
     * @return
     */
    @Override
    public List<MessageInfo> getUserMassageInfo(Long userId, Integer state) {
        return null;
    }

    /**
     * 改变信息状态
     * @param messageId
     * @return
     */
    @Override
    public Integer changeMessageState(Long messageId) {
        return null;
    }


}
