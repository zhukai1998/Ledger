package com.zhukai.ledger.module.sign.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.zhukai.ledger.R;
import com.zhukai.ledger.databinding.ActivitySmsBinding;
import com.zhukai.ledger.module.component.BaseActivity;
import com.zhukai.ledger.module.sign.vm.SMSViewModel;


public class SMSActivity extends BaseActivity {

    ActivitySmsBinding activitySmsBinding;
    SMSViewModel smsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySmsBinding = DataBindingUtil.setContentView(this, R.layout.activity_sms);
        smsViewModel = new SMSViewModel(this);
        activitySmsBinding.setVm(smsViewModel);
    }
}
