package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzms;
import com.google.android.gms.internal.zzmt;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class zznf implements SessionsApi {

    private static class zza extends zzms.zza {
        private final zza.zzb<SessionReadResult> zzOs;

        private zza(zza.zzb<SessionReadResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzms
        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzOs.zzm(sessionReadResult);
        }
    }

    private static class zzb extends zzmt.zza {
        private final zza.zzb<SessionStopResult> zzOs;

        private zzb(zza.zzb<SessionStopResult> zzbVar) {
            this.zzOs = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzmt
        public void zza(SessionStopResult sessionStopResult) {
            this.zzOs.zzm(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zzmd.zza<SessionStopResult>(googleApiClient) { // from class: com.google.android.gms.internal.zznf.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzH, reason: merged with bridge method [inline-methods] */
            public SessionStopResult createFailedResult(Status status) {
                return SessionStopResult.zzP(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmd zzmdVar) throws RemoteException {
                ((zzmo) zzmdVar.zznM()).zza(new SessionStopRequest(str, str2, new zzb(this), zzmdVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> insertSession(GoogleApiClient googleApiClient, final SessionInsertRequest sessionInsertRequest) {
        return googleApiClient.zza((GoogleApiClient) new zzmd.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznf.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmd zzmdVar) throws RemoteException {
                ((zzmo) zzmdVar.zznM()).zza(new SessionInsertRequest(sessionInsertRequest, new zzng(this), zzmdVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<SessionReadResult> readSession(GoogleApiClient googleApiClient, final SessionReadRequest sessionReadRequest) {
        return googleApiClient.zza((GoogleApiClient) new zzmd.zza<SessionReadResult>(googleApiClient) { // from class: com.google.android.gms.internal.zznf.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzI, reason: merged with bridge method [inline-methods] */
            public SessionReadResult createFailedResult(Status status) {
                return SessionReadResult.zzO(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmd zzmdVar) throws RemoteException {
                ((zzmo) zzmdVar.zznM()).zza(new SessionReadRequest(sessionReadRequest, new zza(this), zzmdVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> registerForSessions(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, pendingIntent, 0);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> startSession(GoogleApiClient googleApiClient, final Session session) {
        com.google.android.gms.common.internal.zzu.zzb(session, "Session cannot be null");
        com.google.android.gms.common.internal.zzu.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, "Cannot start a session which has already ended");
        return googleApiClient.zzb(new zzmd.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznf.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmd zzmdVar) throws RemoteException {
                ((zzmo) zzmdVar.zznM()).zza(new SessionStartRequest(session, new zzng(this), zzmdVar.getContext().getPackageName()));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<SessionStopResult> stopSession(GoogleApiClient googleApiClient, String str) {
        return zza(googleApiClient, (String) null, str);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> unregisterForSessions(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        return googleApiClient.zzb(new zzmd.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznf.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmd zzmdVar) throws RemoteException {
                ((zzmo) zzmdVar.zznM()).zza(new SessionUnregistrationRequest(pendingIntent, new zzng(this), zzmdVar.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzmd.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zznf.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzmd zzmdVar) throws RemoteException {
                ((zzmo) zzmdVar.zznM()).zza(new SessionRegistrationRequest(pendingIntent, new zzng(this), zzmdVar.getContext().getPackageName(), i));
            }
        });
    }
}
