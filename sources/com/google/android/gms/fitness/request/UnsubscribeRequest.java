package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzae();
    private final int zzCY;
    private final String zzMZ;
    private final DataType zzajF;
    private final DataSource zzajG;
    private final zzmu zzalN;

    UnsubscribeRequest(int i, DataType dataType, DataSource dataSource, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzajF = dataType;
        this.zzajG = dataSource;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzmu zzmuVar, String str) {
        this.zzCY = 2;
        this.zzajF = dataType;
        this.zzajG = dataSource;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzajG, unsubscribeRequest.zzajG) && com.google.android.gms.common.internal.zzt.equal(this.zzajF, unsubscribeRequest.zzajF);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) obj));
    }

    public DataSource getDataSource() {
        return this.zzajG;
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

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzajG, this.zzajF);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }
}
