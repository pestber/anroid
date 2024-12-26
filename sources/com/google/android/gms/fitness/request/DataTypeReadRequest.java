package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmh;

/* loaded from: classes.dex */
public class DataTypeReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataTypeReadRequest> CREATOR = new zzj();
    private final String mName;
    private final int zzCY;
    private final String zzMZ;
    private final zzmh zzamk;

    DataTypeReadRequest(int i, String str, IBinder iBinder, String str2) {
        this.zzCY = i;
        this.mName = str;
        this.zzamk = iBinder == null ? null : zzmh.zza.zzbs(iBinder);
        this.zzMZ = str2;
    }

    public DataTypeReadRequest(String str, zzmh zzmhVar, String str2) {
        this.zzCY = 2;
        this.mName = str;
        this.zzamk = zzmhVar;
        this.zzMZ = str2;
    }

    private boolean zzb(DataTypeReadRequest dataTypeReadRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.mName, dataTypeReadRequest.mName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest) obj));
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.mName);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("name", this.mName).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzamk.asBinder();
    }
}
