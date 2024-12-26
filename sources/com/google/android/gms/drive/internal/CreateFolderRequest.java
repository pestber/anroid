package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class CreateFolderRequest implements SafeParcelable {
    public static final Parcelable.Creator<CreateFolderRequest> CREATOR = new zzm();
    final int zzCY;
    final MetadataBundle zzaeA;
    final DriveId zzaeC;

    CreateFolderRequest(int i, DriveId driveId, MetadataBundle metadataBundle) {
        this.zzCY = i;
        this.zzaeC = (DriveId) com.google.android.gms.common.internal.zzu.zzu(driveId);
        this.zzaeA = (MetadataBundle) com.google.android.gms.common.internal.zzu.zzu(metadataBundle);
    }

    public CreateFolderRequest(DriveId driveId, MetadataBundle metadataBundle) {
        this(1, driveId, metadataBundle);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
