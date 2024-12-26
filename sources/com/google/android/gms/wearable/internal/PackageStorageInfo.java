package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class PackageStorageInfo implements SafeParcelable {
    public static final Parcelable.Creator<PackageStorageInfo> CREATOR = new zzba();
    public final String label;
    public final String packageName;
    public final int versionCode;
    public final long zzaUN;

    PackageStorageInfo(int i, String str, String str2, long j) {
        this.versionCode = i;
        this.packageName = str;
        this.label = str2;
        this.zzaUN = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzba.zza(this, parcel, i);
    }
}
