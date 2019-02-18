package com.example.viewmanager.Classes.InvoiceHeaderAdd;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;

import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;
import com.example.utilitiesmodule.ViewUtility;
import com.example.viewmanager.Managers.ViewControllerManager;
import com.example.viewmanager.R;

public class InvoiceHeaderAddView extends ScrollView implements InvoiceHeaderAdd, View.OnClickListener {

    public InvoiceHeaderAddView(Context context) {
        super(context);
        inflate(context, R.layout.invoice_header_add, this);
        findViewById(R.id.next).setOnClickListener(this);
        findViewById(R.id.discard).setOnClickListener(this);
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
    public void onClick(View v) {
        if (v.getId() == R.id.next) {
            InvoiceHeader invoiceHeader = new InvoiceHeader();
            if (!ViewUtility.getEmptyFields(this, invoiceHeader)) {
                ViewUtility.View2ToData(this, invoiceHeader);
                ViewControllerManager.getInstance()
                        .getPresenterLocator()
                        .getInvoiceHeaderAddPresenter()
                        .insertHeaderToLocalDatabase(invoiceHeader);
            }
        } else
            ViewControllerManager.getInstance().goBack();
    }
}
