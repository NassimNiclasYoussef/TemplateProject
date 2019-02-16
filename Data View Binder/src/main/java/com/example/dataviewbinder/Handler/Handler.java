package com.example.dataviewbinder.Handler;

import android.view.View;

public interface Handler {
    public void Handle(View view, Object data) throws NoSuchFieldException, IllegalAccessException;
}
