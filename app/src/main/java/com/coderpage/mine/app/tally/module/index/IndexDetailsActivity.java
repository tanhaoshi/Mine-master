package com.coderpage.mine.app.tally.module.index;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.persistence.model.IndexModel;
import com.coderpage.mine.tally.module.index.IndexDetailsActivityBinding;
import com.coderpage.mine.ui.BaseActivity;

public class IndexDetailsActivity extends BaseActivity {

    IndexDetailsActivityBinding mBinding;
    IndexDetailsViewModel mViewModel;

    private IndexModel mIndexModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_index_details);
        mViewModel = ViewModelProviders.of(this).get(IndexDetailsViewModel.class);
        // 虚拟造一些假数据 看看查查一个月是什么结果
        getIntentData();

        setToolbarAsBack((v -> finish()));

        mBinding.setVM(mViewModel);
    }

    private void getIntentData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if(bundle != null){
            mIndexModel = (IndexModel) bundle.getSerializable("indexModel");
        }

        if(mIndexModel != null){
            setToolbarTitle(mIndexModel.getIndexName());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.getLatelyWeek(mIndexModel.getIndexType(),mIndexModel.getIndexName());
    }
}
