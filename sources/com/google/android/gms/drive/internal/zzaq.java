package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzaq extends zzrh<zzaq> {
    public int versionCode;
    public long zzafU;
    public long zzafV;
    public long zzafW;

    public zzaq() {
        zzpG();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaq)) {
            return false;
        }
        zzaq zzaqVar = (zzaq) obj;
        if (this.versionCode == zzaqVar.versionCode && this.zzafU == zzaqVar.zzafU && this.zzafV == zzaqVar.zzafV && this.zzafW == zzaqVar.zzafW) {
            return zza(zzaqVar);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.versionCode) * 31) + ((int) (this.zzafU ^ (this.zzafU >>> 32)))) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + ((int) (this.zzafW ^ (this.zzafW >>> 32)))) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        return super.zzB() + zzrg.zzA(1, this.versionCode) + zzrg.zze(2, this.zzafU) + zzrg.zze(3, this.zzafV) + zzrg.zze(4, this.zzafW);
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        zzrgVar.zzy(1, this.versionCode);
        zzrgVar.zzc(2, this.zzafU);
        zzrgVar.zzc(3, this.zzafV);
        zzrgVar.zzc(4, this.zzafW);
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public zzaq zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int zzBr = zzrfVar.zzBr();
            switch (zzBr) {
                case 0:
                    return this;
                case 8:
                    this.versionCode = zzrfVar.zzBu();
                    break;
                case 16:
                    this.zzafU = zzrfVar.zzBx();
                    break;
                case 24:
                    this.zzafV = zzrfVar.zzBx();
                    break;
                case 32:
                    this.zzafW = zzrfVar.zzBx();
                    break;
                default:
                    if (!zza(zzrfVar, zzBr)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public zzaq zzpG() {
        this.versionCode = 1;
        this.zzafU = -1L;
        this.zzafV = -1L;
        this.zzafW = -1L;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
