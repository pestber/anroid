package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzni;

/* loaded from: classes.dex */
public class zzmz implements BleApi {

    private static class zza extends zzni.zza {
        private final zza.zzb<BleDevicesResult> zzOs;

        private zza(zza.zzb<BleDevicesResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzni
        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzOs.zzm(bleDevicesResult);
        }
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, final BleDevice bleDevice) {
        return googleApiClient.zzb(new zzlx.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzmz.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzlx zzlxVar) throws RemoteException {
                ((zzmi) zzlxVar.zznM()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zzng(this), zzlxVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> claimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzlx.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzmz.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzlx zzlxVar) throws RemoteException {
                ((zzmi) zzlxVar.zznM()).zza(new ClaimBleDeviceRequest(str, null, new zzng(this), zzlxVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new zzlx.zza<BleDevicesResult>(googleApiClient) { // from class: com.google.android.gms.internal.zzmz.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzB, reason: merged with bridge method [inline-methods] */
            public BleDevicesResult createFailedResult(Status status) {
                return BleDevicesResult.zzJ(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzlx zzlxVar) throws RemoteException {
                ((zzmi) zzlxVar.zznM()).zza(new ListClaimedBleDevicesRequest(new zza(this), zzlxVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> startBleScan(GoogleApiClient googleApiClient, final StartBleScanRequest startBleScanRequest) {
        return googleApiClient.zza((GoogleApiClient) new zzlx.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzmz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzlx zzlxVar) throws RemoteException {
                ((zzmi) zzlxVar.zznM()).zza(new StartBleScanRequest(startBleScanRequest, new zzng(this), zzlxVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> stopBleScan(GoogleApiClient googleApiClient, final BleScanCallback bleScanCallback) {
        return googleApiClient.zza((GoogleApiClient) new zzlx.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzmz.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzlx zzlxVar) throws RemoteException {
                ((zzmi) zzlxVar.zznM()).zza(new StopBleScanRequest(bleScanCallback, new zzng(this), zzlxVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, BleDevice bleDevice) {
        return unclaimBleDevice(googleApiClient, bleDevice.getAddress());
    }

    @Override // com.google.android.gms.fitness.BleApi
    public PendingResult<Status> unclaimBleDevice(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzlx.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzmz.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzlx zzlxVar) throws RemoteException {
                ((zzmi) zzlxVar.zznM()).zza(new UnclaimBleDeviceRequest(str, new zzng(this), zzlxVar.getContext().getPackageName()));
            }
        });
    }
}
