package com.coderpage.mine.app.tally.module.index;

import com.coderpage.base.common.SimpleCallback;
import com.coderpage.concurrency.MineExecutors;
import com.coderpage.mine.app.tally.persistence.model.IndexModel;
import com.coderpage.mine.app.tally.persistence.sql.TallyDatabase;

import java.util.List;

/**
 * create by ths on 2020/9/18
 */
public class IndexDetailsRepository {

    private TallyDatabase mDatabase;

    public IndexDetailsRepository() {
        mDatabase = TallyDatabase.getInstance();
    }

    //查询近一周涨幅
    public void queryLatelyWeek(String type,String indexName, SimpleCallback<List<IndexModel>> simpleCallback){
        MineExecutors.ioExecutor().execute(() ->{
            List<IndexModel> indexModels = mDatabase.indexDao().getLatelyWeekIndex(type,indexName);

            if(indexModels != null && indexModels.size() > 0){
                MineExecutors.executeOnUiThread(() -> simpleCallback.success(indexModels));
            }
        });
    }
}
