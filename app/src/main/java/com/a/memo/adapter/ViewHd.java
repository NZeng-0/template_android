package com.a.memo.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.a.memo.R;

import org.jetbrains.annotations.NotNull;

/**
 * @author P7000P
 * @version 1.0
 * @description: TODO
 * @date 2023/12/8 18:05
 */
public class ViewHd extends RecyclerView.ViewHolder {
    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    View item;

    public ViewHd(@NonNull @NotNull View itemView) {
        super(itemView);
        this.mTextView1 = itemView.findViewById(R.id.itext1);
        this.mTextView2 = itemView.findViewById(R.id.itext2);
        this.mTextView3 = itemView.findViewById(R.id.itext3);
        this.item = itemView;
    }

}
