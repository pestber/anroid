package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new zzad();
    private final int zzCY;
    private final String zzMZ;
    private final String zzalL;
    private final zzmu zzalN;

    UnclaimBleDeviceRequest(int i, String str, IBinder iBinder, String str2) {
        this.zzCY = i;
        this.zzalL = str;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str2;
    }

    public UnclaimBleDeviceRequest(String str, zzmu zzmuVar, String str2) {
        this.zzCY = 4;
        this.zzalL = str;
        this.zzalN = zzmuVar;
        this.zzMZ = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.zzalL;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", this.zzalL);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzad.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }
}
