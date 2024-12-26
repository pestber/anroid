package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgd
/* loaded from: classes.dex */
public class zzij extends zzie {
    public zzij(zzid zzidVar, boolean z) {
        super(zzidVar, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (!(webView instanceof zzid)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, str);
            }
            zzid zzidVar = (zzid) webView;
            zzidVar.zzgF().zzet();
            String str2 = zzidVar.zzaN().zzsn ? zzbz.zztX.get() : zzidVar.zzgJ() ? zzbz.zztW.get() : zzbz.zztV.get();
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("shouldInterceptRequest(" + str2 + ")");
            return zzd(zzidVar.getContext(), this.zzoA.zzgI().zzGG, str2);
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, str);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzo.zzbv().zzf(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = new zzho(context).zzb(str2, hashMap).get(60L, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
