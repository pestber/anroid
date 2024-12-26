package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzjb;

@Deprecated
/* loaded from: classes.dex */
public final class AppStateManager {
    static final Api.ClientKey<zzjb> zzNX = new Api.ClientKey<>();
    private static final Api.zza<zzjb, Api.ApiOptions.NoOptions> zzNY = new Api.zza<zzjb, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.appstate.AppStateManager.1
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzjb zza(Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjb(context, looper, zzeVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("AppStateManager.API", zzNY, zzNX, SCOPE_APP_STATE);

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class zza<R extends Result> extends zza.AbstractC0035zza<R, zzjb> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppStateManager.zzNX, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StateDeletedResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    private static abstract class zzc extends zza<StateListResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
        public StateListResult createFailedResult(final Status status) {
            return new StateListResult() { // from class: com.google.android.gms.appstate.AppStateManager.zzc.1
                @Override // com.google.android.gms.appstate.AppStateManager.StateListResult
                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzd extends zza<Status> {
        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private static abstract class zze extends zza<StateResult> {
        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
        public StateResult createFailedResult(Status status) {
            return AppStateManager.zzd(status);
        }
    }

    private AppStateManager() {
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zza(this, i);
            }

            @Override // com.google.android.gms.common.api.AbstractPendingResult
            /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
            public StateDeletedResult createFailedResult(final Status status) {
                return new StateDeletedResult() { // from class: com.google.android.gms.appstate.AppStateManager.5.1
                    @Override // com.google.android.gms.appstate.AppStateManager.StateDeletedResult
                    public int getStateKey() {
                        return i;
                    }

                    @Override // com.google.android.gms.common.api.Result
                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzkW();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzkV();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.zza((GoogleApiClient) new zzc(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zza(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza((GoogleApiClient) new zze(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zzb(this, i);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int i, final String str, final byte[] bArr) {
        return googleApiClient.zzb(new zze(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zza(this, i, str, bArr);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzd(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zzb(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int i, final byte[] bArr) {
        googleApiClient.zzb(new zze(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zza((zza.zzb<StateResult>) null, i, bArr);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int i, final byte[] bArr) {
        return googleApiClient.zzb(new zze(googleApiClient) { // from class: com.google.android.gms.appstate.AppStateManager.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
            public void zza(zzjb zzjbVar) throws RemoteException {
                zzjbVar.zza(this, i, bArr);
            }
        });
    }

    public static zzjb zza(GoogleApiClient googleApiClient) {
        zzu.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzu.zza(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        zzu.zza(googleApiClient.zza(API), "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjb) googleApiClient.zza(zzNX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static StateResult zzd(final Status status) {
        return new StateResult() { // from class: com.google.android.gms.appstate.AppStateManager.2
            @Override // com.google.android.gms.appstate.AppStateManager.StateResult
            public StateConflictResult getConflictResult() {
                return null;
            }

            @Override // com.google.android.gms.appstate.AppStateManager.StateResult
            public StateLoadedResult getLoadedResult() {
                return null;
            }

            @Override // com.google.android.gms.common.api.Result
            public Status getStatus() {
                return status;
            }

            @Override // com.google.android.gms.common.api.Releasable
            public void release() {
            }
        };
    }
}
