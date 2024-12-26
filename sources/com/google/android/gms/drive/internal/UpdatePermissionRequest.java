package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class UpdatePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new zzbv();
    final int zzCY;
    final DriveId zzacT;
    final String zzadn;
    final String zzadz;
    final boolean zzaen;
    final int zzagx;

    UpdatePermissionRequest(int i, DriveId driveId, String str, int i2, boolean z, String str2) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzadz = str;
        this.zzagx = i2;
        this.zzaen = z;
        this.zzadn = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbv.zza(this, parcel, i);
    }
}
