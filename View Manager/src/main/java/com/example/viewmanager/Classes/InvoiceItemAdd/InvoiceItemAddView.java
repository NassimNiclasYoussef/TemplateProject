package com.example.viewmanager.Classes.InvoiceItemAdd;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceItem;
import com.example.viewmanager.Classes.InvoiceHeaderAdd.InvoiceHeaderAdd;
import com.example.viewmanager.Managers.ViewNavigatorManager;
import com.example.viewmanager.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InvoiceItemAddView extends RelativeLayout implements InvoiceAddDialog,
        InvoiceHeaderAdd,
        BottomNavigationView.OnNavigationItemSelectedListener {
    InvoiceItemAddPresenter invoiceItemAddPresenter;

    public InvoiceItemAddView(Context context) {
        super(context);
        inflate(context, R.layout.invoice_item_add, this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.item);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifeCycleManager.getInstance().setLifeCycleInterface(this);
        invoiceItemAddPresenter = new InvoiceItemAddPresenter();
    }

    @Override
    public void onBackPressed() {
        ViewNavigatorManager.getInstance().goBack();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add)
            new ItemAddDialogBox(getContext()).setInvoiceAddDialog(this);
        else
            invoiceItemAddPresenter.sendEmail();
        return false;
    }

    @Override
    public void onAddButtonClicked(InvoiceItem invoiceItem) {
        invoiceItemAddPresenter.insertItemInDatabase(invoiceItem);
    }
}
