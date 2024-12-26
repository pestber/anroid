package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzme;

/* loaded from: classes.dex */
public class DailyTotalRequest implements SafeParcelable {
    public static final Parcelable.Creator<DailyTotalRequest> CREATOR = new zzc();
    private final int zzCY;
    private final String zzMZ;
    private final DataType zzajF;
    private final zzme zzalO;

    DailyTotalRequest(int i, IBinder iBinder, DataType dataType, String str) {
        this.zzCY = i;
        this.zzalO = zzme.zza.zzbp(iBinder);
        this.zzajF = dataType;
        this.zzMZ = str;
    }

    public DailyTotalRequest(zzme zzmeVar, DataType dataType, String str) {
        this.zzCY = 1;
        this.zzalO = zzmeVar;
        this.zzajF = dataType;
        this.zzMZ = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.zzajF;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", this.zzajF.zzqD());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzalO.asBinder();
    }
}
