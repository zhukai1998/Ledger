package com.zhukai.ledger.module.index.vm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.sign.ui.SMSActivity;

public class IndexViewModel extends ViewModel
{

    private Context mContext;
    public IndexViewModel(Context context)
    {
        mContext = context;
    }

    public void login(View view)
    {
        loginPage();
    }

    private void loginPage()
    {
        mContext.startActivity(new Intent(mContext, SMSActivity.class));
    }
}
