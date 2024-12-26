package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.tagmanager.zzp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

/* loaded from: classes.dex */
class zzcn implements zzp.zzf {
    private final Context mContext;
    private final String zzaKy;
    private zzbf<zzpx.zza> zzaMU;
    private final ExecutorService zzaNb = Executors.newSingleThreadExecutor();

    zzcn(Context context, String str) {
        this.mContext = context;
        this.zzaKy = str;
    }

    private zzqf.zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzaz.zzey(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbg.zzay("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException e2) {
            zzbg.zzaC("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private void zzd(zzpx.zza zzaVar) throws IllegalArgumentException {
        if (zzaVar.zziO == null && zzaVar.zzaPa == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzqf.zzc zzr(byte[] bArr) {
        try {
            zzqf.zzc zzb = zzqf.zzb(zzaf.zzf.zzc(bArr));
            if (zzb != null) {
                zzbg.zzaB("The container was successfully loaded from the resource (using binary file)");
            }
            return zzb;
        } catch (zzqf.zzg e) {
            zzbg.zzaC("The resource file is invalid. The container from the binary file is invalid");
            return null;
        } catch (zzrm e2) {
            zzbg.zzaz("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public synchronized void release() {
        this.zzaNb.shutdown();
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zza(zzbf<zzpx.zza> zzbfVar) {
        this.zzaMU = zzbfVar;
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzb(final zzpx.zza zzaVar) {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.2
            @Override // java.lang.Runnable
            public void run() {
                zzcn.this.zzc(zzaVar);
            }
        });
    }

    boolean zzc(zzpx.zza zzaVar) {
        File zzzo = zzzo();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzzo);
            try {
                try {
                    fileOutputStream.write(zzrn.zzf(zzaVar));
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException e) {
                        zzbg.zzaC("error closing stream for writing resource to disk");
                        return true;
                    }
                } catch (IOException e2) {
                    zzbg.zzaC("Error writing resource to disk. Removing resource from disk.");
                    zzzo.delete();
                    return false;
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zzbg.zzaC("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e4) {
            zzbg.zzaz("Error opening resource file for writing");
            return false;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public zzqf.zzc zziR(int i) {
        StringBuilder append;
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            zzbg.zzaB("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqf.zzc(openRawResource, byteArrayOutputStream);
                zzqf.zzc zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzr(byteArrayOutputStream.toByteArray());
                }
                zzbg.zzaB("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException e) {
                append = new StringBuilder().append("Error reading the default container with resource ID ").append(i).append(" (").append(this.mContext.getResources().getResourceName(i)).append(")");
                zzbg.zzaC(append.toString());
                return null;
            }
        } catch (Resources.NotFoundException e2) {
            append = new StringBuilder().append("Failed to load the container. No default container resource found with the resource ID ").append(i);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzp.zzf
    public void zzyw() {
        this.zzaNb.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzcn.1
            @Override // java.lang.Runnable
            public void run() {
                zzcn.this.zzzn();
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
    
        if (r1 == com.google.android.gms.tagmanager.zzcb.zza.CONTAINER_DEBUG) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008a -> B:12:0x008d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void zzzn() {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r1 = r4.zzaMU
            if (r1 == 0) goto Laa
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r1 = r4.zzaMU
            r1.zzyv()
            java.lang.String r1 = "Attempting to load resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaB(r1)
            com.google.android.gms.tagmanager.zzcb r1 = com.google.android.gms.tagmanager.zzcb.zzzf()
            com.google.android.gms.tagmanager.zzcb$zza r1 = r1.zzzg()
            com.google.android.gms.tagmanager.zzcb$zza r2 = com.google.android.gms.tagmanager.zzcb.zza.CONTAINER
            if (r1 == r2) goto L28
            com.google.android.gms.tagmanager.zzcb r1 = com.google.android.gms.tagmanager.zzcb.zzzf()
            com.google.android.gms.tagmanager.zzcb$zza r1 = r1.zzzg()
            com.google.android.gms.tagmanager.zzcb$zza r2 = com.google.android.gms.tagmanager.zzcb.zza.CONTAINER_DEBUG
            if (r1 != r2) goto L40
        L28:
            java.lang.String r1 = r4.zzaKy
            com.google.android.gms.tagmanager.zzcb r2 = com.google.android.gms.tagmanager.zzcb.zzzf()
            java.lang.String r2 = r2.getContainerId()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L40
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r0 = r4.zzaMU
            com.google.android.gms.tagmanager.zzbf$zza r1 = com.google.android.gms.tagmanager.zzbf.zza.NOT_AVAILABLE
            r0.zza(r1)
            return
        L40:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L9c
            java.io.File r2 = r4.zzzo()     // Catch: java.io.FileNotFoundException -> L9c
            r1.<init>(r2)     // Catch: java.io.FileNotFoundException -> L9c
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            r2.<init>()     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            com.google.android.gms.internal.zzqf.zzc(r1, r2)     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            byte[] r2 = r2.toByteArray()     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            com.google.android.gms.internal.zzpx$zza r2 = com.google.android.gms.internal.zzpx.zza.zzs(r2)     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            r4.zzd(r2)     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r3 = r4.zzaMU     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            r3.zzz(r2)     // Catch: java.lang.Throwable -> L65 java.lang.IllegalArgumentException -> L67 java.io.IOException -> L78
            r1.close()     // Catch: java.io.IOException -> L89
            goto L8d
        L65:
            r2 = move-exception
            goto L93
        L67:
            r2 = move-exception
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r2 = r4.zzaMU     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.tagmanager.zzbf$zza r3 = com.google.android.gms.tagmanager.zzbf.zza.IO_ERROR     // Catch: java.lang.Throwable -> L65
            r2.zza(r3)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "Failed to read the resource from disk. The resource is inconsistent"
            com.google.android.gms.tagmanager.zzbg.zzaC(r2)     // Catch: java.lang.Throwable -> L65
            r1.close()     // Catch: java.io.IOException -> L89
            goto L8d
        L78:
            r2 = move-exception
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r2 = r4.zzaMU     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.tagmanager.zzbf$zza r3 = com.google.android.gms.tagmanager.zzbf.zza.IO_ERROR     // Catch: java.lang.Throwable -> L65
            r2.zza(r3)     // Catch: java.lang.Throwable -> L65
            java.lang.String r2 = "Failed to read the resource from disk"
            com.google.android.gms.tagmanager.zzbg.zzaC(r2)     // Catch: java.lang.Throwable -> L65
            r1.close()     // Catch: java.io.IOException -> L89
            goto L8d
        L89:
            r1 = move-exception
            com.google.android.gms.tagmanager.zzbg.zzaC(r0)
        L8d:
            java.lang.String r0 = "The Disk resource was successfully read."
            com.google.android.gms.tagmanager.zzbg.zzaB(r0)
            return
        L93:
            r1.close()     // Catch: java.io.IOException -> L97
            goto L9b
        L97:
            r1 = move-exception
            com.google.android.gms.tagmanager.zzbg.zzaC(r0)
        L9b:
            throw r2
        L9c:
            r0 = move-exception
            java.lang.String r0 = "Failed to find the resource in the disk"
            com.google.android.gms.tagmanager.zzbg.zzay(r0)
            com.google.android.gms.tagmanager.zzbf<com.google.android.gms.internal.zzpx$zza> r0 = r4.zzaMU
            com.google.android.gms.tagmanager.zzbf$zza r1 = com.google.android.gms.tagmanager.zzbf.zza.NOT_AVAILABLE
            r0.zza(r1)
            return
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Callback must be set before execute"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcn.zzzn():void");
    }

    File zzzo() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzaKy);
    }
}
