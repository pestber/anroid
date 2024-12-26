package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

/* loaded from: classes.dex */
public class DataSourceStatsResult implements SafeParcelable {
    public static final Parcelable.Creator<DataSourceStatsResult> CREATOR = new zzd();
    final int zzCY;
    public final long zzOw;
    public final DataSource zzajG;
    public final boolean zzamS;
    public final long zzamT;
    public final long zzamU;

    DataSourceStatsResult(int i, DataSource dataSource, long j, boolean z, long j2, long j3) {
        this.zzCY = i;
        this.zzajG = dataSource;
        this.zzOw = j;
        this.zzamS = z;
        this.zzamT = j2;
        this.zzamU = j3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
