package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationStatusCodes;
import com.google.android.gms.location.zze;
import java.util.List;

/* loaded from: classes.dex */
public class zze implements GeofencingApi {

    private static abstract class zza extends LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zze.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(geofencingRequest, pendingIntent, new zze.zza() { // from class: com.google.android.gms.location.internal.zze.1.1
                    @Override // com.google.android.gms.location.zze.zza
                    public void zza(int i, String[] strArr) {
                        setResult(LocationStatusCodes.zzgB(i));
                    }
                });
            }
        });
    }

    @Override // com.google.android.gms.location.GeofencingApi
    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleApiClient, builder.build(), pendingIntent);
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zze.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(pendingIntent, new zze.zzb() { // from class: com.google.android.gms.location.internal.zze.2.1
                    @Override // com.google.android.gms.location.zze.zzb
                    public void zza(int i, PendingIntent pendingIntent2) {
                        setResult(LocationStatusCodes.zzgB(i));
                    }

                    @Override // com.google.android.gms.location.zze.zzb
                    public void zzb(int i, String[] strArr) {
                        Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                    }
                });
            }
        });
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, final List<String> list) {
        return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.location.internal.zze.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(list, new zze.zzb() { // from class: com.google.android.gms.location.internal.zze.3.1
                    @Override // com.google.android.gms.location.zze.zzb
                    public void zza(int i, PendingIntent pendingIntent) {
                        Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                    }

                    @Override // com.google.android.gms.location.zze.zzb
                    public void zzb(int i, String[] strArr) {
                        setResult(LocationStatusCodes.zzgB(i));
                    }
                });
            }
        });
    }
}
