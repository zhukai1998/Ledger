package com.zhukai.ledger.module.sign.vm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.main.ui.MainActivity;
import com.zhukai.ledger.module.sign.ui.SMSActivity;

public class PWDViewModel extends ViewModel
{
    private Activity mActivity;
    public PWDViewModel(Activity context)
    {
        mActivity = context;
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
        mActivity.startActivity(new Intent(mActivity, SMSActivity.class));
    }

    private void mainPage()
    {
        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
        mActivity.finish();
    }
}
