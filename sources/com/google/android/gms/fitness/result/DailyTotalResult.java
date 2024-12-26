package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataSet;

/* loaded from: classes.dex */
public class DailyTotalResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
    private final int zzCY;
    private final Status zzOt;
    private final DataSet zzakO;

    DailyTotalResult(int i, Status status, DataSet dataSet) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzakO = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.zzCY = 1;
        this.zzOt = status;
        this.zzakO = dataSet;
    }

    public static DailyTotalResult zzK(Status status) {
        return new DailyTotalResult(null, status);
    }

    private boolean zzb(DailyTotalResult dailyTotalResult) {
        return this.zzOt.equals(dailyTotalResult.zzOt) && zzt.equal(this.zzakO, dailyTotalResult.zzakO);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DailyTotalResult) && zzb((DailyTotalResult) obj));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    public DataSet getTotal() {
        return this.zzakO;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzakO);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("dataPoint", this.zzakO).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
