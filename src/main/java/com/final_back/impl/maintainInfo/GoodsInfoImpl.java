package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.GoodsInfo;
import com.final_back.mapper.maintainInfo.GoodsInfoMapper;
import com.final_back.service.maintainInfo.GoodsInfoService;
import com.final_back.service.transport.IncomingRecordService;
import com.final_back.service.transport.TransportRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {
    @Autowired
    GoodsInfoMapper goodsInfoMapper;
    @Autowired
    IncomingRecordService incomingRecordService;
    @Autowired
    TransportRecordService transportRecordService;

    @Override
    public List<GoodsInfo> getAllGoodsInfo() {
        return goodsInfoMapper.selectList(null);
    }

    @Override
    public int addGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoMapper.insert(goodsInfo);
    }

    @Override
    public int deleteGoodsInfoById(Long goodsId) {
        //删除进货情况、运输记录
        List<Long> incomingRecordServiceIdList = incomingRecordService.getIdList(null, goodsId, null, null);
        List<Long> transportRecordServiceIdList = transportRecordService.getIdList(null, null, goodsId, null);

        incomingRecordService.deleteIncomingRecordByIdList(incomingRecordServiceIdList);
        transportRecordService.deleteTransportRecordByIdList(transportRecordServiceIdList);

        int i = goodsInfoMapper.deleteById(goodsId);

        return i;
    }

    @Override
    public int updateGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoMapper.updateById(goodsInfo);
    }


}
