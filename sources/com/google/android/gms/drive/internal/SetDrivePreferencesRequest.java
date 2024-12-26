package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

/* loaded from: classes.dex */
public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetDrivePreferencesRequest> CREATOR = new zzbn();
    final int zzCY;
    final DrivePreferences zzagi;

    SetDrivePreferencesRequest(int i, DrivePreferences drivePreferences) {
        this.zzCY = i;
        this.zzagi = drivePreferences;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbn.zza(this, parcel, i);
    }
}
