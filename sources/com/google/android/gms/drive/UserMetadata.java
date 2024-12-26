package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class UserMetadata implements SafeParcelable {
    public static final Parcelable.Creator<UserMetadata> CREATOR = new zzj();
    final int zzCY;
    final String zzadH;
    final String zzadI;
    final String zzadJ;
    final boolean zzadK;
    final String zzadL;

    UserMetadata(int i, String str, String str2, String str3, boolean z, String str4) {
        this.zzCY = i;
        this.zzadH = str;
        this.zzadI = str2;
        this.zzadJ = str3;
        this.zzadK = z;
        this.zzadL = str4;
    }

    public UserMetadata(String str, String str2, String str3, boolean z, String str4) {
        this(1, str, str2, str3, z, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", this.zzadH, this.zzadI, this.zzadJ, Boolean.valueOf(this.zzadK), this.zzadL);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
