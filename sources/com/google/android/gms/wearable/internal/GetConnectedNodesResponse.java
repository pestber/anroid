package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public class GetConnectedNodesResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetConnectedNodesResponse> CREATOR = new zzam();
    public final int statusCode;
    public final int versionCode;
    public final List<NodeParcelable> zzaUw;

    GetConnectedNodesResponse(int i, int i2, List<NodeParcelable> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.zzaUw = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzam.zza(this, parcel, i);
    }
}
