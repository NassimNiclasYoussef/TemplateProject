package com.example.viewmanager.Classes.InvoiceItemAdd;

import android.content.Context;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceItem;
import com.example.viewmanager.Classes.InvoiceHeaderAdd.InvoiceHeaderAdd;
import com.example.viewmanager.Managers.ViewControllerManager;
import com.example.viewmanager.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InvoiceItemAddView extends RelativeLayout implements InvoiceAddDialog,
        InvoiceHeaderAdd,
        BottomNavigationView.OnNavigationItemSelectedListener {

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
    }

    @Override
    public void onBackPressed() {
        ViewControllerManager.getInstance().goBack();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add)
            new ItemAddDialogBox(getContext()).setInvoiceAddDialog(this);
        else
            ViewControllerManager.getInstance()
                    .getPresenterLocator()
                    .getInvoiceItemAddPresenter().sendEmail(getContext());
        return false;
    }

    @Override
    public void onAddButtonClicked(InvoiceItem invoiceItem) {
        ViewControllerManager.getInstance()
                .getPresenterLocator()
                .getInvoiceItemAddPresenter()
                .insertItemInDatabase(invoiceItem);
    }
}
