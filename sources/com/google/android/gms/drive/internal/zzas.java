package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzas extends zzrh<zzas> {
    public long zzafV;
    public long zzafY;

    public zzas() {
        zzpI();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        if (this.zzafY == zzasVar.zzafY && this.zzafV == zzasVar.zzafV) {
            return zza(zzasVar);
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + ((int) (this.zzafY ^ (this.zzafY >>> 32)))) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        return super.zzB() + zzrg.zze(1, this.zzafY) + zzrg.zze(2, this.zzafV);
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        zzrgVar.zzc(1, this.zzafY);
        zzrgVar.zzc(2, this.zzafV);
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public zzas zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int zzBr = zzrfVar.zzBr();
            switch (zzBr) {
                case 0:
                    return this;
                case 8:
                    this.zzafY = zzrfVar.zzBx();
                    break;
                case 16:
                    this.zzafV = zzrfVar.zzBx();
                    break;
                default:
                    if (!zza(zzrfVar, zzBr)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public zzas zzpI() {
        this.zzafY = -1L;
        this.zzafV = -1L;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
