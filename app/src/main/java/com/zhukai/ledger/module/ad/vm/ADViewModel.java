package com.zhukai.ledger.module.ad.vm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.R;
import com.zhukai.ledger.module.index.ui.IndexActivity;
import com.zhukai.ledger.module.main.ui.SplashActivity;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class ADViewModel extends ViewModel
{
    public ObservableField<String> skipMessage;
    public ObservableInt skipMessageVisibility;
    private Timer timer;
    private Activity mActivity;

    public ADViewModel(Activity activity)
    {
        mActivity = activity;
        final int second = Integer.parseInt(mActivity.getString(R.string.skip_second));
        skipMessage = new ObservableField<>(mActivity.getString(R.string.skip_) +
                " " + second + mActivity.getString(R.string.skip_unit));
        skipMessageVisibility = new ObservableInt(View.VISIBLE);

        for(int i = 1; i <= second; i ++)
        {
            final int finalI = i;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    skipMessage.set(mActivity.getString(R.string.skip_) +
                            " " + (second - finalI) + mActivity.getString(R.string.skip_unit));
                    skipMessageVisibility.set(View.VISIBLE);
                }
            }, Integer.parseInt(i + mActivity.getString(R.string.skip_million)));
        }
        schedule(Integer.parseInt(second + mActivity.getString(R.string.skip_million)));
    }

    private void schedule(long delay_time)
    {
        // 倒计时
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                skip();
            }
        }, delay_time);
    }

    private void skip()
    {
        skip(null);
    }

    public void skip(View view)
    {
        timer.cancel();
        // 跳转到下一页面
        splashPage();
    }


    private void splashPage()
    {
        mActivity.startActivity(new Intent(mActivity, SplashActivity.class));
        mActivity.finish();
    }

}
