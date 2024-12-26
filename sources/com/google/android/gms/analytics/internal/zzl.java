package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.internal.zzio;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zznx;
import com.google.android.gms.internal.zzny;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class zzl extends zzd {
    private boolean mStarted;
    private final zzj zzKn;
    private final zzah zzKo;
    private final zzag zzKp;
    private final zzi zzKq;
    private long zzKr;
    private final zzt zzKs;
    private final zzt zzKt;
    private final zzaj zzKu;
    private long zzKv;
    private boolean zzKw;

    protected zzl(zzf zzfVar, zzg zzgVar) {
        super(zzfVar);
        com.google.android.gms.common.internal.zzu.zzu(zzgVar);
        this.zzKr = Long.MIN_VALUE;
        this.zzKp = zzgVar.zzk(zzfVar);
        this.zzKn = zzgVar.zzm(zzfVar);
        this.zzKo = zzgVar.zzn(zzfVar);
        this.zzKq = zzgVar.zzo(zzfVar);
        this.zzKu = new zzaj(zzhP());
        this.zzKs = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzl.1
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zziA();
            }
        };
        this.zzKt = new zzt(zzfVar) { // from class: com.google.android.gms.analytics.internal.zzl.2
            @Override // com.google.android.gms.analytics.internal.zzt
            public void run() {
                zzl.this.zziB();
            }
        };
    }

    private void zza(zzh zzhVar, zzny zznyVar) {
        com.google.android.gms.common.internal.zzu.zzu(zzhVar);
        com.google.android.gms.common.internal.zzu.zzu(zznyVar);
        com.google.android.gms.analytics.zza zzaVar = new com.google.android.gms.analytics.zza(zzhM());
        zzaVar.zzaI(zzhVar.zzij());
        zzaVar.enableAdvertisingIdCollection(zzhVar.zzik());
        zzno zzhc = zzaVar.zzhc();
        zzip zzipVar = (zzip) zzhc.zze(zzip.class);
        zzipVar.zzaN("data");
        zzipVar.zzF(true);
        zzhc.zzb(zznyVar);
        zzio zzioVar = (zzio) zzhc.zze(zzio.class);
        zznx zznxVar = (zznx) zzhc.zze(zznx.class);
        for (Map.Entry<String, String> entry : zzhVar.zzn().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("an".equals(key)) {
                zznxVar.setAppName(value);
            } else if ("av".equals(key)) {
                zznxVar.setAppVersion(value);
            } else if ("aid".equals(key)) {
                zznxVar.setAppId(value);
            } else if ("aiid".equals(key)) {
                zznxVar.setAppInstallerId(value);
            } else if ("uid".equals(key)) {
                zzipVar.setUserId(value);
            } else {
                zzioVar.set(key, value);
            }
        }
        zzb("Sending installation campaign to", zzhVar.zzij(), zznyVar);
        zzhc.zzL(zzhU().zzkk());
        zzhc.zzvT();
    }

    private boolean zzba(String str) {
        return getContext().checkCallingOrSelfPermission(str) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zziA() {
        zzb(new zzw() { // from class: com.google.android.gms.analytics.internal.zzl.4
            @Override // com.google.android.gms.analytics.internal.zzw
            public void zzc(Throwable th) {
                zzl.this.zziG();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zziB() {
        try {
            this.zzKn.zzis();
            zziG();
        } catch (SQLiteException e) {
            zzd("Failed to delete stale hits", e);
        }
        this.zzKt.zzt(zzhR().zzjy());
    }

    private boolean zziH() {
        if (this.zzKw) {
            return false;
        }
        return (!zzhR().zziW() || zzhR().zziX()) && zziN() > 0;
    }

    private void zziI() {
        zzv zzhT = zzhT();
        if (zzhT.zzjG() && !zzhT.zzbp()) {
            long zzit = zzit();
            if (zzit == 0 || Math.abs(zzhP().currentTimeMillis() - zzit) > zzhR().zzjg()) {
                return;
            }
            zza("Dispatch alarm scheduled (ms)", Long.valueOf(zzhR().zzjf()));
            zzhT.zzjH();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0026, code lost:
    
        if (r2 > 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zziJ() {
        /*
            r8 = this;
            r8.zziI()
            long r0 = r8.zziN()
            com.google.android.gms.analytics.internal.zzai r2 = r8.zzhU()
            long r2 = r2.zzkm()
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L29
            com.google.android.gms.internal.zzlb r6 = r8.zzhP()
            long r6 = r6.currentTimeMillis()
            long r6 = r6 - r2
            long r2 = java.lang.Math.abs(r6)
            long r2 = r0 - r2
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L29
            goto L35
        L29:
            com.google.android.gms.analytics.internal.zzr r2 = r8.zzhR()
            long r2 = r2.zzjd()
            long r2 = java.lang.Math.min(r2, r0)
        L35:
            java.lang.String r0 = "Dispatch scheduled (ms)"
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
            r8.zza(r0, r1)
            com.google.android.gms.analytics.internal.zzt r0 = r8.zzKs
            boolean r0 = r0.zzbp()
            if (r0 == 0) goto L59
            com.google.android.gms.analytics.internal.zzt r0 = r8.zzKs
            long r0 = r0.zzjD()
            long r2 = r2 + r0
            r0 = 1
            long r0 = java.lang.Math.max(r0, r2)
            com.google.android.gms.analytics.internal.zzt r2 = r8.zzKs
            r2.zzu(r0)
            goto L5e
        L59:
            com.google.android.gms.analytics.internal.zzt r0 = r8.zzKs
            r0.zzt(r2)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzl.zziJ():void");
    }

    private void zziK() {
        zziL();
        zziM();
    }

    private void zziL() {
        if (this.zzKs.zzbp()) {
            zzaT("All hits dispatched or no network/service. Going to power save mode");
        }
        this.zzKs.cancel();
    }

    private void zziM() {
        zzv zzhT = zzhT();
        if (zzhT.zzbp()) {
            zzhT.cancel();
        }
    }

    private void zziy() {
        String str;
        Context context = zzhM().getContext();
        if (!AnalyticsReceiver.zzT(context)) {
            zzaW("AnalyticsReceiver is not registered or is disabled. Register the receiver for reliable dispatching on non-Google Play devices. See http://goo.gl/8Rd3yj for instructions.");
        } else if (!AnalyticsService.zzU(context)) {
            zzaX("AnalyticsService is not registered or is disabled. Analytics service at risk of not starting. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!CampaignTrackingReceiver.zzT(context)) {
            str = "CampaignTrackingReceiver is not registered, not exported or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.";
        } else if (CampaignTrackingService.zzU(context)) {
            return;
        } else {
            str = "CampaignTrackingService is not registered or is disabled. Installation campaign tracking is not possible. See http://goo.gl/8Rd3yj for instructions.";
        }
        zzaW(str);
    }

    protected void onServiceConnected() {
        zzhO();
        if (zzhR().zziW()) {
            return;
        }
        zziD();
    }

    void start() {
        zzia();
        com.google.android.gms.common.internal.zzu.zza(!this.mStarted, "Analytics backend already started");
        this.mStarted = true;
        if (!zzhR().zziW()) {
            zziy();
        }
        zzhS().zze(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzl.3
            @Override // java.lang.Runnable
            public void run() {
                zzl.this.zziz();
            }
        });
    }

    public void zzG(boolean z) {
        zziG();
    }

    public long zza(zzh zzhVar, boolean z) {
        com.google.android.gms.common.internal.zzu.zzu(zzhVar);
        zzia();
        zzhO();
        try {
            try {
                this.zzKn.beginTransaction();
                this.zzKn.zza(zzhVar.zzii(), zzhVar.getClientId());
                long zza = this.zzKn.zza(zzhVar.zzii(), zzhVar.getClientId(), zzhVar.zzij());
                if (z) {
                    zzhVar.zzn(1 + zza);
                } else {
                    zzhVar.zzn(zza);
                }
                this.zzKn.zzb(zzhVar);
                this.zzKn.setTransactionSuccessful();
                return zza;
            } catch (SQLiteException e) {
                zze("Failed to update Analytics property", e);
                try {
                    this.zzKn.endTransaction();
                    return -1L;
                } catch (SQLiteException e2) {
                    zze("Failed to end transaction", e2);
                    return -1L;
                }
            }
        } finally {
            try {
                this.zzKn.endTransaction();
            } catch (SQLiteException e3) {
                zze("Failed to end transaction", e3);
            }
        }
    }

    public void zza(zzab zzabVar) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        zzns.zzhO();
        zzia();
        if (this.zzKw) {
            zzaU("Hit delivery not possible. Missing network permissions. See http://goo.gl/8Rd3yj for instructions");
        } else {
            zza("Delivering hit", zzabVar);
        }
        zzab zzf = zzf(zzabVar);
        zziC();
        if (this.zzKq.zzb(zzf)) {
            zzaU("Hit sent to the device AnalyticsService for delivery");
            return;
        }
        if (zzhR().zziW()) {
            zzhQ().zza(zzf, "Service unavailable on package side");
            return;
        }
        try {
            this.zzKn.zzc(zzf);
            zziG();
        } catch (SQLiteException e) {
            zze("Delivery failed to save hit to a database", e);
            zzhQ().zza(zzf, "deliver: failed to insert hit to database");
        }
    }

    public void zza(final zzw zzwVar, final long j) {
        zzns.zzhO();
        zzia();
        long zzkm = zzhU().zzkm();
        zzb("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(zzkm != 0 ? Math.abs(zzhP().currentTimeMillis() - zzkm) : -1L));
        if (!zzhR().zziW()) {
            zziC();
        }
        try {
            if (zziE()) {
                zzhS().zze(new Runnable() { // from class: com.google.android.gms.analytics.internal.zzl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        zzl.this.zza(zzwVar, j);
                    }
                });
                return;
            }
            zzhU().zzkn();
            zziG();
            if (zzwVar != null) {
                zzwVar.zzc(null);
            }
            if (this.zzKv != j) {
                this.zzKp.zzkf();
            }
        } catch (Throwable th) {
            zze("Local dispatch failed", th);
            zzhU().zzkn();
            zziG();
            if (zzwVar != null) {
                zzwVar.zzc(th);
            }
        }
    }

    public void zzb(zzw zzwVar) {
        zza(zzwVar, this.zzKv);
    }

    public void zzbb(String str) {
        com.google.android.gms.common.internal.zzu.zzcj(str);
        zzhO();
        zzhN();
        zzny zza = zzam.zza(zzhQ(), str);
        if (zza == null) {
            zzd("Parsing failed. Ignoring invalid campaign data", str);
            return;
        }
        String zzko = zzhU().zzko();
        if (str.equals(zzko)) {
            zzaW("Ignoring duplicate install campaign");
            return;
        }
        if (!TextUtils.isEmpty(zzko)) {
            zzd("Ignoring multiple install campaigns. original, new", zzko, str);
            return;
        }
        zzhU().zzbf(str);
        if (zzhU().zzkl().zzv(zzhR().zzjB())) {
            zzd("Campaign received too late, ignoring", zza);
            return;
        }
        zzb("Received installation campaign", zza);
        Iterator<zzh> it = this.zzKn.zzr(0L).iterator();
        while (it.hasNext()) {
            zza(it.next(), zza);
        }
    }

    protected void zzc(zzh zzhVar) {
        zzhO();
        zzb("Sending first hit to property", zzhVar.zzij());
        if (zzhU().zzkl().zzv(zzhR().zzjB())) {
            return;
        }
        String zzko = zzhU().zzko();
        if (TextUtils.isEmpty(zzko)) {
            return;
        }
        zzny zza = zzam.zza(zzhQ(), zzko);
        zzb("Found relevant installation campaign", zza);
        zza(zzhVar, zza);
    }

    zzab zzf(zzab zzabVar) {
        Pair<String, Long> zzks;
        if (!TextUtils.isEmpty(zzabVar.zzka()) || (zzks = zzhU().zzkp().zzks()) == null) {
            return zzabVar;
        }
        String str = ((Long) zzks.second) + ":" + ((String) zzks.first);
        HashMap hashMap = new HashMap(zzabVar.zzn());
        hashMap.put("_m", str);
        return zzab.zza(this, zzabVar, hashMap);
    }

    public void zzhG() {
        zzns.zzhO();
        zzia();
        if (!zzhR().zziW()) {
            zzaT("Delete all hits from local store");
            try {
                this.zzKn.zziq();
                this.zzKn.zzir();
                zziG();
            } catch (SQLiteException e) {
                zzd("Failed to delete hits from store", e);
            }
        }
        zziC();
        if (this.zzKq.zzim()) {
            zzaT("Device service unavailable. Can't clear hits stored on the device service.");
        }
    }

    public void zzhJ() {
        zzns.zzhO();
        zzia();
        zzaT("Service disconnected");
    }

    void zzhL() {
        zzhO();
        this.zzKv = zzhP().currentTimeMillis();
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
        this.zzKn.zza();
        this.zzKo.zza();
        this.zzKq.zza();
    }

    protected void zziC() {
        if (this.zzKw || !zzhR().zziY() || this.zzKq.isConnected()) {
            return;
        }
        if (this.zzKu.zzv(zzhR().zzjt())) {
            this.zzKu.start();
            zzaT("Connecting to service");
            if (this.zzKq.connect()) {
                zzaT("Connected to service");
                this.zzKu.clear();
                onServiceConnected();
            }
        }
    }

    public void zziD() {
        zzns.zzhO();
        zzia();
        zzhN();
        if (!zzhR().zziY()) {
            zzaW("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.zzKq.isConnected()) {
            zzaT("Service not connected");
            return;
        }
        if (this.zzKn.isEmpty()) {
            return;
        }
        zzaT("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                List<zzab> zzp = this.zzKn.zzp(zzhR().zzjh());
                if (zzp.isEmpty()) {
                    zziG();
                    return;
                }
                while (!zzp.isEmpty()) {
                    zzab zzabVar = zzp.get(0);
                    if (!this.zzKq.zzb(zzabVar)) {
                        zziG();
                        return;
                    }
                    zzp.remove(zzabVar);
                    try {
                        this.zzKn.zzq(zzabVar.zzjV());
                    } catch (SQLiteException e) {
                        zze("Failed to remove hit that was send for delivery", e);
                        zziK();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                zze("Failed to read hits from store", e2);
                zziK();
                return;
            }
        }
    }

    protected boolean zziE() {
        zzns.zzhO();
        zzia();
        zzaT("Dispatching a batch of local hits");
        boolean z = (this.zzKq.isConnected() || zzhR().zziW()) ? false : true;
        boolean zzkg = this.zzKo.zzkg();
        if (z && !zzkg) {
            zzaT("No network or service available. Will retry later");
            return false;
        }
        long max = Math.max(zzhR().zzjh(), zzhR().zzji());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        while (true) {
            try {
                this.zzKn.beginTransaction();
                arrayList.clear();
                try {
                    List<zzab> zzp = this.zzKn.zzp(max);
                    if (zzp.isEmpty()) {
                        zzaT("Store is empty, nothing to dispatch");
                        zziK();
                        try {
                            this.zzKn.setTransactionSuccessful();
                            this.zzKn.endTransaction();
                            return false;
                        } catch (SQLiteException e) {
                            zze("Failed to commit local dispatch transaction", e);
                            zziK();
                            return false;
                        }
                    }
                    zza("Hits loaded from store. count", Integer.valueOf(zzp.size()));
                    Iterator<zzab> it = zzp.iterator();
                    while (it.hasNext()) {
                        if (it.next().zzjV() == j) {
                            zzd("Database contains successfully uploaded hit", Long.valueOf(j), Integer.valueOf(zzp.size()));
                            zziK();
                            try {
                                this.zzKn.setTransactionSuccessful();
                                this.zzKn.endTransaction();
                                return false;
                            } catch (SQLiteException e2) {
                                zze("Failed to commit local dispatch transaction", e2);
                                zziK();
                                return false;
                            }
                        }
                    }
                    if (this.zzKq.isConnected() && !zzhR().zziW()) {
                        zzaT("Service connected, sending hits to the service");
                        while (!zzp.isEmpty()) {
                            zzab zzabVar = zzp.get(0);
                            if (!this.zzKq.zzb(zzabVar)) {
                                break;
                            }
                            j = Math.max(j, zzabVar.zzjV());
                            zzp.remove(zzabVar);
                            zzb("Hit sent do device AnalyticsService for delivery", zzabVar);
                            try {
                                this.zzKn.zzq(zzabVar.zzjV());
                                arrayList.add(Long.valueOf(zzabVar.zzjV()));
                            } catch (SQLiteException e3) {
                                zze("Failed to remove hit that was send for delivery", e3);
                                zziK();
                                try {
                                    this.zzKn.setTransactionSuccessful();
                                    this.zzKn.endTransaction();
                                    return false;
                                } catch (SQLiteException e4) {
                                    zze("Failed to commit local dispatch transaction", e4);
                                    zziK();
                                    return false;
                                }
                            }
                        }
                    }
                    if (this.zzKo.zzkg()) {
                        List<Long> zzf = this.zzKo.zzf(zzp);
                        Iterator<Long> it2 = zzf.iterator();
                        while (it2.hasNext()) {
                            j = Math.max(j, it2.next().longValue());
                        }
                        zzp.removeAll(zzf);
                        try {
                            this.zzKn.zzd(zzf);
                            arrayList.addAll(zzf);
                        } catch (SQLiteException e5) {
                            zze("Failed to remove successfully uploaded hits", e5);
                            zziK();
                            try {
                                this.zzKn.setTransactionSuccessful();
                                this.zzKn.endTransaction();
                                return false;
                            } catch (SQLiteException e6) {
                                zze("Failed to commit local dispatch transaction", e6);
                                zziK();
                                return false;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            this.zzKn.setTransactionSuccessful();
                            this.zzKn.endTransaction();
                            return false;
                        } catch (SQLiteException e7) {
                            zze("Failed to commit local dispatch transaction", e7);
                            zziK();
                            return false;
                        }
                    }
                    try {
                        this.zzKn.setTransactionSuccessful();
                        this.zzKn.endTransaction();
                    } catch (SQLiteException e8) {
                        zze("Failed to commit local dispatch transaction", e8);
                        zziK();
                        return false;
                    }
                } catch (SQLiteException e9) {
                    zzd("Failed to read hits from persisted store", e9);
                    zziK();
                    try {
                        this.zzKn.setTransactionSuccessful();
                        this.zzKn.endTransaction();
                        return false;
                    } catch (SQLiteException e10) {
                        zze("Failed to commit local dispatch transaction", e10);
                        zziK();
                        return false;
                    }
                }
            } catch (Throwable th) {
                this.zzKn.setTransactionSuccessful();
                this.zzKn.endTransaction();
                throw th;
            }
            try {
                this.zzKn.setTransactionSuccessful();
                this.zzKn.endTransaction();
                throw th;
            } catch (SQLiteException e11) {
                zze("Failed to commit local dispatch transaction", e11);
                zziK();
                return false;
            }
        }
    }

    public void zziF() {
        zzns.zzhO();
        zzia();
        zzaU("Sync dispatching local hits");
        long j = this.zzKv;
        if (!zzhR().zziW()) {
            zziC();
        }
        do {
            try {
            } catch (Throwable th) {
                zze("Sync local dispatch failed", th);
                zziG();
                return;
            }
        } while (zziE());
        zzhU().zzkn();
        zziG();
        if (this.zzKv != j) {
            this.zzKp.zzkf();
        }
    }

    public void zziG() {
        boolean z;
        zzhM().zzhO();
        zzia();
        if (!zziH() || this.zzKn.isEmpty()) {
            this.zzKp.unregister();
            zziK();
            return;
        }
        if (zzy.zzLI.get().booleanValue()) {
            z = true;
        } else {
            this.zzKp.zzkd();
            z = this.zzKp.isConnected();
        }
        if (z) {
            zziJ();
        } else {
            zziK();
            zziI();
        }
    }

    public long zziN() {
        if (this.zzKr != Long.MIN_VALUE) {
            return this.zzKr;
        }
        return zzhm().zzjQ() ? zzhm().zzkH() * 1000 : zzhR().zzje();
    }

    public void zziO() {
        zzia();
        zzhO();
        this.zzKw = true;
        this.zzKq.disconnect();
        zziG();
    }

    public long zzit() {
        zzns.zzhO();
        zzia();
        try {
            return this.zzKn.zzit();
        } catch (SQLiteException e) {
            zze("Failed to get min/max hit times from local store", e);
            return 0L;
        }
    }

    protected void zziz() {
        zzia();
        zzhU().zzkk();
        if (!zzba("android.permission.ACCESS_NETWORK_STATE")) {
            zzaX("Missing required android.permission.ACCESS_NETWORK_STATE. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zziO();
        }
        if (!zzba("android.permission.INTERNET")) {
            zzaX("Missing required android.permission.INTERNET. Google Analytics disabled. See http://goo.gl/8Rd3yj for instructions");
            zziO();
        }
        if (AnalyticsService.zzU(getContext())) {
            zzaT("AnalyticsService registered in the app manifest and enabled");
        } else if (zzhR().zziW()) {
            zzaX("Device AnalyticsService not registered! Hits will not be delivered reliably.");
        } else {
            zzaW("AnalyticsService not registered in the app manifest. Hits might not be delivered reliably. See http://goo.gl/8Rd3yj for instructions.");
        }
        if (!this.zzKw && !zzhR().zziW() && !this.zzKn.isEmpty()) {
            zziC();
        }
        zziG();
    }

    public void zzs(long j) {
        zzns.zzhO();
        zzia();
        if (j < 0) {
            j = 0;
        }
        this.zzKr = j;
        zziG();
    }
}
