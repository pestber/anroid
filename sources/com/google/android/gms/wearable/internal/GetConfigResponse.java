package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
/* loaded from: classes.dex */
public class GetConfigResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConfigResponse> CREATOR = new zzak();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration zzaUu;

    GetConfigResponse(int i, int i2, ConnectionConfiguration connectionConfiguration) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUu = connectionConfiguration;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }
}
