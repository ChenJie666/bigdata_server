package com.hxr.bigdata.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxr.bigdata.dao.AreaDao;
import com.hxr.bigdata.entities.CommonResult;
import com.hxr.bigdata.entities.ProvinceCountPO;
import com.hxr.bigdata.service.AreaService;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 10:55
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaDao areaDao;

    @Override
    public CommonResult getAreaCount(String dt, String whichcount) {
        ProvinceCountPO areaCount = areaDao.getAreaCount(dt, whichcount);
        String data;
        switch (whichcount) {
            case "day_count":
                data = areaCount.getDayCount();
                break;
            case "week_count":
                data = areaCount.getWeekCount();
                break;
            case "month_count":
                data = areaCount.getMonthCount();
                break;
            default:
                throw new IllegalArgumentException("参数异常");
        }
        HashMap<String, String> map = new HashMap<>();
        for (String s : data.split("")) {
            System.out.println(s);
            String[] pros = s.split(":");
            map.put(pros[0], pros[1]);
        }
        if (map.size() == 0) {
            return CommonResult.isNull();
        }
        return CommonResult.isExist(map);
    }

    @Override
    public CommonResult getDtRange(String whichend) {

        QueryWrapper<ProvinceCountPO> wrapper = new QueryWrapper<>();
        wrapper.select("dt");
        switch (whichend) {
            case "is_weekend":
                wrapper.eq("is_weekend", "Y");
                break;
            case "is_monthend":
                wrapper.eq("is_monthend", "Y");
                break;
            default:
                break;
        }

        List<ProvinceCountPO> pros = areaDao.selectList(wrapper);

        if (pros.size() == 0) {
            return CommonResult.isNull();
        }

        ArrayList<String> dts = Lists.newArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (ProvinceCountPO pro : pros) {
            dts.add(sdf.format(pro.getDt()));
        }

        return CommonResult.isExist(dts);
    }

}
