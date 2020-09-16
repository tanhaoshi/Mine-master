package com.coderpage.mine.app.tally.module.index;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.persistence.model.IndexModel;
import com.coderpage.mine.ui.BaseActivity;

import static android.widget.Toast.LENGTH_SHORT;

public class IndexEditActivity extends BaseActivity {

    private IndexEditViewModel       mEditViewModel;
    private IndexEditActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding       = DataBindingUtil.setContentView(this,R.layout.activity_index_editctivity);
        mEditViewModel = ViewModelProviders.of(this).get(IndexEditViewModel.class);
        getLifecycle().addObserver(mEditViewModel);

        setToolbarAsBack(v -> onBackPressed());
        setToolbarTitle(getResources().getString(R.string.menu_tally_investment));

        initView();
        subscribeUi();
    }

    private void initView() {
        mBinding.tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    private void submit(){
        if(mBinding.indexName.getText().toString().length() <= 2){
            Toast.makeText(this,"指数名称不能小于2", LENGTH_SHORT).show();
            return;
        }

        if(mBinding.indexArea.getText().toString().length() == 0){
            Toast.makeText(this,"指数类型必须填", LENGTH_SHORT).show();
            return;
        }

        if(mBinding.currentIndex.getText().toString().length() == 0){
            Toast.makeText(this,"指数必须填写", LENGTH_SHORT).show();
            return;
        }

        if(mBinding.currentRange.getText().toString().length() == 0){
            Toast.makeText(this,"日涨幅必须填写", LENGTH_SHORT).show();
            return;
        }

        if(mBinding.currentPercent.getText().toString().length() == 0){
            Toast.makeText(this,"日涨幅百分比必须填写", LENGTH_SHORT).show();
            return;
        }

        IndexModel indexModel = new IndexModel();
        indexModel.setFundSyncId(System.currentTimeMillis());
        indexModel.setIndexName(mBinding.indexName.getText().toString());
        indexModel.setIndexType(mBinding.indexArea.getText().toString());
        indexModel.setIndexNumber(mBinding.currentIndex.getText().toString());
        indexModel.setIndexRange(mBinding.currentRange.getText().toString());
        indexModel.setIndexPercent(mBinding.currentPercent.getText().toString());

        mEditViewModel.saveIndexData(indexModel);
    }

    private void subscribeUi() {
        mBinding.setData(mEditViewModel);

        mEditViewModel.mLiveData.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(aBoolean){
                    Toast.makeText(IndexEditActivity.this,"添加成功!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

}
