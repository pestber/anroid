package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ReferenceShiftedDetails> CREATOR = new zze();
    final int zzCY;
    final String zzaiT;
    final String zzaiU;
    final int zzaiV;
    final int zzaiW;

    ReferenceShiftedDetails(int i, String str, String str2, int i2, int i3) {
        this.zzCY = i;
        this.zzaiT = str;
        this.zzaiU = str2;
        this.zzaiV = i2;
        this.zzaiW = i3;
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
