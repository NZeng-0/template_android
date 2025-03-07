package com.a.memo.ui.add;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.a.memo.MyApp;
import com.a.memo.base.BaseActivity;
import com.a.memo.bean.NoteData;
import com.a.memo.database.NoteDao;
import com.a.memo.databinding.ActivityAddBinding;

import static com.a.memo.util.Util.getTime;
import static com.a.memo.util.Util.setDialog;

public class AddActivity extends BaseActivity<ActivityAddBinding> {


    @Override
    protected ActivityAddBinding getBind() {
        return ActivityAddBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        binding.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.edit1.getText().toString();
                String s1 = binding.edit2.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(context, "标题为空哦 亲~", Toast.LENGTH_SHORT).show();
                } else if (s1.equals("")) {
                    Toast.makeText(context, "内容为空哦 亲~", Toast.LENGTH_SHORT).show();
                } else {
                    new NoteDao(context).add(
                            new NoteData(
                                    new NoteDao(context).getMaxId() + 1,
                                    MyApp.USERNAME,
                                    s,
                                    s1,
                                    getTime()
                            )
                    );
                    setDialog(context, "添加成功！");
                    binding.edit1.setText("");
                    binding.edit2.setText("");
                }
            }
        });
        binding.out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}