package com.example.localdatasourcemodule.LocalDatabase.Entity;

import com.example.utilitiesmodule.ViewTag;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InvoiceHeader extends RealmObject {
    @PrimaryKey
    public int headerId;

    public boolean isRevision;

    @ViewTag("a4")
    public String a4;

    @ViewTag("bc8")
    public String bc8j0;

    @ViewTag("wo")
    public String wo;

    @ViewTag("customer")
    public String customerName;

    @ViewTag("address")
    public String address;

    @ViewTag("division")
    public String Division;

    @ViewTag("contractor")
    public String Contractor;

    public RealmList<InvoiceItem> invoiceItems;

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s;%s;", a4, bc8j0, wo, customerName, address, Division, Contractor);
    }

}
