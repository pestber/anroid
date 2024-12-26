package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class DeviceStatus implements SafeParcelable {
    public static final Parcelable.Creator<DeviceStatus> CREATOR = new zzg();
    private final int zzCY;
    private double zzSh;
    private boolean zzSi;
    private ApplicationMetadata zzUF;
    private int zzUu;
    private int zzUv;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.zzCY = i;
        this.zzSh = d;
        this.zzSi = z;
        this.zzUu = i2;
        this.zzUF = applicationMetadata;
        this.zzUv = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.zzSh == deviceStatus.zzSh && this.zzSi == deviceStatus.zzSi && this.zzUu == deviceStatus.zzUu && zzf.zza(this.zzUF, deviceStatus.zzUF) && this.zzUv == deviceStatus.zzUv;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzUF;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Double.valueOf(this.zzSh), Boolean.valueOf(this.zzSi), Integer.valueOf(this.zzUu), this.zzUF, Integer.valueOf(this.zzUv));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public double zzlO() {
        return this.zzSh;
    }

    public int zzlP() {
        return this.zzUu;
    }

    public int zzlQ() {
        return this.zzUv;
    }

    public boolean zzlX() {
        return this.zzSi;
    }
}
