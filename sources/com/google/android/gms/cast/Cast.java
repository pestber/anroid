package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v7.internal.widget.ActivityChooserView;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zzu;
import java.io.IOException;

/* loaded from: classes.dex */
public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final Api.zza<zze, CastOptions> zzNY = new Api.zza<zze, CastOptions>() { // from class: com.google.android.gms.cast.Cast.1
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb(castOptions, "Setting the API options is required.");
            return new zze(context, looper, castOptions.zzQE, castOptions.zzQG, castOptions.zzQF, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<CastOptions> API = new Api<>("Cast.API", zzNY, zzk.zzNX, new Scope[0]);
    public static final CastApi CastApi = new CastApi.zza();

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        public static final class zza implements CastApi {
            @Override // com.google.android.gms.cast.Cast.CastApi
            public int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzNX)).zzlP();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzNX)).getApplicationMetadata();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzNX)).getApplicationStatus();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzNX)).zzlQ();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzNX)).zzlO();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException {
                return ((zze) googleApiClient.zza(zzk.zzNX)).isMute();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.6
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zzb(null, null, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.5
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zzb(str, null, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.4
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zzb(str, str2, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(str, false, (zza.zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, final String str, final LaunchOptions launchOptions) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(str, launchOptions, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z) {
                return launchApplication(googleApiClient, str, new LaunchOptions.Builder().setRelaunchIfRunning(z).build());
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zzd(this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzNX)).zzbC(str);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzNX)).zzlN();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, final String str, final String str2) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(str, str2, this);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzNX)).zza(str, messageReceivedCallback);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzNX)).zzR(z);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zze) googleApiClient.zza(zzk.zzNX)).zzd(d);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.8
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza("", this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, final String str) {
                return googleApiClient.zzb(new zzh(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.9
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.zza.AbstractC0035zza
                    public void zza(zze zzeVar) throws RemoteException {
                        if (TextUtils.isEmpty(str)) {
                            zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            zzeVar.zza(str, this);
                        } catch (IllegalStateException e) {
                            zzaL(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zzQE;
        final Listener zzQF;
        private final int zzQG;

        public static final class Builder {
            CastDevice zzQH;
            Listener zzQI;
            private int zzQJ;

            public Builder(CastDevice castDevice, Listener listener) {
                zzu.zzb(castDevice, "CastDevice parameter cannot be null");
                zzu.zzb(listener, "CastListener parameter cannot be null");
                this.zzQH = castDevice;
                this.zzQI = listener;
                this.zzQJ = 0;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public Builder setVerboseLoggingEnabled(boolean z) {
                int i = this.zzQJ;
                this.zzQJ = z ? i | 1 : i & (-2);
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzQE = builder.zzQH;
            this.zzQF = builder.zzQI;
            this.zzQG = builder.zzQJ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener listener) {
            return new Builder(castDevice, listener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int i) {
        }

        public void onApplicationDisconnected(int i) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int i) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private static abstract class zza extends com.google.android.gms.cast.internal.zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
        public ApplicationConnectionResult createFailedResult(final Status status) {
            return new ApplicationConnectionResult() { // from class: com.google.android.gms.cast.Cast.zza.1
                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public String getApplicationStatus() {
                    return null;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public String getSessionId() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
