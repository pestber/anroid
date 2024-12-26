package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzrd extends zzrh<zzrd> {
    public String[] zzaVE;
    public int[] zzaVF;
    public byte[][] zzaVG;

    public zzrd() {
        zzBq();
    }

    public static zzrd zzx(byte[] bArr) throws zzrm {
        return (zzrd) zzrn.zza(new zzrd(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrd)) {
            return false;
        }
        zzrd zzrdVar = (zzrd) obj;
        if (zzrl.equals(this.zzaVE, zzrdVar.zzaVE) && zzrl.equals(this.zzaVF, zzrdVar.zzaVF) && zzrl.zza(this.zzaVG, zzrdVar.zzaVG)) {
            return zza(zzrdVar);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + zzrl.hashCode(this.zzaVE)) * 31) + zzrl.hashCode(this.zzaVF)) * 31) + zzrl.zza(this.zzaVG)) * 31) + zzBI();
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    protected int zzB() {
        int zzB = super.zzB();
        if (this.zzaVE != null && this.zzaVE.length > 0) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.zzaVE.length; i3++) {
                String str = this.zzaVE[i3];
                if (str != null) {
                    i2++;
                    i += zzrg.zzfj(str);
                }
            }
            zzB = zzB + i + (i2 * 1);
        }
        if (this.zzaVF != null && this.zzaVF.length > 0) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.zzaVF.length; i5++) {
                i4 += zzrg.zzkJ(this.zzaVF[i5]);
            }
            zzB = zzB + i4 + (this.zzaVF.length * 1);
        }
        if (this.zzaVG == null || this.zzaVG.length <= 0) {
            return zzB;
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < this.zzaVG.length; i8++) {
            byte[] bArr = this.zzaVG[i8];
            if (bArr != null) {
                i7++;
                i6 += zzrg.zzC(bArr);
            }
        }
        return zzB + i6 + (i7 * 1);
    }

    public zzrd zzBq() {
        this.zzaVE = zzrq.zzaWm;
        this.zzaVF = zzrq.zzaWh;
        this.zzaVG = zzrq.zzaWn;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
    public void zza(zzrg zzrgVar) throws IOException {
        if (this.zzaVE != null && this.zzaVE.length > 0) {
            for (int i = 0; i < this.zzaVE.length; i++) {
                String str = this.zzaVE[i];
                if (str != null) {
                    zzrgVar.zzb(1, str);
                }
            }
        }
        if (this.zzaVF != null && this.zzaVF.length > 0) {
            for (int i2 = 0; i2 < this.zzaVF.length; i2++) {
                zzrgVar.zzy(2, this.zzaVF[i2]);
            }
        }
        if (this.zzaVG != null && this.zzaVG.length > 0) {
            for (int i3 = 0; i3 < this.zzaVG.length; i3++) {
                byte[] bArr = this.zzaVG[i3];
                if (bArr != null) {
                    zzrgVar.zza(3, bArr);
                }
            }
        }
        super.zza(zzrgVar);
    }

    @Override // com.google.android.gms.internal.zzrn
    /* renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public zzrd zzb(zzrf zzrfVar) throws IOException {
        while (true) {
            int zzBr = zzrfVar.zzBr();
            switch (zzBr) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzrq.zzb(zzrfVar, 10);
                    int length = this.zzaVE == null ? 0 : this.zzaVE.length;
                    int i = zzb + length;
                    String[] strArr = new String[i];
                    if (length != 0) {
                        System.arraycopy(this.zzaVE, 0, strArr, 0, length);
                    }
                    while (length < i - 1) {
                        strArr[length] = zzrfVar.readString();
                        zzrfVar.zzBr();
                        length++;
                    }
                    strArr[length] = zzrfVar.readString();
                    this.zzaVE = strArr;
                    break;
                case 16:
                    int zzb2 = zzrq.zzb(zzrfVar, 16);
                    int length2 = this.zzaVF == null ? 0 : this.zzaVF.length;
                    int i2 = zzb2 + length2;
                    int[] iArr = new int[i2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaVF, 0, iArr, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        iArr[length2] = zzrfVar.zzBu();
                        zzrfVar.zzBr();
                        length2++;
                    }
                    iArr[length2] = zzrfVar.zzBu();
                    this.zzaVF = iArr;
                    break;
                case 18:
                    int zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                    int position = zzrfVar.getPosition();
                    int i3 = 0;
                    while (zzrfVar.zzBD() > 0) {
                        zzrfVar.zzBu();
                        i3++;
                    }
                    zzrfVar.zzkE(position);
                    int length3 = this.zzaVF == null ? 0 : this.zzaVF.length;
                    int i4 = i3 + length3;
                    int[] iArr2 = new int[i4];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaVF, 0, iArr2, 0, length3);
                    }
                    while (length3 < i4) {
                        iArr2[length3] = zzrfVar.zzBu();
                        length3++;
                    }
                    this.zzaVF = iArr2;
                    zzrfVar.zzkD(zzkC);
                    break;
                case 26:
                    int zzb3 = zzrq.zzb(zzrfVar, 26);
                    int length4 = this.zzaVG == null ? 0 : this.zzaVG.length;
                    int i5 = zzb3 + length4;
                    byte[][] bArr = new byte[i5][];
                    if (length4 != 0) {
                        System.arraycopy(this.zzaVG, 0, bArr, 0, length4);
                    }
                    while (length4 < i5 - 1) {
                        bArr[length4] = zzrfVar.readBytes();
                        zzrfVar.zzBr();
                        length4++;
                    }
                    bArr[length4] = zzrfVar.readBytes();
                    this.zzaVG = bArr;
                    break;
                default:
                    if (!zza(zzrfVar, zzBr)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
