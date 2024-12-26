package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class UntrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UntrashResourceRequest> CREATOR = new zzbt();
    final int zzCY;
    final DriveId zzaeq;

    UntrashResourceRequest(int i, DriveId driveId) {
        this.zzCY = i;
        this.zzaeq = driveId;
    }

    public UntrashResourceRequest(DriveId driveId) {
        this(1, driveId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbt.zza(this, parcel, i);
    }
}
