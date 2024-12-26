package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public interface GoogleApiClient {

    public static final class Builder {
        private final Context mContext;
        private Account zzMY;
        private String zzOd;
        private String zzOe;
        private FragmentActivity zzWA;
        private int zzWB;
        private int zzWC;
        private OnConnectionFailedListener zzWD;
        private Api.zza<? extends zzps, zzpt> zzWE;
        private final Set<ConnectionCallbacks> zzWF;
        private final Set<OnConnectionFailedListener> zzWG;
        private zzpt.zza zzWH;
        private Looper zzWt;
        private final Set<Scope> zzWv;
        private int zzWw;
        private View zzWx;
        private final Map<Api<?>, zze.zza> zzWy;
        private final Map<Api<?>, Api.ApiOptions> zzWz;

        public Builder(Context context) {
            this.zzWv = new HashSet();
            this.zzWy = new HashMap();
            this.zzWz = new HashMap();
            this.zzWB = -1;
            this.zzWC = -1;
            this.zzWF = new HashSet();
            this.zzWG = new HashSet();
            this.zzWH = new zzpt.zza();
            this.mContext = context;
            this.zzWt = context.getMainLooper();
            this.zzOe = context.getPackageName();
            this.zzOd = context.getClass().getName();
            this.zzWE = zzpq.zzNY;
        }

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzu.zzb(connectionCallbacks, "Must provide a connected listener");
            this.zzWF.add(connectionCallbacks);
            zzu.zzb(onConnectionFailedListener, "Must provide a connection failed listener");
            this.zzWG.add(onConnectionFailedListener);
        }

        private void zza(Api<?> api, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
                z = false;
            }
            HashSet hashSet = new HashSet(api.zzmr());
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.zzWy.put(api, new zze.zza(hashSet, z));
        }

        private GoogleApiClient zzmy() {
            zzm zza = zzm.zza(this.zzWA);
            zzg zzgVar = new zzg(this.mContext.getApplicationContext(), this.zzWt, zzmx(), this.zzWE, this.zzWz, this.zzWF, this.zzWG, this.zzWB, -1);
            zza.zza(this.zzWB, zzgVar, this.zzWD);
            return zzgVar;
        }

        private GoogleApiClient zzmz() {
            zzn zzb = zzn.zzb(this.zzWA);
            GoogleApiClient zzbc = zzb.zzbc(this.zzWC);
            if (zzbc == null) {
                zzbc = new zzg(this.mContext.getApplicationContext(), this.zzWt, zzmx(), this.zzWE, this.zzWz, this.zzWF, this.zzWG, -1, this.zzWC);
            }
            zzb.zza(this.zzWC, zzbc, this.zzWD);
            return zzbc;
        }

        public Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.zzWz.put(api, null);
            this.zzWv.addAll(api.zzmr());
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o) {
            zzu.zzb(o, "Null options are not permitted for this Api");
            this.zzWz.put(api, o);
            this.zzWv.addAll(api.zzmr());
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(Api<O> api, O o, Scope... scopeArr) {
            zzu.zzb(o, "Null options are not permitted for this Api");
            this.zzWz.put(api, o);
            zza(api, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            this.zzWz.put(api, null);
            zza(api, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            this.zzWF.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            this.zzWG.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.zzWv.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzu.zzb(!this.zzWz.isEmpty(), "must call addApi() to add at least one API");
            return this.zzWB >= 0 ? zzmy() : this.zzWC >= 0 ? zzmz() : new zzg(this.mContext, this.zzWt, zzmx(), this.zzWE, this.zzWz, this.zzWF, this.zzWG, -1, -1);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            zzu.zzb(i >= 0, "clientId must be non-negative");
            this.zzWB = i;
            this.zzWA = (FragmentActivity) zzu.zzb(fragmentActivity, "Null activity is not permitted.");
            this.zzWD = onConnectionFailedListener;
            return this;
        }

        public Builder requestServerAuthCode(String str, ServerAuthCodeCallbacks serverAuthCodeCallbacks) {
            this.zzWH.zza(str, serverAuthCodeCallbacks);
            return this;
        }

        public Builder setAccountName(String str) {
            this.zzMY = str == null ? null : new Account(str, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.zzWw = i;
            return this;
        }

        public Builder setHandler(Handler handler) {
            zzu.zzb(handler, "Handler must not be null");
            this.zzWt = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View view) {
            this.zzWx = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public com.google.android.gms.common.internal.zze zzmx() {
            return new com.google.android.gms.common.internal.zze(this.zzMY, this.zzWv, this.zzWy, this.zzWw, this.zzWx, this.zzOe, this.zzOd, this.zzWH.zzyc());
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface ConnectionProgressReportCallbacks {
        void onReportAccountValidation(ConnectionResult connectionResult);

        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public interface ServerAuthCodeCallbacks {

        public static class CheckResult {
            private boolean zzWI;
            private Set<Scope> zzWJ;

            private CheckResult(boolean z, Set<Scope> set) {
                this.zzWI = z;
                this.zzWJ = set;
            }

            public static CheckResult newAuthNotRequiredResult() {
                return new CheckResult(false, null);
            }

            public static CheckResult newAuthRequiredResult(Set<Scope> set) {
                zzu.zzb((set == null || set.isEmpty()) ? false : true, "A non-empty scope set is required if further auth is needed.");
                return new CheckResult(true, set);
            }

            public boolean zzmA() {
                return this.zzWI;
            }

            public Set<Scope> zzmB() {
                return this.zzWJ;
            }
        }

        CheckResult onCheckServerAuthorization(String str, Set<Scope> set);

        boolean onUploadServerAuthCode(String str, String str2);
    }

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    PendingResult<Status> clearDefaultAccountAndReconnect();

    void connect();

    void disconnect();

    void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    ConnectionResult getConnectionResult(Api<?> api);

    Context getContext();

    Looper getLooper();

    int getSessionId();

    boolean hasConnectedApi(Api<?> api);

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage(FragmentActivity fragmentActivity);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    <C extends Api.Client> C zza(Api.ClientKey<C> clientKey);

    <A extends Api.Client, R extends Result, T extends zza.AbstractC0035zza<R, A>> T zza(T t);

    boolean zza(Api<?> api);

    boolean zza(Scope scope);

    <A extends Api.Client, T extends zza.AbstractC0035zza<? extends Result, A>> T zzb(T t);

    <L> zzi<L> zzo(L l);
}
