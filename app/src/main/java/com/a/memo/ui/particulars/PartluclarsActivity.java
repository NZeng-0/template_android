package com.a.memo.ui.particulars;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.a.memo.MyApp;
import com.a.memo.R;
import com.a.memo.base.BaseActivity;
import com.a.memo.bean.NoteData;
import com.a.memo.bean.UserData;
import com.a.memo.database.NoteDao;
import com.a.memo.database.UserDao;
import com.a.memo.databinding.ActivityPartluclarsBinding;

import static com.a.memo.util.Util.getTime;
import static com.a.memo.util.Util.setDialog;

public class PartluclarsActivity extends BaseActivity<ActivityPartluclarsBinding> {

    @Override
    protected ActivityPartluclarsBinding getBind() {
        return ActivityPartluclarsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        binding.out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        String title = getIntent().getStringExtra("title");
        String text = getIntent().getStringExtra("text");
        int id = getIntent().getIntExtra("id", 1);
        binding.edit1.setText(title);
        binding.edit2.setText(text);
        //删除
        binding.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NoteDao(context).detele(id);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("删除成功")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        //修改
        binding.but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NoteDao(context).update(
                        new NoteData(
                                id, MyApp.USERNAME,
                                binding.edit1.getText().toString(),
                                binding.edit2.getText().toString(),
                                getTime()
                        )
                );
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("修改成功")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    protected void initView() {

    }
}