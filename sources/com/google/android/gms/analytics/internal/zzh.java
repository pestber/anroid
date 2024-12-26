package com.google.android.gms.analytics.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzh {
    private final long zzJS;
    private final String zzJT;
    private final boolean zzJU;
    private long zzJV;
    private final String zzJd;
    private final Map<String, String> zzyn;

    public zzh(long j, String str, String str2, boolean z, long j2, Map<String, String> map) {
        com.google.android.gms.common.internal.zzu.zzcj(str);
        com.google.android.gms.common.internal.zzu.zzcj(str2);
        this.zzJS = j;
        this.zzJd = str;
        this.zzJT = str2;
        this.zzJU = z;
        this.zzJV = j2;
        this.zzyn = map != null ? new HashMap<>(map) : Collections.emptyMap();
    }

    public String getClientId() {
        return this.zzJd;
    }

    public long zzii() {
        return this.zzJS;
    }

    public String zzij() {
        return this.zzJT;
    }

    public boolean zzik() {
        return this.zzJU;
    }

    public long zzil() {
        return this.zzJV;
    }

    public Map<String, String> zzn() {
        return this.zzyn;
    }

    public void zzn(long j) {
        this.zzJV = j;
    }
}
