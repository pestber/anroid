package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class Subscription implements SafeParcelable {
    public static final Parcelable.Creator<Subscription> CREATOR = new zzr();
    private final int zzCY;
    private final DataType zzajF;
    private final DataSource zzajG;
    private final long zzakP;
    private final int zzakQ;

    public static class zza {
        private DataType zzajF;
        private DataSource zzajG;
        private long zzakP = -1;
        private int zzakQ = 2;

        public zza zzb(DataSource dataSource) {
            this.zzajG = dataSource;
            return this;
        }

        public zza zzb(DataType dataType) {
            this.zzajF = dataType;
            return this;
        }

        public Subscription zzqN() {
            zzu.zza((this.zzajG == null && this.zzajF == null) ? false : true, "Must call setDataSource() or setDataType()");
            zzu.zza(this.zzajF == null || this.zzajG == null || this.zzajF.equals(this.zzajG.getDataType()), "Specified data type is incompatible with specified data source");
            return new Subscription(this);
        }
    }

    Subscription(int i, DataSource dataSource, DataType dataType, long j, int i2) {
        this.zzCY = i;
        this.zzajG = dataSource;
        this.zzajF = dataType;
        this.zzakP = j;
        this.zzakQ = i2;
    }

    private Subscription(zza zzaVar) {
        this.zzCY = 1;
        this.zzajF = zzaVar.zzajF;
        this.zzajG = zzaVar.zzajG;
        this.zzakP = zzaVar.zzakP;
        this.zzakQ = zzaVar.zzakQ;
    }

    private boolean zza(Subscription subscription) {
        return com.google.android.gms.common.internal.zzt.equal(this.zzajG, subscription.zzajG) && com.google.android.gms.common.internal.zzt.equal(this.zzajF, subscription.zzajF) && this.zzakP == subscription.zzakP && this.zzakQ == subscription.zzakQ;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof Subscription) && zza((Subscription) obj));
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

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzt.hashCode(this.zzajG, this.zzajG, Long.valueOf(this.zzakP), Integer.valueOf(this.zzakQ));
    }

    public String toDebugString() {
        return String.format("Subscription{%s}", this.zzajG == null ? this.zzajF.getName() : this.zzajG.toDebugString());
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("dataSource", this.zzajG).zzg("dataType", this.zzajF).zzg("samplingIntervalMicros", Long.valueOf(this.zzakP)).zzg("accuracyMode", Integer.valueOf(this.zzakQ)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }

    public long zzqL() {
        return this.zzakP;
    }

    public DataType zzqM() {
        return this.zzajF == null ? this.zzajG.getDataType() : this.zzajF;
    }
}
