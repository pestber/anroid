package com.google.android.gms.analytics.internal;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class zzn extends zzd {
    private volatile String zzJd;
    private Future<String> zzKG;

    protected zzn(zzf zzfVar) {
        super(zzfVar);
    }

    private boolean zzg(Context context, String str) {
        com.google.android.gms.common.internal.zzu.zzcj(str);
        com.google.android.gms.common.internal.zzu.zzbZ("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    zza("Storing clientId", str);
                    fileOutputStream = context.openFileOutput("gaClientId", 0);
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream == null) {
                        return true;
                    }
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        zze("Failed to close clientId writing stream", e);
                        return true;
                    }
                } catch (IOException e2) {
                    zze("Error writing to clientId file", e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            zze("Failed to close clientId writing stream", e3);
                        }
                    }
                    return false;
                }
            } catch (FileNotFoundException e4) {
                zze("Error creating clientId file", e4);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e5) {
                        zze("Failed to close clientId writing stream", e5);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zziS() {
        String zziT = zziT();
        try {
            return !zzg(zzhS().getContext(), zziT) ? "0" : zziT;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0081: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:54:0x0081 */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String zzX(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            java.lang.String r2 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.zzu.zzbZ(r2)
            r2 = 0
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.lang.Throwable -> L69 java.io.IOException -> L6b java.io.FileNotFoundException -> L8d
            r4 = 36
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            r6 = 0
            int r4 = r3.read(r5, r6, r4)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            int r7 = r3.available()     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            if (r7 <= 0) goto L33
            java.lang.String r4 = "clientId file seems corrupted, deleting it."
            r8.zzaW(r4)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            r3.close()     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            r9.deleteFile(r0)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            if (r3 == 0) goto L32
            r3.close()     // Catch: java.io.IOException -> L2e
            goto L32
        L2e:
            r9 = move-exception
            r8.zze(r1, r9)
        L32:
            return r2
        L33:
            r7 = 14
            if (r4 >= r7) goto L4d
            java.lang.String r4 = "clientId file is empty, deleting it."
            r8.zzaW(r4)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            r3.close()     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            r9.deleteFile(r0)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r9 = move-exception
            r8.zze(r1, r9)
        L4c:
            return r2
        L4d:
            r3.close()     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            r7.<init>(r5, r6, r4)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            java.lang.String r4 = "Read client id from disk"
            r8.zza(r4, r7)     // Catch: java.io.IOException -> L65 java.io.FileNotFoundException -> L67 java.lang.Throwable -> L80
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r9 = move-exception
            r8.zze(r1, r9)
        L64:
            return r7
        L65:
            r4 = move-exception
            goto L6d
        L67:
            r9 = move-exception
            goto L8f
        L69:
            r9 = move-exception
            goto L82
        L6b:
            r4 = move-exception
            r3 = r2
        L6d:
            java.lang.String r5 = "Error reading client id file, deleting it"
            r8.zze(r5, r4)     // Catch: java.lang.Throwable -> L80
            r9.deleteFile(r0)     // Catch: java.lang.Throwable -> L80
            if (r3 == 0) goto L7f
            r3.close()     // Catch: java.io.IOException -> L7b
            goto L7f
        L7b:
            r9 = move-exception
            r8.zze(r1, r9)
        L7f:
            return r2
        L80:
            r9 = move-exception
            r2 = r3
        L82:
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L88:
            r0 = move-exception
            r8.zze(r1, r0)
        L8c:
            throw r9
        L8d:
            r9 = move-exception
            r3 = r2
        L8f:
            if (r3 == 0) goto L99
            r3.close()     // Catch: java.io.IOException -> L95
            goto L99
        L95:
            r9 = move-exception
            r8.zze(r1, r9)
        L99:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzn.zzX(android.content.Context):java.lang.String");
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x0008, B:7:0x0017, B:15:0x001b, B:16:0x003a, B:18:0x003e, B:19:0x0042, B:9:0x004c, B:10:0x004e, B:22:0x0027, B:23:0x002e, B:25:0x0032), top: B:3:0x0004, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String zziP() {
        /*
            r2 = this;
            r2.zzia()
            monitor-enter(r2)
            java.lang.String r0 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            if (r0 != 0) goto L17
            com.google.android.gms.internal.zzns r0 = r2.zzhS()     // Catch: java.lang.Throwable -> L50
            com.google.android.gms.analytics.internal.zzn$1 r1 = new com.google.android.gms.analytics.internal.zzn$1     // Catch: java.lang.Throwable -> L50
            r1.<init>()     // Catch: java.lang.Throwable -> L50
            java.util.concurrent.Future r0 = r0.zzb(r1)     // Catch: java.lang.Throwable -> L50
            r2.zzKG = r0     // Catch: java.lang.Throwable -> L50
        L17:
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzKG     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L4c
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzKG     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            java.lang.Object r0 = r0.get()     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            r2.zzJd = r0     // Catch: java.util.concurrent.ExecutionException -> L26 java.lang.InterruptedException -> L31 java.lang.Throwable -> L50
            goto L3a
        L26:
            r0 = move-exception
            java.lang.String r1 = "Failed to load or generate client id"
            r2.zze(r1, r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = "0"
        L2e:
            r2.zzJd = r0     // Catch: java.lang.Throwable -> L50
            goto L3a
        L31:
            r0 = move-exception
            java.lang.String r1 = "ClientId loading or generation was interrupted"
            r2.zzd(r1, r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = "0"
            goto L2e
        L3a:
            java.lang.String r0 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            if (r0 != 0) goto L42
            java.lang.String r0 = "0"
            r2.zzJd = r0     // Catch: java.lang.Throwable -> L50
        L42:
            java.lang.String r0 = "Loaded clientId"
            java.lang.String r1 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            r2.zza(r0, r1)     // Catch: java.lang.Throwable -> L50
            r0 = 0
            r2.zzKG = r0     // Catch: java.lang.Throwable -> L50
        L4c:
            java.lang.String r0 = r2.zzJd     // Catch: java.lang.Throwable -> L50
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L50
            return r0
        L50:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L50
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.internal.zzn.zziP():java.lang.String");
    }

    String zziQ() {
        synchronized (this) {
            this.zzJd = null;
            this.zzKG = zzhS().zzb(new Callable<String>() { // from class: com.google.android.gms.analytics.internal.zzn.2
                @Override // java.util.concurrent.Callable
                /* renamed from: zziU, reason: merged with bridge method [inline-methods] */
                public String call() throws Exception {
                    return zzn.this.zziS();
                }
            });
        }
        return zziP();
    }

    String zziR() {
        String zzX = zzX(zzhS().getContext());
        return zzX == null ? zziS() : zzX;
    }

    protected String zziT() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
