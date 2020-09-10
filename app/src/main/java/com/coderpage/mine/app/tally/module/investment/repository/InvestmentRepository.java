package com.coderpage.mine.app.tally.module.investment.repository;

import com.coderpage.mine.app.tally.persistence.model.FundModel;
import com.coderpage.mine.app.tally.persistence.sql.TallyDatabase;

import java.util.List;


/**
 * create by ths on 2020/9/9
 */
public class InvestmentRepository {

    private TallyDatabase mDataBase;

    public InvestmentRepository() {
        mDataBase = TallyDatabase.getInstance();
    }

    /** 查询国内指数 */
    public void queryDomestic(String type){
        List<FundModel> fundEntityList = mDataBase.fundDisposeDao().getAppointFund(type);
    }
}
