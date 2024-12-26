package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SensorRegistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorRegistrationRequest> CREATOR = new zzs();
    private final PendingIntent mPendingIntent;
    private final int zzCY;
    private final String zzMZ;
    private final DataType zzajF;
    private final DataSource zzajG;
    private final long zzakP;
    private final int zzakQ;
    private final zzmu zzalN;
    private com.google.android.gms.fitness.data.zzj zzamr;
    int zzams;
    int zzamt;
    private final long zzamu;
    private final long zzamv;
    private final List<LocationRequest> zzamw;
    private final long zzamx;
    private final List<Object> zzamy;

    SensorRegistrationRequest(int i, DataSource dataSource, DataType dataType, IBinder iBinder, int i2, int i3, long j, long j2, PendingIntent pendingIntent, long j3, int i4, List<LocationRequest> list, long j4, IBinder iBinder2, String str) {
        this.zzCY = i;
        this.zzajG = dataSource;
        this.zzajF = dataType;
        this.zzamr = iBinder == null ? null : zzj.zza.zzbh(iBinder);
        this.zzakP = j == 0 ? i2 : j;
        this.zzamv = j3;
        this.zzamu = j2 == 0 ? i3 : j2;
        this.zzamw = list;
        this.mPendingIntent = pendingIntent;
        this.zzakQ = i4;
        this.zzamy = Collections.emptyList();
        this.zzamx = j4;
        this.zzalN = iBinder2 != null ? zzmu.zza.zzbF(iBinder2) : null;
        this.zzMZ = str;
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, long j, long j2, long j3, int i, List<LocationRequest> list, List<Object> list2, long j4, zzmu zzmuVar, String str) {
        this.zzCY = 5;
        this.zzajG = dataSource;
        this.zzajF = dataType;
        this.zzamr = zzjVar;
        this.mPendingIntent = pendingIntent;
        this.zzakP = j;
        this.zzamv = j2;
        this.zzamu = j3;
        this.zzakQ = i;
        this.zzamw = list;
        this.zzamy = list2;
        this.zzamx = j4;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    public SensorRegistrationRequest(SensorRequest sensorRequest, com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, zzmu zzmuVar, String str) {
        this(sensorRequest.getDataSource(), sensorRequest.getDataType(), zzjVar, pendingIntent, sensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), sensorRequest.getFastestRate(TimeUnit.MICROSECONDS), sensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), sensorRequest.getAccuracyMode(), null, Collections.emptyList(), sensorRequest.zzrm(), zzmuVar, str);
    }

    private boolean zzb(SensorRegistrationRequest sensorRegistrationRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzajG, sensorRegistrationRequest.zzajG) && com.google.android.gms.common.internal.zzt.equal(this.zzajF, sensorRegistrationRequest.zzajF) && this.zzakP == sensorRegistrationRequest.zzakP && this.zzamv == sensorRegistrationRequest.zzamv && this.zzamu == sensorRegistrationRequest.zzamu && this.zzakQ == sensorRegistrationRequest.zzakQ && com.google.android.gms.common.internal.zzt.equal(this.zzamw, sensorRegistrationRequest.zzamw);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest) obj));
    }

    public int getAccuracyMode() {
        return this.zzakQ;
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    public DataType getDataType() {
        return this.zzajF;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzajG, this.zzajF, this.zzamr, Long.valueOf(this.zzakP), Long.valueOf(this.zzamv), Long.valueOf(this.zzamu), Integer.valueOf(this.zzakQ), this.zzamw);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", this.zzajF, this.zzajG, Long.valueOf(this.zzakP), Long.valueOf(this.zzamv), Long.valueOf(this.zzamu));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzs.zza(this, parcel, i);
    }

    public long zzqL() {
        return this.zzakP;
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }

    public PendingIntent zzrg() {
        return this.mPendingIntent;
    }

    public long zzrh() {
        return this.zzamv;
    }

    public long zzri() {
        return this.zzamu;
    }

    public List<LocationRequest> zzrj() {
        return this.zzamw;
    }

    public long zzrk() {
        return this.zzamx;
    }

    IBinder zzrl() {
        if (this.zzamr == null) {
            return null;
        }
        return this.zzamr.asBinder();
    }
}
