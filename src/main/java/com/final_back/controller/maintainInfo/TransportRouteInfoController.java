package com.final_back.controller.maintainInfo;

import com.final_back.entity.maintainInfo.TransportRouteInfo;
import com.final_back.entity.transport.TransportRecord;
import com.final_back.service.maintainInfo.TransportRouteInfoService;
import com.final_back.utils.result.Result;
import com.final_back.utils.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransportRouteInfoController {
    @Autowired
    TransportRouteInfoService transportRouteInfoService;

    @RequestMapping("/addTransportRoute")
    public Result<?> addTransportRoute(@RequestBody TransportRouteInfo transportRouteInfo) {
        Integer integer = transportRouteInfoService.addTransportRouteInfo(transportRouteInfo);
        if (integer > 0) {
            return ResultUtil.success("插入成功");
        } else {
            return ResultUtil.success("插入失败");
        }
    }

    @RequestMapping("/getAllTransportRouteInfo")
    public Result<?> getAllTransportRouteInfo() {
        List<TransportRouteInfo> allTransportRouteInfo = transportRouteInfoService.getAllTransportRouteInfo();
        return ResultUtil.success(allTransportRouteInfo);
    }

    @RequestMapping("/updateTransportRouteInfo")
    public Result<?> updateTransportRouteInfo(@RequestBody TransportRouteInfo transportRouteInfo){
        Integer integer = transportRouteInfoService.updateTransportRouteInfo(transportRouteInfo);
        if (integer > 0) {
            return ResultUtil.success("修改成功");
        } else {
            return ResultUtil.success("修改失败");
        }
    }

    @RequestMapping("/deleteTransportRouteInfo")
    public Result<?> deleteTransportRouteInfo(@RequestBody TransportRouteInfo transportRouteInfo){
        return null;
    }

}
