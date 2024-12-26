package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class DataInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataInsertRequest> CREATOR = new zze();
    private final int zzCY;
    private final String zzMZ;
    private final DataSet zzakO;
    private final zzmu zzalN;
    private final boolean zzalT;

    DataInsertRequest(int i, DataSet dataSet, IBinder iBinder, String str, boolean z) {
        this.zzCY = i;
        this.zzakO = dataSet;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
        this.zzalT = z;
    }

    public DataInsertRequest(DataSet dataSet, zzmu zzmuVar, String str, boolean z) {
        this.zzCY = 3;
        this.zzakO = dataSet;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
        this.zzalT = z;
    }

    private boolean zzb(DataInsertRequest dataInsertRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzakO, dataInsertRequest.zzakO);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof DataInsertRequest) && zzb((DataInsertRequest) obj));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzakO);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("dataSet", this.zzakO).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public DataSet zzqK() {
        return this.zzakO;
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }

    public boolean zzqY() {
        return this.zzalT;
    }
}
