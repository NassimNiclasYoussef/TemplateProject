package com.example.localdatasourcemodule.FirebaseFunctions;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;

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
                .continueWith(new Continuation<HttpsCallableResult, String>() {
                    @Override
                    public String then(@NonNull Task<HttpsCallableResult> task) throws Exception {
                        Log.e("sendWelcomeEmail", task.getResult().getData().toString());
                        return (String) task.getResult().getData();
                    }
                });
    }

}
