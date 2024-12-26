package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzrp {
    final int tag;
    final byte[] zzaWg;

    zzrp(int i, byte[] bArr) {
        this.tag = i;
        this.zzaWg = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrp)) {
            return false;
        }
        zzrp zzrpVar = (zzrp) obj;
        return this.tag == zzrpVar.tag && Arrays.equals(this.zzaWg, zzrpVar.zzaWg);
    }

    public int hashCode() {
        return ((527 + this.tag) * 31) + Arrays.hashCode(this.zzaWg);
    }

    int zzB() {
        return zzrg.zzkO(this.tag) + 0 + this.zzaWg.length;
    }

    void zza(zzrg zzrgVar) throws IOException {
        zzrgVar.zzkN(this.tag);
        zzrgVar.zzD(this.zzaWg);
    }
}
