package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new zzbl();
    final int zzCY;
    final DriveId zzacT;
    final int zzaca;

    RemoveEventListenerRequest(int i, DriveId driveId, int i2) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzaca = i2;
    }

    public RemoveEventListenerRequest(DriveId driveId, int i) {
        this(1, driveId, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbl.zza(this, parcel, i);
    }
}
