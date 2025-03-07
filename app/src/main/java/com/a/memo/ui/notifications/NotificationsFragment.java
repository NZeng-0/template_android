package com.a.memo.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.a.memo.MyApp;
import com.a.memo.R;
import com.a.memo.databinding.FragmentNotificationsBinding;
import com.a.memo.ui.MineActivity;
import com.a.memo.ui.forget.ForgetPasswordActivity;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initView();
        return root;
    }

    private void initView() {
        binding.butHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().finishAffinity();
            }
        });
        binding.nameHome3.setText(MyApp.USERNAME);
        binding.imgHome3.setImageResource(R.mipmap.imglogin);
        binding.select.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), ForgetPasswordActivity.class));
            }
        });
        binding.select.getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), MineActivity.class));
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}