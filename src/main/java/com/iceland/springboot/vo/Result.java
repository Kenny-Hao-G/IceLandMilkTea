package com.iceland.springboot.vo;

import lombok.Data;

/**
 * @program: BootSsm
 * @description:
 * @author: Feri
 * @create: 2019-10-21 10:28
 */
@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    public static Result setOK(Object data){
        Result r=new Result();
        r.setCode(200);
        r.setMsg("OK");
        r.setData(data);
        return r;
    }
    public static Result setERROR(){
        Result r=new Result();
        r.setCode(400);
        r.setMsg("ERROR");
        r.setData(null);
        return r;
    }

    public static Result setResult(boolean isSuccess,Object object){
        if (isSuccess){
            return setOK(object);
        }else {
            return setERROR();
        }

    }
}
