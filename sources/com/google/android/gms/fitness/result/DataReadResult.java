package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DataReadResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
    private final int zzCY;
    private final Status zzOt;
    private final List<DataSet> zzajS;
    private final List<DataSource> zzakc;
    private final List<Bucket> zzamP;
    private int zzamQ;
    private final List<DataType> zzamR;

    DataReadResult(int i, List<RawDataSet> list, Status status, List<RawBucket> list2, int i2, List<DataSource> list3, List<DataType> list4) {
        this.zzCY = i;
        this.zzOt = status;
        this.zzamQ = i2;
        this.zzakc = list3;
        this.zzamR = list4;
        this.zzajS = new ArrayList(list.size());
        Iterator<RawDataSet> it = list.iterator();
        while (it.hasNext()) {
            this.zzajS.add(new DataSet(it.next(), list3));
        }
        this.zzamP = new ArrayList(list2.size());
        Iterator<RawBucket> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zzamP.add(new Bucket(it2.next(), list3));
        }
    }

    public DataReadResult(List<DataSet> list, List<Bucket> list2, Status status) {
        this.zzCY = 5;
        this.zzajS = list;
        this.zzOt = status;
        this.zzamP = list2;
        this.zzamQ = 1;
        this.zzakc = new ArrayList();
        this.zzamR = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        ArrayList arrayList = new ArrayList();
        Iterator<DataSource> it = dataReadRequest.getDataSources().iterator();
        while (it.hasNext()) {
            arrayList.add(DataSet.create(it.next()));
        }
        Iterator<DataType> it2 = dataReadRequest.getDataTypes().iterator();
        while (it2.hasNext()) {
            arrayList.add(DataSet.create(new DataSource.Builder().setDataType(it2.next()).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                Iterator<DataSet> it = bucket.getDataSets().iterator();
                while (it.hasNext()) {
                    zza(it.next(), bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzamP.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzOt.equals(dataReadResult.zzOt) && zzt.equal(this.zzajS, dataReadResult.zzajS) && zzt.equal(this.zzamP, dataReadResult.zzamP);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadResult) && zzc((DataReadResult) obj));
    }

    public List<Bucket> getBuckets() {
        return this.zzamP;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzajS) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", dataSource.getStreamIdentifier()));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzajS) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", dataType.getName()));
    }

    public List<DataSet> getDataSets() {
        return this.zzajS;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzajS, this.zzamP);
    }

    public String toString() {
        return zzt.zzt(this).zzg("status", this.zzOt).zzg("dataSets", this.zzajS.size() > 5 ? this.zzajS.size() + " data sets" : this.zzajS).zzg("buckets", this.zzamP.size() > 5 ? this.zzamP.size() + " buckets" : this.zzamP).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public void zzb(DataReadResult dataReadResult) {
        Iterator<DataSet> it = dataReadResult.getDataSets().iterator();
        while (it.hasNext()) {
            zza(it.next(), this.zzajS);
        }
        Iterator<Bucket> it2 = dataReadResult.getBuckets().iterator();
        while (it2.hasNext()) {
            zza(it2.next(), this.zzamP);
        }
    }

    List<DataSource> zzqA() {
        return this.zzakc;
    }

    public int zzrt() {
        return this.zzamQ;
    }

    List<RawBucket> zzru() {
        ArrayList arrayList = new ArrayList(this.zzamP.size());
        Iterator<Bucket> it = this.zzamP.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawBucket(it.next(), this.zzakc, this.zzamR));
        }
        return arrayList;
    }

    List<RawDataSet> zzrv() {
        ArrayList arrayList = new ArrayList(this.zzajS.size());
        Iterator<DataSet> it = this.zzajS.iterator();
        while (it.hasNext()) {
            arrayList.add(new RawDataSet(it.next(), this.zzakc, this.zzamR));
        }
        return arrayList;
    }

    List<DataType> zzrw() {
        return this.zzamR;
    }
}
