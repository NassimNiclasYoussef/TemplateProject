package com.example.viewmanager.Classes.InvoiceItemAdd;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.localdatasourcemodule.DataService;
import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceItem;

class InvoiceItemAddPresenter {
    private String cvc;

    void insertItemInDatabase(InvoiceItem invoiceItem) {
        cvc = DataService.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .getCurrentHeaderCVC()
                .concat(invoiceItem.toString());
        DataService.getInstance()
                .getDatabaseLocalDatabaseServiceLocator()
                .setCurrentHeaderCVC(cvc);
        Log.e("cvc", cvc);
    }

    void sendEmail(Context context) {
        Toast.makeText(context, "Sending", Toast.LENGTH_SHORT).show();
        DataService.getInstance()
                .getFirebaseFunctionServiceLocator()
                .getEmailService()
                .sendEmail(cvc);
    }
}
