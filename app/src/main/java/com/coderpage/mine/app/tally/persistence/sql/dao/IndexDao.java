package com.coderpage.mine.app.tally.persistence.sql.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.coderpage.mine.app.tally.persistence.model.IndexModel;
import com.coderpage.mine.app.tally.persistence.sql.entity.IndexEntity;

import java.util.List;

/**
 * create by ths on 2020/9/11
 */
@Dao
public interface IndexDao {

    @Insert
    long insert(IndexEntity indexEntity);

    @Query("select * from indexs where index_type == :type group by index_name order by create_time asc ")
    List<IndexModel> getInsideIndex(String type);

    // <= datetime('now','start of day','+0 day','weekday 1')

    // >= datetime('now','start of day','-6day')
    @Query("select * from indexs where index_type == :type and index_name == :indexName and " +
            "create_time <= datetime('now','start of day','+0 day','weekday 1') ")
    List<IndexModel> getLatelyWeekIndex(String type,String indexName);

}
