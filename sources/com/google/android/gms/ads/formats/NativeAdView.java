package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;

/* loaded from: classes.dex */
public abstract class NativeAdView extends FrameLayout {
    private final FrameLayout zznV;
    private final zzcm zznW;

    public NativeAdView(Context context) {
        super(context);
        this.zznV = zzm(context);
        this.zznW = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zznV = zzm(context);
        this.zznW = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zznV = zzm(context);
        this.zznW = zzaI();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zznV = zzm(context);
        this.zznW = zzaI();
    }

    private zzcm zzaI() {
        zzu.zzb(this.zznV, "createDelegate must be called after mOverlayFrame has been created");
        return zzk.zzcE().zza(this.zznV.getContext(), this, this.zznV);
    }

    private FrameLayout zzm(Context context) {
        FrameLayout zzn = zzn(context);
        zzn.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(zzn);
        return zzn;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zznV);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.zznV != view) {
            super.bringChildToFront(this.zznV);
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zznV);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.zznV == view) {
            return;
        }
        super.removeView(view);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zznW.zzb((zzd) nativeAd.zzaH());
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setNativeAd on delegate", e);
        }
    }

    protected void zza(String str, View view) {
        try {
            this.zznW.zza(str, zze.zzw(view));
        } catch (RemoteException e) {
            zzb.zzb("Unable to call setAssetView on delegate", e);
        }
    }

    protected View zzm(String str) {
        try {
            zzd zzS = this.zznW.zzS(str);
            if (zzS != null) {
                return (View) zze.zzn(zzS);
            }
            return null;
        } catch (RemoteException e) {
            zzb.zzb("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    FrameLayout zzn(Context context) {
        return new FrameLayout(context);
    }
}
