package com.a.memo.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.a.memo.R;
import com.a.memo.base.BaseActivity;
import com.a.memo.bean.UserData;
import com.a.memo.database.UserDao;
import com.a.memo.databinding.ActivityRegisterBinding;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {

    @Override
    protected ActivityRegisterBinding getBind() {
        return ActivityRegisterBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        binding.regiOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.regiUsername.getText().toString();
                String s1 = binding.regiPassword.getText().toString();
                String s2 = binding.regiPassword2.getText().toString();

                if (s1.equals(s2) && !s1.isEmpty()) {


                    UserDao userDao = new UserDao(context);
                    UserData userInfo = new UserData(userDao.getMaxId() + 1, s, s2);
                    int res = userDao.add(userInfo);
                    if (res == 200) {
                        Toast.makeText(context, "注册成功！",
                                Toast.LENGTH_SHORT).show();
                        binding.regiUsername.setText("");
                        binding.regiPassword.setText("");
                        binding.regiPassword2.setText("");
                    } else {
                        Toast.makeText(context, "该用户已被注册！",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "请确保账号密码正确输入！", Toast.LENGTH_SHORT).show();
                }


            }
        });

        binding.regiOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}