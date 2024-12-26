package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzh();
    private final int zzCY;
    private final Status zzOt;
    private final LocationSettingsStates zzayf;

    LocationSettingsResult(int i, Status status, LocationSettingsStates locationSettingsStates) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzayf = locationSettingsStates;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzayf;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
