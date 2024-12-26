package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmp;

/* loaded from: classes.dex */
public class zznd implements RecordingApi {

    private static class zza extends zzmp.zza {
        private final zza.zzb<ListSubscriptionsResult> zzOs;

        private zza(zza.zzb<ListSubscriptionsResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzmp
        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzOs.zzm(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza((GoogleApiClient) new zzmb.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmb zzmbVar) throws RemoteException {
                ((zzmm) zzmbVar.zznM()).zza(new SubscribeRequest(subscription, false, new zzng(this), zzmbVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new zzmb.zza<ListSubscriptionsResult>(googleApiClient) { // from class: com.google.android.gms.internal.zznd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzF, reason: merged with bridge method [inline-methods] */
            public ListSubscriptionsResult createFailedResult(Status status) {
                return ListSubscriptionsResult.zzN(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmb zzmbVar) throws RemoteException {
                ((zzmm) zzmbVar.zznM()).zza(new ListSubscriptionsRequest(null, new zza(this), zzmbVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zza((GoogleApiClient) new zzmb.zza<ListSubscriptionsResult>(googleApiClient) { // from class: com.google.android.gms.internal.zznd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzF, reason: merged with bridge method [inline-methods] */
            public ListSubscriptionsResult createFailedResult(Status status) {
                return ListSubscriptionsResult.zzN(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmb zzmbVar) throws RemoteException {
                ((zzmm) zzmbVar.zznM()).zza(new ListSubscriptionsRequest(dataType, new zza(this), zzmbVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataSource dataSource) {
        return zza(googleApiClient, new Subscription.zza().zzb(dataSource).zzqN());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, DataType dataType) {
        return zza(googleApiClient, new Subscription.zza().zzb(dataType).zzqN());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final DataSource dataSource) {
        return googleApiClient.zzb(new zzmb.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznd.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmb zzmbVar) throws RemoteException {
                ((zzmm) zzmbVar.zznM()).zza(new UnsubscribeRequest(null, dataSource, new zzng(this), zzmbVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final DataType dataType) {
        return googleApiClient.zzb(new zzmb.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmb zzmbVar) throws RemoteException {
                ((zzmm) zzmbVar.zznM()).zza(new UnsubscribeRequest(dataType, null, new zzng(this), zzmbVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(googleApiClient, subscription.getDataSource()) : unsubscribe(googleApiClient, subscription.getDataType());
    }
}
