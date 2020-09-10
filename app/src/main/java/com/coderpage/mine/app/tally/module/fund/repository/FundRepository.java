package com.coderpage.mine.app.tally.module.fund.repository;

import com.coderpage.base.common.IError;
import com.coderpage.base.common.Result;
import com.coderpage.base.common.SimpleCallback;
import com.coderpage.concurrency.MineExecutors;
import com.coderpage.mine.app.tally.persistence.model.FundModel;
import com.coderpage.mine.app.tally.persistence.sql.TallyDatabase;

/**
 * create by ths on 2020/9/9
 */
public class FundRepository {

    private TallyDatabase mDataBase;

    public FundRepository() {
        mDataBase = TallyDatabase.getInstance();
    }

    public void saveFund(FundModel fundModel, SimpleCallback<Result<Long, IError>> callback){
        MineExecutors.ioExecutor().execute(() ->{
            long id = mDataBase.fundDisposeDao().insert(fundModel.createEntity());
            MineExecutors.executeOnUiThread(() ->callback.success(new Result<>(id,null)));
        });
    }
}
