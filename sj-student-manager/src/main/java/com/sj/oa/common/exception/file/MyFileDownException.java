package com.sj.oa.common.exception.file;

import java.io.IOException;

/**
 * @author 永健
 * 文件下载异常
 */
public class MyFileDownException extends IOException{
    private String message;

    public MyFileDownException(String msg)
    {
        super(msg);
        this.message=msg;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
