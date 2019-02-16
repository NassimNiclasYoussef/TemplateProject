package com.example.dataviewbinder.DataView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import com.example.dataviewbinder.R;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class BindableTextView extends android.widget.TextView {
    public String field_name;

    public BindableTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        field_name = getContext()
                .obtainStyledAttributes(attrs, R.styleable.BindableTextView)
                .getString(R.styleable.BindableTextView_field_name);
    }

}
