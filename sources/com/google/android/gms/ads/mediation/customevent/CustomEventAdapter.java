package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* loaded from: classes.dex */
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    CustomEventBanner zzHH;
    CustomEventInterstitial zzHI;
    private View zzaV;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzHJ;
        private final MediationBannerListener zzaO;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzHJ = customEventAdapter;
            this.zzaO = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClicked.");
            this.zzaO.onAdClicked(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClosed.");
            this.zzaO.onAdClosed(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdFailedToLoad.");
            this.zzaO.onAdFailedToLoad(this.zzHJ, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdLeftApplication.");
            this.zzaO.onAdLeftApplication(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public void onAdLoaded(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdLoaded.");
            this.zzHJ.zza(view);
            this.zzaO.onAdLoaded(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdOpened.");
            this.zzaO.onAdOpened(this.zzHJ);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzHJ;
        private final MediationInterstitialListener zzaP;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzHJ = customEventAdapter;
            this.zzaP = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClicked.");
            this.zzaP.onAdClicked(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdClosed.");
            this.zzaP.onAdClosed(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onFailedToReceiveAd.");
            this.zzaP.onAdFailedToLoad(this.zzHJ, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdLeftApplication.");
            this.zzaP.onAdLeftApplication(this.zzHJ);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public void onAdLoaded() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onReceivedAd.");
            this.zzaP.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Custom event adapter called onAdOpened.");
            this.zzaP.onAdOpened(this.zzHJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(View view) {
        this.zzaV = view;
    }

    private static <T> T zzj(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzaV;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        if (this.zzHH != null) {
            this.zzHH.onDestroy();
        }
        if (this.zzHI != null) {
            this.zzHI.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        if (this.zzHH != null) {
            this.zzHH.onPause();
        }
        if (this.zzHI != null) {
            this.zzHI.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        if (this.zzHH != null) {
            this.zzHH.onResume();
        }
        if (this.zzHI != null) {
            this.zzHI.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzHH = (CustomEventBanner) zzj(bundle.getString("class_name"));
        if (this.zzHH == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzHH.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString("parameter"), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzHI = (CustomEventInterstitial) zzj(bundle.getString("class_name"));
        if (this.zzHI == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzHI.requestInterstitialAd(context, zza(mediationInterstitialListener), bundle.getString("parameter"), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzHI.showInterstitial();
    }

    zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
