package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DataSourcesResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zze();
    private final int zzCY;
    private final Status zzOt;
    private final List<DataSource> zzalP;

    DataSourcesResult(int i, List<DataSource> list, Status status) {
        this.zzCY = i;
        this.zzalP = Collections.unmodifiableList(list);
        this.zzOt = status;
    }

    public DataSourcesResult(List<DataSource> list, Status status) {
        this.zzCY = 3;
        this.zzalP = Collections.unmodifiableList(list);
        this.zzOt = status;
    }

    public static DataSourcesResult zzL(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzOt.equals(dataSourcesResult.zzOt) && zzt.equal(this.zzalP, dataSourcesResult.zzalP);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataSourcesResult) && zzb((DataSourcesResult) obj));
    }

    public List<DataSource> getDataSources() {
        return this.zzalP;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        ArrayList arrayList = new ArrayList();
        for (DataSource dataSource : this.zzalP) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzalP);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("dataSets", this.zzalP).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
