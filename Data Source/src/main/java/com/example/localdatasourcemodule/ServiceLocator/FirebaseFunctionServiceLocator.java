package com.example.localdatasourcemodule.ServiceLocator;

import com.example.localdatasourcemodule.FirebaseFunction.EmailSender;
import com.example.localdatasourcemodule.LocalDatabase.Services.InvoiceHeaderService;
import com.example.localdatasourcemodule.LocalDatabase.Services.InvoiceItemService;
import com.example.localdatasourcemodule.Service;

public class FirebaseFunctionServiceLocator {

    @Service
    private EmailSender emailSender;

    public EmailSender getEmailSender() {
        return emailSender;
    }
}
