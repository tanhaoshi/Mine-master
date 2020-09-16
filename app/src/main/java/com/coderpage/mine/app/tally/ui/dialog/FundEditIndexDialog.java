package com.coderpage.mine.app.tally.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.coderpage.mine.R;
import com.coderpage.mine.app.tally.common.utils.TallyUtils;
import com.coderpage.mine.app.tally.databinding.CommonBindAdapter;
import com.coderpage.mine.app.tally.persistence.preference.SettingPreference;
import com.coderpage.mine.common.Font;
import com.coderpage.mine.dialog.FundEditDialogBinding;
import com.coderpage.mine.dialog.FundEditIndexDialogBinding;

/**
 * create by ths on 2020/9/10
 */
public class FundEditIndexDialog extends Dialog {

    private FundEditIndexDialog.Listener mListener;
    private FundEditIndexDialogBinding mBinding;

    public FundEditIndexDialog(Activity activity) {
        super(activity, R.style.Widget_Dialog_BottomSheet);
        initView(activity);
    }

    private void initView(Activity activity) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(activity),
                R.layout.dialog_edit_index, null, false);
        CommonBindAdapter.setTypeFace(mBinding.tvBudgetUnit, Font.QUICKSAND_REGULAR);
        CommonBindAdapter.setTypeFace(mBinding.etBudget, Font.QUICKSAND_MEDIUM);

        mBinding.tvBudgetUnit.setText("基金日涨幅:");

        // 显示设置的预算
        float budgetMonth = SettingPreference.getBudgetMonth(activity);
        if (budgetMonth > 0) {
            mBinding.etBudget.setText(TallyUtils.formatDisplayMoney(budgetMonth));
            mBinding.etBudget.setSelection(mBinding.etBudget.getText().toString().length());
        }

//         输入框获取焦点时，弹出软键盘
        mBinding.etBudget.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus && getWindow() != null) {
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        });

        mBinding.ivClose.setOnClickListener(v -> dismiss());
        mBinding.tvConfirm.setOnClickListener(v -> {
            String budgetStr = mBinding.etBudget.getText().toString();
            // 输入预算 <= 0 提示错误信息
            if (budgetStr.length() <= 0) {
                Toast.makeText(activity, "不能输入为空!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (mListener != null) {
                mListener.onBudgetUpdate(this, budgetStr);
            }
        });

        View contentView = mBinding.getRoot();
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        setContentView(contentView);
        initWindow(contentView.getMeasuredHeight());
    }

    private void initWindow(int height) {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(Gravity.BOTTOM);

        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = window.getWindowManager().getDefaultDisplay().getWidth();
        attributes.height = height;
        window.setAttributes(attributes);
    }

    @Override
    public void show() {
        super.show();
        mBinding.etBudget.setFocusable(true);
        mBinding.etBudget.requestFocus();
    }

    public FundEditIndexDialog setListener(Listener listener) {
        mListener = listener;
        return this;
    }

    public interface Listener {
        /**
         * @param dialog dialog
         */
        void onBudgetUpdate(DialogInterface dialog, String percent);
    }
}
