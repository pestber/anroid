package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public final class zzi extends zzt.zza {
    private final AppEventListener zzsq;

    public zzi(AppEventListener appEventListener) {
        this.zzsq = appEventListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzt
    public void onAppEvent(String str, String str2) {
        this.zzsq.onAppEvent(str, str2);
    }
}
