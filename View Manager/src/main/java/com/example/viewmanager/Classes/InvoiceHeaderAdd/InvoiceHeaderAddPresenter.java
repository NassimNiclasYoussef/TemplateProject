package com.example.viewmanager.Classes.InvoiceHeaderAdd;

import android.view.View;

import com.example.localdatasourcemodule.DataSource;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;
import com.example.utilitiesmodule.ViewUtility;

class InvoiceHeaderAddPresenter {
    InvoiceHeaderAddPresenter() {
    }

    void insertHeaderToLocalDatabase(View v) {
        InvoiceHeader invoiceHeader = new InvoiceHeader();
        ViewUtility.View2ToData(v, invoiceHeader);
        
        DataSource.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .setCurrentHeaderCVC(invoiceHeader.toString());

        DataSource.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .getInvoiceHeaderService()
                .insertInvoiceHeader(invoiceHeader);

    }
}
