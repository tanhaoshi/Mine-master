package com.coderpage.mine.app.tally.persistence.sql.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * create by ths on 2020/9/8
 *
 * indices 索引
 */
@Entity(tableName = "fund", indices = {@Index(value = {"fund_sync_id"}, unique = true)})
public class FundEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fund_id")
    private long id;

    @ColumnInfo(name = "fund_sync_id")
    private long fundSyncId;

    /** 记录时间（UNIX TIME） */
    @ColumnInfo(name = "create_time")
    @NonNull
    private long time;

    // id, 同步id , 创建时间, 指数名称, 指数 , 幅度 , 百分比 , 类型 , 类型名
    /** 指数名称 */
    @ColumnInfo(name = "fund_name")
    @NonNull
    private String fundName;

    /** 指数 */
    @ColumnInfo(name = "fund_number")
    @NonNull
    private String fundNumber;

    /** 幅度 */
    @ColumnInfo(name = "fund_range")
    @NonNull
    private String fundRange;

    /** 百分比 */
    @ColumnInfo(name = "fund_percent")
    @NonNull
    private String fundPercent;

    /** 指数类型 主要区分 国内国外*/
    @ColumnInfo(name = "fund_type")
    @NonNull
    private String fundType;

    /** 指数名称 */
    @ColumnInfo(name = "fund_type_unique")
    @NonNull
    private String fundUnique;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFundSyncId() {
        return fundSyncId;
    }

    public void setFundSyncId(long fundSyncId) {
        this.fundSyncId = fundSyncId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @NonNull
    public String getFundName() {
        return fundName;
    }

    public void setFundName(@NonNull String fundName) {
        this.fundName = fundName;
    }

    @NonNull
    public String getFundNumber() {
        return fundNumber;
    }

    public void setFundNumber(@NonNull String fundNumber) {
        this.fundNumber = fundNumber;
    }

    @NonNull
    public String getFundRange() {
        return fundRange;
    }

    public void setFundRange(@NonNull String fundRange) {
        this.fundRange = fundRange;
    }

    @NonNull
    public String getFundPercent() {
        return fundPercent;
    }

    public void setFundPercent(@NonNull String fundPercent) {
        this.fundPercent = fundPercent;
    }

    @NonNull
    public String getFundType() {
        return fundType;
    }

    public void setFundType(@NonNull String fundType) {
        this.fundType = fundType;
    }

    @NonNull
    public String getFundUnique() {
        return fundUnique;
    }

    public void setFundUnique(@NonNull String fundUnique) {
        this.fundUnique = fundUnique;
    }
}
