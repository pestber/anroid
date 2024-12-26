package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzoq implements Connections {
    public static final Api.ClientKey<zzop> zzNX = new Api.ClientKey<>();
    public static final Api.zza<zzop, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zzop, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.internal.zzoq.1
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public zzop zza(Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzop(context, looper, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private static abstract class zza<R extends Result> extends zza.AbstractC0035zza<R, zzop> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzoq.zzNX, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<Connections.StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzaM, reason: merged with bridge method [inline-methods] */
        public Connections.StartAdvertisingResult createFailedResult(final Status status) {
            return new Connections.StartAdvertisingResult() { // from class: com.google.android.gms.internal.zzoq.zzb.1
                @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
                public String getLocalEndpointName() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    public static zzop zzd(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzu.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        com.google.android.gms.common.internal.zzu.zza(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzop zze(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzu.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
        if (hasConnectedApi) {
            return (zzop) googleApiClient.zza(zzNX);
        }
        return null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, final String str, final byte[] bArr, Connections.MessageListener messageListener) {
        final com.google.android.gms.common.api.zzi zzo = googleApiClient.zzo(messageListener);
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzoq.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzop zzopVar) throws RemoteException {
                zzopVar.zza(this, str, bArr, zzo);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzdR(str);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzwS();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzwR();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzoq.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzop zzopVar) throws RemoteException {
                zzopVar.zzp(this, str);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, final String str, final String str2, final byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        final com.google.android.gms.common.api.zzi zzo = googleApiClient.zzo(connectionResponseCallback);
        final com.google.android.gms.common.api.zzi zzo2 = googleApiClient.zzo(messageListener);
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzoq.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzop zzopVar) throws RemoteException {
                zzopVar.zza(this, str, str2, bArr, zzo, zzo2);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zza(new String[]{str}, bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zza((String[]) list.toArray(new String[list.size()]), bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzd(googleApiClient, false).zzb(new String[]{str}, bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzd(googleApiClient, false).zzb((String[]) list.toArray(new String[list.size()]), bArr);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, final String str, final AppMetadata appMetadata, final long j, Connections.ConnectionRequestListener connectionRequestListener) {
        final com.google.android.gms.common.api.zzi zzo = googleApiClient.zzo(connectionRequestListener);
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzoq.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzop zzopVar) throws RemoteException {
                zzopVar.zza(this, str, appMetadata, j, zzo);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, final String str, final long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        final com.google.android.gms.common.api.zzi zzo = googleApiClient.zzo(endpointDiscoveryListener);
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzoq.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzop zzopVar) throws RemoteException {
                zzopVar.zza(this, str, j, zzo);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void stopAdvertising(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzwT();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzd(googleApiClient, false).zzwU();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzd(googleApiClient, false).zzdQ(str);
    }
}
