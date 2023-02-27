package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.TransportRouteInfo;
import com.final_back.mapper.maintainInfo.TransportRouteInfoMapper;
import com.final_back.service.maintainInfo.TransportRouteInfoService;
import org.springframework.stereotype.Service;

@Service
public class TransportRouteInfoImpl extends ServiceImpl<TransportRouteInfoMapper, TransportRouteInfo> implements TransportRouteInfoService {
}
