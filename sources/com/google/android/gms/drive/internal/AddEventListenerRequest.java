package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

/* loaded from: classes.dex */
public class AddEventListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new zza();
    final int zzCY;
    final DriveId zzacT;
    final int zzaca;
    final ChangesAvailableOptions zzadO;

    AddEventListenerRequest(int i, DriveId driveId, int i2, ChangesAvailableOptions changesAvailableOptions) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzaca = i2;
        this.zzadO = changesAvailableOptions;
    }

    public AddEventListenerRequest(DriveId driveId, int i, ChangesAvailableOptions changesAvailableOptions) {
        this(1, driveId, i, changesAvailableOptions);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
