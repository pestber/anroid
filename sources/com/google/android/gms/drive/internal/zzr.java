package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.drive.Drive;

/* loaded from: classes.dex */
public abstract class zzr<R extends Result> extends zza.AbstractC0035zza<R, zzs> {

    public static abstract class zza extends zzr<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    public zzr(GoogleApiClient googleApiClient) {
        super(Drive.zzNX, googleApiClient);
    }
}
