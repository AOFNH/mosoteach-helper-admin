package com.mshelper.dms.vo;

/**
 * @author Bellamy
 *
 * 存储一个功能在某种条件下的 使用量 及在总使用量中的占比
 */


public class FunctionUsageDetail {

    private String funcName;

    private Long count;

    private float proportion;

    public String getFuncName() {
        return funcName;
    }

    public Long getCount() {
        return count;
    }

    public float getProportion() {
        return proportion;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }

}
