package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.zzag;
import java.io.IOException;

/* loaded from: classes.dex */
public interface zzaf {

    public static final class zza extends zzrh<zza> {
        public int level;
        public int zzhK;
        public int zzhL;

        public zza() {
            zzA();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (this.level == zzaVar.level && this.zzhK == zzaVar.zzhK && this.zzhL == zzaVar.zzhL) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + this.level) * 31) + this.zzhK) * 31) + this.zzhL) * 31) + zzBI();
        }

        public zza zzA() {
            this.level = 1;
            this.zzhK = 0;
            this.zzhL = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.level != 1) {
                zzB += zzrg.zzA(1, this.level);
            }
            if (this.zzhK != 0) {
                zzB += zzrg.zzA(2, this.zzhK);
            }
            return this.zzhL != 0 ? zzB + zzrg.zzA(3, this.zzhL) : zzB;
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
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
                                this.level = zzBu;
                                break;
                        }
                    case 16:
                        this.zzhK = zzrfVar.zzBu();
                        break;
                    case 24:
                        this.zzhL = zzrfVar.zzBu();
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
            if (this.level != 1) {
                zzrgVar.zzy(1, this.level);
            }
            if (this.zzhK != 0) {
                zzrgVar.zzy(2, this.zzhK);
            }
            if (this.zzhL != 0) {
                zzrgVar.zzy(3, this.zzhL);
            }
            super.zza(zzrgVar);
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzhM;
        public int name;
        public int[] zzhN;
        public int zzhO;
        public boolean zzhP;
        public boolean zzhQ;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzhM == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhM == null) {
                        zzhM = new zzb[0];
                    }
                }
            }
            return zzhM;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (zzrl.equals(this.zzhN, zzbVar.zzhN) && this.zzhO == zzbVar.zzhO && this.name == zzbVar.name && this.zzhP == zzbVar.zzhP && this.zzhQ == zzbVar.zzhQ) {
                return zza(zzbVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((527 + zzrl.hashCode(this.zzhN)) * 31) + this.zzhO) * 31) + this.name) * 31) + (this.zzhP ? 1231 : 1237)) * 31) + (this.zzhQ ? 1231 : 1237)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzhQ) {
                zzB += zzrg.zzc(1, this.zzhQ);
            }
            int zzA = zzB + zzrg.zzA(2, this.zzhO);
            if (this.zzhN != null && this.zzhN.length > 0) {
                int i = 0;
                for (int i2 = 0; i2 < this.zzhN.length; i2++) {
                    i += zzrg.zzkJ(this.zzhN[i2]);
                }
                zzA = zzA + i + (this.zzhN.length * 1);
            }
            if (this.name != 0) {
                zzA += zzrg.zzA(4, this.name);
            }
            return this.zzhP ? zzA + zzrg.zzc(6, this.zzhP) : zzA;
        }

        public zzb zzD() {
            this.zzhN = zzrq.zzaWh;
            this.zzhO = 0;
            this.name = 0;
            this.zzhP = false;
            this.zzhQ = false;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzhQ) {
                zzrgVar.zzb(1, this.zzhQ);
            }
            zzrgVar.zzy(2, this.zzhO);
            if (this.zzhN != null && this.zzhN.length > 0) {
                for (int i = 0; i < this.zzhN.length; i++) {
                    zzrgVar.zzy(3, this.zzhN[i]);
                }
            }
            if (this.name != 0) {
                zzrgVar.zzy(4, this.name);
            }
            if (this.zzhP) {
                zzrgVar.zzb(6, this.zzhP);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        this.zzhQ = zzrfVar.zzBv();
                        break;
                    case 16:
                        this.zzhO = zzrfVar.zzBu();
                        break;
                    case 24:
                        int zzb = zzrq.zzb(zzrfVar, 24);
                        int length = this.zzhN == null ? 0 : this.zzhN.length;
                        int i = zzb + length;
                        int[] iArr = new int[i];
                        if (length != 0) {
                            System.arraycopy(this.zzhN, 0, iArr, 0, length);
                        }
                        while (length < i - 1) {
                            iArr[length] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length++;
                        }
                        iArr[length] = zzrfVar.zzBu();
                        this.zzhN = iArr;
                        break;
                    case 26:
                        int zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i2 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i2++;
                        }
                        zzrfVar.zzkE(position);
                        int length2 = this.zzhN == null ? 0 : this.zzhN.length;
                        int i3 = i2 + length2;
                        int[] iArr2 = new int[i3];
                        if (length2 != 0) {
                            System.arraycopy(this.zzhN, 0, iArr2, 0, length2);
                        }
                        while (length2 < i3) {
                            iArr2[length2] = zzrfVar.zzBu();
                            length2++;
                        }
                        this.zzhN = iArr2;
                        zzrfVar.zzkD(zzkC);
                        break;
                    case 32:
                        this.name = zzrfVar.zzBu();
                        break;
                    case 48:
                        this.zzhP = zzrfVar.zzBv();
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

    public static final class zzc extends zzrh<zzc> {
        private static volatile zzc[] zzhR;
        public String zzaC;
        public long zzhS;
        public long zzhT;
        public boolean zzhU;
        public long zzhV;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzhR == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhR == null) {
                        zzhR = new zzc[0];
                    }
                }
            }
            return zzhR;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.zzaC == null) {
                if (zzcVar.zzaC != null) {
                    return false;
                }
            } else if (!this.zzaC.equals(zzcVar.zzaC)) {
                return false;
            }
            if (this.zzhS == zzcVar.zzhS && this.zzhT == zzcVar.zzhT && this.zzhU == zzcVar.zzhU && this.zzhV == zzcVar.zzhV) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((527 + (this.zzaC == null ? 0 : this.zzaC.hashCode())) * 31) + ((int) (this.zzhS ^ (this.zzhS >>> 32)))) * 31) + ((int) (this.zzhT ^ (this.zzhT >>> 32)))) * 31) + (this.zzhU ? 1231 : 1237)) * 31) + ((int) (this.zzhV ^ (this.zzhV >>> 32)))) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (!this.zzaC.equals("")) {
                zzB += zzrg.zzk(1, this.zzaC);
            }
            if (this.zzhS != 0) {
                zzB += zzrg.zzd(2, this.zzhS);
            }
            if (this.zzhT != 2147483647L) {
                zzB += zzrg.zzd(3, this.zzhT);
            }
            if (this.zzhU) {
                zzB += zzrg.zzc(4, this.zzhU);
            }
            return this.zzhV != 0 ? zzB + zzrg.zzd(5, this.zzhV) : zzB;
        }

        public zzc zzF() {
            this.zzaC = "";
            this.zzhS = 0L;
            this.zzhT = 2147483647L;
            this.zzhU = false;
            this.zzhV = 0L;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.zzaC.equals("")) {
                zzrgVar.zzb(1, this.zzaC);
            }
            if (this.zzhS != 0) {
                zzrgVar.zzb(2, this.zzhS);
            }
            if (this.zzhT != 2147483647L) {
                zzrgVar.zzb(3, this.zzhT);
            }
            if (this.zzhU) {
                zzrgVar.zzb(4, this.zzhU);
            }
            if (this.zzhV != 0) {
                zzrgVar.zzb(5, this.zzhV);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        this.zzaC = zzrfVar.readString();
                        break;
                    case 16:
                        this.zzhS = zzrfVar.zzBt();
                        break;
                    case 24:
                        this.zzhT = zzrfVar.zzBt();
                        break;
                    case 32:
                        this.zzhU = zzrfVar.zzBv();
                        break;
                    case 40:
                        this.zzhV = zzrfVar.zzBt();
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

    public static final class zzd extends zzrh<zzd> {
        public zzag.zza[] zzhW;
        public zzag.zza[] zzhX;
        public zzc[] zzhY;

        public zzd() {
            zzG();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (zzrl.equals(this.zzhW, zzdVar.zzhW) && zzrl.equals(this.zzhX, zzdVar.zzhX) && zzrl.equals(this.zzhY, zzdVar.zzhY)) {
                return zza(zzdVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((527 + zzrl.hashCode(this.zzhW)) * 31) + zzrl.hashCode(this.zzhX)) * 31) + zzrl.hashCode(this.zzhY)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzhW != null && this.zzhW.length > 0) {
                for (int i = 0; i < this.zzhW.length; i++) {
                    zzag.zza zzaVar = this.zzhW[i];
                    if (zzaVar != null) {
                        zzB += zzrg.zzc(1, zzaVar);
                    }
                }
            }
            if (this.zzhX != null && this.zzhX.length > 0) {
                for (int i2 = 0; i2 < this.zzhX.length; i2++) {
                    zzag.zza zzaVar2 = this.zzhX[i2];
                    if (zzaVar2 != null) {
                        zzB += zzrg.zzc(2, zzaVar2);
                    }
                }
            }
            if (this.zzhY != null && this.zzhY.length > 0) {
                for (int i3 = 0; i3 < this.zzhY.length; i3++) {
                    zzc zzcVar = this.zzhY[i3];
                    if (zzcVar != null) {
                        zzB += zzrg.zzc(3, zzcVar);
                    }
                }
            }
            return zzB;
        }

        public zzd zzG() {
            this.zzhW = zzag.zza.zzQ();
            this.zzhX = zzag.zza.zzQ();
            this.zzhY = zzc.zzE();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzhW != null && this.zzhW.length > 0) {
                for (int i = 0; i < this.zzhW.length; i++) {
                    zzag.zza zzaVar = this.zzhW[i];
                    if (zzaVar != null) {
                        zzrgVar.zza(1, zzaVar);
                    }
                }
            }
            if (this.zzhX != null && this.zzhX.length > 0) {
                for (int i2 = 0; i2 < this.zzhX.length; i2++) {
                    zzag.zza zzaVar2 = this.zzhX[i2];
                    if (zzaVar2 != null) {
                        zzrgVar.zza(2, zzaVar2);
                    }
                }
            }
            if (this.zzhY != null && this.zzhY.length > 0) {
                for (int i3 = 0; i3 < this.zzhY.length; i3++) {
                    zzc zzcVar = this.zzhY[i3];
                    if (zzcVar != null) {
                        zzrgVar.zza(3, zzcVar);
                    }
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        int zzb = zzrq.zzb(zzrfVar, 10);
                        int length = this.zzhW == null ? 0 : this.zzhW.length;
                        int i = zzb + length;
                        zzag.zza[] zzaVarArr = new zzag.zza[i];
                        if (length != 0) {
                            System.arraycopy(this.zzhW, 0, zzaVarArr, 0, length);
                        }
                        while (length < i - 1) {
                            zzaVarArr[length] = new zzag.zza();
                            zzrfVar.zza(zzaVarArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzaVarArr[length] = new zzag.zza();
                        zzrfVar.zza(zzaVarArr[length]);
                        this.zzhW = zzaVarArr;
                        break;
                    case 18:
                        int zzb2 = zzrq.zzb(zzrfVar, 18);
                        int length2 = this.zzhX == null ? 0 : this.zzhX.length;
                        int i2 = zzb2 + length2;
                        zzag.zza[] zzaVarArr2 = new zzag.zza[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzhX, 0, zzaVarArr2, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            zzaVarArr2[length2] = new zzag.zza();
                            zzrfVar.zza(zzaVarArr2[length2]);
                            zzrfVar.zzBr();
                            length2++;
                        }
                        zzaVarArr2[length2] = new zzag.zza();
                        zzrfVar.zza(zzaVarArr2[length2]);
                        this.zzhX = zzaVarArr2;
                        break;
                    case 26:
                        int zzb3 = zzrq.zzb(zzrfVar, 26);
                        int length3 = this.zzhY == null ? 0 : this.zzhY.length;
                        int i3 = zzb3 + length3;
                        zzc[] zzcVarArr = new zzc[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzhY, 0, zzcVarArr, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            zzcVarArr[length3] = new zzc();
                            zzrfVar.zza(zzcVarArr[length3]);
                            zzrfVar.zzBr();
                            length3++;
                        }
                        zzcVarArr[length3] = new zzc();
                        zzrfVar.zza(zzcVarArr[length3]);
                        this.zzhY = zzcVarArr;
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

    public static final class zze extends zzrh<zze> {
        private static volatile zze[] zzhZ;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zzhZ == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzhZ == null) {
                        zzhZ = new zze[0];
                    }
                }
            }
            return zzhZ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zzeVar = (zze) obj;
            if (this.key == zzeVar.key && this.value == zzeVar.value) {
                return zza(zzeVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.key) * 31) + this.value) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            return super.zzB() + zzrg.zzA(1, this.key) + zzrg.zzA(2, this.value);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            zzrgVar.zzy(1, this.key);
            zzrgVar.zzy(2, this.value);
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zze zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        this.key = zzrfVar.zzBu();
                        break;
                    case 16:
                        this.value = zzrfVar.zzBu();
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

    public static final class zzf extends zzrh<zzf> {
        public String version;
        public String[] zzia;
        public String[] zzib;
        public zzag.zza[] zzic;
        public zze[] zzid;
        public zzb[] zzie;
        public zzb[] zzif;
        public zzb[] zzig;
        public zzg[] zzih;
        public String zzii;
        public String zzij;
        public String zzik;
        public zza zzil;
        public float zzim;
        public boolean zzin;
        public String[] zzio;
        public int zzip;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zzrm {
            return (zzf) zzrn.zza(new zzf(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzfVar = (zzf) obj;
            if (!zzrl.equals(this.zzia, zzfVar.zzia) || !zzrl.equals(this.zzib, zzfVar.zzib) || !zzrl.equals(this.zzic, zzfVar.zzic) || !zzrl.equals(this.zzid, zzfVar.zzid) || !zzrl.equals(this.zzie, zzfVar.zzie) || !zzrl.equals(this.zzif, zzfVar.zzif) || !zzrl.equals(this.zzig, zzfVar.zzig) || !zzrl.equals(this.zzih, zzfVar.zzih)) {
                return false;
            }
            if (this.zzii == null) {
                if (zzfVar.zzii != null) {
                    return false;
                }
            } else if (!this.zzii.equals(zzfVar.zzii)) {
                return false;
            }
            if (this.zzij == null) {
                if (zzfVar.zzij != null) {
                    return false;
                }
            } else if (!this.zzij.equals(zzfVar.zzij)) {
                return false;
            }
            if (this.zzik == null) {
                if (zzfVar.zzik != null) {
                    return false;
                }
            } else if (!this.zzik.equals(zzfVar.zzik)) {
                return false;
            }
            if (this.version == null) {
                if (zzfVar.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzfVar.version)) {
                return false;
            }
            if (this.zzil == null) {
                if (zzfVar.zzil != null) {
                    return false;
                }
            } else if (!this.zzil.equals(zzfVar.zzil)) {
                return false;
            }
            if (Float.floatToIntBits(this.zzim) == Float.floatToIntBits(zzfVar.zzim) && this.zzin == zzfVar.zzin && zzrl.equals(this.zzio, zzfVar.zzio) && this.zzip == zzfVar.zzip) {
                return zza(zzfVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((((((((((((((527 + zzrl.hashCode(this.zzia)) * 31) + zzrl.hashCode(this.zzib)) * 31) + zzrl.hashCode(this.zzic)) * 31) + zzrl.hashCode(this.zzid)) * 31) + zzrl.hashCode(this.zzie)) * 31) + zzrl.hashCode(this.zzif)) * 31) + zzrl.hashCode(this.zzig)) * 31) + zzrl.hashCode(this.zzih)) * 31) + (this.zzii == null ? 0 : this.zzii.hashCode())) * 31) + (this.zzij == null ? 0 : this.zzij.hashCode())) * 31) + (this.zzik == null ? 0 : this.zzik.hashCode())) * 31) + (this.version == null ? 0 : this.version.hashCode())) * 31) + (this.zzil != null ? this.zzil.hashCode() : 0)) * 31) + Float.floatToIntBits(this.zzim)) * 31) + (this.zzin ? 1231 : 1237)) * 31) + zzrl.hashCode(this.zzio)) * 31) + this.zzip) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzib != null && this.zzib.length > 0) {
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < this.zzib.length; i3++) {
                    String str = this.zzib[i3];
                    if (str != null) {
                        i2++;
                        i += zzrg.zzfj(str);
                    }
                }
                zzB = zzB + i + (i2 * 1);
            }
            if (this.zzic != null && this.zzic.length > 0) {
                for (int i4 = 0; i4 < this.zzic.length; i4++) {
                    zzag.zza zzaVar = this.zzic[i4];
                    if (zzaVar != null) {
                        zzB += zzrg.zzc(2, zzaVar);
                    }
                }
            }
            if (this.zzid != null && this.zzid.length > 0) {
                for (int i5 = 0; i5 < this.zzid.length; i5++) {
                    zze zzeVar = this.zzid[i5];
                    if (zzeVar != null) {
                        zzB += zzrg.zzc(3, zzeVar);
                    }
                }
            }
            if (this.zzie != null && this.zzie.length > 0) {
                for (int i6 = 0; i6 < this.zzie.length; i6++) {
                    zzb zzbVar = this.zzie[i6];
                    if (zzbVar != null) {
                        zzB += zzrg.zzc(4, zzbVar);
                    }
                }
            }
            if (this.zzif != null && this.zzif.length > 0) {
                for (int i7 = 0; i7 < this.zzif.length; i7++) {
                    zzb zzbVar2 = this.zzif[i7];
                    if (zzbVar2 != null) {
                        zzB += zzrg.zzc(5, zzbVar2);
                    }
                }
            }
            if (this.zzig != null && this.zzig.length > 0) {
                for (int i8 = 0; i8 < this.zzig.length; i8++) {
                    zzb zzbVar3 = this.zzig[i8];
                    if (zzbVar3 != null) {
                        zzB += zzrg.zzc(6, zzbVar3);
                    }
                }
            }
            if (this.zzih != null && this.zzih.length > 0) {
                for (int i9 = 0; i9 < this.zzih.length; i9++) {
                    zzg zzgVar = this.zzih[i9];
                    if (zzgVar != null) {
                        zzB += zzrg.zzc(7, zzgVar);
                    }
                }
            }
            if (!this.zzii.equals("")) {
                zzB += zzrg.zzk(9, this.zzii);
            }
            if (!this.zzij.equals("")) {
                zzB += zzrg.zzk(10, this.zzij);
            }
            if (!this.zzik.equals("0")) {
                zzB += zzrg.zzk(12, this.zzik);
            }
            if (!this.version.equals("")) {
                zzB += zzrg.zzk(13, this.version);
            }
            if (this.zzil != null) {
                zzB += zzrg.zzc(14, this.zzil);
            }
            if (Float.floatToIntBits(this.zzim) != Float.floatToIntBits(0.0f)) {
                zzB += zzrg.zzc(15, this.zzim);
            }
            if (this.zzio != null && this.zzio.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < this.zzio.length; i12++) {
                    String str2 = this.zzio[i12];
                    if (str2 != null) {
                        i11++;
                        i10 += zzrg.zzfj(str2);
                    }
                }
                zzB = zzB + i10 + (i11 * 2);
            }
            if (this.zzip != 0) {
                zzB += zzrg.zzA(17, this.zzip);
            }
            if (this.zzin) {
                zzB += zzrg.zzc(18, this.zzin);
            }
            if (this.zzia == null || this.zzia.length <= 0) {
                return zzB;
            }
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < this.zzia.length; i15++) {
                String str3 = this.zzia[i15];
                if (str3 != null) {
                    i14++;
                    i13 += zzrg.zzfj(str3);
                }
            }
            return zzB + i13 + (i14 * 2);
        }

        public zzf zzJ() {
            this.zzia = zzrq.zzaWm;
            this.zzib = zzrq.zzaWm;
            this.zzic = zzag.zza.zzQ();
            this.zzid = zze.zzH();
            this.zzie = zzb.zzC();
            this.zzif = zzb.zzC();
            this.zzig = zzb.zzC();
            this.zzih = zzg.zzK();
            this.zzii = "";
            this.zzij = "";
            this.zzik = "0";
            this.version = "";
            this.zzil = null;
            this.zzim = 0.0f;
            this.zzin = false;
            this.zzio = zzrq.zzaWm;
            this.zzip = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzib != null && this.zzib.length > 0) {
                for (int i = 0; i < this.zzib.length; i++) {
                    String str = this.zzib[i];
                    if (str != null) {
                        zzrgVar.zzb(1, str);
                    }
                }
            }
            if (this.zzic != null && this.zzic.length > 0) {
                for (int i2 = 0; i2 < this.zzic.length; i2++) {
                    zzag.zza zzaVar = this.zzic[i2];
                    if (zzaVar != null) {
                        zzrgVar.zza(2, zzaVar);
                    }
                }
            }
            if (this.zzid != null && this.zzid.length > 0) {
                for (int i3 = 0; i3 < this.zzid.length; i3++) {
                    zze zzeVar = this.zzid[i3];
                    if (zzeVar != null) {
                        zzrgVar.zza(3, zzeVar);
                    }
                }
            }
            if (this.zzie != null && this.zzie.length > 0) {
                for (int i4 = 0; i4 < this.zzie.length; i4++) {
                    zzb zzbVar = this.zzie[i4];
                    if (zzbVar != null) {
                        zzrgVar.zza(4, zzbVar);
                    }
                }
            }
            if (this.zzif != null && this.zzif.length > 0) {
                for (int i5 = 0; i5 < this.zzif.length; i5++) {
                    zzb zzbVar2 = this.zzif[i5];
                    if (zzbVar2 != null) {
                        zzrgVar.zza(5, zzbVar2);
                    }
                }
            }
            if (this.zzig != null && this.zzig.length > 0) {
                for (int i6 = 0; i6 < this.zzig.length; i6++) {
                    zzb zzbVar3 = this.zzig[i6];
                    if (zzbVar3 != null) {
                        zzrgVar.zza(6, zzbVar3);
                    }
                }
            }
            if (this.zzih != null && this.zzih.length > 0) {
                for (int i7 = 0; i7 < this.zzih.length; i7++) {
                    zzg zzgVar = this.zzih[i7];
                    if (zzgVar != null) {
                        zzrgVar.zza(7, zzgVar);
                    }
                }
            }
            if (!this.zzii.equals("")) {
                zzrgVar.zzb(9, this.zzii);
            }
            if (!this.zzij.equals("")) {
                zzrgVar.zzb(10, this.zzij);
            }
            if (!this.zzik.equals("0")) {
                zzrgVar.zzb(12, this.zzik);
            }
            if (!this.version.equals("")) {
                zzrgVar.zzb(13, this.version);
            }
            if (this.zzil != null) {
                zzrgVar.zza(14, this.zzil);
            }
            if (Float.floatToIntBits(this.zzim) != Float.floatToIntBits(0.0f)) {
                zzrgVar.zzb(15, this.zzim);
            }
            if (this.zzio != null && this.zzio.length > 0) {
                for (int i8 = 0; i8 < this.zzio.length; i8++) {
                    String str2 = this.zzio[i8];
                    if (str2 != null) {
                        zzrgVar.zzb(16, str2);
                    }
                }
            }
            if (this.zzip != 0) {
                zzrgVar.zzy(17, this.zzip);
            }
            if (this.zzin) {
                zzrgVar.zzb(18, this.zzin);
            }
            if (this.zzia != null && this.zzia.length > 0) {
                for (int i9 = 0; i9 < this.zzia.length; i9++) {
                    String str3 = this.zzia[i9];
                    if (str3 != null) {
                        zzrgVar.zzb(19, str3);
                    }
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public zzf zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        int zzb = zzrq.zzb(zzrfVar, 10);
                        int length = this.zzib == null ? 0 : this.zzib.length;
                        int i = zzb + length;
                        String[] strArr = new String[i];
                        if (length != 0) {
                            System.arraycopy(this.zzib, 0, strArr, 0, length);
                        }
                        while (length < i - 1) {
                            strArr[length] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length++;
                        }
                        strArr[length] = zzrfVar.readString();
                        this.zzib = strArr;
                        break;
                    case 18:
                        int zzb2 = zzrq.zzb(zzrfVar, 18);
                        int length2 = this.zzic == null ? 0 : this.zzic.length;
                        int i2 = zzb2 + length2;
                        zzag.zza[] zzaVarArr = new zzag.zza[i2];
                        if (length2 != 0) {
                            System.arraycopy(this.zzic, 0, zzaVarArr, 0, length2);
                        }
                        while (length2 < i2 - 1) {
                            zzaVarArr[length2] = new zzag.zza();
                            zzrfVar.zza(zzaVarArr[length2]);
                            zzrfVar.zzBr();
                            length2++;
                        }
                        zzaVarArr[length2] = new zzag.zza();
                        zzrfVar.zza(zzaVarArr[length2]);
                        this.zzic = zzaVarArr;
                        break;
                    case 26:
                        int zzb3 = zzrq.zzb(zzrfVar, 26);
                        int length3 = this.zzid == null ? 0 : this.zzid.length;
                        int i3 = zzb3 + length3;
                        zze[] zzeVarArr = new zze[i3];
                        if (length3 != 0) {
                            System.arraycopy(this.zzid, 0, zzeVarArr, 0, length3);
                        }
                        while (length3 < i3 - 1) {
                            zzeVarArr[length3] = new zze();
                            zzrfVar.zza(zzeVarArr[length3]);
                            zzrfVar.zzBr();
                            length3++;
                        }
                        zzeVarArr[length3] = new zze();
                        zzrfVar.zza(zzeVarArr[length3]);
                        this.zzid = zzeVarArr;
                        break;
                    case 34:
                        int zzb4 = zzrq.zzb(zzrfVar, 34);
                        int length4 = this.zzie == null ? 0 : this.zzie.length;
                        int i4 = zzb4 + length4;
                        zzb[] zzbVarArr = new zzb[i4];
                        if (length4 != 0) {
                            System.arraycopy(this.zzie, 0, zzbVarArr, 0, length4);
                        }
                        while (length4 < i4 - 1) {
                            zzbVarArr[length4] = new zzb();
                            zzrfVar.zza(zzbVarArr[length4]);
                            zzrfVar.zzBr();
                            length4++;
                        }
                        zzbVarArr[length4] = new zzb();
                        zzrfVar.zza(zzbVarArr[length4]);
                        this.zzie = zzbVarArr;
                        break;
                    case 42:
                        int zzb5 = zzrq.zzb(zzrfVar, 42);
                        int length5 = this.zzif == null ? 0 : this.zzif.length;
                        int i5 = zzb5 + length5;
                        zzb[] zzbVarArr2 = new zzb[i5];
                        if (length5 != 0) {
                            System.arraycopy(this.zzif, 0, zzbVarArr2, 0, length5);
                        }
                        while (length5 < i5 - 1) {
                            zzbVarArr2[length5] = new zzb();
                            zzrfVar.zza(zzbVarArr2[length5]);
                            zzrfVar.zzBr();
                            length5++;
                        }
                        zzbVarArr2[length5] = new zzb();
                        zzrfVar.zza(zzbVarArr2[length5]);
                        this.zzif = zzbVarArr2;
                        break;
                    case 50:
                        int zzb6 = zzrq.zzb(zzrfVar, 50);
                        int length6 = this.zzig == null ? 0 : this.zzig.length;
                        int i6 = zzb6 + length6;
                        zzb[] zzbVarArr3 = new zzb[i6];
                        if (length6 != 0) {
                            System.arraycopy(this.zzig, 0, zzbVarArr3, 0, length6);
                        }
                        while (length6 < i6 - 1) {
                            zzbVarArr3[length6] = new zzb();
                            zzrfVar.zza(zzbVarArr3[length6]);
                            zzrfVar.zzBr();
                            length6++;
                        }
                        zzbVarArr3[length6] = new zzb();
                        zzrfVar.zza(zzbVarArr3[length6]);
                        this.zzig = zzbVarArr3;
                        break;
                    case 58:
                        int zzb7 = zzrq.zzb(zzrfVar, 58);
                        int length7 = this.zzih == null ? 0 : this.zzih.length;
                        int i7 = zzb7 + length7;
                        zzg[] zzgVarArr = new zzg[i7];
                        if (length7 != 0) {
                            System.arraycopy(this.zzih, 0, zzgVarArr, 0, length7);
                        }
                        while (length7 < i7 - 1) {
                            zzgVarArr[length7] = new zzg();
                            zzrfVar.zza(zzgVarArr[length7]);
                            zzrfVar.zzBr();
                            length7++;
                        }
                        zzgVarArr[length7] = new zzg();
                        zzrfVar.zza(zzgVarArr[length7]);
                        this.zzih = zzgVarArr;
                        break;
                    case 74:
                        this.zzii = zzrfVar.readString();
                        break;
                    case 82:
                        this.zzij = zzrfVar.readString();
                        break;
                    case 98:
                        this.zzik = zzrfVar.readString();
                        break;
                    case 106:
                        this.version = zzrfVar.readString();
                        break;
                    case 114:
                        if (this.zzil == null) {
                            this.zzil = new zza();
                        }
                        zzrfVar.zza(this.zzil);
                        break;
                    case 125:
                        this.zzim = zzrfVar.readFloat();
                        break;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                        int zzb8 = zzrq.zzb(zzrfVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.zzio == null ? 0 : this.zzio.length;
                        int i8 = zzb8 + length8;
                        String[] strArr2 = new String[i8];
                        if (length8 != 0) {
                            System.arraycopy(this.zzio, 0, strArr2, 0, length8);
                        }
                        while (length8 < i8 - 1) {
                            strArr2[length8] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length8++;
                        }
                        strArr2[length8] = zzrfVar.readString();
                        this.zzio = strArr2;
                        break;
                    case 136:
                        this.zzip = zzrfVar.zzBu();
                        break;
                    case 144:
                        this.zzin = zzrfVar.zzBv();
                        break;
                    case 154:
                        int zzb9 = zzrq.zzb(zzrfVar, 154);
                        int length9 = this.zzia == null ? 0 : this.zzia.length;
                        int i9 = zzb9 + length9;
                        String[] strArr3 = new String[i9];
                        if (length9 != 0) {
                            System.arraycopy(this.zzia, 0, strArr3, 0, length9);
                        }
                        while (length9 < i9 - 1) {
                            strArr3[length9] = zzrfVar.readString();
                            zzrfVar.zzBr();
                            length9++;
                        }
                        strArr3[length9] = zzrfVar.readString();
                        this.zzia = strArr3;
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

    public static final class zzg extends zzrh<zzg> {
        private static volatile zzg[] zziq;
        public int[] zziA;
        public int[] zzir;
        public int[] zzis;
        public int[] zzit;
        public int[] zziu;
        public int[] zziv;
        public int[] zziw;
        public int[] zzix;
        public int[] zziy;
        public int[] zziz;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziq == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziq == null) {
                        zziq = new zzg[0];
                    }
                }
            }
            return zziq;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzgVar = (zzg) obj;
            if (zzrl.equals(this.zzir, zzgVar.zzir) && zzrl.equals(this.zzis, zzgVar.zzis) && zzrl.equals(this.zzit, zzgVar.zzit) && zzrl.equals(this.zziu, zzgVar.zziu) && zzrl.equals(this.zziv, zzgVar.zziv) && zzrl.equals(this.zziw, zzgVar.zziw) && zzrl.equals(this.zzix, zzgVar.zzix) && zzrl.equals(this.zziy, zzgVar.zziy) && zzrl.equals(this.zziz, zzgVar.zziz) && zzrl.equals(this.zziA, zzgVar.zziA)) {
                return zza(zzgVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((527 + zzrl.hashCode(this.zzir)) * 31) + zzrl.hashCode(this.zzis)) * 31) + zzrl.hashCode(this.zzit)) * 31) + zzrl.hashCode(this.zziu)) * 31) + zzrl.hashCode(this.zziv)) * 31) + zzrl.hashCode(this.zziw)) * 31) + zzrl.hashCode(this.zzix)) * 31) + zzrl.hashCode(this.zziy)) * 31) + zzrl.hashCode(this.zziz)) * 31) + zzrl.hashCode(this.zziA)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzir != null && this.zzir.length > 0) {
                int i = 0;
                for (int i2 = 0; i2 < this.zzir.length; i2++) {
                    i += zzrg.zzkJ(this.zzir[i2]);
                }
                zzB = zzB + i + (this.zzir.length * 1);
            }
            if (this.zzis != null && this.zzis.length > 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.zzis.length; i4++) {
                    i3 += zzrg.zzkJ(this.zzis[i4]);
                }
                zzB = zzB + i3 + (this.zzis.length * 1);
            }
            if (this.zzit != null && this.zzit.length > 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < this.zzit.length; i6++) {
                    i5 += zzrg.zzkJ(this.zzit[i6]);
                }
                zzB = zzB + i5 + (this.zzit.length * 1);
            }
            if (this.zziu != null && this.zziu.length > 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < this.zziu.length; i8++) {
                    i7 += zzrg.zzkJ(this.zziu[i8]);
                }
                zzB = zzB + i7 + (this.zziu.length * 1);
            }
            if (this.zziv != null && this.zziv.length > 0) {
                int i9 = 0;
                for (int i10 = 0; i10 < this.zziv.length; i10++) {
                    i9 += zzrg.zzkJ(this.zziv[i10]);
                }
                zzB = zzB + i9 + (this.zziv.length * 1);
            }
            if (this.zziw != null && this.zziw.length > 0) {
                int i11 = 0;
                for (int i12 = 0; i12 < this.zziw.length; i12++) {
                    i11 += zzrg.zzkJ(this.zziw[i12]);
                }
                zzB = zzB + i11 + (this.zziw.length * 1);
            }
            if (this.zzix != null && this.zzix.length > 0) {
                int i13 = 0;
                for (int i14 = 0; i14 < this.zzix.length; i14++) {
                    i13 += zzrg.zzkJ(this.zzix[i14]);
                }
                zzB = zzB + i13 + (this.zzix.length * 1);
            }
            if (this.zziy != null && this.zziy.length > 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < this.zziy.length; i16++) {
                    i15 += zzrg.zzkJ(this.zziy[i16]);
                }
                zzB = zzB + i15 + (this.zziy.length * 1);
            }
            if (this.zziz != null && this.zziz.length > 0) {
                int i17 = 0;
                for (int i18 = 0; i18 < this.zziz.length; i18++) {
                    i17 += zzrg.zzkJ(this.zziz[i18]);
                }
                zzB = zzB + i17 + (this.zziz.length * 1);
            }
            if (this.zziA == null || this.zziA.length <= 0) {
                return zzB;
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.zziA.length; i20++) {
                i19 += zzrg.zzkJ(this.zziA[i20]);
            }
            return zzB + i19 + (this.zziA.length * 1);
        }

        public zzg zzL() {
            this.zzir = zzrq.zzaWh;
            this.zzis = zzrq.zzaWh;
            this.zzit = zzrq.zzaWh;
            this.zziu = zzrq.zzaWh;
            this.zziv = zzrq.zzaWh;
            this.zziw = zzrq.zzaWh;
            this.zzix = zzrq.zzaWh;
            this.zziy = zzrq.zzaWh;
            this.zziz = zzrq.zzaWh;
            this.zziA = zzrq.zzaWh;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzir != null && this.zzir.length > 0) {
                for (int i = 0; i < this.zzir.length; i++) {
                    zzrgVar.zzy(1, this.zzir[i]);
                }
            }
            if (this.zzis != null && this.zzis.length > 0) {
                for (int i2 = 0; i2 < this.zzis.length; i2++) {
                    zzrgVar.zzy(2, this.zzis[i2]);
                }
            }
            if (this.zzit != null && this.zzit.length > 0) {
                for (int i3 = 0; i3 < this.zzit.length; i3++) {
                    zzrgVar.zzy(3, this.zzit[i3]);
                }
            }
            if (this.zziu != null && this.zziu.length > 0) {
                for (int i4 = 0; i4 < this.zziu.length; i4++) {
                    zzrgVar.zzy(4, this.zziu[i4]);
                }
            }
            if (this.zziv != null && this.zziv.length > 0) {
                for (int i5 = 0; i5 < this.zziv.length; i5++) {
                    zzrgVar.zzy(5, this.zziv[i5]);
                }
            }
            if (this.zziw != null && this.zziw.length > 0) {
                for (int i6 = 0; i6 < this.zziw.length; i6++) {
                    zzrgVar.zzy(6, this.zziw[i6]);
                }
            }
            if (this.zzix != null && this.zzix.length > 0) {
                for (int i7 = 0; i7 < this.zzix.length; i7++) {
                    zzrgVar.zzy(7, this.zzix[i7]);
                }
            }
            if (this.zziy != null && this.zziy.length > 0) {
                for (int i8 = 0; i8 < this.zziy.length; i8++) {
                    zzrgVar.zzy(8, this.zziy[i8]);
                }
            }
            if (this.zziz != null && this.zziz.length > 0) {
                for (int i9 = 0; i9 < this.zziz.length; i9++) {
                    zzrgVar.zzy(9, this.zziz[i9]);
                }
            }
            if (this.zziA != null && this.zziA.length > 0) {
                for (int i10 = 0; i10 < this.zziA.length; i10++) {
                    zzrgVar.zzy(10, this.zziA[i10]);
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
        public zzg zzb(zzrf zzrfVar) throws IOException {
            int zzkC;
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        int zzb = zzrq.zzb(zzrfVar, 8);
                        int length = this.zzir == null ? 0 : this.zzir.length;
                        int i = zzb + length;
                        int[] iArr = new int[i];
                        if (length != 0) {
                            System.arraycopy(this.zzir, 0, iArr, 0, length);
                        }
                        while (length < i - 1) {
                            iArr[length] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length++;
                        }
                        iArr[length] = zzrfVar.zzBu();
                        this.zzir = iArr;
                        continue;
                    case 10:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i2 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i2++;
                        }
                        zzrfVar.zzkE(position);
                        int length2 = this.zzir == null ? 0 : this.zzir.length;
                        int i3 = i2 + length2;
                        int[] iArr2 = new int[i3];
                        if (length2 != 0) {
                            System.arraycopy(this.zzir, 0, iArr2, 0, length2);
                        }
                        while (length2 < i3) {
                            iArr2[length2] = zzrfVar.zzBu();
                            length2++;
                        }
                        this.zzir = iArr2;
                        break;
                    case 16:
                        int zzb2 = zzrq.zzb(zzrfVar, 16);
                        int length3 = this.zzis == null ? 0 : this.zzis.length;
                        int i4 = zzb2 + length3;
                        int[] iArr3 = new int[i4];
                        if (length3 != 0) {
                            System.arraycopy(this.zzis, 0, iArr3, 0, length3);
                        }
                        while (length3 < i4 - 1) {
                            iArr3[length3] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length3++;
                        }
                        iArr3[length3] = zzrfVar.zzBu();
                        this.zzis = iArr3;
                        continue;
                    case 18:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position2 = zzrfVar.getPosition();
                        int i5 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i5++;
                        }
                        zzrfVar.zzkE(position2);
                        int length4 = this.zzis == null ? 0 : this.zzis.length;
                        int i6 = i5 + length4;
                        int[] iArr4 = new int[i6];
                        if (length4 != 0) {
                            System.arraycopy(this.zzis, 0, iArr4, 0, length4);
                        }
                        while (length4 < i6) {
                            iArr4[length4] = zzrfVar.zzBu();
                            length4++;
                        }
                        this.zzis = iArr4;
                        break;
                    case 24:
                        int zzb3 = zzrq.zzb(zzrfVar, 24);
                        int length5 = this.zzit == null ? 0 : this.zzit.length;
                        int i7 = zzb3 + length5;
                        int[] iArr5 = new int[i7];
                        if (length5 != 0) {
                            System.arraycopy(this.zzit, 0, iArr5, 0, length5);
                        }
                        while (length5 < i7 - 1) {
                            iArr5[length5] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length5++;
                        }
                        iArr5[length5] = zzrfVar.zzBu();
                        this.zzit = iArr5;
                        continue;
                    case 26:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position3 = zzrfVar.getPosition();
                        int i8 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i8++;
                        }
                        zzrfVar.zzkE(position3);
                        int length6 = this.zzit == null ? 0 : this.zzit.length;
                        int i9 = i8 + length6;
                        int[] iArr6 = new int[i9];
                        if (length6 != 0) {
                            System.arraycopy(this.zzit, 0, iArr6, 0, length6);
                        }
                        while (length6 < i9) {
                            iArr6[length6] = zzrfVar.zzBu();
                            length6++;
                        }
                        this.zzit = iArr6;
                        break;
                    case 32:
                        int zzb4 = zzrq.zzb(zzrfVar, 32);
                        int length7 = this.zziu == null ? 0 : this.zziu.length;
                        int i10 = zzb4 + length7;
                        int[] iArr7 = new int[i10];
                        if (length7 != 0) {
                            System.arraycopy(this.zziu, 0, iArr7, 0, length7);
                        }
                        while (length7 < i10 - 1) {
                            iArr7[length7] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length7++;
                        }
                        iArr7[length7] = zzrfVar.zzBu();
                        this.zziu = iArr7;
                        continue;
                    case 34:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position4 = zzrfVar.getPosition();
                        int i11 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i11++;
                        }
                        zzrfVar.zzkE(position4);
                        int length8 = this.zziu == null ? 0 : this.zziu.length;
                        int i12 = i11 + length8;
                        int[] iArr8 = new int[i12];
                        if (length8 != 0) {
                            System.arraycopy(this.zziu, 0, iArr8, 0, length8);
                        }
                        while (length8 < i12) {
                            iArr8[length8] = zzrfVar.zzBu();
                            length8++;
                        }
                        this.zziu = iArr8;
                        break;
                    case 40:
                        int zzb5 = zzrq.zzb(zzrfVar, 40);
                        int length9 = this.zziv == null ? 0 : this.zziv.length;
                        int i13 = zzb5 + length9;
                        int[] iArr9 = new int[i13];
                        if (length9 != 0) {
                            System.arraycopy(this.zziv, 0, iArr9, 0, length9);
                        }
                        while (length9 < i13 - 1) {
                            iArr9[length9] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length9++;
                        }
                        iArr9[length9] = zzrfVar.zzBu();
                        this.zziv = iArr9;
                        continue;
                    case 42:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position5 = zzrfVar.getPosition();
                        int i14 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i14++;
                        }
                        zzrfVar.zzkE(position5);
                        int length10 = this.zziv == null ? 0 : this.zziv.length;
                        int i15 = i14 + length10;
                        int[] iArr10 = new int[i15];
                        if (length10 != 0) {
                            System.arraycopy(this.zziv, 0, iArr10, 0, length10);
                        }
                        while (length10 < i15) {
                            iArr10[length10] = zzrfVar.zzBu();
                            length10++;
                        }
                        this.zziv = iArr10;
                        break;
                    case 48:
                        int zzb6 = zzrq.zzb(zzrfVar, 48);
                        int length11 = this.zziw == null ? 0 : this.zziw.length;
                        int i16 = zzb6 + length11;
                        int[] iArr11 = new int[i16];
                        if (length11 != 0) {
                            System.arraycopy(this.zziw, 0, iArr11, 0, length11);
                        }
                        while (length11 < i16 - 1) {
                            iArr11[length11] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length11++;
                        }
                        iArr11[length11] = zzrfVar.zzBu();
                        this.zziw = iArr11;
                        continue;
                    case 50:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position6 = zzrfVar.getPosition();
                        int i17 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i17++;
                        }
                        zzrfVar.zzkE(position6);
                        int length12 = this.zziw == null ? 0 : this.zziw.length;
                        int i18 = i17 + length12;
                        int[] iArr12 = new int[i18];
                        if (length12 != 0) {
                            System.arraycopy(this.zziw, 0, iArr12, 0, length12);
                        }
                        while (length12 < i18) {
                            iArr12[length12] = zzrfVar.zzBu();
                            length12++;
                        }
                        this.zziw = iArr12;
                        break;
                    case 56:
                        int zzb7 = zzrq.zzb(zzrfVar, 56);
                        int length13 = this.zzix == null ? 0 : this.zzix.length;
                        int i19 = zzb7 + length13;
                        int[] iArr13 = new int[i19];
                        if (length13 != 0) {
                            System.arraycopy(this.zzix, 0, iArr13, 0, length13);
                        }
                        while (length13 < i19 - 1) {
                            iArr13[length13] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length13++;
                        }
                        iArr13[length13] = zzrfVar.zzBu();
                        this.zzix = iArr13;
                        continue;
                    case 58:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position7 = zzrfVar.getPosition();
                        int i20 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i20++;
                        }
                        zzrfVar.zzkE(position7);
                        int length14 = this.zzix == null ? 0 : this.zzix.length;
                        int i21 = i20 + length14;
                        int[] iArr14 = new int[i21];
                        if (length14 != 0) {
                            System.arraycopy(this.zzix, 0, iArr14, 0, length14);
                        }
                        while (length14 < i21) {
                            iArr14[length14] = zzrfVar.zzBu();
                            length14++;
                        }
                        this.zzix = iArr14;
                        break;
                    case 64:
                        int zzb8 = zzrq.zzb(zzrfVar, 64);
                        int length15 = this.zziy == null ? 0 : this.zziy.length;
                        int i22 = zzb8 + length15;
                        int[] iArr15 = new int[i22];
                        if (length15 != 0) {
                            System.arraycopy(this.zziy, 0, iArr15, 0, length15);
                        }
                        while (length15 < i22 - 1) {
                            iArr15[length15] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length15++;
                        }
                        iArr15[length15] = zzrfVar.zzBu();
                        this.zziy = iArr15;
                        continue;
                    case 66:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position8 = zzrfVar.getPosition();
                        int i23 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i23++;
                        }
                        zzrfVar.zzkE(position8);
                        int length16 = this.zziy == null ? 0 : this.zziy.length;
                        int i24 = i23 + length16;
                        int[] iArr16 = new int[i24];
                        if (length16 != 0) {
                            System.arraycopy(this.zziy, 0, iArr16, 0, length16);
                        }
                        while (length16 < i24) {
                            iArr16[length16] = zzrfVar.zzBu();
                            length16++;
                        }
                        this.zziy = iArr16;
                        break;
                    case 72:
                        int zzb9 = zzrq.zzb(zzrfVar, 72);
                        int length17 = this.zziz == null ? 0 : this.zziz.length;
                        int i25 = zzb9 + length17;
                        int[] iArr17 = new int[i25];
                        if (length17 != 0) {
                            System.arraycopy(this.zziz, 0, iArr17, 0, length17);
                        }
                        while (length17 < i25 - 1) {
                            iArr17[length17] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length17++;
                        }
                        iArr17[length17] = zzrfVar.zzBu();
                        this.zziz = iArr17;
                        continue;
                    case 74:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position9 = zzrfVar.getPosition();
                        int i26 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i26++;
                        }
                        zzrfVar.zzkE(position9);
                        int length18 = this.zziz == null ? 0 : this.zziz.length;
                        int i27 = i26 + length18;
                        int[] iArr18 = new int[i27];
                        if (length18 != 0) {
                            System.arraycopy(this.zziz, 0, iArr18, 0, length18);
                        }
                        while (length18 < i27) {
                            iArr18[length18] = zzrfVar.zzBu();
                            length18++;
                        }
                        this.zziz = iArr18;
                        break;
                    case 80:
                        int zzb10 = zzrq.zzb(zzrfVar, 80);
                        int length19 = this.zziA == null ? 0 : this.zziA.length;
                        int i28 = zzb10 + length19;
                        int[] iArr19 = new int[i28];
                        if (length19 != 0) {
                            System.arraycopy(this.zziA, 0, iArr19, 0, length19);
                        }
                        while (length19 < i28 - 1) {
                            iArr19[length19] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length19++;
                        }
                        iArr19[length19] = zzrfVar.zzBu();
                        this.zziA = iArr19;
                        continue;
                    case 82:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position10 = zzrfVar.getPosition();
                        int i29 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i29++;
                        }
                        zzrfVar.zzkE(position10);
                        int length20 = this.zziA == null ? 0 : this.zziA.length;
                        int i30 = i29 + length20;
                        int[] iArr20 = new int[i30];
                        if (length20 != 0) {
                            System.arraycopy(this.zziA, 0, iArr20, 0, length20);
                        }
                        while (length20 < i30) {
                            iArr20[length20] = zzrfVar.zzBu();
                            length20++;
                        }
                        this.zziA = iArr20;
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
    }

    public static final class zzh extends zzrh<zzh> {
        public static final zzri<zzag.zza, zzh> zziB = zzri.zza(11, zzh.class, 810);
        private static final zzh[] zziC = new zzh[0];
        public int[] zziD;
        public int[] zziE;
        public int[] zziF;
        public int zziG;
        public int[] zziH;
        public int zziI;
        public int zziJ;

        public zzh() {
            zzM();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzh)) {
                return false;
            }
            zzh zzhVar = (zzh) obj;
            if (zzrl.equals(this.zziD, zzhVar.zziD) && zzrl.equals(this.zziE, zzhVar.zziE) && zzrl.equals(this.zziF, zzhVar.zziF) && this.zziG == zzhVar.zziG && zzrl.equals(this.zziH, zzhVar.zziH) && this.zziI == zzhVar.zziI && this.zziJ == zzhVar.zziJ) {
                return zza(zzhVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((527 + zzrl.hashCode(this.zziD)) * 31) + zzrl.hashCode(this.zziE)) * 31) + zzrl.hashCode(this.zziF)) * 31) + this.zziG) * 31) + zzrl.hashCode(this.zziH)) * 31) + this.zziI) * 31) + this.zziJ) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zziD != null && this.zziD.length > 0) {
                int i = 0;
                for (int i2 = 0; i2 < this.zziD.length; i2++) {
                    i += zzrg.zzkJ(this.zziD[i2]);
                }
                zzB = zzB + i + (this.zziD.length * 1);
            }
            if (this.zziE != null && this.zziE.length > 0) {
                int i3 = 0;
                for (int i4 = 0; i4 < this.zziE.length; i4++) {
                    i3 += zzrg.zzkJ(this.zziE[i4]);
                }
                zzB = zzB + i3 + (this.zziE.length * 1);
            }
            if (this.zziF != null && this.zziF.length > 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < this.zziF.length; i6++) {
                    i5 += zzrg.zzkJ(this.zziF[i6]);
                }
                zzB = zzB + i5 + (this.zziF.length * 1);
            }
            if (this.zziG != 0) {
                zzB += zzrg.zzA(4, this.zziG);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                int i7 = 0;
                for (int i8 = 0; i8 < this.zziH.length; i8++) {
                    i7 += zzrg.zzkJ(this.zziH[i8]);
                }
                zzB = zzB + i7 + (this.zziH.length * 1);
            }
            if (this.zziI != 0) {
                zzB += zzrg.zzA(6, this.zziI);
            }
            return this.zziJ != 0 ? zzB + zzrg.zzA(7, this.zziJ) : zzB;
        }

        public zzh zzM() {
            this.zziD = zzrq.zzaWh;
            this.zziE = zzrq.zzaWh;
            this.zziF = zzrq.zzaWh;
            this.zziG = 0;
            this.zziH = zzrq.zzaWh;
            this.zziI = 0;
            this.zziJ = 0;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zziD != null && this.zziD.length > 0) {
                for (int i = 0; i < this.zziD.length; i++) {
                    zzrgVar.zzy(1, this.zziD[i]);
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (int i2 = 0; i2 < this.zziE.length; i2++) {
                    zzrgVar.zzy(2, this.zziE[i2]);
                }
            }
            if (this.zziF != null && this.zziF.length > 0) {
                for (int i3 = 0; i3 < this.zziF.length; i3++) {
                    zzrgVar.zzy(3, this.zziF[i3]);
                }
            }
            if (this.zziG != 0) {
                zzrgVar.zzy(4, this.zziG);
            }
            if (this.zziH != null && this.zziH.length > 0) {
                for (int i4 = 0; i4 < this.zziH.length; i4++) {
                    zzrgVar.zzy(5, this.zziH[i4]);
                }
            }
            if (this.zziI != 0) {
                zzrgVar.zzy(6, this.zziI);
            }
            if (this.zziJ != 0) {
                zzrgVar.zzy(7, this.zziJ);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public zzh zzb(zzrf zzrfVar) throws IOException {
            int zzkC;
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        int zzb = zzrq.zzb(zzrfVar, 8);
                        int length = this.zziD == null ? 0 : this.zziD.length;
                        int i = zzb + length;
                        int[] iArr = new int[i];
                        if (length != 0) {
                            System.arraycopy(this.zziD, 0, iArr, 0, length);
                        }
                        while (length < i - 1) {
                            iArr[length] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length++;
                        }
                        iArr[length] = zzrfVar.zzBu();
                        this.zziD = iArr;
                        continue;
                    case 10:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position = zzrfVar.getPosition();
                        int i2 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i2++;
                        }
                        zzrfVar.zzkE(position);
                        int length2 = this.zziD == null ? 0 : this.zziD.length;
                        int i3 = i2 + length2;
                        int[] iArr2 = new int[i3];
                        if (length2 != 0) {
                            System.arraycopy(this.zziD, 0, iArr2, 0, length2);
                        }
                        while (length2 < i3) {
                            iArr2[length2] = zzrfVar.zzBu();
                            length2++;
                        }
                        this.zziD = iArr2;
                        break;
                    case 16:
                        int zzb2 = zzrq.zzb(zzrfVar, 16);
                        int length3 = this.zziE == null ? 0 : this.zziE.length;
                        int i4 = zzb2 + length3;
                        int[] iArr3 = new int[i4];
                        if (length3 != 0) {
                            System.arraycopy(this.zziE, 0, iArr3, 0, length3);
                        }
                        while (length3 < i4 - 1) {
                            iArr3[length3] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length3++;
                        }
                        iArr3[length3] = zzrfVar.zzBu();
                        this.zziE = iArr3;
                        continue;
                    case 18:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position2 = zzrfVar.getPosition();
                        int i5 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i5++;
                        }
                        zzrfVar.zzkE(position2);
                        int length4 = this.zziE == null ? 0 : this.zziE.length;
                        int i6 = i5 + length4;
                        int[] iArr4 = new int[i6];
                        if (length4 != 0) {
                            System.arraycopy(this.zziE, 0, iArr4, 0, length4);
                        }
                        while (length4 < i6) {
                            iArr4[length4] = zzrfVar.zzBu();
                            length4++;
                        }
                        this.zziE = iArr4;
                        break;
                    case 24:
                        int zzb3 = zzrq.zzb(zzrfVar, 24);
                        int length5 = this.zziF == null ? 0 : this.zziF.length;
                        int i7 = zzb3 + length5;
                        int[] iArr5 = new int[i7];
                        if (length5 != 0) {
                            System.arraycopy(this.zziF, 0, iArr5, 0, length5);
                        }
                        while (length5 < i7 - 1) {
                            iArr5[length5] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length5++;
                        }
                        iArr5[length5] = zzrfVar.zzBu();
                        this.zziF = iArr5;
                        continue;
                    case 26:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position3 = zzrfVar.getPosition();
                        int i8 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i8++;
                        }
                        zzrfVar.zzkE(position3);
                        int length6 = this.zziF == null ? 0 : this.zziF.length;
                        int i9 = i8 + length6;
                        int[] iArr6 = new int[i9];
                        if (length6 != 0) {
                            System.arraycopy(this.zziF, 0, iArr6, 0, length6);
                        }
                        while (length6 < i9) {
                            iArr6[length6] = zzrfVar.zzBu();
                            length6++;
                        }
                        this.zziF = iArr6;
                        break;
                    case 32:
                        this.zziG = zzrfVar.zzBu();
                        continue;
                    case 40:
                        int zzb4 = zzrq.zzb(zzrfVar, 40);
                        int length7 = this.zziH == null ? 0 : this.zziH.length;
                        int i10 = zzb4 + length7;
                        int[] iArr7 = new int[i10];
                        if (length7 != 0) {
                            System.arraycopy(this.zziH, 0, iArr7, 0, length7);
                        }
                        while (length7 < i10 - 1) {
                            iArr7[length7] = zzrfVar.zzBu();
                            zzrfVar.zzBr();
                            length7++;
                        }
                        iArr7[length7] = zzrfVar.zzBu();
                        this.zziH = iArr7;
                        continue;
                    case 42:
                        zzkC = zzrfVar.zzkC(zzrfVar.zzBy());
                        int position4 = zzrfVar.getPosition();
                        int i11 = 0;
                        while (zzrfVar.zzBD() > 0) {
                            zzrfVar.zzBu();
                            i11++;
                        }
                        zzrfVar.zzkE(position4);
                        int length8 = this.zziH == null ? 0 : this.zziH.length;
                        int i12 = i11 + length8;
                        int[] iArr8 = new int[i12];
                        if (length8 != 0) {
                            System.arraycopy(this.zziH, 0, iArr8, 0, length8);
                        }
                        while (length8 < i12) {
                            iArr8[length8] = zzrfVar.zzBu();
                            length8++;
                        }
                        this.zziH = iArr8;
                        break;
                    case 48:
                        this.zziI = zzrfVar.zzBu();
                        continue;
                    case 56:
                        this.zziJ = zzrfVar.zzBu();
                        continue;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        continue;
                }
                zzrfVar.zzkD(zzkC);
            }
        }
    }

    public static final class zzi extends zzrh<zzi> {
        private static volatile zzi[] zziK;
        public String name;
        public zzag.zza zziL;
        public zzd zziM;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zziK == null) {
                synchronized (zzrl.zzaWe) {
                    if (zziK == null) {
                        zziK = new zzi[0];
                    }
                }
            }
            return zziK;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzi)) {
                return false;
            }
            zzi zziVar = (zzi) obj;
            if (this.name == null) {
                if (zziVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zziVar.name)) {
                return false;
            }
            if (this.zziL == null) {
                if (zziVar.zziL != null) {
                    return false;
                }
            } else if (!this.zziL.equals(zziVar.zziL)) {
                return false;
            }
            if (this.zziM == null) {
                if (zziVar.zziM != null) {
                    return false;
                }
            } else if (!this.zziM.equals(zziVar.zziM)) {
                return false;
            }
            return zza(zziVar);
        }

        public int hashCode() {
            return ((((((527 + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zziL == null ? 0 : this.zziL.hashCode())) * 31) + (this.zziM != null ? this.zziM.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrg.zzk(1, this.name);
            }
            if (this.zziL != null) {
                zzB += zzrg.zzc(2, this.zziL);
            }
            return this.zziM != null ? zzB + zzrg.zzc(3, this.zziM) : zzB;
        }

        public zzi zzO() {
            this.name = "";
            this.zziL = null;
            this.zziM = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.name.equals("")) {
                zzrgVar.zzb(1, this.name);
            }
            if (this.zziL != null) {
                zzrgVar.zza(2, this.zziL);
            }
            if (this.zziM != null) {
                zzrgVar.zza(3, this.zziM);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public zzi zzb(zzrf zzrfVar) throws IOException {
            zzrn zzrnVar;
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        this.name = zzrfVar.readString();
                        continue;
                    case 18:
                        if (this.zziL == null) {
                            this.zziL = new zzag.zza();
                        }
                        zzrnVar = this.zziL;
                        break;
                    case 26:
                        if (this.zziM == null) {
                            this.zziM = new zzd();
                        }
                        zzrnVar = this.zziM;
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        continue;
                }
                zzrfVar.zza(zzrnVar);
            }
        }
    }

    public static final class zzj extends zzrh<zzj> {
        public zzi[] zziN;
        public zzf zziO;
        public String zziP;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zzrm {
            return (zzj) zzrn.zza(new zzj(), bArr);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzj)) {
                return false;
            }
            zzj zzjVar = (zzj) obj;
            if (!zzrl.equals(this.zziN, zzjVar.zziN)) {
                return false;
            }
            if (this.zziO == null) {
                if (zzjVar.zziO != null) {
                    return false;
                }
            } else if (!this.zziO.equals(zzjVar.zziO)) {
                return false;
            }
            if (this.zziP == null) {
                if (zzjVar.zziP != null) {
                    return false;
                }
            } else if (!this.zziP.equals(zzjVar.zziP)) {
                return false;
            }
            return zza(zzjVar);
        }

        public int hashCode() {
            return ((((((527 + zzrl.hashCode(this.zziN)) * 31) + (this.zziO == null ? 0 : this.zziO.hashCode())) * 31) + (this.zziP != null ? this.zziP.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zziN != null && this.zziN.length > 0) {
                for (int i = 0; i < this.zziN.length; i++) {
                    zzi zziVar = this.zziN[i];
                    if (zziVar != null) {
                        zzB += zzrg.zzc(1, zziVar);
                    }
                }
            }
            if (this.zziO != null) {
                zzB += zzrg.zzc(2, this.zziO);
            }
            return !this.zziP.equals("") ? zzB + zzrg.zzk(3, this.zziP) : zzB;
        }

        public zzj zzP() {
            this.zziN = zzi.zzN();
            this.zziO = null;
            this.zziP = "";
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zziN != null && this.zziN.length > 0) {
                for (int i = 0; i < this.zziN.length; i++) {
                    zzi zziVar = this.zziN[i];
                    if (zziVar != null) {
                        zzrgVar.zza(1, zziVar);
                    }
                }
            }
            if (this.zziO != null) {
                zzrgVar.zza(2, this.zziO);
            }
            if (!this.zziP.equals("")) {
                zzrgVar.zzb(3, this.zziP);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
        public zzj zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        int zzb = zzrq.zzb(zzrfVar, 10);
                        int length = this.zziN == null ? 0 : this.zziN.length;
                        int i = zzb + length;
                        zzi[] zziVarArr = new zzi[i];
                        if (length != 0) {
                            System.arraycopy(this.zziN, 0, zziVarArr, 0, length);
                        }
                        while (length < i - 1) {
                            zziVarArr[length] = new zzi();
                            zzrfVar.zza(zziVarArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zziVarArr[length] = new zzi();
                        zzrfVar.zza(zziVarArr[length]);
                        this.zziN = zziVarArr;
                        break;
                    case 18:
                        if (this.zziO == null) {
                            this.zziO = new zzf();
                        }
                        zzrfVar.zza(this.zziO);
                        break;
                    case 26:
                        this.zziP = zzrfVar.readString();
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
