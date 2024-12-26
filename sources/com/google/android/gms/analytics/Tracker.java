package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.internal.widget.ActivityChooserView;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznx;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public class Tracker extends zzd {
    private boolean zzIH;
    private final Map<String, String> zzII;
    private final zzad zzIJ;
    private final zza zzIK;
    private ExceptionReporter zzIL;
    private zzal zzIM;
    private final Map<String, String> zzyn;

    private class zza extends zzd implements GoogleAnalytics.zza {
        private boolean zzIV;
        private int zzIW;
        private long zzIX;
        private boolean zzIY;
        private long zzIZ;

        protected zza(zzf zzfVar) {
            super(zzfVar);
            this.zzIX = -1L;
        }

        private void zzhr() {
            if (this.zzIX >= 0 || this.zzIV) {
                zzhg().zza(Tracker.this.zzIK);
            } else {
                zzhg().zzb(Tracker.this.zzIK);
            }
        }

        public void enableAutoActivityTracking(boolean z) {
            this.zzIV = z;
            zzhr();
        }

        public void setSessionTimeout(long j) {
            this.zzIX = j;
            zzhr();
        }

        @Override // com.google.android.gms.analytics.internal.zzd
        protected void zzhn() {
        }

        public synchronized boolean zzhq() {
            boolean z;
            z = this.zzIY;
            this.zzIY = false;
            return z;
        }

        boolean zzhs() {
            return zzhP().elapsedRealtime() >= this.zzIZ + Math.max(1000L, this.zzIX);
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzn(Activity activity) {
            if (this.zzIW == 0 && zzhs()) {
                this.zzIY = true;
            }
            this.zzIW++;
            if (this.zzIV) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    Tracker.this.setCampaignParamsOnNextHit(intent.getData());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                Tracker.this.set("&cd", Tracker.this.zzIM != null ? Tracker.this.zzIM.zzq(activity) : activity.getClass().getCanonicalName());
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    String zzp = Tracker.zzp(activity);
                    if (!TextUtils.isEmpty(zzp)) {
                        hashMap.put("&dr", zzp);
                    }
                }
                Tracker.this.send(hashMap);
            }
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        public void zzo(Activity activity) {
            this.zzIW--;
            this.zzIW = Math.max(0, this.zzIW);
            if (this.zzIW == 0) {
                this.zzIZ = zzhP().elapsedRealtime();
            }
        }
    }

    Tracker(zzf zzfVar, String str, zzad zzadVar) {
        super(zzfVar);
        this.zzyn = new HashMap();
        this.zzII = new HashMap();
        if (str != null) {
            this.zzyn.put("&tid", str);
        }
        this.zzyn.put("useSecure", "1");
        this.zzyn.put("&a", Integer.toString(new Random().nextInt(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        if (zzadVar == null) {
            this.zzIJ = new zzad("tracking");
        } else {
            this.zzIJ = zzadVar;
        }
        this.zzIK = new zza(zzfVar);
    }

    private static void zza(Map<String, String> map, Map<String, String> map2) {
        zzu.zzu(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String zzb = zzb(entry);
            if (zzb != null) {
                map2.put(zzb, entry.getValue());
            }
        }
    }

    private static boolean zza(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        entry.getValue();
        return key.startsWith("&") && key.length() >= 2;
    }

    private static String zzb(Map.Entry<String, String> entry) {
        if (zza(entry)) {
            return entry.getKey().substring(1);
        }
        return null;
    }

    private static void zzb(Map<String, String> map, Map<String, String> map2) {
        zzu.zzu(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String zzb = zzb(entry);
            if (zzb != null && !map2.containsKey(zzb)) {
                map2.put(zzb, entry.getValue());
            }
        }
    }

    private boolean zzho() {
        return this.zzIL != null;
    }

    static String zzp(Activity activity) {
        zzu.zzu(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return stringExtra;
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.zzIH = z;
    }

    public void enableAutoActivityTracking(boolean z) {
        this.zzIK.enableAutoActivityTracking(z);
    }

    public void enableExceptionReporting(boolean z) {
        String str;
        synchronized (this) {
            if (zzho() == z) {
                return;
            }
            if (z) {
                this.zzIL = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), getContext());
                Thread.setDefaultUncaughtExceptionHandler(this.zzIL);
                str = "Uncaught exceptions will be reported to Google Analytics";
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this.zzIL.zzhh());
                str = "Uncaught exceptions will not be reported to Google Analytics";
            }
            zzaT(str);
        }
    }

    public String get(String str) {
        zzia();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.zzyn.containsKey(str)) {
            return this.zzyn.get(str);
        }
        if (str.equals("&ul")) {
            return zzam.zza(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return zzhV().zziP();
        }
        if (str.equals("&sr")) {
            return zzhY().zzjF();
        }
        if (str.equals("&aid")) {
            return zzhX().zzix().zzsK();
        }
        if (str.equals("&an")) {
            return zzhX().zzix().zzjL();
        }
        if (str.equals("&av")) {
            return zzhX().zzix().zzjN();
        }
        if (str.equals("&aiid")) {
            return zzhX().zzix().zzwi();
        }
        return null;
    }

    public void send(Map<String, String> map) {
        final long currentTimeMillis = zzhP().currentTimeMillis();
        if (zzhg().getAppOptOut()) {
            zzaU("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        final boolean isDryRunEnabled = zzhg().isDryRunEnabled();
        final HashMap hashMap = new HashMap();
        zza(this.zzyn, hashMap);
        zza(map, hashMap);
        int i = 1;
        final boolean zze = zzam.zze(this.zzyn.get("useSecure"), true);
        zzb(this.zzII, hashMap);
        this.zzII.clear();
        final String str = hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            zzhQ().zzg(hashMap, "Missing hit type parameter");
            return;
        }
        final String str2 = hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            zzhQ().zzg(hashMap, "Missing tracking id parameter");
            return;
        }
        final boolean zzhp = zzhp();
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.zzyn.get("&a")) + 1;
                if (parseInt < Integer.MAX_VALUE) {
                    i = parseInt;
                }
                this.zzyn.put("&a", Integer.toString(i));
            }
        }
        zzhS().zze(new Runnable() { // from class: com.google.android.gms.analytics.Tracker.1
            @Override // java.lang.Runnable
            public void run() {
                if (Tracker.this.zzIK.zzhq()) {
                    hashMap.put("sc", "start");
                }
                zzam.zzc(hashMap, "cid", Tracker.this.zzhg().getClientId());
                String str3 = (String) hashMap.get("sf");
                if (str3 != null) {
                    double zza2 = zzam.zza(str3, 100.0d);
                    if (zzam.zza(zza2, (String) hashMap.get("cid"))) {
                        Tracker.this.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(zza2));
                        return;
                    }
                }
                com.google.android.gms.analytics.internal.zza zzhW = Tracker.this.zzhW();
                if (zzhp) {
                    zzam.zzb((Map<String, String>) hashMap, "ate", zzhW.zzhy());
                    zzam.zzb((Map<String, String>) hashMap, "adid", zzhW.zzhC());
                } else {
                    hashMap.remove("ate");
                    hashMap.remove("adid");
                }
                zznx zzix = Tracker.this.zzhX().zzix();
                zzam.zzb((Map<String, String>) hashMap, "an", zzix.zzjL());
                zzam.zzb((Map<String, String>) hashMap, "av", zzix.zzjN());
                zzam.zzb((Map<String, String>) hashMap, "aid", zzix.zzsK());
                zzam.zzb((Map<String, String>) hashMap, "aiid", zzix.zzwi());
                hashMap.put("v", "1");
                hashMap.put("_v", zze.zzJB);
                zzam.zzb((Map<String, String>) hashMap, "ul", Tracker.this.zzhY().zzjE().getLanguage());
                zzam.zzb((Map<String, String>) hashMap, "sr", Tracker.this.zzhY().zzjF());
                if (!str.equals("transaction") && !str.equals("item") && !Tracker.this.zzIJ.zzkb()) {
                    Tracker.this.zzhQ().zzg(hashMap, "Too many hits sent too quickly, rate limiting invoked");
                    return;
                }
                long zzbj = zzam.zzbj((String) hashMap.get("ht"));
                if (zzbj == 0) {
                    zzbj = currentTimeMillis;
                }
                long j = zzbj;
                if (isDryRunEnabled) {
                    Tracker.this.zzhQ().zzc("Dry run enabled. Would have sent hit", new zzab(Tracker.this, hashMap, j, zze));
                    return;
                }
                String str4 = (String) hashMap.get("cid");
                HashMap hashMap2 = new HashMap();
                zzam.zza(hashMap2, "uid", (Map<String, String>) hashMap);
                zzam.zza(hashMap2, "an", (Map<String, String>) hashMap);
                zzam.zza(hashMap2, "aid", (Map<String, String>) hashMap);
                zzam.zza(hashMap2, "av", (Map<String, String>) hashMap);
                zzam.zza(hashMap2, "aiid", (Map<String, String>) hashMap);
                hashMap.put("_s", String.valueOf(Tracker.this.zzhl().zza(new zzh(0L, str4, str2, !TextUtils.isEmpty((CharSequence) hashMap.get("adid")), 0L, hashMap2))));
                Tracker.this.zzhl().zza(new zzab(Tracker.this, hashMap, j, zze));
            }
        });
    }

    public void set(String str, String str2) {
        zzu.zzb(str, "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzyn.put(str, str2);
    }

    public void setAnonymizeIp(boolean z) {
        set("&aip", zzam.zzH(z));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter("referrer");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        Uri parse = Uri.parse("http://hostname/?" + queryParameter);
        String queryParameter2 = parse.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.zzII.put("&ci", queryParameter2);
        }
        String queryParameter3 = parse.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.zzII.put("&anid", queryParameter3);
        }
        String queryParameter4 = parse.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.zzII.put("&cn", queryParameter4);
        }
        String queryParameter5 = parse.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.zzII.put("&cc", queryParameter5);
        }
        String queryParameter6 = parse.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.zzII.put("&cm", queryParameter6);
        }
        String queryParameter7 = parse.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.zzII.put("&cs", queryParameter7);
        }
        String queryParameter8 = parse.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.zzII.put("&ck", queryParameter8);
        }
        String queryParameter9 = parse.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.zzII.put("&dclid", queryParameter9);
        }
        String queryParameter10 = parse.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.zzII.put("&gclid", queryParameter10);
        }
        String queryParameter11 = parse.getQueryParameter("aclid");
        if (queryParameter11 != null) {
            this.zzII.put("&aclid", queryParameter11);
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d) {
        set("&sf", Double.toString(d));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i, int i2) {
        if (i >= 0 || i2 >= 0) {
            set("&sr", i + "x" + i2);
        } else {
            zzaW("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long j) {
        this.zzIK.setSessionTimeout(1000 * j);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z) {
        set("useSecure", zzam.zzH(z));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    void zza(zzal zzalVar) {
        zzaT("Loading Tracker config values");
        this.zzIM = zzalVar;
        if (this.zzIM.zzky()) {
            String trackingId = this.zzIM.getTrackingId();
            set("&tid", trackingId);
            zza("trackingId loaded", trackingId);
        }
        if (this.zzIM.zzkz()) {
            String d = Double.toString(this.zzIM.zzkA());
            set("&sf", d);
            zza("Sample frequency loaded", d);
        }
        if (this.zzIM.zzkB()) {
            int sessionTimeout = this.zzIM.getSessionTimeout();
            setSessionTimeout(sessionTimeout);
            zza("Session timeout loaded", Integer.valueOf(sessionTimeout));
        }
        if (this.zzIM.zzkC()) {
            boolean zzkD = this.zzIM.zzkD();
            enableAutoActivityTracking(zzkD);
            zza("Auto activity tracking loaded", Boolean.valueOf(zzkD));
        }
        if (this.zzIM.zzkE()) {
            boolean zzkF = this.zzIM.zzkF();
            if (zzkF) {
                set("&aip", "1");
            }
            zza("Anonymize ip loaded", Boolean.valueOf(zzkF));
        }
        enableExceptionReporting(this.zzIM.zzkG());
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
        this.zzIK.zza();
        String zzjL = zzhm().zzjL();
        if (zzjL != null) {
            set("&an", zzjL);
        }
        String zzjN = zzhm().zzjN();
        if (zzjN != null) {
            set("&av", zzjN);
        }
    }

    boolean zzhp() {
        return this.zzIH;
    }
}
