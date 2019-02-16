package com.example.localdatasourcemodule.ServiceLocator;

import com.example.localdatasourcemodule.EmailService;
import com.example.localdatasourcemodule.Service;

public class FirebaseFunctionServiceLocator {
    @Service
    private EmailService emailService;

    public EmailService getEmailService() {
        return emailService;
    }
}
