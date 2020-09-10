package com.mshelper.dms.po;

import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import java.util.Date;

public class FuncHits {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_id")
    private Long htId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_fc_id")
    private Long htFcId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_date")
    //yyyy-MM-dd HH:mm:ss
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date htDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_usr_id")
    private Long htUsrId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_id")
    public Long getHtId() {
        return htId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_id")
    public void setHtId(Long htId) {
        this.htId = htId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_fc_id")
    public Long getHtFcId() {
        return htFcId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_fc_id")
    public void setHtFcId(Long htFcId) {
        this.htFcId = htFcId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_date")
    public Date getHtDate() {
        return htDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_date")
    public void setHtDate(Date htDate) {
        this.htDate = htDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_usr_id")
    public Long getHtUsrId() {
        return htUsrId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.664+08:00", comments="Source field: func_hits.ht_usr_id")
    public void setHtUsrId(Long htUsrId) {
        this.htUsrId = htUsrId;
    }
}