package com.coderpage.mine.app.tally.module.investment.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.module.investment.InvestmentActivityBinding;
import com.coderpage.mine.app.tally.module.investment.model.InvestmentModel;
import com.coderpage.mine.app.tally.module.search.SearchViewModel;

/**
 * create by ths on 2020/9/8
 */
public class FundUSAAdapter extends RecyclerView.Adapter<FundUSAAdapter.UsaVH>{

    private LayoutInflater  mInflater;
    private InvestmentModel mViewModel;

    public FundUSAAdapter(Context context , InvestmentModel investmentModel){
        this.mViewModel = investmentModel;
        mInflater = LayoutInflater.from(context);
        //能 速度
    }

    @NonNull
    @Override
    public UsaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UsaVH(DataBindingUtil.inflate(mInflater, R.layout.adapter_fundusa_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsaVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class UsaVH extends RecyclerView.ViewHolder{

        InvestmentActivityBinding mActivityBinding;

        public UsaVH(InvestmentActivityBinding binding) {
            super(binding.getRoot());
            mActivityBinding = binding;
        }
    }

}
