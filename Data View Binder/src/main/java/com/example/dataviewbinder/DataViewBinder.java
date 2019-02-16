package com.example.dataviewbinder;

import android.view.View;
import android.view.ViewGroup;

import com.example.dataviewbinder.Handler.BindableRecyclerViewHandler;
import com.example.dataviewbinder.Handler.BindableTextViewHandler;
import com.example.dataviewbinder.Handler.Handler;

/**
 * @author Nassim-Niclas Youssef
 */

public class DataViewBinder {
    private static final DataViewBinder ourInstance = new DataViewBinder();

    public static DataViewBinder getInstance() {
        return ourInstance;
    }


    private DataViewBinder() {

    }

    /**
     * <table border="1" >
     * <tr >
     * <th>param</th>
     * <th>description</th>
     * </tr>
     * <tr>
     * <th>viewGroup</th>
     * <th color="red">used to specify where to search for bindables</th>
     * </tr>
     * <tr>
     * <th>data</th>
     * <th color="green">represent a pojo class that its field will be mapped to
     * the corresponding Bindable View</th>
     * </tr>
     * </table>
     */
    public void Bind(ViewGroup viewGroup, Object data) throws Exception {
        Handler handler;
        for (int i = 0; i < viewGroup.getChildCount(); i += 1) {
            View view = viewGroup.getChildAt(i);
            if ((handler = getHandler(view.getClass().getSimpleName())) != null) {
                handler.Handle(view, data);
            } else if (view instanceof ViewGroup) {
                Bind((ViewGroup) view, data);
            }
        }
    }

    /**
     * <table border="1" >
     * <tr >
     * <th>param</th>
     * <th>description</th>
     * </tr>
     * <tr>
     * <th>viewGroup</th>
     * <th color="red">used to specify where to search for bindables</th>
     * </tr>
     * <tr>
     * <th>data</th>
     * <th color="green">represent a pojo class that its field will be mapped to
     * the corresponding Bindable View</th>
     * </tr>
     * <tr>
     * <th>limit</th>
     * <th color="orange">Limit the search for bindables to only the
     * number specified by limit</th>
     * </tr>
     * </table>
     */
    public void Bind(ViewGroup viewGroup, Object data, int limit) throws Exception {
        Handler handler;
        for (int i = 0; i < limit; i += 1) {
            View view = viewGroup.getChildAt(i);
            if ((handler = getHandler(view.getClass().getSimpleName())) != null) {
                handler.Handle(view, data);
            }
        }
    }

    private Handler getHandler(String className) {

        switch (className) {
            case DataViewClassName.BindableTextView:
                return BindableTextViewHandler.getInstance();
            case DataViewClassName.BindableRecyclerView:
                return BindableRecyclerViewHandler.getInstance();
            default:
                return null;
        }
    }

}
