package com.zhukai.ledger.module.sign.vm;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.main.ui.MainActivity;
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
        mainPage();
    }

    private void smsPage()
    {
        mContext.startActivity(new Intent(mContext, SMSActivity.class));
    }

    private void mainPage()
    {
        mContext.startActivity(new Intent(mContext, MainActivity.class));
    }
}
