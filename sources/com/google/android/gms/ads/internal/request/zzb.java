package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;
import org.json.JSONException;

@zzgd
/* loaded from: classes.dex */
public class zzb extends zzhh implements zzc.zza {
    private final Context mContext;
    AdResponseParcel zzBt;
    private final zza.InterfaceC0017zza zzCd;
    private final AdRequestInfoParcel.zza zzCe;
    zzhh zzCf;
    private final zzan zzvA;
    zzdy zzxn;
    private final Object zzBr = new Object();
    Object zzqt = new Object();

    @zzgd
    static final class zza extends Exception {
        private final int zzBv;

        public zza(String str, int i) {
            super(str);
            this.zzBv = i;
        }

        public int getErrorCode() {
            return this.zzBv;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, zza.InterfaceC0017zza interfaceC0017zza) {
        this.zzCd = interfaceC0017zza;
        this.mContext = context;
        this.zzCe = zzaVar;
        this.zzvA = zzanVar;
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzBr) {
            if (this.zzCf != null) {
                this.zzCf.cancel();
            }
        }
    }

    zzhh zzb(AdRequestInfoParcel adRequestInfoParcel) {
        return zzc.zza(this.mContext, adRequestInfoParcel, this);
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Received ad response.");
            this.zzBt = adResponseParcel;
            this.zzqt.notify();
        }
    }

    protected AdSizeParcel zzc(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzBt.zzCN == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzBt.zzCN.split("x");
        if (split.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzBt.zzCN, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzpN.zzso) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = adSizeParcel.width == -1 ? (int) (adSizeParcel.widthPixels / f) : adSizeParcel.width;
                int i2 = adSizeParcel.height == -2 ? (int) (adSizeParcel.heightPixels / f) : adSizeParcel.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzpN.zzso);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzBt.zzCN, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzBt.zzCN, 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095 A[Catch: all -> 0x00ea, TryCatch #4 {, blocks: (B:4:0x0003, B:7:0x0028, B:8:0x0036, B:13:0x003e, B:15:0x0052, B:17:0x0058, B:19:0x00b4, B:27:0x00be, B:22:0x00d0, B:23:0x00e8, B:31:0x00ca, B:35:0x0077, B:40:0x0082, B:41:0x0091, B:43:0x0095, B:44:0x009a, B:45:0x00a7, B:46:0x009d, B:47:0x008a, B:53:0x0074), top: B:3:0x0003, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d A[Catch: all -> 0x00ea, TryCatch #4 {, blocks: (B:4:0x0003, B:7:0x0028, B:8:0x0036, B:13:0x003e, B:15:0x0052, B:17:0x0058, B:19:0x00b4, B:27:0x00be, B:22:0x00d0, B:23:0x00e8, B:31:0x00ca, B:35:0x0077, B:40:0x0082, B:41:0x0091, B:43:0x0095, B:44:0x009a, B:45:0x00a7, B:46:0x009d, B:47:0x008a, B:53:0x0074), top: B:3:0x0003, inners: #3 }] */
    @Override // com.google.android.gms.internal.zzhh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzdP() {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzb.zzdP():void");
    }

    protected boolean zze(long j) throws zza {
        long elapsedRealtime = 60000 - (zzo.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zza("Ad request cancelled.", -1);
        }
    }

    protected void zzfu() throws zza {
        if (this.zzBt.errorCode == -3) {
            return;
        }
        if (TextUtils.isEmpty(this.zzBt.zzCI)) {
            throw new zza("No fill from ad server.", 3);
        }
        zzo.zzby().zza(this.mContext, this.zzBt.zzCu);
        if (this.zzBt.zzCK) {
            try {
                this.zzxn = new zzdy(this.zzBt.zzCI);
            } catch (JSONException e) {
                throw new zza("Could not parse mediation config: " + this.zzBt.zzCI, 0);
            }
        }
    }

    protected void zzi(long j) throws zza {
        while (zze(j)) {
            if (this.zzBt != null) {
                synchronized (this.zzBr) {
                    this.zzCf = null;
                }
                if (this.zzBt.errorCode != -2 && this.zzBt.errorCode != -3) {
                    throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzBt.errorCode, this.zzBt.errorCode);
                }
                return;
            }
        }
        throw new zza("Timed out waiting for ad response.", 2);
    }

    protected void zzw(boolean z) {
        zzo.zzby().zzA(z);
        zzbk zzD = zzo.zzby().zzD(this.mContext);
        if (zzD == null || zzD.isAlive()) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzay("start fetching content...");
        zzD.zzcp();
    }
}
