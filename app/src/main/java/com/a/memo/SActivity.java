package com.a.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.a.memo.adapter.RecyclerAdapter;
import com.a.memo.base.BaseActivity;
import com.a.memo.bean.NoteData;
import com.a.memo.database.NoteDao;
import com.a.memo.databinding.ActivitySactivityBinding;

import java.util.List;

public class SActivity extends BaseActivity<ActivitySactivityBinding> {

    @Override
    protected ActivitySactivityBinding getBind() {
        return ActivitySactivityBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        binding.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.edit1.getText().toString();
                List<NoteData> search = new NoteDao(context).search(s);
                binding.rv.setLayoutManager(new LinearLayoutManager(context));
                binding.rv.setAdapter(new RecyclerAdapter(search, context));
            }
        });
    }

    @Override
    protected void initView() {
        binding.out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}