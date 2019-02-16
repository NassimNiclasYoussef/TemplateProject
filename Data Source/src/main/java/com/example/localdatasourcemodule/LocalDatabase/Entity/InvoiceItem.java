package com.example.localdatasourcemodule.LocalDatabase.Entity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class InvoiceItem extends RealmObject {
    @PrimaryKey int itemId;
    public int headerId;
    public int offered;
    public int offeredSubContractor;
    public int execution;
    public int returned;
    public String notes;
}
