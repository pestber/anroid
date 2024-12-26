package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzie;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
/* loaded from: classes.dex */
public final class zzgf extends zzi.zza {
    private static zzgf zzDv;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final zzge zzDw;
    private final zzbr zzDx;
    private final zzdt zzqC;

    zzgf(Context context, zzbr zzbrVar, zzge zzgeVar) {
        this.mContext = context;
        this.zzDw = zzgeVar;
        this.zzDx = zzbrVar;
        this.zzqC = new zzdt(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(7571000, 7571000, true), zzbrVar.zzcW(), new zzdt.zzb<zzbb>() { // from class: com.google.android.gms.internal.zzgf.5
            @Override // com.google.android.gms.internal.zzdt.zzb
            /* renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzc(zzbb zzbbVar) {
                zzbbVar.zza("/log", zzdf.zzwc);
            }
        }, new zzdt.zzc());
    }

    private static AdResponseParcel zza(final Context context, final zzdt zzdtVar, final zzbr zzbrVar, zzge zzgeVar, final AdRequestInfoParcel adRequestInfoParcel) {
        zzcd zzcdVar;
        int i;
        int i2;
        String string;
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Starting ad request from service.");
        zzbz.zzw(context);
        final zzce zzceVar = new zzce("load_ad");
        zzcd zzdo = zzceVar.zzdo();
        zzgeVar.zzDs.init();
        zzgk zzC = com.google.android.gms.ads.internal.zzo.zzbB().zzC(context);
        if (zzC.zzEy == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzCE : UUID.randomUUID().toString();
        final zzgh zzghVar = new zzgh(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzCm.extras != null && (string = adRequestInfoParcel.zzCm.extras.getString("_ad")) != null) {
            return zzgg.zza(context, adRequestInfoParcel, string);
        }
        Location zzc = zzgeVar.zzDs.zzc(250L);
        String zzc2 = zzgeVar.zzDt.zzc(context, adRequestInfoParcel.zzCn.packageName);
        JSONObject zza = zzgg.zza(adRequestInfoParcel, zzC, zzc, zzbrVar, zzc2, zzgeVar.zzDu.zzar(adRequestInfoParcel.zzCo), zzgeVar.zzDr.zza(adRequestInfoParcel));
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza.put("request_id", uuid);
            } catch (JSONException e) {
            }
        }
        if (zza == null) {
            return new AdResponseParcel(0);
        }
        final String jSONObject = zza.toString();
        zzceVar.zza(zzdo, "arc");
        final zzcd zzdo2 = zzceVar.zzdo();
        if (zzbz.zztE.get().booleanValue()) {
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzgf.1
                @Override // java.lang.Runnable
                public void run() {
                    zzdt.zzd zzdU = zzdtVar.zzdU();
                    zzghVar.zzb(zzdU);
                    zzceVar.zza(zzdo2, "rwc");
                    final zzcd zzdo3 = zzceVar.zzdo();
                    zzdU.zza(new zzhx.zzc<zzbe>() { // from class: com.google.android.gms.internal.zzgf.1.1
                        @Override // com.google.android.gms.internal.zzhx.zzc
                        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
                        public void zzc(zzbe zzbeVar) {
                            zzceVar.zza(zzdo3, "jsf");
                            zzceVar.zzdp();
                            zzbeVar.zza("/invalidRequest", zzghVar.zzDO);
                            zzbeVar.zza("/loadAdURL", zzghVar.zzDP);
                            try {
                                zzbeVar.zza("AFMA_buildAdURL", jSONObject);
                            } catch (Exception e2) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e2);
                            }
                        }
                    }, new zzhx.zza() { // from class: com.google.android.gms.internal.zzgf.1.2
                        @Override // com.google.android.gms.internal.zzhx.zza
                        public void run() {
                        }
                    });
                }
            });
            zzcdVar = zzdo;
            i = 0;
        } else {
            zzcdVar = zzdo;
            i = 0;
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzgf.2
                @Override // java.lang.Runnable
                public void run() {
                    zzid zza2 = com.google.android.gms.ads.internal.zzo.zzbw().zza(context, new AdSizeParcel(), false, false, null, adRequestInfoParcel.zzpJ);
                    if (com.google.android.gms.ads.internal.zzo.zzby().zzge()) {
                        zza2.getWebView().clearCache(true);
                    }
                    zza2.setWillNotDraw(true);
                    zzghVar.zze(zza2);
                    zzceVar.zza(zzdo2, "rwc");
                    zzie.zza zza3 = zzgf.zza(jSONObject, zzceVar, zzceVar.zzdo());
                    zzie zzgF = zza2.zzgF();
                    zzgF.zza("/invalidRequest", zzghVar.zzDO);
                    zzgF.zza("/loadAdURL", zzghVar.zzDP);
                    zzgF.zza("/log", zzdf.zzwc);
                    zzgF.zza(zza3);
                    com.google.android.gms.ads.internal.util.client.zzb.zzay("Loading the JS library.");
                    zza2.loadUrl(zzbrVar.zzcW());
                }
            });
        }
        try {
            zzgj zzgjVar = zzghVar.zzfE().get(10L, TimeUnit.SECONDS);
            if (zzgjVar == null) {
                return new AdResponseParcel(i);
            }
            if (zzgjVar.getErrorCode() != -2) {
                return new AdResponseParcel(zzgjVar.getErrorCode());
            }
            if (zzceVar.zzds() != null) {
                zzcd zzds = zzceVar.zzds();
                String[] strArr = new String[1];
                strArr[i] = "rur";
                zzceVar.zza(zzds, strArr);
            }
            String zzaq = zzgjVar.zzfI() ? zzgeVar.zzDq.zzaq(adRequestInfoParcel.zzCn.packageName) : null;
            zzcd zzdo3 = zzceVar.zzdo();
            AdResponseParcel zza2 = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzpJ.zzGG, zzgjVar.getUrl(), zzaq, zzc2, zzgjVar);
            if (zza2.zzCW == 1) {
                i2 = 1;
                zzgeVar.zzDt.clearToken(context, adRequestInfoParcel.zzCn.packageName);
            } else {
                i2 = 1;
            }
            String[] strArr2 = new String[i2];
            strArr2[i] = "ufe";
            zzceVar.zza(zzdo3, strArr2);
            String[] strArr3 = new String[i2];
            strArr3[i] = "tts";
            zzceVar.zza(zzcdVar, strArr3);
            if (zzhg.zzfY() != null) {
                zzhg.zzfY().zza(zzceVar);
            }
            return zza2;
        } catch (Exception e2) {
            return new AdResponseParcel(i);
        } finally {
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzgf.3
                @Override // java.lang.Runnable
                public void run() {
                    zzghVar.zzfF();
                    if (zzghVar.zzfD() != null) {
                        zzghVar.zzfD().release();
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Received error HTTP response code: " + r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0132, code lost:
    
        return new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r16, android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.google.android.gms.internal.zzgj r22) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgf.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzgj):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzgf zza(Context context, zzbr zzbrVar, zzge zzgeVar) {
        zzgf zzgfVar;
        synchronized (zzoW) {
            if (zzDv == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzDv = new zzgf(context, zzbrVar, zzgeVar);
            }
            zzgfVar = zzDv;
        }
        return zzgfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzie.zza zza(final String str, final zzce zzceVar, final zzcd zzcdVar) {
        return new zzie.zza() { // from class: com.google.android.gms.internal.zzgf.4
            @Override // com.google.android.gms.internal.zzie.zza
            public void zza(zzid zzidVar, boolean z) {
                zzceVar.zza(zzcdVar, "jsf");
                zzceVar.zzdp();
                zzidVar.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("    " + str3 + ":");
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("      " + it.next());
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Body:");
            if (str2 != null) {
                int i2 = 0;
                while (i2 < Math.min(str2.length(), 100000)) {
                    int i3 = i2 + 1000;
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB(str2.substring(i2, Math.min(str2.length(), i3)));
                    i2 = i3;
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Response Code:\n    " + i + "\n}");
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzi
    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final com.google.android.gms.ads.internal.request.zzj zzjVar) {
        com.google.android.gms.ads.internal.zzo.zzby().zzb(this.mContext, adRequestInfoParcel.zzpJ);
        new zzhh() { // from class: com.google.android.gms.internal.zzgf.6
            @Override // com.google.android.gms.internal.zzhh
            public void onStop() {
                try {
                    zzjVar.zzb(new AdResponseParcel(-1));
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e);
                }
            }

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzgf.this.zze(adRequestInfoParcel);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzo.zzby().zzc((Throwable) e, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzjVar.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        }.zzgi();
    }

    @Override // com.google.android.gms.ads.internal.request.zzi
    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        zzhg.zze(this.mContext, adRequestInfoParcel.zzpJ.zzGG);
        return zza(this.mContext, this.zzqC, this.zzDx, this.zzDw, adRequestInfoParcel);
    }
}
