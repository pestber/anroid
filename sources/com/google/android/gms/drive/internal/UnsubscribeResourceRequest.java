package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class UnsubscribeResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeResourceRequest> CREATOR = new zzbs();
    final int zzCY;
    final DriveId zzaeq;

    UnsubscribeResourceRequest(int i, DriveId driveId) {
        this.zzCY = i;
        this.zzaeq = driveId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbs.zza(this, parcel, i);
    }
}
