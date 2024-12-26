package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;

/* loaded from: classes.dex */
public abstract class zzqn {
    private zzqd zzaPU;
    private zzqb zzaPV;
    private zzlb zzpw;

    public enum zza {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    public class zzb {
        private final zzqe.zza.EnumC0159zza zzaPp;
        private final long zzaPr;
        private final Object zzaQa;

        public Object zzAH() {
            return this.zzaQa;
        }

        public zzqe.zza.EnumC0159zza zzAh() {
            return this.zzaPp;
        }

        public long zzAl() {
            return this.zzaPr;
        }
    }

    public zzqn(zzqd zzqdVar, zzqb zzqbVar) {
        this(zzqdVar, zzqbVar, zzld.zzoQ());
    }

    public zzqn(zzqd zzqdVar, zzqb zzqbVar, zzlb zzlbVar) {
        com.google.android.gms.common.internal.zzu.zzV(zzqdVar.zzAf().size() == 1);
        this.zzaPU = zzqdVar;
        this.zzaPV = zzqbVar;
        this.zzpw = zzlbVar;
    }

    protected abstract zzb zza(zzpy zzpyVar);

    protected abstract void zza(zzqe zzqeVar);

    public void zza(zza zzaVar) {
        com.google.android.gms.tagmanager.zzbg.zzaz("ResourceManager: Failed to download a resource: " + zzaVar.name());
        zzpy zzpyVar = this.zzaPU.zzAf().get(0);
        zzb zza2 = zza(zzpyVar);
        zza(new zzqe((zza2 == null || !(zza2.zzAH() instanceof zzqf.zzc)) ? new zzqe.zza(Status.zzXR, zzpyVar, zzqe.zza.EnumC0159zza.NETWORK) : new zzqe.zza(Status.zzXP, zzpyVar, null, (zzqf.zzc) zza2.zzAH(), zza2.zzAh(), zza2.zzAl())));
    }

    public void zzu(byte[] bArr) {
        com.google.android.gms.tagmanager.zzbg.zzaB("ResourceManager: Resource downloaded from Network: " + this.zzaPU.getId());
        zzpy zzpyVar = this.zzaPU.zzAf().get(0);
        zzqe.zza.EnumC0159zza enumC0159zza = zzqe.zza.EnumC0159zza.NETWORK;
        Object obj = null;
        long j = 0;
        try {
            obj = this.zzaPV.zzt(bArr);
            j = this.zzpw.currentTimeMillis();
            if (obj == null) {
                com.google.android.gms.tagmanager.zzbg.zzaA("Parsed resource from network is null");
                zzb zza2 = zza(zzpyVar);
                if (zza2 != null) {
                    obj = zza2.zzAH();
                    enumC0159zza = zza2.zzAh();
                    j = zza2.zzAl();
                }
            }
        } catch (zzqf.zzg e) {
            com.google.android.gms.tagmanager.zzbg.zzaA("Resource from network is corrupted");
            zzb zza3 = zza(zzpyVar);
            if (zza3 != null) {
                obj = zza3.zzAH();
                enumC0159zza = zza3.zzAh();
            }
        }
        zza(new zzqe(obj != null ? new zzqe.zza(Status.zzXP, zzpyVar, bArr, (zzqf.zzc) obj, enumC0159zza, j) : new zzqe.zza(Status.zzXR, zzpyVar, zzqe.zza.EnumC0159zza.NETWORK)));
    }
}
