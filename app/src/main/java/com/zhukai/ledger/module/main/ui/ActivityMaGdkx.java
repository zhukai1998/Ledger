package com.zhukai.ledger.module.main.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zhukai.ledger.R;
import com.zhukai.ledger.bean.GdkzData;
import com.zhukai.ledger.bean.MyStringUtils;
import com.zhukai.ledger.module.component.BaseActivity;
import com.zhukai.ledger.module.main.dao.MyDataBase;

import java.util.ArrayList;
import java.util.List;

public class ActivityMaGdkx extends BaseActivity {

    private Toolbar toolbar;
    private GridView gv;
    private String value;
    private MyDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_gdkx);

        initView();
        initData();
    }

    private void initData() {
        MyAsyncTask myAsyncTask = new MyAsyncTask(gv);
        myAsyncTask.execute();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.ma_gdkx_toolbar);
        setSupportActionBar(toolbar);
        gv = (GridView) findViewById(R.id.ma_gdkx_gv);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityMaGdkx.this.finish();
            }
        });
        TextView emptyView = (TextView) findViewById(R.id.ma_gdkx_gv_empty);
        gv.setEmptyView(emptyView);
        gv.setOnItemClickListener(itemClickListener);
    }

    /**
     * 单击item修改开销
     */
    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            TextView tv = (TextView) view
                    .findViewById(R.id.gdkx_gv_item_tv_name);
            showSettingDialog(position, tv.getText().toString());
        }
    };

    private class GdkzAdapter extends BaseAdapter {

        private Context context;
        private List<GdkzData> datas;

        public GdkzAdapter(Context context, List<GdkzData> datas) {
            this.context = context;
            this.datas = datas;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                LayoutInflater mInflater = LayoutInflater.from(context);
                convertView = mInflater.inflate(
                        R.layout.activity_ma_gdkx_gv_item,
                        (ViewGroup) convertView, false);
                holder = new ViewHolder();
                holder.view = convertView.findViewById(R.id.gdkx_gv_item_view);
                holder.name = (TextView) convertView
                        .findViewById(R.id.gdkx_gv_item_tv_name);
                holder.limit = (TextView) convertView
                        .findViewById(R.id.gdkx_gv_item_tv_limit);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final GdkzData d = datas.get(position);
            holder.view.setBackgroundColor(Color.parseColor(d.getColor()));
            holder.name.setText(d.getName());
            holder.limit.setText(d.getMoney() + " ￥");
            if (d.getMoney().equals("0")) {
                holder.limit.setText("未设置");
            }
            return convertView;
        }

        private class ViewHolder {
            private View view;
            private TextView name, limit;
        }

    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        private List<GdkzData> mDatas = new ArrayList<GdkzData>();
        private GridView gridView;
        private GdkzAdapter adapter;
        private MyDataBase dataBase;

        public MyAsyncTask(GridView gridView) {
            this.gridView = gridView;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            dataBase = new MyDataBase(getBaseContext());
            dataBase.open();
            mDatas = dataBase.getLimitsDatas();
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            adapter = new GdkzAdapter(ActivityMaGdkx.this, mDatas);
            gridView.setAdapter(adapter);
            dataBase.close();
        }

    }

    protected void showSettingDialog(final int pos, final String type) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View dilog = layoutInflater.inflate(R.layout.activity_setting_dialog,
                (ViewGroup) findViewById(R.id.setting_dialog));
        final EditText eText = (EditText) dilog
                .findViewById(R.id.setting_dialog_et);
        final TextView tView = (TextView) dilog
                .findViewById(R.id.setting_dialog_tv);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                value = eText.getText().toString();
                if (!value.equals("")) {
                    value = MyStringUtils.get2dotFloat(Float.parseFloat(value));
                    updataToDBp(pos, type);
                }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        MyStringUtils.setPricePoint(eText);
        tView.setText("请输入金额：");
        builder.setTitle("设置该类别的固定开销");
        builder.setView(dilog);
        builder.show();
    }

    protected void updataToDBp(int position, String type) {
        dataBase = new MyDataBase(this);
        dataBase.open();
        dataBase.updateDataTolimitsLimit(type, value,
                dataBase.getProORLimit(0, type));
        initData();
        dataBase.close();
    }

}
