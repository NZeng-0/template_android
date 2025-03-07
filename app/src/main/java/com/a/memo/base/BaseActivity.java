package com.a.memo.base;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;


abstract public class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    public T binding;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getBind();
        context = this;
        setContentView(binding.getRoot());
        initData();
        initView();
    }

    protected abstract T getBind();

    protected abstract void initData();


    protected abstract void initView();
}