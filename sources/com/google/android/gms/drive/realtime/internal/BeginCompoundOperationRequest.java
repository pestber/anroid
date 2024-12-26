package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new zza();
    final String mName;
    final int zzCY;
    final boolean zzaiq;
    final boolean zzair;

    BeginCompoundOperationRequest(int i, boolean z, String str, boolean z2) {
        this.zzCY = i;
        this.zzaiq = z;
        this.mName = str;
        this.zzair = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
