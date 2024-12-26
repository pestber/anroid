package com.google.android.gms.analytics.internal;

/* loaded from: classes.dex */
public abstract class zzd extends zzc {
    private boolean zzJA;
    private boolean zzJz;

    protected zzd(zzf zzfVar) {
        super(zzfVar);
    }

    public boolean isInitialized() {
        return this.zzJz && !this.zzJA;
    }

    public void zza() {
        zzhn();
        this.zzJz = true;
    }

    protected abstract void zzhn();

    protected void zzia() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
