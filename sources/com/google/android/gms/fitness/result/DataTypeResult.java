package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataType;

/* loaded from: classes.dex */
public class DataTypeResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataTypeResult> CREATOR = new zzg();
    private final int zzCY;
    private final Status zzOt;
    private final DataType zzajF;

    DataTypeResult(int i, Status status, DataType dataType) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzajF = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.zzCY = 2;
        this.zzOt = status;
        this.zzajF = dataType;
    }

    public static DataTypeResult zzM(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzOt.equals(dataTypeResult.zzOt) && zzt.equal(this.zzajF, dataTypeResult.zzajF);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataTypeResult) && zzb((DataTypeResult) obj));
    }

    public DataType getDataType() {
        return this.zzajF;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzajF);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("dataType", this.zzajF).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
