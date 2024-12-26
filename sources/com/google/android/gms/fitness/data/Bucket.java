package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class Bucket implements SafeParcelable {
    public static final Parcelable.Creator<Bucket> CREATOR = new zzc();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int zzCY;
    private final long zzKT;
    private final long zzajH;
    private final Session zzajJ;
    private final int zzajR;
    private final List<DataSet> zzajS;
    private final int zzajT;
    private boolean zzajU;

    Bucket(int i, long j, long j2, Session session, int i2, List<DataSet> list, int i3, boolean z) {
        this.zzajU = false;
        this.zzCY = i;
        this.zzKT = j;
        this.zzajH = j2;
        this.zzajJ = session;
        this.zzajR = i2;
        this.zzajS = list;
        this.zzajT = i3;
        this.zzajU = z;
    }

    public Bucket(RawBucket rawBucket, List<DataSource> list) {
        this(2, rawBucket.zzKT, rawBucket.zzajH, rawBucket.zzajJ, rawBucket.zzakG, zza(rawBucket.zzajS, list), rawBucket.zzajT, rawBucket.zzajU);
    }

    private static List<DataSet> zza(Collection<RawDataSet> collection, List<DataSource> list) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<RawDataSet> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new DataSet(it.next(), list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzKT == bucket.zzKT && this.zzajH == bucket.zzajH && this.zzajR == bucket.zzajR && com.google.android.gms.common.internal.zzt.equal(this.zzajS, bucket.zzajS) && this.zzajT == bucket.zzajT && this.zzajU == bucket.zzajU;
    }

    public static String zzeb(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Bucket) && zza((Bucket) obj));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzajR);
    }

    public int getBucketType() {
        return this.zzajT;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzajS) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zzajS;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajH, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzajJ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzKT, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Long.valueOf(this.zzKT), Long.valueOf(this.zzajH), Integer.valueOf(this.zzajR), Integer.valueOf(this.zzajT));
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("startTime", Long.valueOf(this.zzKT)).zzg("endTime", Long.valueOf(this.zzajH)).zzg("activity", Integer.valueOf(this.zzajR)).zzg("dataSets", this.zzajS).zzg("bucketType", zzeb(this.zzajT)).zzg("serverHasMoreData", Boolean.valueOf(this.zzajU)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public boolean zzb(Bucket bucket) {
        return this.zzKT == bucket.zzKT && this.zzajH == bucket.zzajH && this.zzajR == bucket.zzajR && this.zzajT == bucket.zzajT;
    }

    public long zzkt() {
        return this.zzKT;
    }

    public int zzqq() {
        return this.zzajR;
    }

    public boolean zzqr() {
        if (this.zzajU) {
            return true;
        }
        Iterator<DataSet> it = this.zzajS.iterator();
        while (it.hasNext()) {
            if (it.next().zzqr()) {
                return true;
            }
        }
        return false;
    }

    public long zzqs() {
        return this.zzajH;
    }
}
