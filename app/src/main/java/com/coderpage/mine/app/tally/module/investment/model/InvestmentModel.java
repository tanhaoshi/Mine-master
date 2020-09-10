package com.coderpage.mine.app.tally.module.investment.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;

import com.coderpage.mine.app.tally.module.investment.repository.InvestmentRepository;

/**
 * create by ths on 2020/9/7
 */
public class InvestmentModel extends AndroidViewModel implements LifecycleObserver {

    private InvestmentRepository mRepository;

    public InvestmentModel(@NonNull Application application) {
        super(application);
        mRepository = new InvestmentRepository();
        initData();
    }

    private void initData(){
        mRepository.queryDomestic("1123");
    }
}
