package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class StorageInfoResponse implements SafeParcelable {
    public static final Parcelable.Creator<StorageInfoResponse> CREATOR = new zzbh();
    public final int statusCode;
    public final int versionCode;
    public final long zzaUN;
    public final List<PackageStorageInfo> zzaUP;

    StorageInfoResponse(int i, int i2, long j, List<PackageStorageInfo> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUN = j;
        this.zzaUP = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbh.zza(this, parcel, i);
    }
}
