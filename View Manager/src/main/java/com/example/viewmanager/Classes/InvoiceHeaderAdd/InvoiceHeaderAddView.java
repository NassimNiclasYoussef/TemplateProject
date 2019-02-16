package com.example.viewmanager.Classes.InvoiceHeaderAdd;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.viewmanager.Managers.ViewNavigatorManager;
import com.example.viewmanager.R;

import static com.example.viewmanager.Managers.ViewConstants.INVOICE_ITEM_ADD;

public class InvoiceHeaderAddView extends ScrollView implements InvoiceHeaderAdd, View.OnClickListener {
    InvoiceHeaderAddPresenter invoiceHeaderAddPresenter = new InvoiceHeaderAddPresenter();

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
        ViewNavigatorManager.getInstance().goBack();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next) {
            invoiceHeaderAddPresenter.insertHeaderToLocalDatabase(this);
            ViewNavigatorManager.getInstance().goTo(INVOICE_ITEM_ADD);
        } else
            ViewNavigatorManager.getInstance().goBack();
    }
}
