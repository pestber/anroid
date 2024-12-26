package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class SyncInfoResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SyncInfoResult> CREATOR = new zzl();
    private final int zzCY;
    private final Status zzOt;
    private final long zzVp;

    SyncInfoResult(int i, Status status, long j) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzVp = j;
    }

    private boolean zzb(SyncInfoResult syncInfoResult) {
        return this.zzOt.equals(syncInfoResult.zzOt) && zzt.equal(Long.valueOf(this.zzVp), Long.valueOf(syncInfoResult.zzVp));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SyncInfoResult) && zzb((SyncInfoResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, Long.valueOf(this.zzVp));
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("timestamp", Long.valueOf(this.zzVp)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public long zzrz() {
        return this.zzVp;
    }
}
