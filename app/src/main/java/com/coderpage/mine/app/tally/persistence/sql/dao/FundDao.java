package com.coderpage.mine.app.tally.persistence.sql.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomWarnings;

import com.coderpage.mine.app.tally.persistence.sql.entity.FundEntity;

/**
 * create by ths on 2020/9/8
 */
@Dao
public interface FundDao {

    // 根据指定时间查询 一批数据
    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("select * from fund where fund.fund_type == :type and fund.fund_type_unique == :unique order by create_time desc")
    FundEntity getAppointFund(long time,String type,String unique);

}
