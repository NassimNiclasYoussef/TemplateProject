package com.example.viewmanager.Classes.InvoiceHistory;

import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;
import com.example.localdatasourcemodule.DataSource;
import com.example.viewcomponentsmodule.InvoiceHeaderItem;

import org.apache.commons.collections4.CollectionUtils;

import java.util.AbstractList;

import static android.view.View.GONE;

class InvoiceHistoryPresenter {
    AbstractList<InvoiceHeader> headers;

    void setHeadersItem(InvoiceHistoryView invoiceHistoryView) {
        headers = DataSource.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .getInvoiceHeaderService()
                .getAllInvoiceHeader();
        if (CollectionUtils.isNotEmpty(headers)) {
            invoiceHistoryView.indicator.setVisibility(GONE);
            for (InvoiceHeader invoiceHeader : headers) {
                invoiceHistoryView.slidingContainer.addView(new InvoiceHeaderItem(invoiceHistoryView.getContext()));
            }
        }

    }
}
