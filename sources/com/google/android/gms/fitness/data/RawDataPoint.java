package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class RawDataPoint implements SafeParcelable {
    public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzn();
    final int zzCY;
    public final long zzajV;
    public final long zzajW;
    public final Value[] zzajX;
    public final long zzajZ;
    public final int zzakH;
    public final int zzakI;
    public final long zzaka;

    public RawDataPoint(int i, long j, long j2, Value[] valueArr, int i2, int i3, long j3, long j4) {
        this.zzCY = i;
        this.zzajV = j;
        this.zzajW = j2;
        this.zzakH = i2;
        this.zzakI = i3;
        this.zzajZ = j3;
        this.zzaka = j4;
        this.zzajX = valueArr;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> list) {
        this.zzCY = 4;
        this.zzajV = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzajW = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzajX = dataPoint.zzqu();
        this.zzakH = zzs.zza(dataPoint.getDataSource(), list);
        this.zzakI = zzs.zza(dataPoint.getOriginalDataSource(), list);
        this.zzajZ = dataPoint.zzqv();
        this.zzaka = dataPoint.zzqw();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzajV == rawDataPoint.zzajV && this.zzajW == rawDataPoint.zzajW && Arrays.equals(this.zzajX, rawDataPoint.zzajX) && this.zzakH == rawDataPoint.zzakH && this.zzakI == rawDataPoint.zzakI && this.zzajZ == rawDataPoint.zzajZ;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataPoint) && zza((RawDataPoint) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Long.valueOf(this.zzajV), Long.valueOf(this.zzajW));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", Arrays.toString(this.zzajX), Long.valueOf(this.zzajW), Long.valueOf(this.zzajV), Integer.valueOf(this.zzakH), Integer.valueOf(this.zzakI));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }
}
