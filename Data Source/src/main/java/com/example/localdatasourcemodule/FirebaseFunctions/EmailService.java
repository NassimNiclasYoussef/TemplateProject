package com.example.localdatasourcemodule.FirebaseFunctions;

import android.util.Log;

import com.google.firebase.functions.FirebaseFunctions;

import java.util.HashMap;

public class EmailService {

    private EmailService() {
    }

    public void sendEmail(String msg) {
        HashMap<String, String> data = new HashMap<>();
        data.put("msg", msg);
        FirebaseFunctions.getInstance()
                .getHttpsCallable("sendWelcomeEmail")
                .call(data)
                .continueWith(task -> {
                    Log.e("sendWelcomeEmail", task.getResult().getData().toString());
                    return (String) task.getResult().getData();
                });
    }

}
