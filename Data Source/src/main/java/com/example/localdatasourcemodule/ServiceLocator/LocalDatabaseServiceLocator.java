package com.example.localdatasourcemodule.ServiceLocator;

import com.example.localdatasourcemodule.LocalDatabase.Services.InvoiceHeaderService;
import com.example.localdatasourcemodule.LocalDatabase.Services.InvoiceItemService;
import com.example.localdatasourcemodule.Service;

import java.lang.annotation.Documented;

public class LocalDatabaseServiceLocator {

    @Service
    private InvoiceHeaderService invoiceHeaderService;

    @Service
    private InvoiceItemService invoiceItemService;

    private int currentHeaderId;

    private String currentHeaderCVC;

    /**
     * Invoice Header Entity query services
     *
     * @return invoiceHeaderService
     */
    public InvoiceHeaderService getInvoiceHeaderService() {
        return invoiceHeaderService;
    }

    /**
     * Invoice Item Entity query services
     *
     * @return invoiceItemService
     */
    public InvoiceItemService getInvoiceItemService() {
        return invoiceItemService;
    }


    /**
     * @return currentHeaderId
     */
    public int getCurrentHeaderId() {
        return currentHeaderId;
    }

    /**
     * @param currentHeaderId current header id to be set with the item messages
     */
    public void setCurrentHeaderId(int currentHeaderId) {
        this.currentHeaderId = currentHeaderId;
    }

    /**
     * @return currentHeaderCVC
     */
    public String getCurrentHeaderCVC() {
        return currentHeaderCVC;
    }

    /**
     * @param currentHeaderCVC current header cvc to be set with the item messages
     */
    public void setCurrentHeaderCVC(String currentHeaderCVC) {
        this.currentHeaderCVC = currentHeaderCVC;
    }
}
