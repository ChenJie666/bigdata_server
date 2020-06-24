package com.hxr.bigdata.controller;

import com.hxr.bigdata.entities.CommonResult;
import com.hxr.bigdata.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 10:53
 */
@RestController
public class AreaController {

    @Resource
    private AreaService areaService;

    @GetMapping("/area/getAreaCount/{dt}/{whichcount}")
    public CommonResult getAreaCount(@PathVariable String dt,@PathVariable String whichcount){
        return areaService.getAreaCount(dt,whichcount);
    }

    @GetMapping("/area/getDtRange/{whichend}")
    public CommonResult getDtRange(@PathVariable String whichend){
        return areaService.getDtRange(whichend);
    }

}
