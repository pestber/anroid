package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public interface zznj {

    public static final class zza extends zzrh<zza> {
        public C0143zza[] zzawk;

        /* renamed from: com.google.android.gms.internal.zznj$zza$zza, reason: collision with other inner class name */
        public static final class C0143zza extends zzrh<C0143zza> {
            private static volatile C0143zza[] zzawl;
            public int viewId;
            public String zzawm;
            public String zzawn;

            public C0143zza() {
                zztW();
            }

            public static C0143zza[] zztV() {
                if (zzawl == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzawl == null) {
                            zzawl = new C0143zza[0];
                        }
                    }
                }
                return zzawl;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof C0143zza)) {
                    return false;
                }
                C0143zza c0143zza = (C0143zza) obj;
                if (this.zzawm == null) {
                    if (c0143zza.zzawm != null) {
                        return false;
                    }
                } else if (!this.zzawm.equals(c0143zza.zzawm)) {
                    return false;
                }
                if (this.zzawn == null) {
                    if (c0143zza.zzawn != null) {
                        return false;
                    }
                } else if (!this.zzawn.equals(c0143zza.zzawn)) {
                    return false;
                }
                if (this.viewId != c0143zza.viewId) {
                    return false;
                }
                return zza(c0143zza);
            }

            public int hashCode() {
                return ((((((527 + (this.zzawm == null ? 0 : this.zzawm.hashCode())) * 31) + (this.zzawn != null ? this.zzawn.hashCode() : 0)) * 31) + this.viewId) * 31) + zzBI();
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            protected int zzB() {
                int zzB = super.zzB();
                if (!this.zzawm.equals("")) {
                    zzB += zzrg.zzk(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzB += zzrg.zzk(2, this.zzawn);
                }
                return this.viewId != 0 ? zzB + zzrg.zzA(3, this.viewId) : zzB;
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public void zza(zzrg zzrgVar) throws IOException {
                if (!this.zzawm.equals("")) {
                    zzrgVar.zzb(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzrgVar.zzb(2, this.zzawn);
                }
                if (this.viewId != 0) {
                    zzrgVar.zzy(3, this.viewId);
                }
                super.zza(zzrgVar);
            }

            @Override // com.google.android.gms.internal.zzrn
            /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
            public C0143zza zzb(zzrf zzrfVar) throws IOException {
                while (true) {
                    int zzBr = zzrfVar.zzBr();
                    switch (zzBr) {
                        case 0:
                            return this;
                        case 10:
                            this.zzawm = zzrfVar.readString();
                            break;
                        case 18:
                            this.zzawn = zzrfVar.readString();
                            break;
                        case 24:
                            this.viewId = zzrfVar.zzBu();
                            break;
                        default:
                            if (!zza(zzrfVar, zzBr)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            public C0143zza zztW() {
                this.zzawm = "";
                this.zzawn = "";
                this.viewId = 0;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }
        }

        public zza() {
            zztU();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            if (zzrl.equals(this.zzawk, zzaVar.zzawk)) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((527 + zzrl.hashCode(this.zzawk)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (int i = 0; i < this.zzawk.length; i++) {
                    C0143zza c0143zza = this.zzawk[i];
                    if (c0143zza != null) {
                        zzB += zzrg.zzc(1, c0143zza);
                    }
                }
            }
            return zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (int i = 0; i < this.zzawk.length; i++) {
                    C0143zza c0143zza = this.zzawk[i];
                    if (c0143zza != null) {
                        zzrgVar.zza(1, c0143zza);
                    }
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        int zzb = zzrq.zzb(zzrfVar, 10);
                        int length = this.zzawk == null ? 0 : this.zzawk.length;
                        int i = zzb + length;
                        C0143zza[] c0143zzaArr = new C0143zza[i];
                        if (length != 0) {
                            System.arraycopy(this.zzawk, 0, c0143zzaArr, 0, length);
                        }
                        while (length < i - 1) {
                            c0143zzaArr[length] = new C0143zza();
                            zzrfVar.zza(c0143zzaArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        c0143zzaArr[length] = new C0143zza();
                        zzrfVar.zza(c0143zzaArr[length]);
                        this.zzawk = c0143zzaArr;
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public zza zztU() {
            this.zzawk = C0143zza.zztV();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzawo;
        public String name;
        public zzd zzawp;

        public zzb() {
            zztY();
        }

        public static zzb[] zztX() {
            if (zzawo == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzawo == null) {
                        zzawo = new zzb[0];
                    }
                }
            }
            return zzawo;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) obj;
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.zzawp == null) {
                if (zzbVar.zzawp != null) {
                    return false;
                }
            } else if (!this.zzawp.equals(zzbVar.zzawp)) {
                return false;
            }
            return zza(zzbVar);
        }

        public int hashCode() {
            return ((((527 + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzawp != null ? this.zzawp.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrg.zzk(1, this.name);
            }
            return this.zzawp != null ? zzB + zzrg.zzc(2, this.zzawp) : zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.name.equals("")) {
                zzrgVar.zzb(1, this.name);
            }
            if (this.zzawp != null) {
                zzrgVar.zza(2, this.zzawp);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        this.name = zzrfVar.readString();
                        break;
                    case 18:
                        if (this.zzawp == null) {
                            this.zzawp = new zzd();
                        }
                        zzrfVar.zza(this.zzawp);
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public zzb zztY() {
            this.name = "";
            this.zzawp = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public String type;
        public zzb[] zzawq;

        public zzc() {
            zztZ();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) obj;
            if (this.type == null) {
                if (zzcVar.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzcVar.type)) {
                return false;
            }
            if (zzrl.equals(this.zzawq, zzcVar.zzawq)) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + (this.type == null ? 0 : this.type.hashCode())) * 31) + zzrl.hashCode(this.zzawq)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals("")) {
                zzB += zzrg.zzk(1, this.type);
            }
            if (this.zzawq != null && this.zzawq.length > 0) {
                for (int i = 0; i < this.zzawq.length; i++) {
                    zzb zzbVar = this.zzawq[i];
                    if (zzbVar != null) {
                        zzB += zzrg.zzc(2, zzbVar);
                    }
                }
            }
            return zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.type.equals("")) {
                zzrgVar.zzb(1, this.type);
            }
            if (this.zzawq != null && this.zzawq.length > 0) {
                for (int i = 0; i < this.zzawq.length; i++) {
                    zzb zzbVar = this.zzawq[i];
                    if (zzbVar != null) {
                        zzrgVar.zza(2, zzbVar);
                    }
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 10:
                        this.type = zzrfVar.readString();
                        break;
                    case 18:
                        int zzb = zzrq.zzb(zzrfVar, 18);
                        int length = this.zzawq == null ? 0 : this.zzawq.length;
                        int i = zzb + length;
                        zzb[] zzbVarArr = new zzb[i];
                        if (length != 0) {
                            System.arraycopy(this.zzawq, 0, zzbVarArr, 0, length);
                        }
                        while (length < i - 1) {
                            zzbVarArr[length] = new zzb();
                            zzrfVar.zza(zzbVarArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzrfVar.zza(zzbVarArr[length]);
                        this.zzawq = zzbVarArr;
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public zzc zztZ() {
            this.type = "";
            this.zzawq = zzb.zztX();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String zzabE;
        public boolean zzawr;
        public long zzaws;
        public double zzawt;
        public zzc zzawu;

        public zzd() {
            zzua();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) obj;
            if (this.zzawr != zzdVar.zzawr) {
                return false;
            }
            if (this.zzabE == null) {
                if (zzdVar.zzabE != null) {
                    return false;
                }
            } else if (!this.zzabE.equals(zzdVar.zzabE)) {
                return false;
            }
            if (this.zzaws != zzdVar.zzaws || Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(zzdVar.zzawt)) {
                return false;
            }
            if (this.zzawu == null) {
                if (zzdVar.zzawu != null) {
                    return false;
                }
            } else if (!this.zzawu.equals(zzdVar.zzawu)) {
                return false;
            }
            return zza(zzdVar);
        }

        public int hashCode() {
            int hashCode = ((((527 + (this.zzawr ? 1231 : 1237)) * 31) + (this.zzabE == null ? 0 : this.zzabE.hashCode())) * 31) + ((int) (this.zzaws ^ (this.zzaws >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzawt);
            return (((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + (this.zzawu != null ? this.zzawu.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzawr) {
                zzB += zzrg.zzc(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                zzB += zzrg.zzk(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                zzB += zzrg.zzd(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrg.zzb(4, this.zzawt);
            }
            return this.zzawu != null ? zzB + zzrg.zzc(5, this.zzawu) : zzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzawr) {
                zzrgVar.zzb(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                zzrgVar.zzb(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                zzrgVar.zzb(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzrgVar.zza(4, this.zzawt);
            }
            if (this.zzawu != null) {
                zzrgVar.zza(5, this.zzawu);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int zzBr = zzrfVar.zzBr();
                switch (zzBr) {
                    case 0:
                        return this;
                    case 8:
                        this.zzawr = zzrfVar.zzBv();
                        break;
                    case 18:
                        this.zzabE = zzrfVar.readString();
                        break;
                    case 24:
                        this.zzaws = zzrfVar.zzBt();
                        break;
                    case 33:
                        this.zzawt = zzrfVar.readDouble();
                        break;
                    case 42:
                        if (this.zzawu == null) {
                            this.zzawu = new zzc();
                        }
                        zzrfVar.zza(this.zzawu);
                        break;
                    default:
                        if (!zza(zzrfVar, zzBr)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public zzd zzua() {
            this.zzawr = false;
            this.zzabE = "";
            this.zzaws = 0L;
            this.zzawt = 0.0d;
            this.zzawu = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
