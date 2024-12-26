package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SessionReadRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzv();
    private final int zzCY;
    private final String zzFE;
    private final long zzKT;
    private final String zzMZ;
    private final long zzajH;
    private final List<DataType> zzajQ;
    private final List<DataSource> zzalP;
    private final String zzamE;
    private boolean zzamF;
    private final List<String> zzamG;
    private final zzms zzamH;
    private final boolean zzama;

    public static class Builder {
        private String zzFE;
        private String zzamE;
        private long zzKT = 0;
        private long zzajH = 0;
        private List<DataType> zzajQ = new ArrayList();
        private List<DataSource> zzalP = new ArrayList();
        private boolean zzamF = false;
        private boolean zzama = false;
        private List<String> zzamG = new ArrayList();

        public SessionReadRequest build() {
            com.google.android.gms.common.internal.zzu.zzb(this.zzKT > 0, "Invalid start time: %s", Long.valueOf(this.zzKT));
            com.google.android.gms.common.internal.zzu.zzb(this.zzajH > 0 && this.zzajH > this.zzKT, "Invalid end time: %s", Long.valueOf(this.zzajH));
            return new SessionReadRequest(this);
        }

        public Builder enableServerQueries() {
            this.zzama = true;
            return this;
        }

        public Builder excludePackage(String str) {
            com.google.android.gms.common.internal.zzu.zzb(str, "Attempting to use a null package name");
            if (!this.zzamG.contains(str)) {
                this.zzamG.add(str);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            com.google.android.gms.common.internal.zzu.zzb(dataSource, "Attempting to add a null data source");
            if (!this.zzalP.contains(dataSource)) {
                this.zzalP.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            com.google.android.gms.common.internal.zzu.zzb(dataType, "Attempting to use a null data type");
            if (!this.zzajQ.contains(dataType)) {
                this.zzajQ.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzamF = true;
            return this;
        }

        public Builder setSessionId(String str) {
            this.zzFE = str;
            return this;
        }

        public Builder setSessionName(String str) {
            this.zzamE = str;
            return this;
        }

        public Builder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzKT = timeUnit.toMillis(j);
            this.zzajH = timeUnit.toMillis(j2);
            return this;
        }
    }

    SessionReadRequest(int i, String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, IBinder iBinder, String str3) {
        this.zzCY = i;
        this.zzamE = str;
        this.zzFE = str2;
        this.zzKT = j;
        this.zzajH = j2;
        this.zzajQ = Collections.unmodifiableList(list);
        this.zzalP = Collections.unmodifiableList(list2);
        this.zzamF = z;
        this.zzama = z2;
        this.zzamG = list3;
        this.zzamH = iBinder == null ? null : zzms.zza.zzbD(iBinder);
        this.zzMZ = str3;
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzamE, builder.zzFE, builder.zzKT, builder.zzajH, builder.zzajQ, builder.zzalP, builder.zzamF, builder.zzama, builder.zzamG, null, null);
    }

    public SessionReadRequest(SessionReadRequest sessionReadRequest, zzms zzmsVar, String str) {
        this(sessionReadRequest.zzamE, sessionReadRequest.zzFE, sessionReadRequest.zzKT, sessionReadRequest.zzajH, sessionReadRequest.zzajQ, sessionReadRequest.zzalP, sessionReadRequest.zzamF, sessionReadRequest.zzama, sessionReadRequest.zzamG, zzmsVar, str);
    }

    public SessionReadRequest(String str, String str2, long j, long j2, List<DataType> list, List<DataSource> list2, boolean z, boolean z2, List<String> list3, zzms zzmsVar, String str3) {
        this.zzCY = 4;
        this.zzamE = str;
        this.zzFE = str2;
        this.zzKT = j;
        this.zzajH = j2;
        this.zzajQ = Collections.unmodifiableList(list);
        this.zzalP = Collections.unmodifiableList(list2);
        this.zzamF = z;
        this.zzama = z2;
        this.zzamG = list3;
        this.zzamH = zzmsVar;
        this.zzMZ = str3;
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzamE, sessionReadRequest.zzamE) && this.zzFE.equals(sessionReadRequest.zzFE) && this.zzKT == sessionReadRequest.zzKT && this.zzajH == sessionReadRequest.zzajH && com.google.android.gms.common.internal.zzt.equal(this.zzajQ, sessionReadRequest.zzajQ) && com.google.android.gms.common.internal.zzt.equal(this.zzalP, sessionReadRequest.zzalP) && this.zzamF == sessionReadRequest.zzamF && this.zzamG.equals(sessionReadRequest.zzamG) && this.zzama == sessionReadRequest.zzama;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SessionReadRequest) && zzb((SessionReadRequest) obj));
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

    public List<String> getExcludedPackages() {
        return this.zzamG;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public String getSessionId() {
        return this.zzFE;
    }

    public String getSessionName() {
        return this.zzamE;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzKT, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzamE, this.zzFE, Long.valueOf(this.zzKT), Long.valueOf(this.zzajH));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzamF;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("sessionName", this.zzamE).zzg("sessionId", this.zzFE).zzg("startTimeMillis", Long.valueOf(this.zzKT)).zzg("endTimeMillis", Long.valueOf(this.zzajH)).zzg("dataTypes", this.zzajQ).zzg("dataSources", this.zzalP).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzamF)).zzg("excludedPackages", this.zzamG).zzg("useServer", Boolean.valueOf(this.zzama)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzv.zza(this, parcel, i);
    }

    public long zzkt() {
        return this.zzKT;
    }

    public IBinder zzqU() {
        if (this.zzamH == null) {
            return null;
        }
        return this.zzamH.asBinder();
    }

    public boolean zzqZ() {
        return this.zzama;
    }

    public long zzqs() {
        return this.zzajH;
    }

    public boolean zzro() {
        return this.zzamF;
    }
}
