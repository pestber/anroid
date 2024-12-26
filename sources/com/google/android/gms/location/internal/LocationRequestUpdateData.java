package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;

/* loaded from: classes.dex */
public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    PendingIntent mPendingIntent;
    private final int zzCY;
    int zzazf;
    LocationRequestInternal zzazg;
    com.google.android.gms.location.zzd zzazh;
    com.google.android.gms.location.zzc zzazi;

    LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2) {
        this.zzCY = i;
        this.zzazf = i2;
        this.zzazg = locationRequestInternal;
        this.zzazh = iBinder == null ? null : zzd.zza.zzbT(iBinder);
        this.mPendingIntent = pendingIntent;
        this.zzazi = iBinder2 != null ? zzc.zza.zzbS(iBinder2) : null;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzc zzcVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, zzcVar.asBinder());
    }

    public static LocationRequestUpdateData zza(com.google.android.gms.location.zzc zzcVar) {
        return new LocationRequestUpdateData(1, 2, null, null, null, zzcVar.asBinder());
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null);
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, com.google.android.gms.location.zzd zzdVar) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, zzdVar.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zzb(com.google.android.gms.location.zzd zzdVar) {
        return new LocationRequestUpdateData(1, 2, null, zzdVar.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zze(PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    IBinder zzuy() {
        if (this.zzazh == null) {
            return null;
        }
        return this.zzazh.asBinder();
    }

    IBinder zzuz() {
        if (this.zzazi == null) {
            return null;
        }
        return this.zzazi.asBinder();
    }
}
