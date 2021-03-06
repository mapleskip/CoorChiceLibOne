package com.chenbing.coorchicelibone.Views;

import com.chenbing.coorchicelibone.Utils.DataCacheTest;
import com.chenbing.iceweather.R;
import com.chenbing.coorchicelibone.Utils.LogUtils;
import com.chenbing.coorchicelibone.Views.BaseView.BaseActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskActivity_A extends BaseActivity {
  @BindView(R.id.btn_1)
  Button btn_1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_task_a);
    ButterKnife.bind(this);
    initData();
    initView();
    addListener();
    if (DataCacheTest.getInstance().getActivity() == null){
      DataCacheTest.getInstance().setActivity(this);
    } else {
      LogUtils.e(String.format("DataCacheTest: TaskActivity_A: %s, TaskId = %s", DataCacheTest.getInstance().getActivity().toString(), this.getTaskId() + ""));

    }
    LogUtils.e(String.format("TaskActivity_A: %s, TaskId = %s", this.toString(), this.getTaskId() + ""));
  }

  @Override
  protected void initData() {

  }

  @Override
  protected void initView() {

  }

  @Override
  protected void addListener() {
    btn_1.setOnClickListener(v -> {
      Intent intent = new Intent(this,TaskActivity_B.class);
      startActivity(intent);
    });

  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    LogUtils.e("TaskActivity_A - > onDestroy");
    DataCacheTest.getInstance().setActivity(null);
  }

  @Override
  public void finish() {
    super.finish();
    LogUtils.e("TaskActivity_A - > finish");
  }
}
