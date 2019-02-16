package com.example.dataviewbinder.DataView;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dataviewbinder.DataViewBinder;
import com.example.dataviewbinder.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BindableRecyclerView extends RecyclerView {
    public String field_name;
    private int item_resource;
    private List<Object> data;

    public BindableRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        field_name = getContext()
                .obtainStyledAttributes(attrs, R.styleable.BindableRecyclerView)
                .getString(R.styleable.BindableRecyclerView_list_name);
        item_resource = getContext()
                .obtainStyledAttributes(attrs, R.styleable.BindableRecyclerView)
                .getResourceId(R.styleable.BindableRecyclerView_item_layout, 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(VERTICAL);
        linearLayoutManager.setMeasurementCacheEnabled(false);
        linearLayoutManager.setItemPrefetchEnabled(true);
        this.setLayoutManager(linearLayoutManager);
        this.setItemAnimator(null);
        this.setAnimation(null);

    }

    public void Construct(List<Object> data) {
        this.data = data;
        this.setAdapter(new Adapter());
    }

    class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(item_resource, parent, false);
            return new Holder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            try {
                DataViewBinder.getInstance().Bind((ViewGroup) holder.view, data.get(position));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class Holder extends RecyclerView.ViewHolder {
            View view;

            Holder(@NonNull View itemView) {
                super(itemView);
                view = itemView;
            }
        }
    }

}
