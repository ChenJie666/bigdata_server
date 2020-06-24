package com.hxr.bigdata.conf;

import com.hxr.bigdata.entities.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: CJ
 * @Data: 2020/6/24 15:06
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonResult exception(Exception e) {
        String message = e.getMessage();
        return CommonResult.error(message);
    }

}
