package com.atguigu.springboot.exception;

public class UserException extends RuntimeException {

    public  UserException(){
        super("异常了啊");
    }
}
