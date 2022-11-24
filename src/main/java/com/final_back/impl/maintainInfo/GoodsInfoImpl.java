package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.GoodsInfo;
import com.final_back.mapper.maintainInfo.GoodsInfoMapper;
import com.final_back.service.maintainInfo.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoImpl extends ServiceImpl<GoodsInfoMapper, GoodsInfo> implements GoodsInfoService {
    @Autowired
    GoodsInfoMapper goodsInfoMapper;

    @Override
    public List<GoodsInfo> getAllGoodsInfo() {
        return goodsInfoMapper.selectList(null);
    }

    @Override
    public int addGoodsInfo(GoodsInfo goodsInfo) {
        return goodsInfoMapper.insert(goodsInfo);
    }
}
