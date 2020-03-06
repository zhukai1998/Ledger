package com.zhukai.ledger.module.index.ui;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.zhukai.ledger.R;
import com.zhukai.ledger.databinding.ActivityIndexBinding;
import com.zhukai.ledger.module.component.BaseActivity;
import com.zhukai.ledger.module.index.vm.IndexViewModel;

public class IndexActivity extends BaseActivity {

    ActivityIndexBinding activityIndexBinding;
    IndexViewModel indexViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityIndexBinding = DataBindingUtil.setContentView(this, R.layout.activity_index);
        indexViewModel = new IndexViewModel(this);
        activityIndexBinding.setVm(indexViewModel);
    }
}
