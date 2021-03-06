package com.example.utilitiesmodule;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ViewUtility {

    public static <T> void View2ToData(View view, T output) {
        Field[] fields = output.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(ViewTag.class) != null) {
                try {
                    TextView textView = view.findViewWithTag(field.getAnnotation(ViewTag.class).value());
                    if (!field.isAccessible())
                        field.setAccessible(true);
                    field.set(output, textView.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T> void Data2View(View view, T output) {
        Field[] fields = output.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(ViewTag.class) != null) {
                try {
                    TextView textView = view.findViewWithTag(field.getAnnotation(ViewTag.class).value());
                    if (!field.isAccessible())
                        field.setAccessible(true);
                    textView.setText((CharSequence) field.get(output));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
