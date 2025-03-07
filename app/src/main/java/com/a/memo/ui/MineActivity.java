package com.a.memo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.a.memo.base.BaseActivity;
import com.a.memo.databinding.ActivityMineBinding;

public class MineActivity extends BaseActivity<ActivityMineBinding> {


    @Override
    protected ActivityMineBinding getBind() {
        return ActivityMineBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        binding.out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initView() {

    }
}