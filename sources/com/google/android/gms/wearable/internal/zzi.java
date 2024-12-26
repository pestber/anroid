package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* loaded from: classes.dex */
public final class zzi implements ChannelApi {

    static final class zza extends zzf<Status> {
        private final String zzaTK;
        private ChannelApi.ChannelListener zzaTL;

        zza(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaTL = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzu.zzu(channelListener);
            this.zzaTK = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(zzbk zzbkVar) throws RemoteException {
            zzbkVar.zza(this, this.zzaTL, this.zzaTK);
            this.zzaTL = null;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            this.zzaTL = null;
            return status;
        }
    }

    static final class zzb implements ChannelApi.OpenChannelResult {
        private final Status zzOt;
        private final Channel zzaTM;

        zzb(Status status, Channel channel) {
            this.zzOt = (Status) com.google.android.gms.common.internal.zzu.zzu(status);
            this.zzaTM = channel;
        }

        @Override // com.google.android.gms.wearable.ChannelApi.OpenChannelResult
        public Channel getChannel() {
            return this.zzaTM;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzOt;
        }
    }

    static final class zzc extends zzf<Status> {
        private final String zzaTK;
        private ChannelApi.ChannelListener zzaTL;

        zzc(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaTL = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzu.zzu(channelListener);
            this.zzaTK = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
        public void zza(zzbk zzbkVar) throws RemoteException {
            zzbkVar.zzb(this, this.zzaTL, this.zzaTK);
            this.zzaTL = null;
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            this.zzaTL = null;
            return status;
        }
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(channelListener, "listener is null");
        return googleApiClient.zza((GoogleApiClient) new zza(googleApiClient, channelListener, null));
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient googleApiClient, final String str, final String str2) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(str, "nodeId is null");
        com.google.android.gms.common.internal.zzu.zzb(str2, "path is null");
        return googleApiClient.zzb(new zzf<ChannelApi.OpenChannelResult>(googleApiClient) { // from class: com.google.android.gms.wearable.internal.zzi.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzbk zzbkVar) throws RemoteException {
                zzbkVar.zze(this, str, str2);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzba, reason: merged with bridge method [inline-methods] */
            public ChannelApi.OpenChannelResult createFailedResult(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient, "client is null");
        com.google.android.gms.common.internal.zzu.zzb(channelListener, "listener is null");
        return googleApiClient.zza((GoogleApiClient) new zzc(googleApiClient, channelListener, null));
    }
}
