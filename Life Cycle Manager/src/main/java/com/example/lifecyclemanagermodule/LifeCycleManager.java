package com.example.lifecyclemanagermodule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

public class LifeCycleManager<T extends LifeCycleInterface> {
    private static final LifeCycleManager ourInstance = new LifeCycleManager();
    private static final String MAIN_INTERFACE_NAME = "LifeCycleInterface";
    private HashMap<String, Method> methods = new HashMap<>(0);
    private LifeCycleInterface lifeCycle;

    public static LifeCycleManager getInstance() {
        return ourInstance;
    }

    private LifeCycleManager() {
    }

    public void setLifeCycleInterface(LifeCycleInterface target) {
        this.methods.clear();
        if (target == null)
            return;
        this.lifeCycle = target;
        Class interface_ = null;
        for (Class class_ : target.getClass().getInterfaces()) {
            if (class_.getInterfaces().length > 0 && class_.getInterfaces()[0].getSimpleName().equals(MAIN_INTERFACE_NAME))
                interface_ = class_;
        }
        Method[] methods = interface_.getDeclaredMethods();
        for (Method method : methods) {
            this.methods.put(method.getDeclaredAnnotations()[0].toString(), method);
        }
    }

    public boolean invoke(String lifeCycleKey) throws InvocationTargetException, IllegalAccessException {
        if (methods.get(lifeCycleKey) != null) {
            methods.get(lifeCycleKey).invoke(lifeCycle);
            return false;
        } else
            return true;
    }
}