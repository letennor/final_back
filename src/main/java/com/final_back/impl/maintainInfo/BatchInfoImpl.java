package com.final_back.impl.maintainInfo;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.final_back.entity.maintainInfo.BatchInfo;
import com.final_back.mapper.maintainInfo.BatchInfoMapper;
import com.final_back.service.maintainInfo.BatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchInfoImpl extends ServiceImpl<BatchInfoMapper, BatchInfo> implements BatchInfoService {
    @Autowired
    BatchInfoMapper batchInfoMapper;

    @Override
    public List<BatchInfo> getAllBatch() {
        return batchInfoMapper.selectList(null);
    }
}
