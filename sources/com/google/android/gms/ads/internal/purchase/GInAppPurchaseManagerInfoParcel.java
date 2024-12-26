package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public final class GInAppPurchaseManagerInfoParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final int versionCode;
    public final zzj zzAA;
    public final zzfe zzAy;
    public final Context zzAz;
    public final zzk zzqe;

    GInAppPurchaseManagerInfoParcel(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.zzqe = (zzk) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder));
        this.zzAy = (zzfe) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder2));
        this.zzAz = (Context) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder3));
        this.zzAA = (zzj) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder4));
    }

    public GInAppPurchaseManagerInfoParcel(Context context, zzk zzkVar, zzfe zzfeVar, zzj zzjVar) {
        this.versionCode = 2;
        this.zzAz = context;
        this.zzqe = zzkVar;
        this.zzAy = zzfeVar;
        this.zzAA = zzjVar;
    }

    public static void zza(Intent intent, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", gInAppPurchaseManagerInfoParcel);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static GInAppPurchaseManagerInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(GInAppPurchaseManagerInfoParcel.class.getClassLoader());
            return (GInAppPurchaseManagerInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    IBinder zzfa() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzAA).asBinder();
    }

    IBinder zzfb() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzqe).asBinder();
    }

    IBinder zzfc() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzAy).asBinder();
    }

    IBinder zzfd() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzAz).asBinder();
    }
}
