package com.example.viewmanager.Managers;

import com.example.viewmanager.Classes.InvoiceHeaderAdd.InvoiceHeaderAddPresenter;
import com.example.viewmanager.Classes.InvoiceHistory.InvoiceHistoryPresenter;
import com.example.viewmanager.Classes.InvoiceItemAdd.InvoiceItemAddPresenter;

public class PresenterLocator {

    @Presenter
    private InvoiceItemAddPresenter invoiceItemAddPresenter;

    @Presenter
    private InvoiceHistoryPresenter invoiceHistoryPresenter;

    @Presenter
    private InvoiceHeaderAddPresenter invoiceHeaderAddPresenter;

    public InvoiceItemAddPresenter getInvoiceItemAddPresenter() {
        return invoiceItemAddPresenter;
    }

    public InvoiceHistoryPresenter getInvoiceHistoryPresenter() {
        return invoiceHistoryPresenter;
    }

    public InvoiceHeaderAddPresenter getInvoiceHeaderAddPresenter() {
        return invoiceHeaderAddPresenter;
    }
}
