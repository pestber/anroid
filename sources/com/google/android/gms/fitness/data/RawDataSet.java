package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* loaded from: classes.dex */
public final class RawDataSet implements SafeParcelable {
    public static final Parcelable.Creator<RawDataSet> CREATOR = new zzo();
    final int zzCY;
    public final boolean zzajU;
    public final int zzakH;
    public final int zzakJ;
    public final List<RawDataPoint> zzakK;

    public RawDataSet(int i, int i2, int i3, List<RawDataPoint> list, boolean z) {
        this.zzCY = i;
        this.zzakH = i2;
        this.zzakJ = i3;
        this.zzakK = list;
        this.zzajU = z;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> list, List<DataType> list2) {
        this.zzCY = 3;
        this.zzakK = dataSet.zzk(list);
        this.zzajU = dataSet.zzqr();
        this.zzakH = zzs.zza(dataSet.getDataSource(), list);
        this.zzakJ = zzs.zza(dataSet.getDataType(), list2);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzakH == rawDataSet.zzakH && this.zzajU == rawDataSet.zzajU && com.google.android.gms.common.internal.zzt.equal(this.zzakK, rawDataSet.zzakK);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof RawDataSet) && zza((RawDataSet) obj));
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Integer.valueOf(this.zzakH));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", Integer.valueOf(this.zzakH), this.zzakK);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }
}
