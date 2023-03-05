package com.final_back.service.maintainInfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.maintainInfo.TransportRouteInfo;

import java.util.List;

public interface TransportRouteInfoService extends IService<TransportRouteInfo> {

    List<TransportRouteInfo> getAllTransportRouteInfo();

    Integer addTransportRouteInfo(TransportRouteInfo transportRouteInfo);

    Integer updateTransportRouteInfo(TransportRouteInfo transportRouteInfo);

    Integer deleteTransportRouteInfo(Long transportRouteInfoId);

}
