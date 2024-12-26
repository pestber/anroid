package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public class zzhu {

    public interface zza<D, R> {
        R zze(D d);
    }

    public static <A, B> zzhv<B> zza(final zzhv<A> zzhvVar, final zza<A, B> zzaVar) {
        final zzhs zzhsVar = new zzhs();
        zzhvVar.zzb(new Runnable() { // from class: com.google.android.gms.internal.zzhu.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzhsVar.zzf(zzaVar.zze(zzhvVar.get()));
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    zzhsVar.cancel(true);
                }
            }
        });
        return zzhsVar;
    }
}
