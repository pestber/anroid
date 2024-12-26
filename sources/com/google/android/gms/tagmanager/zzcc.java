package com.google.android.gms.tagmanager;

/* loaded from: classes.dex */
class zzcc extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.RANDOM.toString();
    private static final String zzaMM = com.google.android.gms.internal.zzae.MIN.toString();
    private static final String zzaMN = com.google.android.gms.internal.zzae.MAX.toString();

    public zzcc() {
        super(ID, new String[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        if (r0 <= r2) goto L17;
     */
    @Override // com.google.android.gms.tagmanager.zzak
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.zzag.zza zzE(java.util.Map<java.lang.String, com.google.android.gms.internal.zzag.zza> r7) {
        /*
            r6 = this;
            java.lang.String r0 = com.google.android.gms.tagmanager.zzcc.zzaMM
            java.lang.Object r0 = r7.get(r0)
            com.google.android.gms.internal.zzag$zza r0 = (com.google.android.gms.internal.zzag.zza) r0
            java.lang.String r1 = com.google.android.gms.tagmanager.zzcc.zzaMN
            java.lang.Object r7 = r7.get(r1)
            com.google.android.gms.internal.zzag$zza r7 = (com.google.android.gms.internal.zzag.zza) r7
            if (r0 == 0) goto L41
            com.google.android.gms.internal.zzag$zza r1 = com.google.android.gms.tagmanager.zzdf.zzzQ()
            if (r0 == r1) goto L41
            if (r7 == 0) goto L41
            com.google.android.gms.internal.zzag$zza r1 = com.google.android.gms.tagmanager.zzdf.zzzQ()
            if (r7 == r1) goto L41
            com.google.android.gms.tagmanager.zzde r0 = com.google.android.gms.tagmanager.zzdf.zzh(r0)
            com.google.android.gms.tagmanager.zzde r7 = com.google.android.gms.tagmanager.zzdf.zzh(r7)
            com.google.android.gms.tagmanager.zzde r1 = com.google.android.gms.tagmanager.zzdf.zzzO()
            if (r0 == r1) goto L41
            com.google.android.gms.tagmanager.zzde r1 = com.google.android.gms.tagmanager.zzdf.zzzO()
            if (r7 == r1) goto L41
            double r0 = r0.doubleValue()
            double r2 = r7.doubleValue()
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 > 0) goto L41
            goto L48
        L41:
            r0 = 0
            r2 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
        L48:
            double r4 = java.lang.Math.random()
            double r2 = r2 - r0
            double r4 = r4 * r2
            double r4 = r4 + r0
            long r0 = java.lang.Math.round(r4)
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            com.google.android.gms.internal.zzag$zza r7 = com.google.android.gms.tagmanager.zzdf.zzI(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzcc.zzE(java.util.Map):com.google.android.gms.internal.zzag$zza");
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
