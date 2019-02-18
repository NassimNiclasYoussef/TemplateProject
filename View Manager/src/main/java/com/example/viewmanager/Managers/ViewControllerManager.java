package com.example.viewmanager.Managers;

import android.util.Log;

import com.example.localdatasourcemodule.Service;
import com.example.localdatasourcemodule.ServiceLocator.LocalDatabaseServiceLocator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ViewControllerManager {
    private static final ViewControllerManager ourInstance = new ViewControllerManager();

    public static ViewControllerManager getInstance() {
        return ourInstance;
    }

    private ViewNavigator navigator;
    private ArrayList<Integer> viewsHistory = new ArrayList<>(10);
    private PresenterLocator presenterLocator;

    private ViewControllerManager() {
        viewsHistory.add(0);
    }

    void setNavigator(ViewNavigator navigator) {
        this.navigator = navigator;
    }

    void initPresenterLocator() {
        presenterLocator = new PresenterLocator();
        Class databaseServiceLocatorClass = PresenterLocator.class;
        Field[] fields = databaseServiceLocatorClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Presenter.class)) {
                try {
                    if (field.getModifiers() != Modifier.PRIVATE)
                        throw new IllegalAccessException("Field should be Private");
                    field.setAccessible(true);
                    Constructor fieldConstructor = field.getType().getDeclaredConstructor();
                    if (fieldConstructor.getModifiers() != Modifier.PRIVATE)
                        throw new IllegalAccessException("Constructor should be Private");
                    fieldConstructor.setAccessible(true);
                    Object serviceInstance = fieldConstructor.newInstance();
                    field.set(presenterLocator, serviceInstance);
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

    public PresenterLocator getPresenterLocator() {
        return presenterLocator;
    }

    public void goTo(int index) {
        viewsHistory.add(index);
        navigator.Switch(index); 
    }

    public void goBack() {
        if (viewsHistory.size() > 1) {
            navigator.Switch(viewsHistory.get(viewsHistory.size() - 2));
            viewsHistory.remove(viewsHistory.size() - 1);
        }
    }
}