package com.example.viewmanager.Classes.InvoiceItemAdd;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;

import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceItem;
import com.example.utilitiesmodule.ViewUtility;
import com.example.viewmanager.R;

class ItemAddDialogBox extends Dialog implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    InvoiceAddDialog invoiceAddDialog;
    InvoiceItem invoiceItem = new InvoiceItem();

    ItemAddDialogBox(@NonNull Context context) {
        super(context);
        setContentView(R.layout.invoice_item_add_dialog);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        show();

    }

    public void setInvoiceAddDialog(InvoiceAddDialog invoiceAddDialog) {
        this.invoiceAddDialog = invoiceAddDialog;
    }

    @Override
    public void onClick(View v) {
        if (!ViewUtility.getEmptyFields(findViewById(R.id.root), invoiceItem)) {
            ViewUtility.View2ToData(findViewById(R.id.root), invoiceItem);
            invoiceAddDialog.onAddButtonClicked(invoiceItem);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
