package com.ex.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommandResult<T> {

    private int code;
    private String msg;
    private T data;


    /*
     * @Author maiBangMin
     * @Description [系统消息-成功]
     * @Date 11:02 下午 2020/11/18
     * @Version 1.0
     **/
    public static CommandResult success(){
        return new CommandResult(ENUM_RESULT_CODE.SUCCESS.getCode(),ENUM_RESULT_CODE.SUCCESS.getMsg(),null);
    }



    /*
     * @Author maiBangMin
     * @Description [自定义返回数据-成功]
     * @Date 11:03 下午 2020/11/18
     * @Version 1.0
     **/
    public static <T> CommandResult<T> success(T data){
        return new CommandResult(ENUM_RESULT_CODE.SUCCESS.getCode(),ENUM_RESULT_CODE.SUCCESS.getMsg(),data);
    }



    /*
     * @Author maiBangMin
     * @Description [自定义返回数据和消息-成功]
     * @Date 11:03 下午 2020/11/18
     * @Version 1.0
     **/
    public static <T> CommandResult<T> success(String msg,T data){
        return new CommandResult(ENUM_RESULT_CODE.SUCCESS.getCode(),msg,data);
    }


    /*
     * @Author maiBangMin
     * @Description [自动返回数据、消息、状态码-成功]
     * @Date 11:04 下午 2020/11/18
     * @Version 1.0
     **/
    public static <T> CommandResult<T> success(int code,String msg,T data){
        return new CommandResult(code,msg,data);
    }



    /*
     * @Author maiBangMin
     * @Description [系统消息-失败]
     * @Date 11:05 下午 2020/11/18
     * @Version 1.0
     **/
    public static CommandResult failed(){
        return new CommandResult(ENUM_RESULT_CODE.SUCCESS.getCode(),ENUM_RESULT_CODE.SUCCESS.getMsg(),null);
    }


    /*
     * @Author maiBangMin
     * @Description [自定义返回数据-失败]
     * @Date 11:05 下午 2020/11/18
     * @Version 1.0
     **/
    public static <T> CommandResult<T> failed(T data){
        return new CommandResult(ENUM_RESULT_CODE.SUCCESS.getCode(),ENUM_RESULT_CODE.SUCCESS.getMsg(),data);
    }


    /*
     * @Author maiBangMin
     * @Description [自定义返回数据、消息-失败]
     * @Date 11:07 下午 2020/11/18
     * @Version 1.0
     **/
    public static <T> CommandResult<T> failed(String msg,T data){
        return new CommandResult(ENUM_RESULT_CODE.SUCCESS.getCode(),msg,data);
    }



    /*
     * @Author maiBangMin
     * @Description [自定义返回数据、消息、代码=失败]
     * @Date 11:07 下午 2020/11/18
     * @Version 1.0
     **/
    public static <T> CommandResult<T> failed(int code,String msg,T data){
        return new CommandResult(code,msg,data);
    }

}
