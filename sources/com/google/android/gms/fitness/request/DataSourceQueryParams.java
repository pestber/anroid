package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public class DataSourceQueryParams implements SafeParcelable {
    public static final Parcelable.Creator<DataSourceQueryParams> CREATOR = new zzg();
    final int zzCY;
    public final long zzOw;
    public final DataSource zzajG;
    public final long zzajW;
    public final int zzalY;
    public final long zzamd;
    public final int zzame;

    DataSourceQueryParams(int i, DataSource dataSource, long j, long j2, long j3, int i2, int i3) {
        this.zzCY = i;
        this.zzajG = dataSource;
        this.zzOw = j;
        this.zzajW = j2;
        this.zzamd = j3;
        this.zzalY = i2;
        this.zzame = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
