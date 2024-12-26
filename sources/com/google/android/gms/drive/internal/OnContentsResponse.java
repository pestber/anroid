package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

/* loaded from: classes.dex */
public class OnContentsResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnContentsResponse> CREATOR = new zzau();
    final int zzCY;
    final Contents zzafa;
    final boolean zzage;

    OnContentsResponse(int i, Contents contents, boolean z) {
        this.zzCY = i;
        this.zzafa = contents;
        this.zzage = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzau.zza(this, parcel, i);
    }

    public Contents zzpJ() {
        return this.zzafa;
    }

    public boolean zzpK() {
        return this.zzage;
    }
}
