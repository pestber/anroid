package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@zzgd
/* loaded from: classes.dex */
public class zzdr {
    private static final Set<String> zzwF = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzwG = new DecimalFormat("#,###");
    private zzid zzoA;
    private File zzwH;
    private boolean zzwI;

    public zzdr(zzid zzidVar) {
        this.zzoA = zzidVar;
        File cacheDir = zzidVar.getContext().getCacheDir();
        if (cacheDir == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Context.getCacheDir() returned null");
            return;
        }
        this.zzwH = new File(cacheDir, "admobVideoStreams");
        if (!this.zzwH.isDirectory() && !this.zzwH.mkdirs()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not create preload cache directory at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
        } else {
            if (this.zzwH.setReadable(true, false) && this.zzwH.setExecutable(true, false)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not set cache file permissions at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
        }
    }

    private String zzX(String str) {
        return com.google.android.gms.ads.internal.client.zzk.zzcA().zzax(str);
    }

    private File zza(File file) {
        return new File(this.zzwH, file.getName() + ".done");
    }

    private void zza(final String str, final File file) {
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "precacheCanceled");
                hashMap.put("src", str);
                if (file != null) {
                    hashMap.put("cachedSrc", file.getAbsolutePath());
                }
                zzdr.this.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private void zza(final String str, final File file, final int i) {
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "precacheComplete");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", file.getAbsolutePath());
                hashMap.put("totalBytes", Integer.toString(i));
                zzdr.this.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private void zza(final String str, final File file, final int i, final int i2) {
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "precacheProgress");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", file.getAbsolutePath());
                hashMap.put("bytesLoaded", Integer.toString(i));
                hashMap.put("totalBytes", Integer.toString(i2));
                zzdr.this.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    public void abort() {
        this.zzwI = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x0227, code lost:
    
        r3 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0229, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0231, code lost:
    
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(3) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0233, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Preloaded " + com.google.android.gms.internal.zzdr.zzwG.format(r6) + " bytes from " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x025c, code lost:
    
        r3.setReadable(true, false);
        zzb(r0);
        zza(r24, r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0267, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0269, code lost:
    
        com.google.android.gms.internal.zzdr.zzwF.remove(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x026c, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x026d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x027f, code lost:
    
        r6 = r0;
        r4 = r3;
        r3 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x026f, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0274, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean zzW(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdr.zzW(java.lang.String):boolean");
    }

    public int zzdQ() {
        if (this.zzwH == null) {
            return 0;
        }
        int i = 0;
        for (File file : this.zzwH.listFiles()) {
            if (!file.getName().endsWith(".done")) {
                i++;
            }
        }
        return i;
    }

    public boolean zzdR() {
        if (this.zzwH == null) {
            return false;
        }
        File file = null;
        long j = Long.MAX_VALUE;
        for (File file2 : this.zzwH.listFiles()) {
            if (!file2.getName().endsWith(".done")) {
                long lastModified = file2.lastModified();
                if (lastModified < j) {
                    file = file2;
                    j = lastModified;
                }
            }
        }
        if (file == null) {
            return false;
        }
        boolean delete = file.delete();
        File zza = zza(file);
        return zza.isFile() ? delete & zza.delete() : delete;
    }
}
