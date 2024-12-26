package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class zzqh {
    public static final Integer zzaPM = 0;
    public static final Integer zzaPN = 1;
    private final Context mContext;
    private final ExecutorService zzaNb;

    public zzqh(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzqh(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzaNb = executorService;
    }

    private String zzfc(String str) {
        return "resource_" + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [byte[]] */
    private byte[] zzm(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                zzlg.zza((InputStream) inputStream, byteArrayOutputStream);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    com.google.android.gms.tagmanager.zzbg.zzaC("Error closing stream for reading resource from disk");
                    return null;
                }
            } catch (IOException e2) {
                com.google.android.gms.tagmanager.zzbg.zzaC("Failed to read the resource from disk");
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    com.google.android.gms.tagmanager.zzbg.zzaC("Error closing stream for reading resource from disk");
                    return null;
                }
            }
            inputStream = byteArrayOutputStream.toByteArray();
            return inputStream;
        } catch (Throwable th) {
            try {
                inputStream.close();
                throw th;
            } catch (IOException e4) {
                com.google.android.gms.tagmanager.zzbg.zzaC("Error closing stream for reading resource from disk");
                return null;
            }
        }
    }

    public void zza(final String str, final Integer num, final zzqb zzqbVar, final zzqg zzqgVar) {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.internal.zzqh.1
            @Override // java.lang.Runnable
            public void run() {
                zzqh.this.zzb(str, num, zzqbVar, zzqgVar);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void zzb(java.lang.String r8, java.lang.Integer r9, com.google.android.gms.internal.zzqb r10, com.google.android.gms.internal.zzqg r11) {
        /*
            r7 = this;
            java.lang.String r0 = "DiskLoader: Starting to load resource from Disk."
            com.google.android.gms.tagmanager.zzbg.zzaB(r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.io.File r1 = r7.zzfb(r8)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            r0.<init>(r1)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            byte[] r0 = r7.zzm(r0)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.lang.Object r3 = r10.zzt(r0)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            if (r3 == 0) goto L63
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            r0.<init>()     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.lang.String r1 = "Saved resource loaded: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.lang.String r1 = r7.zzfc(r8)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.lang.String r0 = r0.toString()     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            com.google.android.gms.tagmanager.zzbg.zzaB(r0)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.Status.zzXP     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            java.lang.Integer r4 = com.google.android.gms.internal.zzqh.zzaPN     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            long r5 = r7.zzfa(r8)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            r1 = r11
            r1.zza(r2, r3, r4, r5)     // Catch: com.google.android.gms.internal.zzqf.zzg -> L3f java.io.FileNotFoundException -> L48
            return
        L3f:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Saved resource is corrupted: "
            goto L50
        L48:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Saved resource not found: "
        L50:
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r8 = r7.zzfc(r8)
            java.lang.StringBuilder r8 = r0.append(r8)
            java.lang.String r8 = r8.toString()
            com.google.android.gms.tagmanager.zzbg.zzaz(r8)
        L63:
            if (r9 != 0) goto L70
        L65:
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.zzXR
            r3 = 0
            r4 = 0
            r2 = 0
            r0 = r11
            r0.zza(r1, r2, r3, r4)
            return
        L70:
            android.content.Context r8 = r7.mContext     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            android.content.res.Resources r8 = r8.getResources()     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            int r0 = r9.intValue()     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.io.InputStream r8 = r8.openRawResource(r0)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            if (r8 == 0) goto L65
            byte[] r8 = r7.zzm(r8)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.lang.Object r2 = r10.zzt(r8)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            if (r2 == 0) goto L65
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            r8.<init>()     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.lang.String r10 = "Default resource loaded: "
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            android.content.Context r10 = r7.mContext     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            android.content.res.Resources r10 = r10.getResources()     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            int r0 = r9.intValue()     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.lang.String r10 = r10.getResourceEntryName(r0)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.lang.StringBuilder r8 = r8.append(r10)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.lang.String r8 = r8.toString()     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            com.google.android.gms.tagmanager.zzbg.zzaB(r8)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            com.google.android.gms.common.api.Status r1 = com.google.android.gms.common.api.Status.zzXP     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            java.lang.Integer r3 = com.google.android.gms.internal.zzqh.zzaPM     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            r4 = 0
            r0 = r11
            r0.zza(r1, r2, r3, r4)     // Catch: com.google.android.gms.internal.zzqf.zzg -> Lb9 android.content.res.Resources.NotFoundException -> Lc2
            return
        Lb9:
            r8 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "Default resource resource is corrupted: "
            goto Lca
        Lc2:
            r8 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = "Default resource not found. ID: "
        Lca:
            java.lang.StringBuilder r8 = r8.append(r10)
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.google.android.gms.tagmanager.zzbg.zzaz(r8)
            goto L65
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqh.zzb(java.lang.String, java.lang.Integer, com.google.android.gms.internal.zzqb, com.google.android.gms.internal.zzqg):void");
    }

    public void zze(final String str, final byte[] bArr) {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.internal.zzqh.2
            @Override // java.lang.Runnable
            public void run() {
                zzqh.this.zzf(str, bArr);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.IOException] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x002f -> B:7:0x0059). Please report as a decompilation issue!!! */
    void zzf(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File zzfb = zzfb(str);
        try {
            try {
                fileOutputStream = new FileOutputStream(zzfb);
            } catch (FileNotFoundException e) {
                com.google.android.gms.tagmanager.zzbg.zzaz("Error opening resource file for writing");
                return;
            }
        } catch (IOException e2) {
            com.google.android.gms.tagmanager.zzbg.zzaz("Error closing stream for writing resource to disk");
            str = e2;
        }
        try {
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                String str2 = "Resource " + str + " saved on Disk.";
                com.google.android.gms.tagmanager.zzbg.zzaB(str2);
                str = str2;
            } catch (IOException e3) {
                com.google.android.gms.tagmanager.zzbg.zzaz("Error writing resource to disk. Removing resource from disk");
                zzfb.delete();
                fileOutputStream.close();
                String str3 = "Resource " + str + " saved on Disk.";
                com.google.android.gms.tagmanager.zzbg.zzaB(str3);
                str = str3;
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
                com.google.android.gms.tagmanager.zzbg.zzaB("Resource " + str + " saved on Disk.");
            } catch (IOException e4) {
                com.google.android.gms.tagmanager.zzbg.zzaz("Error closing stream for writing resource to disk");
            }
            throw th;
        }
    }

    public long zzfa(String str) {
        File zzfb = zzfb(str);
        if (zzfb.exists()) {
            return zzfb.lastModified();
        }
        return 0L;
    }

    File zzfb(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzfc(str));
    }
}
