package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zznx extends zznq<zznx> {
    private String zzLU;
    private String zzLV;
    private String zzaEw;
    private String zzaEx;

    public void setAppId(String str) {
        this.zzaEw = str;
    }

    public void setAppInstallerId(String str) {
        this.zzaEx = str;
    }

    public void setAppName(String str) {
        this.zzLU = str;
    }

    public void setAppVersion(String str) {
        this.zzLV = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.zzLU);
        hashMap.put("appVersion", this.zzLV);
        hashMap.put("appId", this.zzaEw);
        hashMap.put("appInstallerId", this.zzaEx);
        return zzy(hashMap);
    }

    @Override // com.google.android.gms.internal.zznq
    public void zza(zznx zznxVar) {
        if (!TextUtils.isEmpty(this.zzLU)) {
            zznxVar.setAppName(this.zzLU);
        }
        if (!TextUtils.isEmpty(this.zzLV)) {
            zznxVar.setAppVersion(this.zzLV);
        }
        if (!TextUtils.isEmpty(this.zzaEw)) {
            zznxVar.setAppId(this.zzaEw);
        }
        if (TextUtils.isEmpty(this.zzaEx)) {
            return;
        }
        zznxVar.setAppInstallerId(this.zzaEx);
    }

    public String zzjL() {
        return this.zzLU;
    }

    public String zzjN() {
        return this.zzLV;
    }

    public String zzsK() {
        return this.zzaEw;
    }

    public String zzwi() {
        return this.zzaEx;
    }
}
