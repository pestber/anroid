package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

/* loaded from: classes.dex */
public final class zzpd implements Moments {

    private static abstract class zza extends Plus.zza<Moments.LoadMomentsResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzaP, reason: merged with bridge method [inline-methods] */
        public Moments.LoadMomentsResult createFailedResult(final Status status) {
            return new Moments.LoadMomentsResult() { // from class: com.google.android.gms.internal.zzpd.zza.1
                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getUpdated() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class zzb extends Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private static abstract class zzc extends Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzi(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, final int i, final String str, final Uri uri, final String str2, final String str3) {
        return googleApiClient.zza((GoogleApiClient) new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzpd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, i, str, uri, str2, str3);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzpd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzdX(str);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, moment);
            }
        });
    }
}
