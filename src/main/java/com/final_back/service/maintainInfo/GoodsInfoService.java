package com.final_back.service.maintainInfo;

import com.baomidou.mybatisplus.extension.service.IService;
import com.final_back.entity.maintainInfo.GoodsInfo;

import java.util.List;

public interface GoodsInfoService extends IService<GoodsInfo> {
    List<GoodsInfo> getAllGoodsInfo();

    int addGoodsInfo(GoodsInfo goodsInfo);

    int deleteGoodsInfoById(Long goodsId);

}
