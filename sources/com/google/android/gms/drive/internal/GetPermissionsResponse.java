package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

/* loaded from: classes.dex */
public class GetPermissionsResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionsResponse> CREATOR = new zzaj();
    final int zzCY;
    final List<Permission> zzafO;
    final int zzws;

    GetPermissionsResponse(int i, List<Permission> list, int i2) {
        this.zzCY = i;
        this.zzafO = list;
        this.zzws = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaj.zza(this, parcel, i);
    }
}
