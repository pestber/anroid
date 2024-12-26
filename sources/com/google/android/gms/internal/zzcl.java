package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd;

@zzgd
/* loaded from: classes.dex */
public class zzcl implements NativeAd.Image {
    private final Uri mUri;
    private final zzck zzvI;
    private final Drawable zzvJ;

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|2|3|(6:5|6|7|8|9|10)|16|6|7|8|9|10) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzb.zzb("Failed to get uri.", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzcl(com.google.android.gms.internal.zzck r3) {
        /*
            r2 = this;
            r2.<init>()
            r2.zzvI = r3
            r3 = 0
            com.google.android.gms.internal.zzck r0 = r2.zzvI     // Catch: android.os.RemoteException -> L15
            com.google.android.gms.dynamic.zzd r0 = r0.zzdw()     // Catch: android.os.RemoteException -> L15
            if (r0 == 0) goto L1b
            java.lang.Object r0 = com.google.android.gms.dynamic.zze.zzn(r0)     // Catch: android.os.RemoteException -> L15
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch: android.os.RemoteException -> L15
            goto L1c
        L15:
            r0 = move-exception
            java.lang.String r1 = "Failed to get drawable."
            com.google.android.gms.ads.internal.util.client.zzb.zzb(r1, r0)
        L1b:
            r0 = r3
        L1c:
            r2.zzvJ = r0
            com.google.android.gms.internal.zzck r0 = r2.zzvI     // Catch: android.os.RemoteException -> L25
            android.net.Uri r3 = r0.getUri()     // Catch: android.os.RemoteException -> L25
            goto L2b
        L25:
            r0 = move-exception
            java.lang.String r1 = "Failed to get uri."
            com.google.android.gms.ads.internal.util.client.zzb.zzb(r1, r0)
        L2b:
            r2.mUri = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcl.<init>(com.google.android.gms.internal.zzck):void");
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Drawable getDrawable() {
        return this.zzvJ;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public Uri getUri() {
        return this.mUri;
    }
}
