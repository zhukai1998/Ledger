package com.zhukai.ledger.module.sign.vm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.sign.ui.SMSActivity;

public class PWDViewModel extends ViewModel
{
    private Context mContext;
    public PWDViewModel(Context context)
    {
        mContext = context;
    }

    public void turnTo(View view)
    {
        smsPage();
    }

    public void login(View view)
    {

    }

    private void smsPage()
    {
        mContext.startActivity(new Intent(mContext, SMSActivity.class));
    }
}
