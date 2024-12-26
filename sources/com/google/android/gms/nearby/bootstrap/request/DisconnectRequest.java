package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes.dex */
public class DisconnectRequest implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int versionCode;
    private final Device zzaFh;
    private final zzol zzaFk;

    DisconnectRequest(int i, Device device, IBinder iBinder) {
        this.versionCode = i;
        this.zzaFh = (Device) zzu.zzu(device);
        zzu.zzu(iBinder);
        this.zzaFk = zzol.zza.zzcX(iBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        return this.zzaFk.asBinder();
    }

    public Device zzwM() {
        return this.zzaFh;
    }
}
