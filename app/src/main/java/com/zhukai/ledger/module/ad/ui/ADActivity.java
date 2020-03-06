package com.zhukai.ledger.module.ad.ui;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.zhukai.ledger.R;
import com.zhukai.ledger.module.component.BaseActivity;
import com.zhukai.ledger.databinding.ActivityAdBinding;
import com.zhukai.ledger.module.ad.vm.ADViewModel;

public class ADActivity extends BaseActivity {

    ActivityAdBinding activityAdBinding;
    ADViewModel adViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAdBinding = DataBindingUtil.setContentView(this, R.layout.activity_ad);
        adViewModel = new ADViewModel(this);
        activityAdBinding.setAd(adViewModel);
    }
}
