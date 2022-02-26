package com.dapeng.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{

    private Integer code;
    private String  message;
    private T       data;

    //有可能data为null
    public CommonResult( Integer code , String message ) {
        this.code = code;
        this.message = message;
    }

}
