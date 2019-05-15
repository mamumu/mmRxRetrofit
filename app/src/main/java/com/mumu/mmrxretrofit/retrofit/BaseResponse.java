package com.mumu.mmrxretrofit.retrofit;

import java.util.List;

/**
 * 统一响应
 * @param <T>
 */
public class BaseResponse<T> {


    /**
     * timestamp : 1557832075724
     * resthead : {"errorCode":0,"message":""}
     * restbody : []
     * extend : {"totalNum":0,"rowNum":0}
     */

    private long timestamp;
    private RestheadBean resthead;
    private ExtendBean extend;
    private T restbody;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public RestheadBean getResthead() {
        return resthead;
    }

    public void setResthead(RestheadBean resthead) {
        this.resthead = resthead;
    }

    public ExtendBean getExtend() {
        return extend;
    }

    public void setExtend(ExtendBean extend) {
        this.extend = extend;
    }

    public T getRestbody() {
        return restbody;
    }

    public void setRestbody(T restbody) {
        this.restbody = restbody;
    }

    public static class RestheadBean {
        /**
         * errorCode : 0
         * message :
         */

        private int errorCode;
        private String message;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ExtendBean {
        /**
         * totalNum : 0
         * rowNum : 0
         */

        private int totalNum;
        private int rowNum;

        public int getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(int totalNum) {
            this.totalNum = totalNum;
        }

        public int getRowNum() {
            return rowNum;
        }

        public void setRowNum(int rowNum) {
            this.rowNum = rowNum;
        }
    }
}
