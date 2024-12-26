package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

/* loaded from: classes.dex */
public class CloseContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new zzh();
    final int zzCY;
    final Contents zzaes;
    final int zzaeu;
    final Boolean zzaew;

    CloseContentsRequest(int i, Contents contents, Boolean bool, int i2) {
        this.zzCY = i;
        this.zzaes = contents;
        this.zzaew = bool;
        this.zzaeu = i2;
    }

    public CloseContentsRequest(int i, boolean z) {
        this(1, null, Boolean.valueOf(z), i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
