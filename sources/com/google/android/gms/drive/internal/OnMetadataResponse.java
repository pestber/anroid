package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public class OnMetadataResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new zzbd();
    final int zzCY;
    final MetadataBundle zzaeA;

    OnMetadataResponse(int i, MetadataBundle metadataBundle) {
        this.zzCY = i;
        this.zzaeA = metadataBundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }

    public MetadataBundle zzpS() {
        return this.zzaeA;
    }
}
