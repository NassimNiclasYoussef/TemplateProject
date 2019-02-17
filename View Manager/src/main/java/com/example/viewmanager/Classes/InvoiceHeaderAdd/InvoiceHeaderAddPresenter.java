package com.example.viewmanager.Classes.InvoiceHeaderAdd;

import com.example.localdatasourcemodule.DataSource;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;
import com.example.viewmanager.Managers.ViewNavigatorManager;

import static com.example.viewmanager.Managers.ViewConstants.INVOICE_ITEM_ADD;

class InvoiceHeaderAddPresenter {

    void insertHeaderToLocalDatabase(InvoiceHeader invoiceHeader) {

        DataSource.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .setCurrentHeaderCVC(invoiceHeader.toString());

        DataSource.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .getInvoiceHeaderService()
                .insertInvoiceHeader(invoiceHeader);

        ViewNavigatorManager.getInstance().goTo(INVOICE_ITEM_ADD);
    }
}
