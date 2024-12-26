package com.google.android.gms.internal;

import java.util.Map;

@zzgd
/* loaded from: classes.dex */
public class zzeq {
    private final zzid zzoA;
    private final boolean zzyJ;
    private final String zzyK;

    public zzeq(zzid zzidVar, Map<String, String> map) {
        this.zzoA = zzidVar;
        this.zzyK = map.get("forceOrientation");
        this.zzyJ = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean(map.get("allowOrientationChange")) : true;
    }

    public void execute() {
        if (this.zzoA == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("AdWebView is null");
        } else {
            this.zzoA.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzyK) ? com.google.android.gms.ads.internal.zzo.zzbx().zzgr() : "landscape".equalsIgnoreCase(this.zzyK) ? com.google.android.gms.ads.internal.zzo.zzbx().zzgq() : this.zzyJ ? -1 : com.google.android.gms.ads.internal.zzo.zzbx().zzgs());
        }
    }
}
