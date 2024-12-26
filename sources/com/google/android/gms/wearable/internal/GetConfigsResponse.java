package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

/* loaded from: classes.dex */
public class GetConfigsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConfigsResponse> CREATOR = new zzal();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration[] zzaUv;

    GetConfigsResponse(int i, int i2, ConnectionConfiguration[] connectionConfigurationArr) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUv = connectionConfigurationArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzal.zza(this, parcel, i);
    }
}
