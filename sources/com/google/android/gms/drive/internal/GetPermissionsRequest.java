package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class GetPermissionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetPermissionsRequest> CREATOR = new zzai();
    final int zzCY;
    final DriveId zzacT;

    GetPermissionsRequest(int i, DriveId driveId) {
        this.zzCY = i;
        this.zzacT = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzai.zza(this, parcel, i);
    }
}
