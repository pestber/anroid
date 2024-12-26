package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class GetAllCapabilitiesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetAllCapabilitiesResponse> CREATOR = new zzae();
    public final int statusCode;
    public final int versionCode;
    final List<CapabilityInfoParcelable> zzaUq;

    GetAllCapabilitiesResponse(int i, int i2, List<CapabilityInfoParcelable> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUq = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }
}
