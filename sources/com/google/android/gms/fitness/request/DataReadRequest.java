package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzmf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DataReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int zzCY;
    private final long zzKT;
    private final String zzMZ;
    private final long zzajH;
    private final List<DataType> zzajQ;
    private final int zzajT;
    private final List<DataSource> zzalP;
    private final List<DataType> zzalU;
    private final List<DataSource> zzalV;
    private final long zzalW;
    private final DataSource zzalX;
    private final int zzalY;
    private final boolean zzalZ;
    private final boolean zzama;
    private final zzmf zzamb;
    private final List<Device> zzamc;

    public static class Builder {
        private long zzKT;
        private long zzajH;
        private DataSource zzalX;
        private List<DataType> zzajQ = new ArrayList();
        private List<DataSource> zzalP = new ArrayList();
        private List<DataType> zzalU = new ArrayList();
        private List<DataSource> zzalV = new ArrayList();
        private int zzajT = 0;
        private long zzalW = 0;
        private int zzalY = 0;
        private boolean zzalZ = false;
        private boolean zzama = false;
        private List<Device> zzamc = new ArrayList();

        public Builder aggregate(DataSource dataSource, DataType dataType) {
            com.google.android.gms.common.internal.zzu.zzb(dataSource, "Attempting to add a null data source");
            com.google.android.gms.common.internal.zzu.zza(!this.zzalP.contains(dataSource), "Cannot add the same data source for aggregated and detailed");
            DataType dataType2 = dataSource.getDataType();
            com.google.android.gms.common.internal.zzu.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType2), "Unsupported input data type specified for aggregation: %s", dataType2);
            com.google.android.gms.common.internal.zzu.zzb(DataType.getAggregatesForInput(dataType2).contains(dataType), "Invalid output aggregate data type specified: %s -> %s", dataType2, dataType);
            if (!this.zzalV.contains(dataSource)) {
                this.zzalV.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType dataType, DataType dataType2) {
            com.google.android.gms.common.internal.zzu.zzb(dataType, "Attempting to use a null data type");
            com.google.android.gms.common.internal.zzu.zza(!this.zzajQ.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            com.google.android.gms.common.internal.zzu.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            com.google.android.gms.common.internal.zzu.zzb(DataType.getAggregatesForInput(dataType).contains(dataType2), "Invalid output aggregate data type specified: %s -> %s", dataType, dataType2);
            if (!this.zzalU.contains(dataType)) {
                this.zzalU.add(dataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzajT = 4;
            this.zzalW = timeUnit.toMillis(i);
            return this;
        }

        public Builder bucketByActivitySegment(int i, TimeUnit timeUnit, DataSource dataSource) {
            com.google.android.gms.common.internal.zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            com.google.android.gms.common.internal.zzu.zzb(dataSource != null, "Invalid activity data source specified");
            com.google.android.gms.common.internal.zzu.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzalX = dataSource;
            this.zzajT = 4;
            this.zzalW = timeUnit.toMillis(i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzajT = 3;
            this.zzalW = timeUnit.toMillis(i);
            return this;
        }

        public Builder bucketByActivityType(int i, TimeUnit timeUnit, DataSource dataSource) {
            com.google.android.gms.common.internal.zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            com.google.android.gms.common.internal.zzu.zzb(dataSource != null, "Invalid activity data source specified");
            com.google.android.gms.common.internal.zzu.zzb(dataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", dataSource);
            this.zzalX = dataSource;
            this.zzajT = 3;
            this.zzalW = timeUnit.toMillis(i);
            return this;
        }

        public Builder bucketBySession(int i, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzajT = 2;
            this.zzalW = timeUnit.toMillis(i);
            return this;
        }

        public Builder bucketByTime(int i, TimeUnit timeUnit) {
            com.google.android.gms.common.internal.zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(i));
            this.zzajT = 1;
            this.zzalW = timeUnit.toMillis(i);
            return this;
        }

        public DataReadRequest build() {
            boolean z = false;
            com.google.android.gms.common.internal.zzu.zza((this.zzalP.isEmpty() && this.zzajQ.isEmpty() && this.zzalV.isEmpty() && this.zzalU.isEmpty()) ? false : true, "Must add at least one data source (aggregated or detailed)");
            com.google.android.gms.common.internal.zzu.zza(this.zzKT > 0, "Invalid start time: %s", Long.valueOf(this.zzKT));
            com.google.android.gms.common.internal.zzu.zza(this.zzajH > 0 && this.zzajH > this.zzKT, "Invalid end time: %s", Long.valueOf(this.zzajH));
            boolean z2 = this.zzalV.isEmpty() && this.zzalU.isEmpty();
            if ((z2 && this.zzajT == 0) || (!z2 && this.zzajT != 0)) {
                z = true;
            }
            com.google.android.gms.common.internal.zzu.zza(z, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzama = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            com.google.android.gms.common.internal.zzu.zzb(dataSource, "Attempting to add a null data source");
            com.google.android.gms.common.internal.zzu.zzb(!this.zzalV.contains(dataSource), "Cannot add the same data source as aggregated and detailed");
            if (!this.zzalP.contains(dataSource)) {
                this.zzalP.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            com.google.android.gms.common.internal.zzu.zzb(dataType, "Attempting to use a null data type");
            com.google.android.gms.common.internal.zzu.zza(!this.zzalU.contains(dataType), "Cannot add the same data type as aggregated and detailed");
            if (!this.zzajQ.contains(dataType)) {
                this.zzajQ.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int i) {
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Invalid limit %d is specified", Integer.valueOf(i));
            this.zzalY = i;
            return this;
        }

        public Builder setTimeRange(long j, long j2, TimeUnit timeUnit) {
            this.zzKT = timeUnit.toMillis(j);
            this.zzajH = timeUnit.toMillis(j2);
            return this;
        }
    }

    DataReadRequest(int i, List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i2, long j3, DataSource dataSource, int i3, boolean z, boolean z2, IBinder iBinder, String str, List<Device> list5) {
        this.zzCY = i;
        this.zzajQ = Collections.unmodifiableList(list);
        this.zzalP = Collections.unmodifiableList(list2);
        this.zzKT = j;
        this.zzajH = j2;
        this.zzalU = Collections.unmodifiableList(list3);
        this.zzalV = Collections.unmodifiableList(list4);
        this.zzajT = i2;
        this.zzalW = j3;
        this.zzalX = dataSource;
        this.zzalY = i3;
        this.zzalZ = z;
        this.zzama = z2;
        this.zzamb = iBinder == null ? null : zzmf.zza.zzbq(iBinder);
        this.zzMZ = str;
        this.zzamc = list5 == null ? Collections.EMPTY_LIST : list5;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzajQ, builder.zzalP, builder.zzKT, builder.zzajH, builder.zzalU, builder.zzalV, builder.zzajT, builder.zzalW, builder.zzalX, builder.zzalY, builder.zzalZ, builder.zzama, null, null, builder.zzamc);
    }

    public DataReadRequest(DataReadRequest dataReadRequest, zzmf zzmfVar, String str) {
        this(dataReadRequest.zzajQ, dataReadRequest.zzalP, dataReadRequest.zzKT, dataReadRequest.zzajH, dataReadRequest.zzalU, dataReadRequest.zzalV, dataReadRequest.zzajT, dataReadRequest.zzalW, dataReadRequest.zzalX, dataReadRequest.zzalY, dataReadRequest.zzalZ, dataReadRequest.zzama, zzmfVar, str, dataReadRequest.zzamc);
    }

    public DataReadRequest(List<DataType> list, List<DataSource> list2, long j, long j2, List<DataType> list3, List<DataSource> list4, int i, long j3, DataSource dataSource, int i2, boolean z, boolean z2, zzmf zzmfVar, String str, List<Device> list5) {
        this.zzCY = 4;
        this.zzajQ = Collections.unmodifiableList(list);
        this.zzalP = Collections.unmodifiableList(list2);
        this.zzKT = j;
        this.zzajH = j2;
        this.zzalU = Collections.unmodifiableList(list3);
        this.zzalV = Collections.unmodifiableList(list4);
        this.zzajT = i;
        this.zzalW = j3;
        this.zzalX = dataSource;
        this.zzalY = i2;
        this.zzalZ = z;
        this.zzama = z2;
        this.zzamb = zzmfVar;
        this.zzMZ = str;
        this.zzamc = list5;
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzajQ.equals(dataReadRequest.zzajQ) && this.zzalP.equals(dataReadRequest.zzalP) && this.zzKT == dataReadRequest.zzKT && this.zzajH == dataReadRequest.zzajH && this.zzajT == dataReadRequest.zzajT && this.zzalV.equals(dataReadRequest.zzalV) && this.zzalU.equals(dataReadRequest.zzalU) && com.google.android.gms.common.internal.zzt.equal(this.zzalX, dataReadRequest.zzalX) && this.zzalW == dataReadRequest.zzalW && this.zzama == dataReadRequest.zzama;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof DataReadRequest) && zzb((DataReadRequest) obj));
    }

    public DataSource getActivityDataSource() {
        return this.zzalX;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzalV;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzalU;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzalW, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzajT;
    }

    public List<DataSource> getDataSources() {
        return this.zzalP;
    }

    public List<DataType> getDataTypes() {
        return this.zzajQ;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajH, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzalY;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzKT, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(Integer.valueOf(this.zzajT), Long.valueOf(this.zzKT), Long.valueOf(this.zzajH));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataReadRequest{");
        if (!this.zzajQ.isEmpty()) {
            Iterator<DataType> it = this.zzajQ.iterator();
            while (it.hasNext()) {
                sb.append(it.next().zzqD()).append(" ");
            }
        }
        if (!this.zzalP.isEmpty()) {
            Iterator<DataSource> it2 = this.zzalP.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().toDebugString()).append(" ");
            }
        }
        if (this.zzajT != 0) {
            sb.append("bucket by ").append(Bucket.zzeb(this.zzajT));
            if (this.zzalW > 0) {
                sb.append(" >").append(this.zzalW).append("ms");
            }
            sb.append(": ");
        }
        if (!this.zzalU.isEmpty()) {
            Iterator<DataType> it3 = this.zzalU.iterator();
            while (it3.hasNext()) {
                sb.append(it3.next().zzqD()).append(" ");
            }
        }
        if (!this.zzalV.isEmpty()) {
            Iterator<DataSource> it4 = this.zzalV.iterator();
            while (it4.hasNext()) {
                sb.append(it4.next().toDebugString()).append(" ");
            }
        }
        sb.append(String.format("(%tF %tT - %tF %tT)", Long.valueOf(this.zzKT), Long.valueOf(this.zzKT), Long.valueOf(this.zzajH), Long.valueOf(this.zzajH)));
        if (this.zzalX != null) {
            sb.append("activities: ").append(this.zzalX.toDebugString());
        }
        if (this.zzama) {
            sb.append(" +server");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public long zzkt() {
        return this.zzKT;
    }

    public IBinder zzqU() {
        if (this.zzamb == null) {
            return null;
        }
        return this.zzamb.asBinder();
    }

    public boolean zzqZ() {
        return this.zzama;
    }

    public long zzqs() {
        return this.zzajH;
    }

    public boolean zzra() {
        return this.zzalZ;
    }

    public long zzrb() {
        return this.zzalW;
    }

    public List<Device> zzrc() {
        return this.zzamc;
    }
}
