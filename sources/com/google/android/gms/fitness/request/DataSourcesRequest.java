package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzmg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DataSourcesRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzh();
    private final int zzCY;
    private final String zzMZ;
    private final List<DataType> zzajQ;
    private final List<Integer> zzamf;
    private final boolean zzamg;
    private final zzmg zzamh;

    public static class Builder {
        private DataType[] zzami = new DataType[0];
        private int[] zzamj = {0, 1};
        private boolean zzamg = false;

        public DataSourcesRequest build() {
            com.google.android.gms.common.internal.zzu.zza(this.zzami.length > 0, "Must add at least one data type");
            com.google.android.gms.common.internal.zzu.zza(this.zzamj.length > 0, "Must add at least one data source type");
            return new DataSourcesRequest(this);
        }

        public Builder setDataSourceTypes(int... iArr) {
            this.zzamj = iArr;
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzami = dataTypeArr;
            return this;
        }
    }

    DataSourcesRequest(int i, List<DataType> list, List<Integer> list2, boolean z, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzajQ = list;
        this.zzamf = list2;
        this.zzamg = z;
        this.zzamh = iBinder == null ? null : zzmg.zza.zzbr(iBinder);
        this.zzMZ = str;
    }

    private DataSourcesRequest(Builder builder) {
        this(zzkx.zzb(builder.zzami), Arrays.asList(zzkx.zza(builder.zzamj)), builder.zzamg, null, null);
    }

    public DataSourcesRequest(DataSourcesRequest dataSourcesRequest, zzmg zzmgVar, String str) {
        this(dataSourcesRequest.zzajQ, dataSourcesRequest.zzamf, dataSourcesRequest.zzamg, zzmgVar, str);
    }

    public DataSourcesRequest(List<DataType> list, List<Integer> list2, boolean z, zzmg zzmgVar, String str) {
        this.zzCY = 3;
        this.zzajQ = list;
        this.zzamf = list2;
        this.zzamg = z;
        this.zzamh = zzmgVar;
        this.zzMZ = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzajQ);
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        zzt.zza zzg = com.google.android.gms.common.internal.zzt.zzt(this).zzg("dataTypes", this.zzajQ).zzg("sourceTypes", this.zzamf);
        if (this.zzamg) {
            zzg.zzg("includeDbOnlySources", "true");
        }
        return zzg.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzamh == null) {
            return null;
        }
        return this.zzamh.asBinder();
    }

    public List<Integer> zzrd() {
        return this.zzamf;
    }

    public boolean zzre() {
        return this.zzamg;
    }
}
