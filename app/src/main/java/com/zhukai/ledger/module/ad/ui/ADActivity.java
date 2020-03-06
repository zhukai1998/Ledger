package com.zhukai.ledger.module.ad.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.zhukai.ledger.R;
import com.zhukai.ledger.databinding.ActivityMainBinding;
import com.zhukai.ledger.module.ad.vm.ADViewModel;

public class ADActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ADViewModel adViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adViewModel = new ADViewModel(this);
        activityMainBinding.setAd(adViewModel);
    }
}
