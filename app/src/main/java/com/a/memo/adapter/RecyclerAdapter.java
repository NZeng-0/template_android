package com.a.memo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a.memo.R;
import com.a.memo.bean.NoteData;
import com.a.memo.ui.particulars.PartluclarsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author P7000P
 * @version 1.0
 * @description: TODO
 * @date 2023/12/8 18:04
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ViewHd> {

    List<NoteData> list = new ArrayList<>();
    Context context;

    public RecyclerAdapter(List<NoteData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHd onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHd(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHd holder, int position) {
        holder.mTextView1.setText(list.get(position).getTitle());
        holder.mTextView2.setText(list.get(position).getText());
        holder.mTextView3.setText(list.get(position).getTime());
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, PartluclarsActivity.class)
                        .putExtra("id", list.get(position).get_id())
                        .putExtra("title", list.get(position).getTitle())
                        .putExtra("text", list.get(position).getText())
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
