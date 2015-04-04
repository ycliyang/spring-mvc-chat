package com.ly.web.model;

import org.aspectj.apache.bcel.classfile.Code;

/**
 * Created by liyang on 15/3/28.
 */
public class ResultModel {

    public static enum  Code{
        error(500),
        success(200);

        int code;

        Code(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code+"";
        }

        public int getCode() {
            return code;
        }
    }


    private Code code = Code.success;

    private Object data;


    public String getCode() {
        return code.toString();
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
