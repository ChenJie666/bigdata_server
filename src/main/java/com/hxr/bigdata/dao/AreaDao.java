package com.hxr.bigdata.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxr.bigdata.entities.ProvinceCountPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 10:54
 */
@Component
public interface AreaDao extends BaseMapper<ProvinceCountPO> {

    @Select("SELECT * " +
            "FROM ads_area_count " +
            "WHERE dt=#{dt}")
    ProvinceCountPO getAreaCount(@Param("dt")String dt, @Param("whichcount") String whichcount);

}
