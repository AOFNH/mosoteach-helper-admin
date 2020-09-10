package com.mshelper.dms.dao;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class FuncFunctionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.653+08:00", comments="Source Table: func_function")
    public static final FuncFunction funcFunction = new FuncFunction();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.654+08:00", comments="Source field: func_function.fc_id")
    public static final SqlColumn<Long> fcId = funcFunction.fcId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.654+08:00", comments="Source field: func_function.fc_no")
    public static final SqlColumn<Integer> fcNo = funcFunction.fcNo;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.654+08:00", comments="Source field: func_function.fc_name")
    public static final SqlColumn<String> fcName = funcFunction.fcName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.654+08:00", comments="Source field: func_function.fc_status")
    public static final SqlColumn<Integer> fcStatus = funcFunction.fcStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.654+08:00", comments="Source field: func_function.fc_hits")
    public static final SqlColumn<Long> fcHits = funcFunction.fcHits;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-08-27T13:35:02.654+08:00", comments="Source Table: func_function")
    public static final class FuncFunction extends SqlTable {
        public final SqlColumn<Long> fcId = column("fc_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> fcNo = column("fc_no", JDBCType.INTEGER);

        public final SqlColumn<String> fcName = column("fc_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> fcStatus = column("fc_status", JDBCType.INTEGER);

        public final SqlColumn<Long> fcHits = column("fc_hits", JDBCType.BIGINT);

        public FuncFunction() {
            super("func_function");
        }
    }
}