package com.example.dataviewbinder.Handler;

import android.view.View;

import com.example.dataviewbinder.DataView.BindableTextView;

public class BindableTextViewHandler implements Handler {
    private static final BindableTextViewHandler ourInstance = new BindableTextViewHandler();

    public static BindableTextViewHandler getInstance() {
        return ourInstance;
    }

    private BindableTextViewHandler() {
    }

    @Override
    public void Handle(View view, Object data) throws NoSuchFieldException, IllegalAccessException {
        BindableTextView txt = (BindableTextView) view;
        String value;
        if (data instanceof String)
            value = (String) data;
        else
            value = (String) data.getClass().getDeclaredField(txt.field_name).get(data);
        txt.setText(value);
    }
}
