package com.zhukai.ledger.module.index.vm;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModel;

import com.zhukai.ledger.module.main.ui.MainActivity;
import com.zhukai.ledger.module.sign.ui.PWDActivity;
import com.zhukai.ledger.module.sign.ui.SMSActivity;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

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

        mActivity.startActivity(new Intent(mActivity, PWDActivity.class));
    }

    public void sms(View view)
    {
        sendCode(view.getContext());
    }

    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        // 如果使用我们的ui，没有申请模板编号的情况下需传 null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    // 国家代码，如“86”
                    String country = (String) phoneMap.get("country");
                    // 手机号码，如“13800138000”
                    String phone = (String) phoneMap.get("phone");
                    // TODO 利用国家代码和手机号码进行后续的操作
                    System.out.println("true");
                    mainPage();
                } else{
                    // TODO 处理错误的结果
                    System.out.println("false");
                }
            }
        });
        page.show(context);
    }
    private void mainPage()
    {
        mActivity.startActivity(new Intent(mActivity, MainActivity.class));
    }



}
