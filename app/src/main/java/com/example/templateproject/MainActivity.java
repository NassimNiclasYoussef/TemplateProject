package com.example.templateproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lifecyclemanagermodule.LifeCycleAnnotationNames;
import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.localdatasourcemodule.DataSource;
import com.example.viewmanager.Managers.ViewManager;

import java.lang.reflect.InvocationTargetException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataSource.getInstance().initDatabaseLocator(this);
        new ViewManager(findViewById(R.id.ROOT));
    }

    @Override
    public void onBackPressed() {
        try {
            boolean isDefault = LifeCycleManager.getInstance().invoke(LifeCycleAnnotationNames.ON_BACK_PRESSED);
            if (isDefault)
                super.onBackPressed();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}


