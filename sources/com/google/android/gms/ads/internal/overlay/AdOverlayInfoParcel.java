package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzde;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzid;

@zzgd
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int orientation;
    public final int versionCode;
    public final VersionInfoParcel zzpJ;
    public final AdLauncherIntentInfoParcel zzzB;
    public final com.google.android.gms.ads.internal.client.zza zzzC;
    public final zzf zzzD;
    public final zzid zzzE;
    public final zzde zzzF;
    public final String zzzG;
    public final boolean zzzH;
    public final String zzzI;
    public final zzk zzzJ;
    public final int zzzK;
    public final zzdi zzzL;
    public final String zzzM;
    public final InterstitialAdParameterParcel zzzN;
    public final String zzzf;

    AdOverlayInfoParcel(int i, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, VersionInfoParcel versionInfoParcel, IBinder iBinder6, String str4, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = i;
        this.zzzB = adLauncherIntentInfoParcel;
        this.zzzC = (com.google.android.gms.ads.internal.client.zza) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder));
        this.zzzD = (zzf) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder2));
        this.zzzE = (zzid) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder3));
        this.zzzF = (zzde) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder4));
        this.zzzG = str;
        this.zzzH = z;
        this.zzzI = str2;
        this.zzzJ = (zzk) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder5));
        this.orientation = i2;
        this.zzzK = i3;
        this.zzzf = str3;
        this.zzpJ = versionInfoParcel;
        this.zzzL = (zzdi) com.google.android.gms.dynamic.zze.zzn(zzd.zza.zzbg(iBinder6));
        this.zzzM = str4;
        this.zzzN = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzf zzfVar, zzk zzkVar, zzid zzidVar, int i, VersionInfoParcel versionInfoParcel, String str, InterstitialAdParameterParcel interstitialAdParameterParcel) {
        this.versionCode = 4;
        this.zzzB = null;
        this.zzzC = zzaVar;
        this.zzzD = zzfVar;
        this.zzzE = zzidVar;
        this.zzzF = null;
        this.zzzG = null;
        this.zzzH = false;
        this.zzzI = null;
        this.zzzJ = zzkVar;
        this.orientation = i;
        this.zzzK = 1;
        this.zzzf = null;
        this.zzpJ = versionInfoParcel;
        this.zzzL = null;
        this.zzzM = str;
        this.zzzN = interstitialAdParameterParcel;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzf zzfVar, zzk zzkVar, zzid zzidVar, boolean z, int i, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzzB = null;
        this.zzzC = zzaVar;
        this.zzzD = zzfVar;
        this.zzzE = zzidVar;
        this.zzzF = null;
        this.zzzG = null;
        this.zzzH = z;
        this.zzzI = null;
        this.zzzJ = zzkVar;
        this.orientation = i;
        this.zzzK = 2;
        this.zzzf = null;
        this.zzpJ = versionInfoParcel;
        this.zzzL = null;
        this.zzzM = null;
        this.zzzN = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzf zzfVar, zzde zzdeVar, zzk zzkVar, zzid zzidVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzdi zzdiVar) {
        this.versionCode = 4;
        this.zzzB = null;
        this.zzzC = zzaVar;
        this.zzzD = zzfVar;
        this.zzzE = zzidVar;
        this.zzzF = zzdeVar;
        this.zzzG = null;
        this.zzzH = z;
        this.zzzI = null;
        this.zzzJ = zzkVar;
        this.orientation = i;
        this.zzzK = 3;
        this.zzzf = str;
        this.zzpJ = versionInfoParcel;
        this.zzzL = zzdiVar;
        this.zzzM = null;
        this.zzzN = null;
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzf zzfVar, zzde zzdeVar, zzk zzkVar, zzid zzidVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzdi zzdiVar) {
        this.versionCode = 4;
        this.zzzB = null;
        this.zzzC = zzaVar;
        this.zzzD = zzfVar;
        this.zzzE = zzidVar;
        this.zzzF = zzdeVar;
        this.zzzG = str2;
        this.zzzH = z;
        this.zzzI = str;
        this.zzzJ = zzkVar;
        this.orientation = i;
        this.zzzK = 3;
        this.zzzf = null;
        this.zzpJ = versionInfoParcel;
        this.zzzL = zzdiVar;
        this.zzzM = null;
        this.zzzN = null;
    }

    public AdOverlayInfoParcel(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, com.google.android.gms.ads.internal.client.zza zzaVar, zzf zzfVar, zzk zzkVar, VersionInfoParcel versionInfoParcel) {
        this.versionCode = 4;
        this.zzzB = adLauncherIntentInfoParcel;
        this.zzzC = zzaVar;
        this.zzzD = zzfVar;
        this.zzzE = null;
        this.zzzF = null;
        this.zzzG = null;
        this.zzzH = false;
        this.zzzI = null;
        this.zzzJ = zzkVar;
        this.orientation = -1;
        this.zzzK = 4;
        this.zzzf = null;
        this.zzpJ = versionInfoParcel;
        this.zzzL = null;
        this.zzzM = null;
        this.zzzN = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzb(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
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
        zze.zza(this, parcel, i);
    }

    IBinder zzeA() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzzF).asBinder();
    }

    IBinder zzeB() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzzL).asBinder();
    }

    IBinder zzeC() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzzJ).asBinder();
    }

    IBinder zzex() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzzC).asBinder();
    }

    IBinder zzey() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzzD).asBinder();
    }

    IBinder zzez() {
        return com.google.android.gms.dynamic.zze.zzw(this.zzzE).asBinder();
    }
}
