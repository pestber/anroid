package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.drive.internal.zzs;

/* loaded from: classes.dex */
public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzadn;
    private final boolean zzado;
    private final int zzadp;

    public static final class Builder {
        private String zzadn;
        private boolean zzado;
        private int zzadp = 0;

        public ExecutionOptions build() {
            if (this.zzadp != 1 || this.zzado) {
                return new ExecutionOptions(this.zzadn, this.zzado, this.zzadp);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int i) {
            if (!ExecutionOptions.zzbY(i)) {
                throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + i);
            }
            this.zzadp = i;
            return this;
        }

        public Builder setNotifyOnCompletion(boolean z) {
            this.zzado = z;
            return this;
        }

        public Builder setTrackingTag(String str) {
            if (!ExecutionOptions.zzct(str)) {
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", 65536));
            }
            this.zzadn = str;
            return this;
        }
    }

    public ExecutionOptions(String str, boolean z, int i) {
        this.zzadn = str;
        this.zzado = z;
        this.zzadp = i;
    }

    public static void zza(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        zzs zzsVar = (zzs) googleApiClient.zza(Drive.zzNX);
        if (executionOptions.zzpj() && !zzsVar.zzpE()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean zzbX(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzbY(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzct(String str) {
        return (str == null || str.isEmpty() || str.length() > 65536) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) obj;
        return zzt.equal(this.zzadn, executionOptions.zzadn) && this.zzadp == executionOptions.zzadp && this.zzado == executionOptions.zzado;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzadn, Integer.valueOf(this.zzadp), Boolean.valueOf(this.zzado));
    }

    public String zzpi() {
        return this.zzadn;
    }

    public boolean zzpj() {
        return this.zzado;
    }

    public int zzpk() {
        return this.zzadp;
    }
}
