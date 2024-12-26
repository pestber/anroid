package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class StringParcel implements SafeParcelable {
    public static final Parcelable.Creator<StringParcel> CREATOR = new zzm();
    final int zzCY;
    String zzuU;

    StringParcel(int i, String str) {
        this.zzCY = i;
        this.zzuU = str;
    }

    public StringParcel(String str) {
        this.zzCY = 1;
        this.zzuU = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public String zzfB() {
        return this.zzuU;
    }
}
