package com.example.viewmanager.Classes.InvoiceHistory;

import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;
import com.example.localdatasourcemodule.DataService;
import com.example.viewcomponentsmodule.InvoiceHeaderItem;

import org.apache.commons.collections4.CollectionUtils;

import java.util.AbstractList;

import static android.view.View.GONE;

public class InvoiceHistoryPresenter {
    AbstractList<InvoiceHeader> headers;

    private InvoiceHistoryPresenter() {
    }

    public void setHeadersItem(InvoiceHistoryView invoiceHistoryView) {
        headers = DataService.getInstance()
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
