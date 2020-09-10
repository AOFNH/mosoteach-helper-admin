package com.mshelper.dms.vo;

/**
 * @author Bellamy
 *
 * 存储某一功能 在 某一天 的使用量
 */
public class FunctionUsageDetailOnDate {

    private String date;
    private long count;

    public String getDate() {
        return date;
    }

    public long getCount() {
        return count;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
