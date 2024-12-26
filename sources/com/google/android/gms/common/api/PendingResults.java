package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class PendingResults {

    private static final class zza<R extends Result> extends AbstractPendingResult<R> {
        private final R zzXN;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzXN = r;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        protected R createFailedResult(Status status) {
            if (status.getStatusCode() == this.zzXN.getStatus().getStatusCode()) {
                return this.zzXN;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends AbstractPendingResult<R> {
        public zzb() {
            super(Looper.getMainLooper());
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        protected R createFailedResult(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzl zzlVar = new zzl(Looper.getMainLooper());
        zzlVar.cancel();
        return zzlVar;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzu.zzb(r, "Result must not be null");
        zzu.zzb(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zzaVar = new zza(r);
        zzaVar.cancel();
        return zzaVar;
    }

    public static <R extends Result> PendingResult<R> immediatePendingResult(R r) {
        zzu.zzb(r, "Result must not be null");
        zzb zzbVar = new zzb();
        zzbVar.setResult(r);
        return zzbVar;
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzu.zzb(status, "Result must not be null");
        zzl zzlVar = new zzl(Looper.getMainLooper());
        zzlVar.setResult(status);
        return zzlVar;
    }
}
