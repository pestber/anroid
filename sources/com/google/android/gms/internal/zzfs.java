package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzha;

@zzgd
/* loaded from: classes.dex */
public abstract class zzfs extends zzhh {
    protected final Context mContext;
    protected final zzft.zza zzBq;
    protected final zzha.zza zzBs;
    protected AdResponseParcel zzBt;
    protected final zzid zzoA;
    protected final Object zzqt = new Object();
    protected final Object zzBr = new Object();

    protected static final class zza extends Exception {
        private final int zzBv;

        public zza(String str, int i) {
            super(str);
            this.zzBv = i;
        }

        public int getErrorCode() {
            return this.zzBv;
        }
    }

    protected zzfs(Context context, zzha.zza zzaVar, zzid zzidVar, zzft.zza zzaVar2) {
        this.mContext = context;
        this.zzBs = zzaVar;
        this.zzBt = zzaVar.zzFs;
        this.zzoA = zzidVar;
        this.zzBq = zzaVar2;
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:7:0x0050, B:8:0x005e, B:14:0x0015, B:19:0x0020, B:20:0x002f, B:22:0x0033, B:23:0x0038, B:24:0x0045, B:25:0x003b, B:26:0x0028), top: B:3:0x0003, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000c, B:7:0x0050, B:8:0x005e, B:14:0x0015, B:19:0x0020, B:20:0x002f, B:22:0x0033, B:23:0x0038, B:24:0x0045, B:25:0x003b, B:26:0x0028), top: B:3:0x0003, inners: #1 }] */
    @Override // com.google.android.gms.internal.zzhh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void zzdP() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zzqt
            monitor-enter(r0)
            java.lang.String r1 = "AdRendererBackgroundTask started."
            com.google.android.gms.ads.internal.util.client.zzb.zzay(r1)     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzha$zza r1 = r5.zzBs     // Catch: java.lang.Throwable -> L60
            int r1 = r1.errorCode     // Catch: java.lang.Throwable -> L60
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: com.google.android.gms.internal.zzfs.zza -> L14 java.lang.Throwable -> L60
            r5.zzh(r2)     // Catch: com.google.android.gms.internal.zzfs.zza -> L14 java.lang.Throwable -> L60
            goto L50
        L14:
            r1 = move-exception
            int r2 = r1.getErrorCode()     // Catch: java.lang.Throwable -> L60
            r3 = 3
            if (r2 == r3) goto L28
            r3 = -1
            if (r2 != r3) goto L20
            goto L28
        L20:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r1)     // Catch: java.lang.Throwable -> L60
            goto L2f
        L28:
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.ads.internal.util.client.zzb.zzaA(r1)     // Catch: java.lang.Throwable -> L60
        L2f:
            com.google.android.gms.ads.internal.request.AdResponseParcel r1 = r5.zzBt     // Catch: java.lang.Throwable -> L60
            if (r1 != 0) goto L3b
            com.google.android.gms.ads.internal.request.AdResponseParcel r1 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch: java.lang.Throwable -> L60
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L60
        L38:
            r5.zzBt = r1     // Catch: java.lang.Throwable -> L60
            goto L45
        L3b:
            com.google.android.gms.ads.internal.request.AdResponseParcel r1 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = r5.zzBt     // Catch: java.lang.Throwable -> L60
            long r3 = r3.zzxJ     // Catch: java.lang.Throwable -> L60
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L60
            goto L38
        L45:
            android.os.Handler r1 = com.google.android.gms.internal.zzhl.zzGk     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzfs$1 r3 = new com.google.android.gms.internal.zzfs$1     // Catch: java.lang.Throwable -> L60
            r3.<init>()     // Catch: java.lang.Throwable -> L60
            r1.post(r3)     // Catch: java.lang.Throwable -> L60
            r1 = r2
        L50:
            com.google.android.gms.internal.zzha r1 = r5.zzz(r1)     // Catch: java.lang.Throwable -> L60
            android.os.Handler r2 = com.google.android.gms.internal.zzhl.zzGk     // Catch: java.lang.Throwable -> L60
            com.google.android.gms.internal.zzfs$2 r3 = new com.google.android.gms.internal.zzfs$2     // Catch: java.lang.Throwable -> L60
            r3.<init>()     // Catch: java.lang.Throwable -> L60
            r2.post(r3)     // Catch: java.lang.Throwable -> L60
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
            return
        L60:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L60
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfs.zzdP():void");
    }

    protected abstract void zzh(long j) throws zza;

    protected void zzk(zzha zzhaVar) {
        this.zzBq.zzb(zzhaVar);
    }

    protected zzha zzz(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzBs.zzFr;
        return new zzha(adRequestInfoParcel.zzCm, this.zzoA, this.zzBt.zzxF, i, this.zzBt.zzxG, this.zzBt.zzCM, this.zzBt.orientation, this.zzBt.zzxJ, adRequestInfoParcel.zzCp, this.zzBt.zzCK, null, null, null, null, null, this.zzBt.zzCL, this.zzBs.zzpN, this.zzBt.zzCJ, this.zzBs.zzFo, this.zzBt.zzCO, this.zzBt.zzCP, this.zzBs.zzFl, null, adRequestInfoParcel.zzCC);
    }
}
