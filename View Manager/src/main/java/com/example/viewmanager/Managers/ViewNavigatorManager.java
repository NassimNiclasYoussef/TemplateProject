package com.example.viewmanager.Managers;

import android.util.Log;
import android.util.SparseArray;

import java.util.ArrayList;

public class ViewNavigatorManager {
    private static final ViewNavigatorManager ourInstance = new ViewNavigatorManager();

    public static ViewNavigatorManager getInstance() {
        return ourInstance;
    }

    private ViewNavigator navigator;
    private ArrayList<Integer> viewsHistory = new ArrayList<>(10);

    private ViewNavigatorManager() {
        viewsHistory.add(0);
    }

    void setNavigator(ViewNavigator navigator) {
        this.navigator = navigator;
    }

    public void goTo(int index) {
        viewsHistory.add(index);
        navigator.Switch(index);
        Log.e("size", "" + viewsHistory.size());
    }

    public void goBack() {
        if (viewsHistory.size() > 1) {
            navigator.Switch(viewsHistory.get(viewsHistory.size() - 2));
            viewsHistory.remove(viewsHistory.size() - 1);
        }
    }
}