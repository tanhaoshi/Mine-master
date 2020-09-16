package com.coderpage.mine.app.tally.module.investment.model;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;
import android.view.View;

import com.coderpage.mine.app.tally.persistence.model.FundModel;

/**
 * create by ths on 2020/9/16
 */
public class IndexFundViewModel extends AndroidViewModel implements LifecycleObserver {

    public IndexFundViewModel(@NonNull Application application) {
        super(application);
    }

    public void onItemClick(View view, Activity activity, FundModel fundModel){

    }
}
