package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhl;
import java.util.ArrayList;

@zzgd
/* loaded from: classes.dex */
public abstract class zzb extends zza implements com.google.android.gms.ads.internal.overlay.zzf, com.google.android.gms.ads.internal.purchase.zzj, zzdi, zzdz {
    private final Messenger mMessenger;
    protected final zzef zzoq;
    protected transient boolean zzor;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzef zzefVar, VersionInfoParcel versionInfoParcel) {
        this(new zzp(context, adSizeParcel, str, versionInfoParcel), zzefVar, null);
    }

    zzb(zzp zzpVar, zzef zzefVar, zzn zznVar) {
        super(zzpVar, zznVar);
        this.zzoq = zzefVar;
        this.mMessenger = new Messenger(new zzfc(this.zzon.zzpH));
        this.zzor = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x011d A[LOOP:0: B:24:0x0113->B:26:0x011d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zza(com.google.android.gms.ads.internal.client.AdRequestParcel r32, android.os.Bundle r33) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzb.zza(com.google.android.gms.ads.internal.client.AdRequestParcel, android.os.Bundle):com.google.android.gms.ads.internal.request.AdRequestInfoParcel$zza");
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public String getMediationAdapterClassName() {
        if (this.zzon.zzpO == null) {
            return null;
        }
        return this.zzon.zzpO.zzyb;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzon.zzpO == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.zzon.zzpO.zzFm != null && this.zzon.zzpO.zzFm.zzxF != null) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, this.zzon.zzpO, this.zzon.zzpG, false, zza(this.zzon.zzpO.zzFm.zzxF, this.zzon.zzpO.zzCC));
        }
        if (this.zzon.zzpO.zzxZ != null && this.zzon.zzpO.zzxZ.zzxx != null) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, this.zzon.zzpO, this.zzon.zzpG, false, this.zzon.zzpO.zzxZ.zzxx);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzr
    public void pause() {
        zzu.zzbY("pause must be called on the main UI thread.");
        if (this.zzon.zzpO != null && this.zzon.zzbM()) {
            zzo.zzbx().zza(this.zzon.zzpO.zzzE.getWebView());
        }
        if (this.zzon.zzpO != null && this.zzon.zzpO.zzya != null) {
            try {
                this.zzon.zzpO.zzya.pause();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not pause mediation adapter.");
            }
        }
        this.zzop.zzi(this.zzon.zzpO);
        this.zzom.pause();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzr
    public void resume() {
        zzu.zzbY("resume must be called on the main UI thread.");
        if (this.zzon.zzpO != null && this.zzon.zzbM()) {
            zzo.zzbx().zzb(this.zzon.zzpO.zzzE.getWebView());
        }
        if (this.zzon.zzpO != null && this.zzon.zzpO.zzya != null) {
            try {
                this.zzon.zzpO.zzya.resume();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not resume mediation adapter.");
            }
        }
        this.zzom.resume();
        this.zzop.zzj(this.zzon.zzpO);
    }

    @Override // com.google.android.gms.ads.internal.client.zzr
    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzr
    public void zza(zzff zzffVar) {
        zzu.zzbY("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzon.zzpV = zzffVar;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzr
    public void zza(zzfj zzfjVar, String str) {
        zzu.zzbY("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzon.zzqe = new com.google.android.gms.ads.internal.purchase.zzk(str);
        this.zzon.zzpW = zzfjVar;
        if (zzo.zzby().zzfZ() || zzfjVar == null) {
            return;
        }
        new com.google.android.gms.ads.internal.purchase.zzc(this.zzon.zzpH, this.zzon.zzpW, this.zzon.zzqe).zzgi();
    }

    protected void zza(zzha zzhaVar, boolean z) {
        if (zzhaVar == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzhaVar);
        if (zzhaVar.zzFm != null && zzhaVar.zzFm.zzxG != null) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zzhaVar, this.zzon.zzpG, z, zza(zzhaVar.zzFm.zzxG, zzhaVar.zzCC));
        }
        if (zzhaVar.zzxZ == null || zzhaVar.zzxZ.zzxy == null) {
            return;
        }
        zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zzhaVar, this.zzon.zzpG, z, zzhaVar.zzxZ.zzxy);
    }

    @Override // com.google.android.gms.internal.zzdi
    public void zza(String str, ArrayList<String> arrayList) {
        com.google.android.gms.ads.internal.purchase.zzd zzdVar = new com.google.android.gms.ads.internal.purchase.zzd(str, arrayList, this.zzon.zzpH, this.zzon.zzpJ.zzGG);
        if (this.zzon.zzpV != null) {
            try {
                this.zzon.zzpV.zza(zzdVar);
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not start In-App purchase.");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("InAppPurchaseListener is not set. Try to launch default purchase flow.");
        if (!com.google.android.gms.ads.internal.client.zzk.zzcA().zzP(this.zzon.zzpH)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Google Play Service unavailable, cannot launch default purchase flow.");
            return;
        }
        if (this.zzon.zzpW == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("PlayStorePurchaseListener is not set.");
            return;
        }
        if (this.zzon.zzqe == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("PlayStorePurchaseVerifier is not initialized.");
            return;
        }
        if (this.zzon.zzqi) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("An in-app purchase request is already in progress, abort");
            return;
        }
        this.zzon.zzqi = true;
        try {
            if (this.zzon.zzpW.isValidPurchase(str)) {
                zzo.zzbF().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGJ, new GInAppPurchaseManagerInfoParcel(this.zzon.zzpH, this.zzon.zzqe, zzdVar, this));
            } else {
                this.zzon.zzqi = false;
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not start In-App purchase.");
            this.zzon.zzqi = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.purchase.zzj
    public void zza(String str, boolean z, int i, final Intent intent, com.google.android.gms.ads.internal.purchase.zzf zzfVar) {
        try {
            if (this.zzon.zzpW != null) {
                this.zzon.zzpW.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzon.zzpH, str, z, i, intent, zzfVar));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Fail to invoke PlayStorePurchaseListener.");
        }
        zzhl.zzGk.postDelayed(new Runnable() { // from class: com.google.android.gms.ads.internal.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                int zzd = zzo.zzbF().zzd(intent);
                zzo.zzbF();
                if (zzd == 0 && zzb.this.zzon.zzpO != null && zzb.this.zzon.zzpO.zzzE != null && zzb.this.zzon.zzpO.zzzE.zzgD() != null) {
                    zzb.this.zzon.zzpO.zzzE.zzgD().close();
                }
                zzb.this.zzon.zzqi = false;
            }
        }, 500L);
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzha zzhaVar, boolean z) {
        zzn zznVar;
        long j;
        if (!z && this.zzon.zzbM()) {
            if (zzhaVar.zzxJ > 0) {
                zznVar = this.zzom;
                j = zzhaVar.zzxJ;
            } else if (zzhaVar.zzFm != null && zzhaVar.zzFm.zzxJ > 0) {
                zznVar = this.zzom;
                j = zzhaVar.zzFm.zzxJ;
            } else if (!zzhaVar.zzCK && zzhaVar.errorCode == 2) {
                this.zzom.zzf(adRequestParcel);
            }
            zznVar.zza(adRequestParcel, j);
        }
        return this.zzom.zzbp();
    }

    @Override // com.google.android.gms.ads.internal.zza
    boolean zza(zzha zzhaVar) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzoo != null) {
            adRequestParcel = this.zzoo;
            this.zzoo = null;
        } else {
            adRequestParcel = zzhaVar.zzCm;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzhaVar, z);
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected boolean zza(zzha zzhaVar, zzha zzhaVar2) {
        int i;
        int i2;
        if (zzhaVar != null && zzhaVar.zzyc != null) {
            zzhaVar.zzyc.zza((zzdz) null);
        }
        if (zzhaVar2.zzyc != null) {
            zzhaVar2.zzyc.zza(this);
        }
        if (zzhaVar2.zzFm != null) {
            i = zzhaVar2.zzFm.zzxM;
            i2 = zzhaVar2.zzFm.zzxN;
        } else {
            i = 0;
            i2 = 0;
        }
        this.zzon.zzqf.zzf(i, i2);
        return true;
    }

    protected boolean zzaU() {
        return zzo.zzbv().zza(this.zzon.zzpH.getPackageManager(), this.zzon.zzpH.getPackageName(), "android.permission.INTERNET") && zzo.zzbv().zzG(this.zzon.zzpH);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzf
    public void zzaV() {
        this.zzop.zzg(this.zzon.zzpO);
        this.zzor = false;
        zzaQ();
        this.zzon.zzpQ.zzfR();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzf
    public void zzaW() {
        this.zzor = true;
        zzaS();
    }

    @Override // com.google.android.gms.internal.zzdz
    public void zzaX() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzdz
    public void zzaY() {
        zzaV();
    }

    @Override // com.google.android.gms.internal.zzdz
    public void zzaZ() {
        zzaO();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzft.zza
    public void zzb(zzha zzhaVar) {
        super.zzb(zzhaVar);
        if (zzhaVar.errorCode != 3 || zzhaVar.zzFm == null || zzhaVar.zzFm.zzxH == null) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Pinging no fill URLs.");
        zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, zzhaVar, this.zzon.zzpG, false, zzhaVar.zzFm.zzxH);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzb(AdRequestParcel adRequestParcel) {
        if (!zzaU()) {
            return false;
        }
        Bundle zza = zza(zzo.zzby().zzD(this.zzon.zzpH));
        this.zzom.cancel();
        this.zzon.zzqh = 0;
        AdRequestInfoParcel.zza zza2 = zza(adRequestParcel, zza);
        this.zzon.zzpL = zzo.zzbr().zza(this.zzon.zzpH, zza2, this.zzon.zzpI, this);
        return true;
    }

    @Override // com.google.android.gms.internal.zzdz
    public void zzba() {
        zzaW();
    }

    @Override // com.google.android.gms.internal.zzdz
    public void zzbb() {
        if (this.zzon.zzpO != null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Mediation adapter " + this.zzon.zzpO.zzyb + " refreshed, but mediation adapters should never refresh.");
        }
        zza(this.zzon.zzpO, true);
        zzaT();
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzor;
    }
}
