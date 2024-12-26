package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

/* loaded from: classes.dex */
public class AddPermissionRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new zzb();
    final int zzCY;
    final DriveId zzacT;
    final String zzadn;
    final Permission zzaek;
    final boolean zzael;
    final String zzaem;
    final boolean zzaen;

    AddPermissionRequest(int i, DriveId driveId, Permission permission, boolean z, String str, boolean z2, String str2) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzaek = permission;
        this.zzael = z;
        this.zzaem = str;
        this.zzaen = z2;
        this.zzadn = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
