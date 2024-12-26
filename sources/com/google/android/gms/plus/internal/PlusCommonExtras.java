package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int zzCY;
    private String zzaHr;
    private String zzaHs;

    public PlusCommonExtras() {
        this.zzCY = 1;
        this.zzaHr = "";
        this.zzaHs = "";
    }

    PlusCommonExtras(int i, String str, String str2) {
        this.zzCY = i;
        this.zzaHr = str;
        this.zzaHs = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.zzCY == plusCommonExtras.zzCY && zzt.equal(this.zzaHr, plusCommonExtras.zzaHr) && zzt.equal(this.zzaHs, plusCommonExtras.zzaHs);
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzCY), this.zzaHr, this.zzaHs);
    }

    public String toString() {
        return zzt.zzt(this).zzg("versionCode", Integer.valueOf(this.zzCY)).zzg("Gpsrc", this.zzaHr).zzg("ClientCallingPackage", this.zzaHs).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzxv() {
        return this.zzaHr;
    }

    public String zzxw() {
        return this.zzaHs;
    }

    public void zzy(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", com.google.android.gms.common.internal.safeparcel.zzc.zza(this));
    }
}
