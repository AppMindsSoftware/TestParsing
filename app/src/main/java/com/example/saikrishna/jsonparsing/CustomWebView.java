package com.example.saikrishna.jsonparsing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.WebView;

public class CustomWebView extends WebView {

    public CustomWebView(Context context) {
        super(context);
        initView(context);
    }

    public CustomWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    private void initView(Context context){
        // i am not sure with these inflater lines
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // you should not use a new instance of MyWebView here
        // MyWebView view = (MyWebView) inflater.inflate(R.layout.custom_webview, this);
        this.getSettings().setJavaScriptEnabled(true) ;
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setDomStorageEnabled(true);

    }
}