package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    public final int versionCode;
    public final boolean zzoU;
    public final boolean zzoV;

    InterstitialAdParameterParcel(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.zzoU = z;
        this.zzoV = z2;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2) {
        this.versionCode = 1;
        this.zzoU = z;
        this.zzoV = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
