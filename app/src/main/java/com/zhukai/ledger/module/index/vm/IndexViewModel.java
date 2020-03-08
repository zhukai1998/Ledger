package com.zhukai.ledger.module.index.vm;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.sign.ui.SMSActivity;

public class IndexViewModel extends ViewModel
{

    private Activity mActivity;
    public IndexViewModel(Activity activity)
    {
        mActivity = activity;

    }

    public void login(View view)
    {
        loginPage();
    }

    private void loginPage()
    {

        mActivity.startActivity(new Intent(mActivity, SMSActivity.class));
    }




}
