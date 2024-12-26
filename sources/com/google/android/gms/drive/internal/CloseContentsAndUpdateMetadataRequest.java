package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzg();
    final int zzCY;
    final String zzadn;
    final boolean zzado;
    final DriveId zzaeq;
    final MetadataBundle zzaer;
    final Contents zzaes;
    final int zzaet;
    final int zzaeu;
    final boolean zzaev;

    CloseContentsAndUpdateMetadataRequest(int i, DriveId driveId, MetadataBundle metadataBundle, Contents contents, boolean z, String str, int i2, int i3, boolean z2) {
        this.zzCY = i;
        this.zzaeq = driveId;
        this.zzaer = metadataBundle;
        this.zzaes = contents;
        this.zzado = z;
        this.zzadn = str;
        this.zzaet = i2;
        this.zzaeu = i3;
        this.zzaev = z2;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId driveId, MetadataBundle metadataBundle, int i, boolean z, ExecutionOptions executionOptions) {
        this(1, driveId, metadataBundle, null, executionOptions.zzpj(), executionOptions.zzpi(), executionOptions.zzpk(), i, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
