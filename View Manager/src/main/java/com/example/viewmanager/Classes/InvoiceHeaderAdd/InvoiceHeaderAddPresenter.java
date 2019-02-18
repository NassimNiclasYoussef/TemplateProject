package com.example.viewmanager.Classes.InvoiceHeaderAdd;

import com.example.localdatasourcemodule.DataService;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;
import com.example.viewmanager.Managers.ViewControllerManager;

import static com.example.viewmanager.Managers.ViewConstants.INVOICE_ITEM_ADD;

public class InvoiceHeaderAddPresenter {
    private InvoiceHeaderAddPresenter() {

    }

    public void insertHeaderToLocalDatabase(InvoiceHeader invoiceHeader) {

        DataService.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .setCurrentHeaderCVC(invoiceHeader.toString());

        DataService.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .getInvoiceHeaderService()
                .insertInvoiceHeader(invoiceHeader);

        ViewControllerManager.getInstance().goTo(INVOICE_ITEM_ADD);
    }
}
