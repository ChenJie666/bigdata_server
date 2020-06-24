package com.hxr.bigdata.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 11:56
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> CommonResult isExist(T data){
        return new CommonResult<>(200,"success",data);
    }

    public static CommonResult isNull(){
        return new CommonResult<>(404,"null",null);
    }

    public static CommonResult error(String message){
        return new CommonResult<>(500, message, null);
    }

}
