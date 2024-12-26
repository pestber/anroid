package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorUnregistrationRequest> CREATOR = new zzt();
    private final PendingIntent mPendingIntent;
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;
    private final com.google.android.gms.fitness.data.zzj zzamr;

    SensorUnregistrationRequest(int i, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, String str) {
        this.zzCY = i;
        this.zzamr = iBinder == null ? null : zzj.zza.zzbh(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzalN = zzmu.zza.zzbF(iBinder2);
        this.zzMZ = str;
    }

    public SensorUnregistrationRequest(com.google.android.gms.fitness.data.zzj zzjVar, PendingIntent pendingIntent, zzmu zzmuVar, String str) {
        this.zzCY = 3;
        this.zzamr = zzjVar;
        this.mPendingIntent = pendingIntent;
        this.zzalN = zzmuVar;
        this.zzMZ = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.zzamr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzt.zza(this, parcel, i);
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

    IBinder zzrl() {
        if (this.zzamr == null) {
            return null;
        }
        return this.zzamr.asBinder();
    }
}
