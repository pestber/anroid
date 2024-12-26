package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.nearby.bootstrap.Device;

/* loaded from: classes.dex */
public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    final int versionCode;
    private final long zzPr;
    private final byte zzaFg;
    private final Device zzaFh;
    private final zzoj zzaFi;
    private final zzok zzaFj;
    private final zzol zzaFk;
    private final String zzaFl;

    ConnectRequest(int i, Device device, String str, String str2, byte b, long j, String str3, IBinder iBinder, IBinder iBinder2, IBinder iBinder3) {
        this.versionCode = i;
        this.zzaFh = (Device) zzu.zzu(device);
        this.name = zzu.zzcj(str);
        this.description = (String) zzu.zzu(str2);
        this.zzaFg = b;
        this.zzPr = j;
        this.zzaFl = str3;
        zzu.zzu(iBinder);
        this.zzaFi = zzoj.zza.zzcV(iBinder);
        zzu.zzu(iBinder2);
        this.zzaFj = zzok.zza.zzcW(iBinder2);
        zzu.zzu(iBinder3);
        this.zzaFk = zzol.zza.zzcX(iBinder3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzaFl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public IBinder zzqU() {
        if (this.zzaFk == null) {
            return null;
        }
        return this.zzaFk.asBinder();
    }

    public byte zzwK() {
        return this.zzaFg;
    }

    public Device zzwM() {
        return this.zzaFh;
    }

    public long zzwN() {
        return this.zzPr;
    }

    public IBinder zzwO() {
        if (this.zzaFi == null) {
            return null;
        }
        return this.zzaFi.asBinder();
    }

    public IBinder zzwP() {
        if (this.zzaFj == null) {
            return null;
        }
        return this.zzaFj.asBinder();
    }
}
