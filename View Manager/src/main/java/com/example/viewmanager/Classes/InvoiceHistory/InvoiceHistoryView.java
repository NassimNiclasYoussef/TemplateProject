package com.example.viewmanager.Classes.InvoiceHistory;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lifecyclemanagermodule.LifeCycleManager;
import com.example.viewcomponentsmodule.InvoiceHeaderItem;
import com.example.viewmanager.Classes.InvoiceItemAdd.InvoiceItemAddView;
import com.example.viewmanager.Managers.ViewConstants;
import com.example.viewmanager.Managers.ViewNavigatorManager;
import com.example.viewmanager.R;

import static com.example.viewmanager.Managers.ViewConstants.*;

public class InvoiceHistoryView extends RelativeLayout implements View.OnClickListener {
    protected LinearLayout slidingContainer;
    protected TextView indicator;
    private InvoiceHistoryPresenter invoiceHeaderPresenter;
    private boolean isSet = false;

    public InvoiceHistoryView(Context context) {
        super(context);
        inflate(context, R.layout.invoice_history, this);
        slidingContainer = findViewById(R.id.SLIDING_CONTENT);
        indicator = findViewById(R.id.INDICATOR);
        findViewById(R.id.ADD_HEADER).setOnClickListener(this);
        invoiceHeaderPresenter = new InvoiceHistoryPresenter();

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        invoiceHeaderPresenter.setHeadersItem(this);
        LifeCycleManager.getInstance().setLifeCycleInterface(null);
    }

    @Override
    public void onClick(View v) {
        ViewNavigatorManager.getInstance().goTo(INVOICE_HEADER_ADD);
    }
}
