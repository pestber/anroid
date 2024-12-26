package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ParcelableIndexReference implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new zzq();
    final int mIndex;
    final int zzCY;
    final String zzaiw;
    final boolean zzaix;
    final int zzaiy;

    ParcelableIndexReference(int i, String str, int i2, boolean z, int i3) {
        this.zzCY = i;
        this.zzaiw = str;
        this.mIndex = i2;
        this.zzaix = z;
        this.zzaiy = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
