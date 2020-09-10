package com.mshelper.dms.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class FuncHitsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    public static final FuncHits funcHits = new FuncHits();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source field: func_hits.ht_id")
    public static final SqlColumn<Long> htId = funcHits.htId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source field: func_hits.ht_fc_id")
    public static final SqlColumn<Long> htFcId = funcHits.htFcId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source field: func_hits.ht_date")
    public static final SqlColumn<Date> htDate = funcHits.htDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source field: func_hits.ht_usr_id")
    public static final SqlColumn<Long> htUsrId = funcHits.htUsrId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.665+08:00", comments="Source Table: func_hits")
    public static final class FuncHits extends SqlTable {
        public final SqlColumn<Long> htId = column("ht_id", JDBCType.BIGINT);

        public final SqlColumn<Long> htFcId = column("ht_fc_id", JDBCType.BIGINT);

        public final SqlColumn<Date> htDate = column("ht_date", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> htUsrId = column("ht_usr_id", JDBCType.BIGINT);

        public FuncHits() {
            super("func_hits");
        }
    }
}