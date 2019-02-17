package com.example.localdatasourcemodule;

import android.content.Context;
import android.util.Log;

import com.example.localdatasourcemodule.ServiceLocator.FirebaseFunctionServiceLocator;
import com.example.localdatasourcemodule.ServiceLocator.LocalDatabaseServiceLocator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import io.realm.Realm;

public class DataService {
    private static final DataService ourInstance = new DataService();
    private LocalDatabaseServiceLocator localDatabaseServiceLocator;
    private FirebaseFunctionServiceLocator firebaseFunctionServiceLocator;

    private DataService() {

    }

    public static DataService getInstance() {
        return ourInstance;
    }

    public void initDatabaseLocator(Context context) {
        Realm.init(context);
        localDatabaseServiceLocator = new LocalDatabaseServiceLocator();
        Class databaseServiceLocatorClass = LocalDatabaseServiceLocator.class;
        Field[] fields = databaseServiceLocatorClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Service.class)) {
                try {
                    if (field.getModifiers() != Modifier.PRIVATE)
                        throw new IllegalAccessException("Field should be Private");
                    field.setAccessible(true);
                    Constructor fieldConstructor = field.getType().getDeclaredConstructor();
                    if (fieldConstructor.getModifiers() != Modifier.PRIVATE)
                        throw new IllegalAccessException("Constructor should be Private");
                    fieldConstructor.setAccessible(true);
                    Object serviceInstance = fieldConstructor.newInstance();
                    field.set(localDatabaseServiceLocator, serviceInstance);
                } catch (InvocationTargetException ignored) {
                } catch (NoSuchMethodException e) {
                    Log.e(field.getType().getName(), "No default constructor is detected.");
                } catch (IllegalAccessException e) {
                    Log.e(field.getType().getName(), e.getLocalizedMessage());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void initFirebaseFunctionLocator() {
        firebaseFunctionServiceLocator = new FirebaseFunctionServiceLocator();
        Class databaseServiceLocatorClass = FirebaseFunctionServiceLocator.class;
        Field[] fields = databaseServiceLocatorClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Service.class)) {
                try {
                    if (field.getModifiers() != Modifier.PRIVATE)
                        throw new IllegalAccessException("Field should be Private");
                    field.setAccessible(true);
                    Constructor fieldConstructor = field.getType().getDeclaredConstructor();
                    if (fieldConstructor.getModifiers() != Modifier.PRIVATE)
                        throw new IllegalAccessException("Constructor should be Private");
                    fieldConstructor.setAccessible(true);
                    Object serviceInstance = fieldConstructor.newInstance();
                    field.set(firebaseFunctionServiceLocator, serviceInstance);
                } catch (InvocationTargetException ignored) {
                } catch (NoSuchMethodException e) {
                    Log.e(field.getType().getName(), "No default constructor is detected.");
                } catch (IllegalAccessException e) {
                    Log.e(field.getType().getName(), e.getLocalizedMessage());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public LocalDatabaseServiceLocator getDatabaseLocalDatabaseServiceLocator() {
        return localDatabaseServiceLocator;
    }

    public FirebaseFunctionServiceLocator getFirebaseFunctionServiceLocator() {
        return firebaseFunctionServiceLocator;
    }
}