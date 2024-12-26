package com.android.grafobank;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: classes5.dex */
public class MyWebViewClient extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
