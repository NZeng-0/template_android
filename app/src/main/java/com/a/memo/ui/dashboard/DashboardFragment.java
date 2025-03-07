package com.a.memo.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.a.memo.R;
import com.a.memo.databinding.FragmentDashboardBinding;

import static com.a.memo.util.Util.setDialog;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initView();
        return root;
    }

    private void initView() {
        binding.but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.yjfk.getText().toString();
                if (s.equals("")) {
                    setDialog(requireActivity(), "意见反馈不能为空哦 否则反馈无效！\n请重新填写");
                } else {
                    setDialog(requireActivity(), "反馈成功 请在三天后查看您的邮箱^_^");
                    binding.yjfk.setText("");
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}