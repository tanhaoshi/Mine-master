package com.coderpage.mine.app.tally.module.fund;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.module.fund.model.FundViewModel;
import com.coderpage.mine.ui.BaseActivity;

public class FundEditActivity extends BaseActivity {

    private FundViewModel mFundViewModel;
    private FundEditActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_fund_edit);
        mFundViewModel = ViewModelProviders.of(this).get(FundViewModel.class);
        getLifecycle().addObserver(mFundViewModel);

        setToolbarTitle(getResources().getString(R.string.add_fund));
        setToolbarAsBack(v -> onBackPressed());

        initView();

        subscribeUi();
    }

    private void initView() {

    }

    private void subscribeUi() {
        mBinding.setActivity(this);
        mBinding.setVm(mFundViewModel);
    }

}
