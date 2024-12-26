package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmg;
import com.google.android.gms.internal.zzmu;

/* loaded from: classes.dex */
public class zzne implements SensorsApi {

    private interface zza {
        void zzqR();
    }

    private static class zzb extends zzmg.zza {
        private final zza.zzb<DataSourcesResult> zzOs;

        private zzb(zza.zzb<DataSourcesResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzmg
        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzOs.zzm(dataSourcesResult);
        }
    }

    private static class zzc extends zzmu.zza {
        private final zza.zzb<Status> zzOs;
        private final zza zzalA;

        private zzc(zza.zzb<Status> zzbVar, zza zzaVar) {
            this.zzOs = zzbVar;
            this.zzalA = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzmu
        public void zzm(Status status) {
            if (this.zzalA != null && status.isSuccess()) {
                this.zzalA.zzqR();
            }
            this.zzOs.zzm(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final com.google.android.gms.fitness.data.zzj zzjVar, final PendingIntent pendingIntent, final zza zzaVar) {
        return googleApiClient.zzb(new zzmc.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzne.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmc zzmcVar) throws RemoteException {
                ((zzmn) zzmcVar.zznM()).zza(new SensorUnregistrationRequest(zzjVar, pendingIntent, new zzc(this, zzaVar), zzmcVar.getContext().getPackageName()));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzmc.zzc, com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final SensorRequest sensorRequest, final com.google.android.gms.fitness.data.zzj zzjVar, final PendingIntent pendingIntent) {
        return googleApiClient.zza((GoogleApiClient) new zzmc.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzne.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmc zzmcVar) throws RemoteException {
                ((zzmn) zzmcVar.zznM()).zza(new SensorRegistrationRequest(sensorRequest, zzjVar, pendingIntent, new zzng(this), zzmcVar.getContext().getPackageName()));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzmc.zzc, com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzb */
            public Status createFailedResult(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, PendingIntent pendingIntent) {
        return zza(googleApiClient, sensorRequest, (com.google.android.gms.fitness.data.zzj) null, pendingIntent);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> add(GoogleApiClient googleApiClient, SensorRequest sensorRequest, OnDataPointListener onDataPointListener) {
        return zza(googleApiClient, sensorRequest, zzk.zza.zzqH().zza(onDataPointListener), (PendingIntent) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient googleApiClient, final DataSourcesRequest dataSourcesRequest) {
        return googleApiClient.zza((GoogleApiClient) new zzmc.zza<DataSourcesResult>(googleApiClient) { // from class: com.google.android.gms.internal.zzne.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzG, reason: merged with bridge method [inline-methods] */
            public DataSourcesResult createFailedResult(Status status) {
                return DataSourcesResult.zzL(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmc zzmcVar) throws RemoteException {
                ((zzmn) zzmcVar.zznM()).zza(new DataSourcesRequest(dataSourcesRequest, new zzb(this), zzmcVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, (com.google.android.gms.fitness.data.zzj) null, pendingIntent, (zza) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final OnDataPointListener onDataPointListener) {
        com.google.android.gms.fitness.data.zzk zzb2 = zzk.zza.zzqH().zzb(onDataPointListener);
        return zzb2 == null ? new zzmw(Status.zzXP) : zza(googleApiClient, zzb2, (PendingIntent) null, new zza() { // from class: com.google.android.gms.internal.zzne.3
            @Override // com.google.android.gms.internal.zzne.zza
            public void zzqR() {
                zzk.zza.zzqH().zzc(onDataPointListener);
            }
        });
    }
}
