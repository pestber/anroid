package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zza;
import com.google.android.gms.fitness.request.zzn;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzmu;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class StartBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzaa();
    private final int zzCY;
    private final String zzMZ;
    private final List<DataType> zzajQ;
    private final zzmu zzalN;
    private final zzn zzamK;
    private final int zzamL;

    public static class Builder {
        private zzn zzamK;
        private DataType[] zzami = new DataType[0];
        private int zzamL = 10;

        public StartBleScanRequest build() {
            com.google.android.gms.common.internal.zzu.zza(this.zzamK != null, "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public Builder setBleScanCallback(BleScanCallback bleScanCallback) {
            zza(zza.C0067zza.zzqS().zza(bleScanCallback));
            return this;
        }

        public Builder setDataTypes(DataType... dataTypeArr) {
            this.zzami = dataTypeArr;
            return this;
        }

        public Builder setTimeoutSecs(int i) {
            com.google.android.gms.common.internal.zzu.zzb(i > 0, "Stop time must be greater than zero");
            com.google.android.gms.common.internal.zzu.zzb(i <= 60, "Stop time must be less than 1 minute");
            this.zzamL = i;
            return this;
        }

        public Builder zza(zzn zznVar) {
            this.zzamK = zznVar;
            return this;
        }
    }

    StartBleScanRequest(int i, List<DataType> list, IBinder iBinder, int i2, IBinder iBinder2, String str) {
        this.zzCY = i;
        this.zzajQ = list;
        this.zzamK = zzn.zza.zzbI(iBinder);
        this.zzamL = i2;
        this.zzalN = iBinder2 == null ? null : zzmu.zza.zzbF(iBinder2);
        this.zzMZ = str;
    }

    private StartBleScanRequest(Builder builder) {
        this(zzkx.zzb(builder.zzami), builder.zzamK, builder.zzamL, null, null);
    }

    public StartBleScanRequest(StartBleScanRequest startBleScanRequest, zzmu zzmuVar, String str) {
        this(startBleScanRequest.zzajQ, startBleScanRequest.zzamK, startBleScanRequest.zzamL, zzmuVar, str);
    }

    public StartBleScanRequest(List<DataType> list, zzn zznVar, int i, zzmu zzmuVar, String str) {
        this.zzCY = 3;
        this.zzajQ = list;
        this.zzamK = zznVar;
        this.zzamL = i;
        this.zzalN = zzmuVar;
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

    public int getTimeoutSecs() {
        return this.zzamL;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzt.zzt(this).zzg("dataTypes", this.zzajQ).zzg("timeoutSecs", Integer.valueOf(this.zzamL)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzaa.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }

    public IBinder zzrq() {
        return this.zzamK.asBinder();
    }
}
