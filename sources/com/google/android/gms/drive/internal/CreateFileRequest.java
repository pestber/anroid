package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class CreateFileRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFileRequest> CREATOR = new zzl();
    final int zzCY;
    final String zzadn;
    final MetadataBundle zzaeA;
    final Integer zzaeB;
    final DriveId zzaeC;
    final int zzaeD;
    final int zzaeE;
    final boolean zzaen;
    final Contents zzaes;

    CreateFileRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, Integer num, boolean z, String str, int i2, int i3) {
        if (contents != null && i3 != 0) {
            com.google.android.gms.common.internal.zzu.zzb(contents.getRequestId() == i3, "inconsistent contents reference");
        }
        if ((num == null || num.intValue() == 0) && contents == null && i3 == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzCY = i;
        this.zzaeC = (DriveId) com.google.android.gms.common.internal.zzu.zzu(driveId);
        this.zzaeA = (MetadataBundle) com.google.android.gms.common.internal.zzu.zzu(metadataBundle);
        this.zzaes = contents;
        this.zzaeB = num;
        this.zzadn = str;
        this.zzaeD = i2;
        this.zzaen = z;
        this.zzaeE = i3;
    }

    public CreateFileRequest(DriveId driveId, MetadataBundle metadataBundle, int i, int i2, ExecutionOptions executionOptions) {
        this(2, driveId, metadataBundle, null, Integer.valueOf(i2), executionOptions.zzpj(), executionOptions.zzpi(), executionOptions.zzpk(), i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }
}
