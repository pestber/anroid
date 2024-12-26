package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class FieldChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<FieldChangedDetails> CREATOR = new zza();
    final int zzCY;
    final int zzaiz;

    FieldChangedDetails(int i, int i2) {
        this.zzCY = i;
        this.zzaiz = i2;
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
