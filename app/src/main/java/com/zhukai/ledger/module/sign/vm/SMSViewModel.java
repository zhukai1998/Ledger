package com.zhukai.ledger.module.sign.vm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.sign.ui.PWDActivity;

public class SMSViewModel extends ViewModel
{
    private Context mContext;
    public SMSViewModel(Context context)
    {
        mContext = context;
    }

    public void turnTo(View view)
    {
        pwdPage();
    }

    public void sendCode(View view)
    {

    }

    private void pwdPage()
    {
        mContext.startActivity(new Intent(mContext, PWDActivity.class));
    }
}
