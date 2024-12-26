package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class DrivePreferences implements SafeParcelable {
    public static final Parcelable.Creator<DrivePreferences> CREATOR = new zze();
    final int zzCY;
    final boolean zzadh;

    DrivePreferences(int i, boolean z) {
        this.zzCY = i;
        this.zzadh = z;
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
