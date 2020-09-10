package com.mshelper.dms.po;

import javax.annotation.Generated;

public class FuncFunction {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.647+08:00", comments="Source field: func_function.fc_id")
    private Long fcId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_no")
    private Integer fcNo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_name")
    private String fcName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.651+08:00", comments="Source field: func_function.fc_status")
    private Integer fcStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.651+08:00", comments="Source field: func_function.fc_hits")
    private Long fcHits;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_id")
    public Long getFcId() {
        return fcId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_id")
    public void setFcId(Long fcId) {
        this.fcId = fcId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_no")
    public Integer getFcNo() {
        return fcNo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_no")
    public void setFcNo(Integer fcNo) {
        this.fcNo = fcNo;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_name")
    public String getFcName() {
        return fcName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.65+08:00", comments="Source field: func_function.fc_name")
    public void setFcName(String fcName) {
        this.fcName = fcName == null ? null : fcName.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.651+08:00", comments="Source field: func_function.fc_status")
    public Integer getFcStatus() {
        return fcStatus;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.651+08:00", comments="Source field: func_function.fc_status")
    public void setFcStatus(Integer fcStatus) {
        this.fcStatus = fcStatus;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.651+08:00", comments="Source field: func_function.fc_hits")
    public Long getFcHits() {
        return fcHits;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.651+08:00", comments="Source field: func_function.fc_hits")
    public void setFcHits(Long fcHits) {
        this.fcHits = fcHits;
    }
}