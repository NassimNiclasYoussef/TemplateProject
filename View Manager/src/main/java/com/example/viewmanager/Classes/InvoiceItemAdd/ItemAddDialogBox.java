package com.example.viewmanager.Classes.InvoiceItemAdd;

import android.app.Dialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.example.viewmanager.R;

 class ItemAddDialogBox extends Dialog {
    Spinner spinner;
    ArrayAdapter<String> dataAdapter;

      ItemAddDialogBox(@NonNull Context context) {
        super(context);
        setContentView(R.layout.invoice_item_add_dialog);
        spinner = findViewById(R.id.spinner);

    }
}
