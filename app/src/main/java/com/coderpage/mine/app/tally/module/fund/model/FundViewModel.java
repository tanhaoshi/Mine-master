package com.coderpage.mine.app.tally.module.fund.model;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;

import com.coderpage.base.common.IError;
import com.coderpage.base.common.Result;
import com.coderpage.base.common.SimpleCallback;
import com.coderpage.mine.app.tally.module.fund.repository.FundRepository;
import com.coderpage.mine.app.tally.persistence.model.FundModel;
import com.coderpage.mine.app.tally.ui.dialog.SetBudgetMonthDialog;

/**
 * create by ths on 2020/9/9
 */
public class FundViewModel extends AndroidViewModel implements LifecycleObserver {

    private FundRepository mRepository;

    public FundViewModel(@NonNull Application application) {
        super(application);
        mRepository = new FundRepository();
        initData();
    }

    private void initData() {

    }

    private void saveData(FundModel fundModel){
        if(fundModel == null){
            return;
        }

        mRepository.saveFund(fundModel, new SimpleCallback<Result<Long, IError>>() {
            @Override
            public void success(Result<Long, IError> longIErrorResult) {

            }
        });
    }

    /** 添加新纪录点击 */
    public void onAddNewRecordClick(Activity activity) {
        new SetBudgetMonthDialog(activity).setListener((dialog, budget) -> {
//            mBudgetLeftMoney.set(formatBudgetLeftMoney(mData));
            dialog.dismiss();
        }).show();
    }

}
