package com.example.localdatasourcemodule.LocalDatabase.Services;

import com.example.localdatasourcemodule.LocalDatabase.Entity.InvoiceHeader;

import java.util.AbstractList;

import io.realm.Realm;

@SuppressWarnings("ALL")
public class InvoiceHeaderService {
    private int currentIndex;

    private InvoiceHeaderService() {
    }

    public AbstractList<InvoiceHeader> getAllInvoiceHeader() {
        AbstractList<InvoiceHeader> invoiceHeaders = Realm.getDefaultInstance().where(InvoiceHeader.class).findAll();
        currentIndex = invoiceHeaders.size();
        return invoiceHeaders;
    }

    public void insertInvoiceHeader(InvoiceHeader invoiceHeader) {
        currentIndex += 1;
        invoiceHeader.headerId = currentIndex;
        Realm.getDefaultInstance().beginTransaction();
        Realm.getDefaultInstance().insert(invoiceHeader);
        Realm.getDefaultInstance().commitTransaction();
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
}
