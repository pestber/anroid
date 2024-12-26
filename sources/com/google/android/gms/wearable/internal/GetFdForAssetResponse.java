package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetFdForAssetResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetFdForAssetResponse> CREATOR = new zzao();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzaUy;

    GetFdForAssetResponse(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUy = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzao.zza(this, parcel, i | 1);
    }
}
