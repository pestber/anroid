package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zza;
import com.google.android.gms.fitness.request.zzn;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class StopBleScanRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopBleScanRequest> CREATOR = new zzab();
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;
    private final zzn zzamK;

    StopBleScanRequest(int i, IBinder iBinder, IBinder iBinder2, String str) {
        this.zzCY = i;
        this.zzamK = zzn.zza.zzbI(iBinder);
        this.zzalN = iBinder2 == null ? null : zzmu.zza.zzbF(iBinder2);
        this.zzMZ = str;
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zzmu zzmuVar, String str) {
        this(zza.C0067zza.zzqS().zzb(bleScanCallback), zzmuVar, str);
    }

    public StopBleScanRequest(zzn zznVar, zzmu zzmuVar, String str) {
        this.zzCY = 2;
        this.zzamK = zznVar;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzab.zza(this, parcel, i);
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
