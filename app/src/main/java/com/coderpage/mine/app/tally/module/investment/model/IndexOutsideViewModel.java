package com.coderpage.mine.app.tally.module.investment.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.support.annotation.NonNull;

/**
 * create by ths on 2020/9/16
 */
public class IndexOutsideViewModel extends AndroidViewModel implements LifecycleObserver {

    public IndexOutsideViewModel(@NonNull Application application) {
        super(application);
    }

}
