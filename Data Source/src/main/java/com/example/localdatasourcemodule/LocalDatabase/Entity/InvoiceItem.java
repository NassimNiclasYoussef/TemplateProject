package com.example.localdatasourcemodule.LocalDatabase.Entity;

import com.example.utilitiesmodule.ViewTag;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InvoiceItem extends RealmObject {
    @PrimaryKey
    int itemId;

    public String material;

    @ViewTag("offered")
    public String offered;

    @ViewTag("offeredSubContractor")
    public String offeredSubContractor;

    @ViewTag("execution")
    public String execution;

    @ViewTag("returned")
    public String returned;

    @ViewTag("notes")
    public String notes;
}
