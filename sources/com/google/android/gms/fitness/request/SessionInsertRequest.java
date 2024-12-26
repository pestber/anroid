package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzmu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SessionInsertRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzu();
    private final int zzCY;
    private final String zzMZ;
    private final Session zzajJ;
    private final List<DataSet> zzajS;
    private final zzmu zzalN;
    private final List<DataPoint> zzamC;

    public static class Builder {
        private Session zzajJ;
        private List<DataSet> zzajS = new ArrayList();
        private List<DataPoint> zzamC = new ArrayList();
        private List<DataSource> zzamD = new ArrayList();

        private void zzd(DataPoint dataPoint) {
            zzf(dataPoint);
            zze(dataPoint);
        }

        private void zze(DataPoint dataPoint) {
            long startTime = this.zzajJ.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzajJ.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 == 0 || endTime2 == 0) {
                return;
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (endTime2 > endTime) {
                endTime2 = zzlu.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
            }
            long j = endTime2;
            com.google.android.gms.common.internal.zzu.zza(startTime2 >= startTime && j <= endTime, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
            if (j != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(j), timeUnit));
                dataPoint.setTimeInterval(startTime2, j, TimeUnit.NANOSECONDS);
            }
        }

        private void zzf(DataPoint dataPoint) {
            long startTime = this.zzajJ.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzajJ.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzlu.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                com.google.android.gms.common.internal.zzu.zza(timestamp >= startTime && timestamp <= endTime, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzrn() {
            Iterator<DataSet> it = this.zzajS.iterator();
            while (it.hasNext()) {
                Iterator<DataPoint> it2 = it.next().getDataPoints().iterator();
                while (it2.hasNext()) {
                    zzd(it2.next());
                }
            }
            Iterator<DataPoint> it3 = this.zzamC.iterator();
            while (it3.hasNext()) {
                zzd(it3.next());
            }
        }

        public Builder addAggregateDataPoint(DataPoint dataPoint) {
            boolean z = false;
            com.google.android.gms.common.internal.zzu.zzb(dataPoint != null, "Must specify a valid aggregate data point.");
            long startTime = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime > 0 && endTime > startTime) {
                z = true;
            }
            com.google.android.gms.common.internal.zzu.zzb(z, "Aggregate data point should have valid start and end times: %s", dataPoint);
            DataSource dataSource = dataPoint.getDataSource();
            com.google.android.gms.common.internal.zzu.zza(true ^ this.zzamD.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.zzamD.add(dataSource);
            this.zzamC.add(dataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            com.google.android.gms.common.internal.zzu.zzb(dataSet != null, "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            com.google.android.gms.common.internal.zzu.zza(!this.zzamD.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            com.google.android.gms.common.internal.zzu.zzb(true ^ dataSet.getDataPoints().isEmpty(), "No data points specified in the input data set.");
            this.zzamD.add(dataSource);
            this.zzajS.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            com.google.android.gms.common.internal.zzu.zza(this.zzajJ != null, "Must specify a valid session.");
            com.google.android.gms.common.internal.zzu.zza(this.zzajJ.getEndTime(TimeUnit.MILLISECONDS) != 0, "Must specify a valid end time, cannot insert a continuing session.");
            zzrn();
            return new SessionInsertRequest(this);
        }

        public Builder setSession(Session session) {
            this.zzajJ = session;
            return this;
        }
    }

    SessionInsertRequest(int i, Session session, List<DataSet> list, List<DataPoint> list2, IBinder iBinder, String str) {
        this.zzCY = i;
        this.zzajJ = session;
        this.zzajS = Collections.unmodifiableList(list);
        this.zzamC = Collections.unmodifiableList(list2);
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str;
    }

    public SessionInsertRequest(Session session, List<DataSet> list, List<DataPoint> list2, zzmu zzmuVar, String str) {
        this.zzCY = 2;
        this.zzajJ = session;
        this.zzajS = Collections.unmodifiableList(list);
        this.zzamC = Collections.unmodifiableList(list2);
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzajJ, builder.zzajS, builder.zzamC, null, null);
    }

    public SessionInsertRequest(SessionInsertRequest sessionInsertRequest, zzmu zzmuVar, String str) {
        this(sessionInsertRequest.zzajJ, sessionInsertRequest.zzajS, sessionInsertRequest.zzamC, zzmuVar, str);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzajJ, sessionInsertRequest.zzajJ) && com.google.android.gms.common.internal.zzt.equal(this.zzajS, sessionInsertRequest.zzajS) && com.google.android.gms.common.internal.zzt.equal(this.zzamC, sessionInsertRequest.zzamC);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof SessionInsertRequest) && zzb((SessionInsertRequest) obj));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzamC;
    }

    public List<DataSet> getDataSets() {
        return this.zzajS;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public Session getSession() {
        return this.zzajJ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzajJ, this.zzajS, this.zzamC);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("session", this.zzajJ).zzg("dataSets", this.zzajS).zzg("aggregateDataPoints", this.zzamC).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }
}
