package com.hxr.bigdata.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 10:56
 */
@Data
@TableName("ads_area_count")
public class ProvinceCountPO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date dt;

    private String dayCount;

    private String weekCount;

    private String monthCount;

    @TableField("is_weekend")
    private String isWeekend;

    @TableField("is_monthend")
    private String isMonthend;

}
