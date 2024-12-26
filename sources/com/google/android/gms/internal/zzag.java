package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

/* loaded from: classes.dex */
public interface zzag {

    public static final class zza extends zzrh<zza> {
        private static volatile zza[] zziQ;
        public int type;
        public String zziR;
        public zza[] zziS;
        public zza[] zziT;
        public zza[] zziU;
        public String zziV;
        public String zziW;
        public long zziX;
        public boolean zziY;
        public zza[] zziZ;
        public int[] zzja;
        public boolean zzjb;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zziQ == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziQ == null) {
                        zziQ = new zza[0];
                    }
                }
            }
            return zziQ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.type != zzaVar.type) {
                return false;
            }
            if (this.zziR == null) {
                if (zzaVar.zziR != null) {
                    return false;
                }
            } else if (!this.zziR.equals(zzaVar.zziR)) {
                return false;
            }
            if (!zzrl.equals(this.zziS, zzaVar.zziS) || !zzrl.equals(this.zziT, zzaVar.zziT) || !zzrl.equals(this.zziU, zzaVar.zziU)) {
                return false;
            }
            if (this.zziV == null) {
                if (zzaVar.zziV != null) {
                    return false;
                }
            } else if (!this.zziV.equals(zzaVar.zziV)) {
                return false;
            }
            if (this.zziW == null) {
                if (zzaVar.zziW != null) {
                    return false;
                }
            } else if (!this.zziW.equals(zzaVar.zziW)) {
                return false;
            }
            if (this.zziX == zzaVar.zziX && this.zziY == zzaVar.zziY && zzrl.equals(this.zziZ, zzaVar.zziZ) && zzrl.equals(this.zzja, zzaVar.zzja) && this.zzjb == zzaVar.zzjb) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((527 + this.type) * 31) + (this.zziR == null ? 0 : this.zziR.hashCode())) * 31) + zzrl.hashCode(this.zziS)) * 31) + zzrl.hashCode(this.zziT)) * 31) + zzrl.hashCode(this.zziU)) * 31) + (this.zziV == null ? 0 : this.zziV.hashCode())) * 31) + (this.zziW != null ? this.zziW.hashCode() : 0)) * 31) + ((int) (this.zziX ^ (this.zziX >>> 32)))) * 31) + (this.zziY ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zziZ)) * 31) + zzrl.hashCode(this.zzja)) * 31) + (this.zzjb ? 1231 : 1237)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB() + zzrg.zzA(1, this.type);
            if (!this.zziR.equals("")) {
                zzB += zzrg.zzk(2, this.zziR);
            }
            if (this.zziS != null && this.zziS.length > 0) {
                for (int i = 0; i < this.zziS.length; i++) {
                    zza zzaVar = this.zziS[i];
                    if (zzaVar != null) {
                        zzB += zzrg.zzc(3, zzaVar);
                    }
                }
            }
            if (this.zziT != null && this.zziT.length > 0) {
                for (int i2 = 0; i2 < this.zziT.length; i2++) {
                    zza zzaVar2 = this.zziT[i2];
                    if (zzaVar2 != null) {
                        zzB += zzrg.zzc(4, zzaVar2);
                    }
                }
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (int i3 = 0; i3 < this.zziU.length; i3++) {
                    zza zzaVar3 = this.zziU[i3];
                    if (zzaVar3 != null) {
                        zzB += zzrg.zzc(5, zzaVar3);
                    }
                }
            }
            if (!this.zziV.equals("")) {
                zzB += zzrg.zzk(6, this.zziV);
            }
            if (!this.zziW.equals("")) {
                zzB += zzrg.zzk(7, this.zziW);
            }
            if (this.zziX != 0) {
                zzB += zzrg.zzd(8, this.zziX);
            }
            if (this.zzjb) {
                zzB += zzrg.zzc(9, this.zzjb);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < this.zzja.length; i5++) {
                    i4 += zzrg.zzkJ(this.zzja[i5]);
                }
                zzB = zzB + i4 + (this.zzja.length * 1);
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int i6 = 0; i6 < this.zziZ.length; i6++) {
                    zza zzaVar4 = this.zziZ[i6];
                    if (zzaVar4 != null) {
                        zzB += zzrg.zzc(11, zzaVar4);
                    }
                }
            }
            return this.zziY ? zzB + zzrg.zzc(12, this.zziY) : zzB;
        }

        public zza zzR() {
            this.type = 1;
            this.zziR = "";
            this.zziS = zzQ();
            this.zziT = zzQ();
            this.zziU = zzQ();
            this.zziV = "";
            this.zziW = "";
            this.zziX = 0L;
            this.zziY = false;
            this.zziZ = zzQ();
            this.zzja = zzrq.zzaWh;
            this.zzjb = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzrgVar.zzy(1, this.type);
            if (!this.zziR.equals("")) {
                zzrgVar.zzb(2, this.zziR);
            }
            if (this.zziS != null && this.zziS.length > 0) {
                for (int i = 0; i < this.zziS.length; i++) {
                    zza zzaVar = this.zziS[i];
                    if (zzaVar != null) {
                        zzrgVar.zza(3, zzaVar);
                    }
                }
            }
            if (this.zziT != null && this.zziT.length > 0) {
                for (int i2 = 0; i2 < this.zziT.length; i2++) {
                    zza zzaVar2 = this.zziT[i2];
                    if (zzaVar2 != null) {
                        zzrgVar.zza(4, zzaVar2);
                    }
                }
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (int i3 = 0; i3 < this.zziU.length; i3++) {
                    zza zzaVar3 = this.zziU[i3];
                    if (zzaVar3 != null) {
                        zzrgVar.zza(5, zzaVar3);
                    }
                }
            }
            if (!this.zziV.equals("")) {
                zzrgVar.zzb(6, this.zziV);
            }
            if (!this.zziW.equals("")) {
                zzrgVar.zzb(7, this.zziW);
            }
            if (this.zziX != 0) {
                zzrgVar.zzb(8, this.zziX);
            }
            if (this.zzjb) {
                zzrgVar.zzb(9, this.zzjb);
            }
            if (this.zzja != null && this.zzja.length > 0) {
                for (int i4 = 0; i4 < this.zzja.length; i4++) {
                    zzrgVar.zzy(10, this.zzja[i4]);
                }
            }
            if (this.zziZ != null && this.zziZ.length > 0) {
                for (int i5 = 0; i5 < this.zziZ.length; i5++) {
                    zza zzaVar4 = this.zziZ[i5];
                    if (zzaVar4 != null) {
                        zzrgVar.zza(11, zzaVar4);
                    }
                }
            }
            if (this.zziY) {
                zzrgVar.zzb(12, this.zziY);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        int zzBu = zzrfVar.zzBu();
                        switch (zzBu) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzBu;
                                break;
                        }
                    case 18:
                        this.zziR = zzrfVar.readString();
                        break;
                    case 26:
                        int zzb = zzrq.zzb(zzrfVar, 26);
                        int length = this.zziS == null ? 0 : this.zziS.length;
                        int i = zzb + length;
                        zza[] zzaVarArr = new zza[i];
                        if (length != 0) {
                            System.arraycopy(this.zziS, 0, zzaVarArr, 0, length);
                        }
                        while (length < i - 1) {
                            zzaVarArr[length] = new zza();
                            zzrfVar.zza(zzaVarArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzaVarArr[length] = new zza();
                        zzrfVar.zza(zzaVarArr[length]);
                        this.zziS = zzaVarArr;
                        break;
                    case 34:
                        int zzb2 = zzrq.zzb(zzrfVar, 34);
                        int length2 = this.zziT == null ? 0 : this.zziT.length;
                        int i2 = zzb2 + length2;
                        zza[] zzaVarArr2 = new zza[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.zziT, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            zzaVarArr2[length2] = new zza();
                            zzrfVar.zza(zzaVarArr2[length2]);
                            zzrfVar.zzBr();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zza();
                        zzrfVar.zza(zzaVarArr2[length2]);
                        this.zziT = zzaVarArr2;
                        break;
                    case 42:
                        int zzb3 = zzrq.zzb(zzrfVar, 42);
                        int length3 = this.zziU == null ? 0 : this.zziU.length;
                        int i3 = zzb3 + length3;
                        zza[] zzaVarArr3 = new zza[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.zziU, 0, zzaVarArr3, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            zzaVarArr3[length3] = new zza();
                            zzrfVar.zza(zzaVarArr3[length3]);
                            zzrfVar.zzBr();
                            length3++;
                        }
                        zzaVarArr3[length3] = new zza();
                        zzrfVar.zza(zzaVarArr3[length3]);
                        this.zziU = zzaVarArr3;
                        break;
                    case 50:
                        this.zziV = zzrfVar.readString();
                        break;
                    case 58:
                        this.zziW = zzrfVar.readString();
                        break;
                    case 64:
                        this.zziX = zzrfVar.zzBt();
                        break;
                    case 72:
                        this.zzjb = zzrfVar.zzBv();
                        break;
                    case 80:
                        int zzb4 = zzrq.zzb(zzrfVar, 80);
                        int[] iArr = new int[zzb4];
                        int i4 = 0;
                        for (int i5 = 0; i5 < zzb4; i5++) {
                            if (i5 != 0) {
                                zzrfVar.zzBr();
                            }
                            int zzBu2 = zzrfVar.zzBu();
                            switch (zzBu2) {
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
                                    iArr[i4] = zzBu2;
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 == 0) {
                            break;
                        } else {
                            int length4 = this.zzja == null ? 0 : this.zzja.length;
                            if (length4 != 0 || i4 != zzb4) {
                                int[] iArr2 = new int[length4 + i4];
                                if (length4 != 0) {
                                    System.arraycopy(this.zzja, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i4);
                                this.zzja = iArr2;
                                break;
                            } else {
                                this.zzja = iArr;
                                break;
                            }
                        }
                    case 82:
                        int zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i6 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            switch (zzrfVar.zzBu()) {
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
                                    i6++;
                                    break;
                            }
                        }
                        if (i6 != 0) {
                            zzrfVar.zzkE(position);
                            int length5 = this.zzja == null ? 0 : this.zzja.length;
                            int[] iArr3 = new int[i6 + length5];
                            if (length5 != 0) {
                                System.arraycopy(this.zzja, 0, iArr3, 0, length5);
                            }
                            while (zzrfVar.zzBD() > 0) {
                                int zzBu3 = zzrfVar.zzBu();
                                switch (zzBu3) {
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
                                        iArr3[length5] = zzBu3;
                                        length5++;
                                        break;
                                }
                            }
                            this.zzja = iArr3;
                        }
                        zzrfVar.zzkD(zzkC);
                        break;
                    case 90:
                        int zzb5 = zzrq.zzb(zzrfVar, 90);
                        int length6 = this.zziZ == null ? 0 : this.zziZ.length;
                        int i7 = zzb5 + length6;
                        zza[] zzaVarArr4 = new zza[i7];
                        if (length6 != 0) {
                            System.arraycopy(this.zziZ, 0, zzaVarArr4, 0, length6);
                        }
                        while (length6 < i7 - 1) {
                            zzaVarArr4[length6] = new zza();
                            zzrfVar.zza(zzaVarArr4[length6]);
                            zzrfVar.zzBr();
                            length6++;
                        }
                        zzaVarArr4[length6] = new zza();
                        zzrfVar.zza(zzaVarArr4[length6]);
                        this.zziZ = zzaVarArr4;
                        break;
                    case Place.TYPE_ZOO /* 96 */:
                        this.zziY = zzrfVar.zzBv();
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
}
