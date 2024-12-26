package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

/* loaded from: classes.dex */
public final class InterstitialAd {
    private final zzz zznQ;

    public InterstitialAd(Context context) {
        this.zznQ = new zzz(context);
    }

    public AdListener getAdListener() {
        return this.zznQ.getAdListener();
    }

    public String getAdUnitId() {
        return this.zznQ.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zznQ.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zznQ.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.zznQ.isLoaded();
    }

    public void loadAd(AdRequest adRequest) {
        this.zznQ.zza(adRequest.zzaF());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        zzz zzzVar;
        com.google.android.gms.ads.internal.client.zza zzaVar;
        this.zznQ.setAdListener(adListener);
        if (adListener != 0 && (adListener instanceof com.google.android.gms.ads.internal.client.zza)) {
            zzzVar = this.zznQ;
            zzaVar = (com.google.android.gms.ads.internal.client.zza) adListener;
        } else {
            if (adListener != 0) {
                return;
            }
            zzzVar = this.zznQ;
            zzaVar = null;
        }
        zzzVar.zza(zzaVar);
    }

    public void setAdUnitId(String str) {
        this.zznQ.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zznQ.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zznQ.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }

    public void show() {
        this.zznQ.show();
    }
}
