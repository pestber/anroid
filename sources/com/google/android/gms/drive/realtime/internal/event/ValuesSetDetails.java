package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class ValuesSetDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new zzk();
    final int mIndex;
    final int zzCY;
    final int zzaiA;
    final int zzaiB;

    ValuesSetDetails(int i, int i2, int i3, int i4) {
        this.zzCY = i;
        this.mIndex = i2;
        this.zzaiA = i3;
        this.zzaiB = i4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
