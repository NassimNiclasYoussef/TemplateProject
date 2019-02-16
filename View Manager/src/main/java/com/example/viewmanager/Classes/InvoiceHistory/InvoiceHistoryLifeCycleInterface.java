package com.example.viewmanager.Classes.InvoiceHistory;

import com.example.lifecyclemanagermodule.Annotations.onBackPressed;
import com.example.lifecyclemanagermodule.LifeCycleInterface;


public interface InvoiceHistoryLifeCycleInterface extends LifeCycleInterface {

    @onBackPressed
    public void onBackPressed();

}
