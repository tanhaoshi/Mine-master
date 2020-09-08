package com.coderpage.mine.app.tally.module.investment.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * create by ths on 2020/9/7
 */
public class InvestmentModel extends AndroidViewModel implements LifecycleObserver {

    public InvestmentModel(@NonNull Application application) {
        super(application);
    }


}
