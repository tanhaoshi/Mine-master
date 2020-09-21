package com.coderpage.mine.app.tally.module.index;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.coderpage.base.common.SimpleCallback;
import com.coderpage.mine.app.tally.persistence.model.IndexModel;

import java.util.List;

/**
 * create by ths on 2020/9/18
 */
public class IndexDetailsViewModel extends AndroidViewModel implements LifecycleObserver {

    private MutableLiveData<String> indexWeekObserver  = new MutableLiveData<>();

    private MutableLiveData<String> indexMouthObserver = new MutableLiveData<>();

    private MutableLiveData<String> indexThreeMouthObserver = new MutableLiveData<>();

    private MutableLiveData<String> indexHalfYearObserver = new MutableLiveData<>();

    private MutableLiveData<String> indexYearObserver = new MutableLiveData<>();

    private MutableLiveData<String> indexThreeYearObserver = new MutableLiveData<>();

    private MutableLiveData<String> indexFiveYearObserver = new MutableLiveData<>();

    private MutableLiveData<String> indexStartObserver = new MutableLiveData<>();

    private IndexDetailsRepository mRepository;

    public IndexDetailsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new IndexDetailsRepository();
    }

    public void getLatelyWeek(String type,String indexName){
        mRepository.queryLatelyWeek(type,indexName, new SimpleCallback<List<IndexModel>>() {
            @Override
            public void success(List<IndexModel> indexModels) {
                Log.i("IndexDetailsViewModel","look at lately json models = " + JSON.toJSONString(indexModels));
            }
        });
    }

}
