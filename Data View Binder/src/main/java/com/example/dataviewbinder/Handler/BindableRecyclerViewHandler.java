package com.example.dataviewbinder.Handler;

import android.view.View;

import com.example.dataviewbinder.DataView.BindableRecyclerView;

import java.util.List;

@SuppressWarnings("unchecked")
public class BindableRecyclerViewHandler implements Handler {
    private static final BindableRecyclerViewHandler ourInstance = new BindableRecyclerViewHandler();

    public static BindableRecyclerViewHandler getInstance() {
        return ourInstance;
    }

    private BindableRecyclerViewHandler() {
    }


    @Override
    public void Handle(View view, Object data) throws NoSuchFieldException, IllegalAccessException {
        BindableRecyclerView bindableRecyclerView = (BindableRecyclerView) view;
        List<Object> list;
        if (data instanceof List) {
            list = (List) data;
        } else
            list = (List) data.getClass()
                    .getDeclaredField(bindableRecyclerView.field_name)
                    .get(data);
        bindableRecyclerView.Construct(list);
    }
}
