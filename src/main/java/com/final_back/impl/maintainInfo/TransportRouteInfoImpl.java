package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.TransportRouteInfo;
import com.final_back.mapper.maintainInfo.TransportRouteInfoMapper;
import com.final_back.service.maintainInfo.TransportRouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportRouteInfoImpl extends ServiceImpl<TransportRouteInfoMapper, TransportRouteInfo> implements TransportRouteInfoService {



    @Autowired
    TransportRouteInfoMapper transportRouteInfoMapper;

    @Override
    public List<TransportRouteInfo> getAllTransportRouteInfo() {
        List<TransportRouteInfo> transportRouteInfos = transportRouteInfoMapper.selectList(null);
        return transportRouteInfos;
    }

    @Override
    public Integer addTransportRouteInfo(TransportRouteInfo transportRouteInfo) {
        return transportRouteInfoMapper.insert(transportRouteInfo);
    }

    @Override
    public Integer updateTransportRouteInfo(TransportRouteInfo transportRouteInfo) {
        return transportRouteInfoMapper.updateById(transportRouteInfo);
    }

    @Override
    public Integer deleteTransportRouteInfo(Long transportRouteInfoId) {
        return null;
    }
}
