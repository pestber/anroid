package com.google.android.gms.common.api;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzg;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zzd implements zzh {
    private final zzg zzWK;

    public zzd(zzg zzgVar) {
        this.zzWK = zzgVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <A extends Api.Client> void zza(zzg.zze<A> zzeVar) throws DeadObjectException {
        this.zzWK.zzb(zzeVar);
        Api.Client zza = this.zzWK.zza((Api.ClientKey<Api.Client>) zzeVar.zzms());
        if (zza.isConnected() || !this.zzWK.zzXv.containsKey(zzeVar.zzms())) {
            zzeVar.zzb(zza);
        } else {
            zzeVar.zzr(new Status(17));
        }
    }

    @Override // com.google.android.gms.common.api.zzh
    public void begin() {
        while (!this.zzWK.zzXo.isEmpty()) {
            try {
                zza(this.zzWK.zzXo.remove());
            } catch (DeadObjectException e) {
                Log.w("GoogleApiClientConnected", "Service died while flushing queue", e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.zzh
    public void connect() {
    }

    @Override // com.google.android.gms.common.api.zzh
    public String getName() {
        return "CONNECTED";
    }

    @Override // com.google.android.gms.common.api.zzh
    public void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.zzh
    public void onConnectionSuspended(int i) {
        switch (i) {
            case 1:
                this.zzWK.zzmQ();
                zzaV(i);
                break;
            case 2:
                zzaV(i);
                this.zzWK.connect();
                break;
        }
    }

    @Override // com.google.android.gms.common.api.zzh
    public <A extends Api.Client, R extends Result, T extends zza.AbstractC0035zza<R, A>> T zza(T t) {
        return (T) zzb(t);
    }

    @Override // com.google.android.gms.common.api.zzh
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    @Override // com.google.android.gms.common.api.zzh
    public void zzaV(int i) {
        boolean z = i == -1;
        zzg zzgVar = this.zzWK;
        if (z) {
            zzgVar.zzmK();
            this.zzWK.zzXv.clear();
        } else {
            Iterator<zzg.zze<?>> it = zzgVar.zzXA.iterator();
            while (it.hasNext()) {
                it.next().forceFailureUnlessReady(new Status(8, "The connection to Google Play services was lost"));
            }
        }
        this.zzWK.zze(null);
        if (!z) {
            this.zzWK.zzXn.zzbu(i);
        }
        this.zzWK.zzXn.zznT();
    }

    @Override // com.google.android.gms.common.api.zzh
    public <A extends Api.Client, T extends zza.AbstractC0035zza<? extends Result, A>> T zzb(T t) {
        try {
            zza((zzg.zze) t);
        } catch (DeadObjectException e) {
            zzaV(1);
        }
        return t;
    }
}
