package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.net.URISyntaxException;

@zzgd
/* loaded from: classes.dex */
public class zzil extends WebViewClient {
    private final String zzHE;
    private boolean zzHF = false;
    private final zzfq zzHG;
    private final zzid zzoA;

    public zzil(zzfq zzfqVar, zzid zzidVar, String str) {
        this.zzHE = zzaH(str);
        this.zzoA = zzidVar;
        this.zzHG = zzfqVar;
    }

    private String zzaH(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.endsWith("/")) {
                return str.substring(0, str.length() - 1);
            }
        } catch (IndexOutOfBoundsException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz(e.getMessage());
        }
        return str;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("JavascriptAdWebViewClient::onLoadResource: " + str);
        if (zzaG(str)) {
            return;
        }
        this.zzoA.zzgF().onLoadResource(this.zzoA.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("JavascriptAdWebViewClient::onPageFinished: " + str);
        if (this.zzHF) {
            return;
        }
        this.zzHG.zzfj();
        this.zzHF = true;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + str);
        if (!zzaG(str)) {
            return this.zzoA.zzgF().shouldOverrideUrlLoading(this.zzoA.getWebView(), str);
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzay("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzaG(String str) {
        URI uri;
        String zzaH = zzaH(str);
        if (TextUtils.isEmpty(zzaH)) {
            return false;
        }
        try {
            uri = new URI(zzaH);
        } catch (URISyntaxException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz(e.getMessage());
        }
        if ("passback".equals(uri.getScheme())) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Passback received");
            this.zzHG.zzfk();
            return true;
        }
        if (!TextUtils.isEmpty(this.zzHE)) {
            URI uri2 = new URI(this.zzHE);
            String host = uri2.getHost();
            String host2 = uri.getHost();
            String path = uri2.getPath();
            String path2 = uri.getPath();
            if (com.google.android.gms.common.internal.zzt.equal(host, host2) && com.google.android.gms.common.internal.zzt.equal(path, path2)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzay("Passback received");
                this.zzHG.zzfk();
                return true;
            }
        }
        return false;
    }
}
