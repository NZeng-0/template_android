package com.a.memo.ui.home;

import android.content.Intent;
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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.a.memo.R;
import com.a.memo.SActivity;
import com.a.memo.adapter.RecyclerAdapter;
import com.a.memo.bean.NoteData;
import com.a.memo.database.NoteDao;
import com.a.memo.databinding.FragmentHomeBinding;
import com.a.memo.ui.add.AddActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initView();
        return root;
    }

    private void initView() {
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), AddActivity.class));
            }
        });

        binding.s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(requireActivity(), SActivity.class));
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<NoteData> getList() {
        List<NoteData> list = new ArrayList<>();
        List<NoteData> all = new NoteDao(requireActivity()).getAll();
        return all;
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.rv.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.rv.setAdapter(new RecyclerAdapter(getList(), requireActivity()));
    }
}