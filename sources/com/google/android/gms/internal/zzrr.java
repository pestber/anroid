package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public interface zzrr {

    public static final class zza extends zzrh<zza> {
        public String[] zzaWp;
        public String[] zzaWq;
        public int[] zzaWr;
        public int[] zzaWs;

        public zza() {
            zzBW();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (zzrl.equals(this.zzaWp, zzaVar.zzaWp) && zzrl.equals(this.zzaWq, zzaVar.zzaWq) && zzrl.equals(this.zzaWr, zzaVar.zzaWr) && zzrl.equals(this.zzaWs, zzaVar.zzaWs)) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((527 + zzrl.hashCode(this.zzaWp)) * 31) + zzrl.hashCode(this.zzaWq)) * 31) + zzrl.hashCode(this.zzaWr)) * 31) + zzrl.hashCode(this.zzaWs)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaWp != null && this.zzaWp.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzaWp.length; i3++) {
                    String str = this.zzaWp[i3];
                    if (str != null) {
                        i2++;
                        i += zzrg.zzfj(str);
                    }
                }
                zzB = zzB + i + (i2 * 1);
            }
            if (this.zzaWq != null && this.zzaWq.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < this.zzaWq.length; i6++) {
                    String str2 = this.zzaWq[i6];
                    if (str2 != null) {
                        i5++;
                        i4 += zzrg.zzfj(str2);
                    }
                }
                zzB = zzB + i4 + (i5 * 1);
            }
            if (this.zzaWr != null && this.zzaWr.length > 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < this.zzaWr.length; i8++) {
                    i7 += zzrg.zzkJ(this.zzaWr[i8]);
                }
                zzB = zzB + i7 + (this.zzaWr.length * 1);
            }
            if (this.zzaWs == null || this.zzaWs.length <= 0) {
                return zzB;
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.zzaWs.length; i10++) {
                i9 += zzrg.zzkJ(this.zzaWs[i10]);
            }
            return zzB + i9 + (this.zzaWs.length * 1);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzB, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            int zzkC;
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        int zzb = zzrq.zzb(zzrfVar, 10);
                        int length = this.zzaWp == null ? 0 : this.zzaWp.length;
                        int i = zzb + length;
                        String[] strArr = new String[i];
                        if (length != 0) {
                            System.arraycopy(this.zzaWp, 0, strArr, 0, length);
                        }
                        while (length < i - 1) {
                            strArr[length] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length++;
                        }
                        strArr[length] = zzrfVar.readString();
                        this.zzaWp = strArr;
                        continue;
                    case 18:
                        int zzb2 = zzrq.zzb(zzrfVar, 18);
                        int length2 = this.zzaWq == null ? 0 : this.zzaWq.length;
                        int i2 = zzb2 + length2;
                        String[] strArr2 = new String[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaWq, 0, strArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            strArr2[length2] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length2++;
                        }
                        strArr2[length2] = zzrfVar.readString();
                        this.zzaWq = strArr2;
                        continue;
                    case 24:
                        int zzb3 = zzrq.zzb(zzrfVar, 24);
                        int length3 = this.zzaWr == null ? 0 : this.zzaWr.length;
                        int i3 = zzb3 + length3;
                        int[] iArr = new int[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzaWr, 0, iArr, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            iArr[length3] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length3++;
                        }
                        iArr[length3] = zzrfVar.zzBu();
                        this.zzaWr = iArr;
                        continue;
                    case 26:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i4 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i4++;
                        }
                        zzrfVar.zzkE(position);
                        int length4 = this.zzaWr == null ? 0 : this.zzaWr.length;
                        int i5 = i4 + length4;
                        int[] iArr2 = new int[i5];
                        if (length4 != 0) {
                            System.arraycopy(this.zzaWr, 0, iArr2, 0, length4);
                        }
                        while (length4 < i5) {
                            iArr2[length4] = zzrfVar.zzBu();
                            length4++;
                        }
                        this.zzaWr = iArr2;
                        break;
                    case 32:
                        int zzb4 = zzrq.zzb(zzrfVar, 32);
                        int length5 = this.zzaWs == null ? 0 : this.zzaWs.length;
                        int i6 = zzb4 + length5;
                        int[] iArr3 = new int[i6];
                        if (length5 != 0) {
                            System.arraycopy(this.zzaWs, 0, iArr3, 0, length5);
                        }
                        while (length5 < i6 - 1) {
                            iArr3[length5] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length5++;
                        }
                        iArr3[length5] = zzrfVar.zzBu();
                        this.zzaWs = iArr3;
                        continue;
                    case 34:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position2 = zzrfVar.getPosition();
                        int i7 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i7++;
                        }
                        zzrfVar.zzkE(position2);
                        int length6 = this.zzaWs == null ? 0 : this.zzaWs.length;
                        int i8 = i7 + length6;
                        int[] iArr4 = new int[i8];
                        if (length6 != 0) {
                            System.arraycopy(this.zzaWs, 0, iArr4, 0, length6);
                        }
                        while (length6 < i8) {
                            iArr4[length6] = zzrfVar.zzBu();
                            length6++;
                        }
                        this.zzaWs = iArr4;
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        continue;
                }
                zzrfVar.zzkD(zzkC);
            }
        }

        public zza zzBW() {
            this.zzaWp = zzrq.zzaWm;
            this.zzaWq = zzrq.zzaWm;
            this.zzaWr = zzrq.zzaWh;
            this.zzaWs = zzrq.zzaWh;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzaWp != null && this.zzaWp.length > 0) {
                for (int i = 0; i < this.zzaWp.length; i++) {
                    String str = this.zzaWp[i];
                    if (str != null) {
                        zzrgVar.zzb(1, str);
                    }
                }
            }
            if (this.zzaWq != null && this.zzaWq.length > 0) {
                for (int i2 = 0; i2 < this.zzaWq.length; i2++) {
                    String str2 = this.zzaWq[i2];
                    if (str2 != null) {
                        zzrgVar.zzb(2, str2);
                    }
                }
            }
            if (this.zzaWr != null && this.zzaWr.length > 0) {
                for (int i3 = 0; i3 < this.zzaWr.length; i3++) {
                    zzrgVar.zzy(3, this.zzaWr[i3]);
                }
            }
            if (this.zzaWs != null && this.zzaWs.length > 0) {
                for (int i4 = 0; i4 < this.zzaWs.length; i4++) {
                    zzrgVar.zzy(4, this.zzaWs[i4]);
                }
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzb extends zzrh<zzb> {
        public String version;
        public int zzaWt;
        public String zzaWu;

        public zzb() {
            zzBX();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.zzaWt != zzbVar.zzaWt) {
                return false;
            }
            if (this.zzaWu == null) {
                if (zzbVar.zzaWu != null) {
                    return false;
                }
            } else if (!this.zzaWu.equals(zzbVar.zzaWu)) {
                return false;
            }
            if (this.version == null) {
                if (zzbVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzbVar.version)) {
                return false;
            }
            return zza(zzbVar);
        }

        public int hashCode() {
            return ((((((527 + this.zzaWt) * 31) + (this.zzaWu == null ? 0 : this.zzaWu.hashCode())) * 31) + (this.version != null ? this.version.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaWt != 0) {
                zzB += zzrg.zzA(1, this.zzaWt);
            }
            if (!this.zzaWu.equals("")) {
                zzB += zzrg.zzk(2, this.zzaWu);
            }
            return !this.version.equals("") ? zzB + zzrg.zzk(3, this.version) : zzB;
        }

        public zzb zzBX() {
            this.zzaWt = 0;
            this.zzaWu = "";
            this.version = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzC, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        int zzBu = zzrfVar.zzBu();
                        switch (zzBu) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzaWt = zzBu;
                                break;
                        }
                    case 18:
                        this.zzaWu = zzrfVar.readString();
                        break;
                    case 26:
                        this.version = zzrfVar.readString();
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzaWt != 0) {
                zzrgVar.zzy(1, this.zzaWt);
            }
            if (!this.zzaWu.equals("")) {
                zzrgVar.zzb(2, this.zzaWu);
            }
            if (!this.version.equals("")) {
                zzrgVar.zzb(3, this.version);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public byte[] zzaWv;
        public byte[][] zzaWw;
        public boolean zzaWx;

        public zzc() {
            zzBY();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (Arrays.equals(this.zzaWv, zzcVar.zzaWv) && zzrl.zza(this.zzaWw, zzcVar.zzaWw) && this.zzaWx == zzcVar.zzaWx) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + Arrays.hashCode(this.zzaWv)) * 31) + zzrl.zza(this.zzaWw)) * 31) + (this.zzaWx ? 1231 : 1237)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (!Arrays.equals(this.zzaWv, zzrq.zzaWo)) {
                zzB += zzrg.zzb(1, this.zzaWv);
            }
            if (this.zzaWw != null && this.zzaWw.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzaWw.length; i3++) {
                    byte[] bArr = this.zzaWw[i3];
                    if (bArr != null) {
                        i2++;
                        i += zzrg.zzC(bArr);
                    }
                }
                zzB = zzB + i + (i2 * 1);
            }
            return this.zzaWx ? zzB + zzrg.zzc(3, this.zzaWx) : zzB;
        }

        public zzc zzBY() {
            this.zzaWv = zzrq.zzaWo;
            this.zzaWw = zzrq.zzaWn;
            this.zzaWx = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzD, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        this.zzaWv = zzrfVar.readBytes();
                        break;
                    case 18:
                        int zzb = zzrq.zzb(zzrfVar, 18);
                        int length = this.zzaWw == null ? 0 : this.zzaWw.length;
                        int i = zzb + length;
                        byte[][] bArr = new byte[i][];
                        if (length != 0) {
                            System.arraycopy(this.zzaWw, 0, bArr, 0, length);
                        }
                        while (length < i - 1) {
                            bArr[length] = zzrfVar.readBytes();
                            zzrfVar.zzBr();
                            length++;
                        }
                        bArr[length] = zzrfVar.readBytes();
                        this.zzaWw = bArr;
                        break;
                    case 24:
                        this.zzaWx = zzrfVar.zzBv();
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!Arrays.equals(this.zzaWv, zzrq.zzaWo)) {
                zzrgVar.zza(1, this.zzaWv);
            }
            if (this.zzaWw != null && this.zzaWw.length > 0) {
                for (int i = 0; i < this.zzaWw.length; i++) {
                    byte[] bArr = this.zzaWw[i];
                    if (bArr != null) {
                        zzrgVar.zza(2, bArr);
                    }
                }
            }
            if (this.zzaWx) {
                zzrgVar.zzb(3, this.zzaWx);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String tag;
        public int zzaWA;
        public int zzaWB;
        public boolean zzaWC;
        public zze[] zzaWD;
        public zzb zzaWE;
        public byte[] zzaWF;
        public byte[] zzaWG;
        public byte[] zzaWH;
        public zza zzaWI;
        public String zzaWJ;
        public long zzaWK;
        public zzc zzaWL;
        public byte[] zzaWM;
        public long zzaWy;
        public long zzaWz;

        public zzd() {
            zzBZ();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzaWy != zzdVar.zzaWy || this.zzaWz != zzdVar.zzaWz) {
                return false;
            }
            if (this.tag == null) {
                if (zzdVar.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzdVar.tag)) {
                return false;
            }
            if (this.zzaWA != zzdVar.zzaWA || this.zzaWB != zzdVar.zzaWB || this.zzaWC != zzdVar.zzaWC || !zzrl.equals(this.zzaWD, zzdVar.zzaWD)) {
                return false;
            }
            if (this.zzaWE == null) {
                if (zzdVar.zzaWE != null) {
                    return false;
                }
            } else if (!this.zzaWE.equals(zzdVar.zzaWE)) {
                return false;
            }
            if (!Arrays.equals(this.zzaWF, zzdVar.zzaWF) || !Arrays.equals(this.zzaWG, zzdVar.zzaWG) || !Arrays.equals(this.zzaWH, zzdVar.zzaWH)) {
                return false;
            }
            if (this.zzaWI == null) {
                if (zzdVar.zzaWI != null) {
                    return false;
                }
            } else if (!this.zzaWI.equals(zzdVar.zzaWI)) {
                return false;
            }
            if (this.zzaWJ == null) {
                if (zzdVar.zzaWJ != null) {
                    return false;
                }
            } else if (!this.zzaWJ.equals(zzdVar.zzaWJ)) {
                return false;
            }
            if (this.zzaWK != zzdVar.zzaWK) {
                return false;
            }
            if (this.zzaWL == null) {
                if (zzdVar.zzaWL != null) {
                    return false;
                }
            } else if (!this.zzaWL.equals(zzdVar.zzaWL)) {
                return false;
            }
            if (Arrays.equals(this.zzaWM, zzdVar.zzaWM)) {
                return zza(zzdVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((527 + ((int) (this.zzaWy ^ (this.zzaWy >>> 32)))) * 31) + ((int) (this.zzaWz ^ (this.zzaWz >>> 32)))) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + this.zzaWA) * 31) + this.zzaWB) * 31) + (this.zzaWC ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zzaWD)) * 31) + (this.zzaWE == null ? 0 : this.zzaWE.hashCode())) * 31) + Arrays.hashCode(this.zzaWF)) * 31) + Arrays.hashCode(this.zzaWG)) * 31) + Arrays.hashCode(this.zzaWH)) * 31) + (this.zzaWI == null ? 0 : this.zzaWI.hashCode())) * 31) + (this.zzaWJ == null ? 0 : this.zzaWJ.hashCode())) * 31) + ((int) ((this.zzaWK >>> 32) ^ this.zzaWK))) * 31) + (this.zzaWL != null ? this.zzaWL.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzaWM)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzaWy != 0) {
                zzB += zzrg.zzd(1, this.zzaWy);
            }
            if (!this.tag.equals("")) {
                zzB += zzrg.zzk(2, this.tag);
            }
            if (this.zzaWD != null && this.zzaWD.length > 0) {
                for (int i = 0; i < this.zzaWD.length; i++) {
                    zze zzeVar = this.zzaWD[i];
                    if (zzeVar != null) {
                        zzB += zzrg.zzc(3, zzeVar);
                    }
                }
            }
            if (!Arrays.equals(this.zzaWF, zzrq.zzaWo)) {
                zzB += zzrg.zzb(6, this.zzaWF);
            }
            if (this.zzaWI != null) {
                zzB += zzrg.zzc(7, this.zzaWI);
            }
            if (!Arrays.equals(this.zzaWG, zzrq.zzaWo)) {
                zzB += zzrg.zzb(8, this.zzaWG);
            }
            if (this.zzaWE != null) {
                zzB += zzrg.zzc(9, this.zzaWE);
            }
            if (this.zzaWC) {
                zzB += zzrg.zzc(10, this.zzaWC);
            }
            if (this.zzaWA != 0) {
                zzB += zzrg.zzA(11, this.zzaWA);
            }
            if (this.zzaWB != 0) {
                zzB += zzrg.zzA(12, this.zzaWB);
            }
            if (!Arrays.equals(this.zzaWH, zzrq.zzaWo)) {
                zzB += zzrg.zzb(13, this.zzaWH);
            }
            if (!this.zzaWJ.equals("")) {
                zzB += zzrg.zzk(14, this.zzaWJ);
            }
            if (this.zzaWK != 180000) {
                zzB += zzrg.zze(15, this.zzaWK);
            }
            if (this.zzaWL != null) {
                zzB += zzrg.zzc(16, this.zzaWL);
            }
            if (this.zzaWz != 0) {
                zzB += zzrg.zzd(17, this.zzaWz);
            }
            return !Arrays.equals(this.zzaWM, zzrq.zzaWo) ? zzB + zzrg.zzb(18, this.zzaWM) : zzB;
        }

        public zzd zzBZ() {
            this.zzaWy = 0L;
            this.zzaWz = 0L;
            this.tag = "";
            this.zzaWA = 0;
            this.zzaWB = 0;
            this.zzaWC = false;
            this.zzaWD = zze.zzCa();
            this.zzaWE = null;
            this.zzaWF = zzrq.zzaWo;
            this.zzaWG = zzrq.zzaWo;
            this.zzaWH = zzrq.zzaWo;
            this.zzaWI = null;
            this.zzaWJ = "";
            this.zzaWK = 180000L;
            this.zzaWL = null;
            this.zzaWM = zzrq.zzaWo;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzE, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            zzrn zzrnVar;
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        this.zzaWy = zzrfVar.zzBt();
                        continue;
                    case 18:
                        this.tag = zzrfVar.readString();
                        continue;
                    case 26:
                        int zzb = zzrq.zzb(zzrfVar, 26);
                        int length = this.zzaWD == null ? 0 : this.zzaWD.length;
                        int i = zzb + length;
                        zze[] zzeVarArr = new zze[i];
                        if (length != 0) {
                            System.arraycopy(this.zzaWD, 0, zzeVarArr, 0, length);
                        }
                        while (length < i - 1) {
                            zzeVarArr[length] = new zze();
                            zzrfVar.zza(zzeVarArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzeVarArr[length] = new zze();
                        zzrfVar.zza(zzeVarArr[length]);
                        this.zzaWD = zzeVarArr;
                        continue;
                    case 50:
                        this.zzaWF = zzrfVar.readBytes();
                        continue;
                    case 58:
                        if (this.zzaWI == null) {
                            this.zzaWI = new zza();
                        }
                        zzrnVar = this.zzaWI;
                        break;
                    case 66:
                        this.zzaWG = zzrfVar.readBytes();
                        continue;
                    case 74:
                        if (this.zzaWE == null) {
                            this.zzaWE = new zzb();
                        }
                        zzrnVar = this.zzaWE;
                        break;
                    case 80:
                        this.zzaWC = zzrfVar.zzBv();
                        continue;
                    case Place.TYPE_STORE /* 88 */:
                        this.zzaWA = zzrfVar.zzBu();
                        continue;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zzaWB = zzrfVar.zzBu();
                        continue;
                    case 106:
                        this.zzaWH = zzrfVar.readBytes();
                        continue;
                    case 114:
                        this.zzaWJ = zzrfVar.readString();
                        continue;
                    case 120:
                        this.zzaWK = zzrfVar.zzBx();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        if (this.zzaWL == null) {
                            this.zzaWL = new zzc();
                        }
                        zzrnVar = this.zzaWL;
                        break;
                    case 136:
                        this.zzaWz = zzrfVar.zzBt();
                        continue;
                    case 146:
                        this.zzaWM = zzrfVar.readBytes();
                        continue;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        continue;
                }
                zzrfVar.zza(zzrnVar);
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzaWy != 0) {
                zzrgVar.zzb(1, this.zzaWy);
            }
            if (!this.tag.equals("")) {
                zzrgVar.zzb(2, this.tag);
            }
            if (this.zzaWD != null && this.zzaWD.length > 0) {
                for (int i = 0; i < this.zzaWD.length; i++) {
                    zze zzeVar = this.zzaWD[i];
                    if (zzeVar != null) {
                        zzrgVar.zza(3, zzeVar);
                    }
                }
            }
            if (!Arrays.equals(this.zzaWF, zzrq.zzaWo)) {
                zzrgVar.zza(6, this.zzaWF);
            }
            if (this.zzaWI != null) {
                zzrgVar.zza(7, this.zzaWI);
            }
            if (!Arrays.equals(this.zzaWG, zzrq.zzaWo)) {
                zzrgVar.zza(8, this.zzaWG);
            }
            if (this.zzaWE != null) {
                zzrgVar.zza(9, this.zzaWE);
            }
            if (this.zzaWC) {
                zzrgVar.zzb(10, this.zzaWC);
            }
            if (this.zzaWA != 0) {
                zzrgVar.zzy(11, this.zzaWA);
            }
            if (this.zzaWB != 0) {
                zzrgVar.zzy(12, this.zzaWB);
            }
            if (!Arrays.equals(this.zzaWH, zzrq.zzaWo)) {
                zzrgVar.zza(13, this.zzaWH);
            }
            if (!this.zzaWJ.equals("")) {
                zzrgVar.zzb(14, this.zzaWJ);
            }
            if (this.zzaWK != 180000) {
                zzrgVar.zzc(15, this.zzaWK);
            }
            if (this.zzaWL != null) {
                zzrgVar.zza(16, this.zzaWL);
            }
            if (this.zzaWz != 0) {
                zzrgVar.zzb(17, this.zzaWz);
            }
            if (!Arrays.equals(this.zzaWM, zzrq.zzaWo)) {
                zzrgVar.zza(18, this.zzaWM);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zze extends zzrh<zze> {
        private static volatile zze[] zzaWN;
        public String value;
        public String zzaC;

        public zze() {
            zzCb();
        }

        public static zze[] zzCa() {
            if (zzaWN == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzaWN == null) {
                        zzaWN = new zze[0];
                    }
                }
            }
            return zzaWN;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.zzaC == null) {
                if (zzeVar.zzaC != null) {
                    return false;
                }
            } else if (!this.zzaC.equals(zzeVar.zzaC)) {
                return false;
            }
            if (this.value == null) {
                if (zzeVar.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zzeVar.value)) {
                return false;
            }
            return zza(zzeVar);
        }

        public int hashCode() {
            return ((((527 + (this.zzaC == null ? 0 : this.zzaC.hashCode())) * 31) + (this.value != null ? this.value.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (!this.zzaC.equals("")) {
                zzB += zzrg.zzk(1, this.zzaC);
            }
            return !this.value.equals("") ? zzB + zzrg.zzk(2, this.value) : zzB;
        }

        public zze zzCb() {
            this.zzaC = "";
            this.value = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzF, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        this.zzaC = zzrfVar.readString();
                        break;
                    case 18:
                        this.value = zzrfVar.readString();
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.zzaC.equals("")) {
                zzrgVar.zzb(1, this.zzaC);
            }
            if (!this.value.equals("")) {
                zzrgVar.zzb(2, this.value);
            }
            super.zza(zzrgVar);
        }
    }
}
