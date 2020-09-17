package com.coderpage.mine.app.tally.module.investment.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.coderpage.mine.MineApp;
import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.module.investment.model.IndexFundViewModel;
import com.coderpage.mine.app.tally.persistence.model.FundModel;
import com.coderpage.mine.tally.module.fund.AdapterIndexOfBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * create by ths on 2020/9/16
 */
public class IndexOfFundAdapter extends RecyclerView.Adapter<IndexOfFundAdapter.FundVH>{

    private LayoutInflater mInflater;
    private List<FundModel> mFundModels = new ArrayList<>();
    private Activity mActivity;
    private IndexFundViewModel mFundViewModel;

    public IndexOfFundAdapter(Activity activity,IndexFundViewModel fundViewModel){
        this.mActivity = activity;
        mInflater = LayoutInflater.from(activity);
        this.mFundViewModel = fundViewModel;
    }

    public void setData(List<FundModel> list){
        if(list == null){
            return;
        }

        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
            @Override
            public int getOldListSize() {
                return mFundModels.size();
            }

            @Override
            public int getNewListSize() {
                return list.size();
            }

            @Override
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                FundModel oldModel = mFundModels.get(oldItemPosition);
                FundModel newModel = list.get(newItemPosition);

                if(oldModel.getId() != newModel.getId()){
                    return false;
                }

                if(oldModel.getFundName().equals(newModel.getFundName())){
                    return false;
                }

                return true;
            }

            @Override
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                return false;
            }
        });
        mFundModels.clear();
        mFundModels.addAll(list);
        result.dispatchUpdatesTo(this);
    }

    @NonNull
    @Override
    public FundVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FundVH(DataBindingUtil.inflate(LayoutInflater.from(mActivity), R.layout.adapter_index_of_fund,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FundVH holder, int position) {
        holder.bindTo(mFundModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mFundModels.size();
    }

    class FundVH extends RecyclerView.ViewHolder{

        AdapterIndexOfBinding mBinding;

        public FundVH(AdapterIndexOfBinding mBinding) {
            super(mBinding.getRoot());
            this.mBinding = mBinding;
        }

        public void bindTo(FundModel fundModel){
            mBinding.setActivity(mActivity);
            mBinding.setData(fundModel);
            mBinding.setVm(mFundViewModel);
            mBinding.executePendingBindings();
        }
    }
}
