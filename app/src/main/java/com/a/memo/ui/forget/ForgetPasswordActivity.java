package com.a.memo.ui.forget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.a.memo.MyApp;
import com.a.memo.base.BaseActivity;
import com.a.memo.bean.UserData;
import com.a.memo.database.UserDao;
import com.a.memo.databinding.ActivityForgetPasswordBinding;

import static com.a.memo.util.Util.setDialog;

public class ForgetPasswordActivity extends BaseActivity<ActivityForgetPasswordBinding> {


    @Override
    protected ActivityForgetPasswordBinding getBind() {
        return ActivityForgetPasswordBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {
        binding.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = binding.edit2.getText().toString();
                String s2 = binding.edit3.getText().toString();
                if (s1.equals("")) {
                    Toast.makeText(context, "新密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (!s1.equals(s2)) {
                        Toast.makeText(context, "两次新密码输入不相同", Toast.LENGTH_SHORT).show();
                    } else {
                        new UserDao(context).update(
                                new UserData(MyApp.ID, MyApp.USERNAME, s1)
                        );
                        setDialog(context, "修改成功！\n密码为：" + s1);
                        binding.edit3.setText("");
                        binding.edit2.setText("");

                    }
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

    @Override
    protected void initView() {

    }
}