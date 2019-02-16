package com.example.viewcomponentsmodule;

import android.content.Context;
import android.widget.RelativeLayout;

import com.example.dataviewbinder.DataViewBinder;

import androidx.annotation.NonNull;

public class InvoiceHeaderItem extends RelativeLayout {

    public InvoiceHeaderItem(@NonNull Context context) {
        super(context);
        inflate(context, R.layout.header_welcome_screen, this);
    }
}
