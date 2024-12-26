package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrh;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzrh<M extends zzrh<M>> extends zzrn {
    protected zzrj zzaVU;

    @Override // com.google.android.gms.internal.zzrn
    protected int zzB() {
        if (this.zzaVU == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzaVU.size(); i2++) {
            i += this.zzaVU.zzkS(i2).zzB();
        }
        return i;
    }

    protected final int zzBI() {
        if (this.zzaVU == null || this.zzaVU.isEmpty()) {
            return 0;
        }
        return this.zzaVU.hashCode();
    }

    @Override // com.google.android.gms.internal.zzrn
    /* renamed from: zzBJ, reason: merged with bridge method [inline-methods] */
    public M clone() throws CloneNotSupportedException {
        M m = (M) super.clone();
        zzrl.zza(this, m);
        return m;
    }

    public final <T> T zza(zzri<M, T> zzriVar) {
        zzrk zzkR;
        if (this.zzaVU == null || (zzkR = this.zzaVU.zzkR(zzrq.zzkV(zzriVar.tag))) == null) {
            return null;
        }
        return (T) zzkR.zzb(zzriVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        if (this.zzaVU == null) {
            return;
        }
        for (int i = 0; i < this.zzaVU.size(); i++) {
            this.zzaVU.zzkS(i).zza(zzrgVar);
        }
    }

    protected final boolean zza(zzrf zzrfVar, int i) throws IOException {
        zzrk zzkR;
        int position = zzrfVar.getPosition();
        if (!zzrfVar.zzkA(i)) {
            return false;
        }
        int zzkV = zzrq.zzkV(i);
        zzrp zzrpVar = new zzrp(i, zzrfVar.zzx(position, zzrfVar.getPosition() - position));
        if (this.zzaVU == null) {
            this.zzaVU = new zzrj();
            zzkR = null;
        } else {
            zzkR = this.zzaVU.zzkR(zzkV);
        }
        if (zzkR == null) {
            zzkR = new zzrk();
            this.zzaVU.zza(zzkV, zzkR);
        }
        zzkR.zza(zzrpVar);
        return true;
    }

    protected final boolean zza(M m) {
        return (this.zzaVU == null || this.zzaVU.isEmpty()) ? m.zzaVU == null || m.zzaVU.isEmpty() : this.zzaVU.equals(m.zzaVU);
    }
}
