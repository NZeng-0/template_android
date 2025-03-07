package com.a.memo.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.a.memo.MainActivity;
import com.a.memo.MyApp;
import com.a.memo.base.BaseActivity;
import com.a.memo.bean.UserData;
import com.a.memo.database.UserDao;
import com.a.memo.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    @Override
    protected ActivityLoginBinding getBind() {
        return ActivityLoginBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        binding.loginLogin.setOnClickListener(new View.OnClickListener() {

            private String password;
            private String username;

            @Override
            public void onClick(View v) {
                Boolean state = false;
                username = binding.username.getText().toString();
                password = binding.password.getText().toString();
                if (!username.isEmpty() && !password.isEmpty()) {
                    UserDao userDao = new UserDao(context);
                    for (UserData a : userDao.getAll()) {
                        if (a.getUsername().equals(username)) {
                            if (a.getPassword().equals(password)) {
                                MyApp.ID = a.get_id();
                                state = true;
                                break;
                            }
                        }
                        state = false;
                    }
                    if (!state) {
                        Toast.makeText(context, "请检查账号密码状态", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(context, MainActivity.class));
                        MyApp.USERNAME = username;
                        Toast.makeText(context, MyApp.USERNAME + "登录成功！", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(context, "请确保账号密码正确输入！", Toast.LENGTH_SHORT).show();
                }
            }



        });

        binding.loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, RegisterActivity.class));
            }
        });
    }
}