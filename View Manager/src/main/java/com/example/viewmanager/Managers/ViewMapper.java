package com.example.viewmanager.Managers;

import android.content.Context;
import android.view.View;

import com.example.viewmanager.Classes.InvoiceHistory.InvoiceHistoryView;
import com.example.viewmanager.Classes.InvoiceHeaderAdd.InvoiceHeaderAddView;
import com.example.viewmanager.Classes.InvoiceItemAdd.InvoiceItemAddView;

class ViewMapper {
    private Context context;
    private InvoiceHistoryView invoiceHistoryView;
    private InvoiceHeaderAddView invoiceHeaderAddView;
    InvoiceItemAddView invoiceItemAddView;

    ViewMapper(Context context) {
        this.context = context;
        invoiceHistoryView = new InvoiceHistoryView(context);
        invoiceHeaderAddView = new InvoiceHeaderAddView(context);
    }

    View getViewByIndex(int index) {
        switch (index) {
            case 0:
                return invoiceHistoryView;
            case 1:
                return invoiceHeaderAddView;
            default:
                return new InvoiceItemAddView(context);
        }
    }
}
