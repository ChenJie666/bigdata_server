package com.hxr.bigdata.service;

import com.hxr.bigdata.entities.CommonResult;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 10:55
 */
public interface AreaService {

    CommonResult getAreaCount(String dt, String whichcount);

    CommonResult getDtRange(String whichend);
}
