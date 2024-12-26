package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public class PartialDriveId implements SafeParcelable {
    public static final Parcelable.Creator<PartialDriveId> CREATOR = new zzm();
    final int zzCY;
    final String zzadd;
    final long zzade;
    final int zzadf;

    PartialDriveId(int i, String str, long j, int i2) {
        this.zzCY = i;
        this.zzadd = str;
        this.zzade = j;
        this.zzadf = i2;
    }

    public PartialDriveId(String str, long j, int i) {
        this(1, str, j, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }

    public DriveId zzD(long j) {
        return new DriveId(this.zzadd, this.zzade, j, this.zzadf);
    }
}
