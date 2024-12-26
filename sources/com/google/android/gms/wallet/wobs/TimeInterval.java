package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class TimeInterval implements SafeParcelable {
    public static final Parcelable.Creator<TimeInterval> CREATOR = new zzg();
    private final int zzCY;
    long zzaSH;
    long zzaSI;

    TimeInterval() {
        this.zzCY = 1;
    }

    TimeInterval(int i, long j, long j2) {
        this.zzCY = i;
        this.zzaSH = j;
        this.zzaSI = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
