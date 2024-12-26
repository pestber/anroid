package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class ClaimBleDeviceRequest implements SafeParcelable {
    public static final Parcelable.Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
    private final int zzCY;
    private final String zzMZ;
    private final String zzalL;
    private final BleDevice zzalM;
    private final zzmu zzalN;

    ClaimBleDeviceRequest(int i, String str, BleDevice bleDevice, IBinder iBinder, String str2) {
        this.zzCY = i;
        this.zzalL = str;
        this.zzalM = bleDevice;
        this.zzalN = iBinder == null ? null : zzmu.zza.zzbF(iBinder);
        this.zzMZ = str2;
    }

    public ClaimBleDeviceRequest(String str, BleDevice bleDevice, zzmu zzmuVar, String str2) {
        this.zzCY = 3;
        this.zzalL = str;
        this.zzalM = bleDevice;
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
        return String.format("ClaimBleDeviceRequest{%s %s}", this.zzalL, this.zzalM);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public BleDevice zzqT() {
        return this.zzalM;
    }

    public IBinder zzqU() {
        if (this.zzalN == null) {
            return null;
        }
        return this.zzalN.asBinder();
    }
}
