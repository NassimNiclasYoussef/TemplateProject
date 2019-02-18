package com.example.viewmanager.Classes.InvoiceHistory;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.viewmanager.Managers.ViewControllerManager;
import com.example.viewmanager.R;

import static com.example.viewmanager.Managers.ViewConstants.*;

public class InvoiceHistoryView extends RelativeLayout implements View.OnClickListener {
    protected LinearLayout slidingContainer;
    protected TextView indicator;

    public InvoiceHistoryView(Context context) {
        super(context);
        inflate(context, R.layout.invoice_history, this);
        slidingContainer = findViewById(R.id.SLIDING_CONTENT);
        indicator = findViewById(R.id.INDICATOR);
        findViewById(R.id.ADD_HEADER).setOnClickListener(this);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifeCycleManager.getInstance()
                .setLifeCycleInterface(null);
        ViewControllerManager.getInstance()
                .getPresenterLocator()
                .getInvoiceHistoryPresenter()
                .setHeadersItem(InvoiceHistoryView.this);
    }

    @Override
    public void onClick(View v) {
        ViewControllerManager.getInstance().goTo(INVOICE_HEADER_ADD);
    }
}
