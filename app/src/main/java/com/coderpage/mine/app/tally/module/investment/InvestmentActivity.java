package com.coderpage.mine.app.tally.module.investment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.common.router.TallyRouter;
import com.coderpage.mine.app.tally.module.fund.FundEditActivity;
import com.coderpage.mine.app.tally.module.investment.model.InvestmentModel;
import com.coderpage.mine.app.tally.ui.refresh.RefreshHeadView;
import com.coderpage.mine.ui.BaseActivity;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

@Route(path = TallyRouter.INVESTMENT_PATH)
public class InvestmentActivity extends BaseActivity {

    private InvestmentModel           mInvestmentModel;
    private InvestmentActivityBinding mActivityBinding;
    private TwinklingRefreshLayout    mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_investment);
        mInvestmentModel = ViewModelProviders.of(this).get(InvestmentModel.class);
        getLifecycle().addObserver(mInvestmentModel);

        setToolbarAsBack(v -> onBackPressed());
        setToolbarTitle(getResources().getString(R.string.menu_tally_investment));

        initView();
        subscribeUi();
    }

    private void initView() {
        mRefreshLayout = mActivityBinding.refreshLayout;
        mRefreshLayout.setHeaderView(new RefreshHeadView(this));
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
            }
        });

        RecyclerView recyclerView = mActivityBinding.indexUSARecycler;
    }

    private void subscribeUi() {
        mActivityBinding.setActivity(this);
        mActivityBinding.setVm(mInvestmentModel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_investment_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.details:
                startActivity(new Intent(this, FundEditActivity.class));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

