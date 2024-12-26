package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzm;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes.dex */
public class zzc implements GeoDataApi {
    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<PlaceBuffer> addPlace(GoogleApiClient googleApiClient, final AddPlaceRequest addPlaceRequest) {
        return googleApiClient.zzb(new zzm.zzc<zzd>(Places.zzazQ, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zza(new com.google.android.gms.location.places.zzm(this, zzdVar.getContext()), addPlaceRequest);
            }
        });
    }

    @Override // com.google.android.gms.location.places.GeoDataApi
    public PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(GoogleApiClient googleApiClient, final String str, final LatLngBounds latLngBounds, final AutocompleteFilter autocompleteFilter) {
        return googleApiClient.zza((GoogleApiClient) new zzm.zza<zzd>(Places.zzazQ, googleApiClient) { // from class: com.google.android.gms.location.places.internal.zzc.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzd zzdVar) throws RemoteException {
                zzdVar.zza(new com.google.android.gms.location.places.zzm(this), str, latLngBounds, autocompleteFilter);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        if (r4.length >= 1) goto L7;
     */
    @Override // com.google.android.gms.location.places.GeoDataApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.common.api.PendingResult<com.google.android.gms.location.places.PlaceBuffer> getPlaceById(com.google.android.gms.common.api.GoogleApiClient r3, final java.lang.String... r4) {
        /*
            r2 = this;
            if (r4 == 0) goto L7
            int r0 = r4.length
            r1 = 1
            if (r0 < r1) goto L7
            goto L8
        L7:
            r1 = 0
        L8:
            com.google.android.gms.common.internal.zzu.zzV(r1)
            com.google.android.gms.location.places.internal.zzc$2 r0 = new com.google.android.gms.location.places.internal.zzc$2
            com.google.android.gms.common.api.Api$ClientKey<com.google.android.gms.location.places.internal.zzd> r1 = com.google.android.gms.location.places.Places.zzazQ
            r0.<init>(r1, r3)
            com.google.android.gms.common.api.zza$zza r0 = r3.zza(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.places.internal.zzc.getPlaceById(com.google.android.gms.common.api.GoogleApiClient, java.lang.String[]):com.google.android.gms.common.api.PendingResult");
    }
}
