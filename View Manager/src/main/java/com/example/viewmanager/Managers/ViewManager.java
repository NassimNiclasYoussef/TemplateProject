package com.example.viewmanager.Managers;

import android.view.ViewGroup;

public final class ViewManager extends ViewMapper implements ViewNavigator {
    private ViewGroup container;

    public ViewManager(ViewGroup container) {
        super(container.getContext());
        this.container = container;
        this.container.removeAllViews();
        ViewControllerManager.getInstance().setNavigator(this);
        ViewControllerManager.getInstance().initPresenterLocator();
        container.addView(getViewByIndex(0));
    }

    @Override
    public void Switch(int index) {
        container.removeViewAt(0);
        container.addView(getViewByIndex(index));
    }
}
