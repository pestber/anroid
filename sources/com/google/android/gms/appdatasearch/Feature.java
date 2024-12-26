package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class Feature implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int id;
    final int zzCY;
    final Bundle zzNi;

    Feature(int i, int i2, Bundle bundle) {
        this.zzCY = i;
        this.id = i2;
        this.zzNi = bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
