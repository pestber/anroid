package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* loaded from: classes.dex */
public final class zzav implements MessageApi {

    private static final class zza extends zzf<Status> {
        private MessageApi.MessageListener zzaUF;
        private IntentFilter[] zzaUk;

        private zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzaUF = messageListener;
            this.zzaUk = intentFilterArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(zzbk zzbkVar) throws RemoteException {
            zzbkVar.zza(this, this.zzaUF, this.zzaUk);
            this.zzaUF = null;
            this.zzaUk = null;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            this.zzaUF = null;
            this.zzaUk = null;
            return status;
        }
    }

    public static class zzb implements MessageApi.SendMessageResult {
        private final Status zzOt;
        private final int zzacR;

        public zzb(Status status, int i) {
            this.zzOt = status;
            this.zzacR = i;
        }

        @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
        public int getRequestId() {
            return this.zzacR;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza((GoogleApiClient) new zza(googleApiClient, messageListener, intentFilterArr));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener) {
        return zza(googleApiClient, messageListener, null);
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, final MessageApi.MessageListener messageListener) {
        return googleApiClient.zza((GoogleApiClient) new zzf<Status>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzav.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zza(this, messageListener);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient googleApiClient, final String str, final String str2, final byte[] bArr) {
        return googleApiClient.zza((GoogleApiClient) new zzf<MessageApi.SendMessageResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzav.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zza(this, str, str2, bArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzbh, reason: merged with bridge method [inline-methods] */
            public MessageApi.SendMessageResult createFailedResult(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
