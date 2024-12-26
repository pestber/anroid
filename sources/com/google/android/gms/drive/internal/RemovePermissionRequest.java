package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class RemovePermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemovePermissionRequest> CREATOR = new zzbm();
    final int zzCY;
    final DriveId zzacT;
    final String zzadn;
    final String zzadz;
    final boolean zzaen;

    RemovePermissionRequest(int i, DriveId driveId, String str, boolean z, String str2) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzadz = str;
        this.zzaen = z;
        this.zzadn = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbm.zza(this, parcel, i);
    }
}
