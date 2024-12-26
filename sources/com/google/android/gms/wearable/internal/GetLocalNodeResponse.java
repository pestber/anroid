package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class GetLocalNodeResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetLocalNodeResponse> CREATOR = new zzap();
    public final int statusCode;
    public final int versionCode;
    public final NodeParcelable zzaUz;

    GetLocalNodeResponse(int i, int i2, NodeParcelable nodeParcelable) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUz = nodeParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzap.zza(this, parcel, i);
    }
}
