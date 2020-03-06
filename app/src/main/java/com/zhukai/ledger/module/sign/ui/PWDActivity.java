package com.zhukai.ledger.module.sign.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.zhukai.ledger.R;
import com.zhukai.ledger.databinding.ActivityPwdBinding;
import com.zhukai.ledger.module.component.BaseActivity;
import com.zhukai.ledger.module.sign.vm.PWDViewModel;

public class PWDActivity extends BaseActivity {

    ActivityPwdBinding activityPwdBinding;
    PWDViewModel pwdViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityPwdBinding = DataBindingUtil.setContentView(this, R.layout.activity_pwd);
        pwdViewModel = new PWDViewModel(this);
        activityPwdBinding.setVm(pwdViewModel);
    }
}
