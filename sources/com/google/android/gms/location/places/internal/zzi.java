package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;

/* loaded from: classes.dex */
public class zzi implements PlaceDetectionApi {
    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient googleApiClient, final PlaceFilter placeFilter) {
        return googleApiClient.zza((GoogleApiClient) new zzm.zzd<zzj>(Places.zzazR, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzi.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(new com.google.android.gms.location.places.zzm(this, zzjVar.getContext()), placeFilter);
            }
        });
    }

    @Override // com.google.android.gms.location.places.PlaceDetectionApi
    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient googleApiClient, final PlaceReport placeReport) {
        return googleApiClient.zzb(new zzm.zzf<zzj>(Places.zzazR, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzi.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(new com.google.android.gms.location.places.zzm(this), placeReport);
            }
        });
    }
}
