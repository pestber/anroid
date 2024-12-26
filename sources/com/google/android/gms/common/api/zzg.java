package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
final class zzg implements GoogleApiClient {
    private final Context mContext;
    private final int zzWB;
    private final int zzWC;
    final Api.zza<? extends zzps, zzpt> zzWE;
    private final Looper zzWt;
    final com.google.android.gms.common.internal.zze zzXa;
    final com.google.android.gms.common.internal.zzj zzXn;
    private volatile boolean zzXp;
    final zza zzXs;
    BroadcastReceiver zzXt;
    private final Lock zzWL = new ReentrantLock();
    final Queue<zze<?>> zzXo = new LinkedList();
    private long zzXq = 120000;
    private long zzXr = 5000;
    final Map<Api.ClientKey<?>, Api.Client> zzXu = new HashMap();
    final Map<Api.ClientKey<?>, ConnectionResult> zzXv = new HashMap();
    Set<Scope> zzXw = new HashSet();
    private ConnectionResult zzXy = null;
    private final Set<zzi<?>> zzXz = Collections.newSetFromMap(new WeakHashMap());
    final Set<zze<?>> zzXA = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final zzc zzXB = new zzc() { // from class: com.google.android.gms.common.api.zzg.1
        @Override // com.google.android.gms.common.api.zzg.zzc
        public void zzc(zze<?> zzeVar) {
            zzg.this.zzXA.remove(zzeVar);
        }
    };
    private final GoogleApiClient.ConnectionCallbacks zzXC = new zzd() { // from class: com.google.android.gms.common.api.zzg.2
        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            zzg.this.zzXx.onConnected(bundle);
        }
    };
    private final zzj.zza zzXD = new zzj.zza() { // from class: com.google.android.gms.common.api.zzg.3
        @Override // com.google.android.gms.common.internal.zzj.zza
        public boolean isConnected() {
            return zzg.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzj.zza
        public Bundle zzlM() {
            return null;
        }
    };
    final Map<Api<?>, Integer> zzXb = new HashMap();
    private final Condition zzXm = this.zzWL.newCondition();
    private volatile zzh zzXx = new zzf(this);

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzg.this.zzmP();
                    break;
                case 2:
                    zzg.this.resume();
                    break;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    break;
            }
        }
    }

    private static class zzb extends BroadcastReceiver {
        private WeakReference<zzg> zzXK;

        zzb(zzg zzgVar) {
            this.zzXK = new WeakReference<>(zzgVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            zzg zzgVar;
            Uri data = intent.getData();
            String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
            if (schemeSpecificPart == null || !schemeSpecificPart.equals("com.google.android.gms") || (zzgVar = this.zzXK.get()) == null) {
                return;
            }
            zzgVar.resume();
        }
    }

    interface zzc {
        void zzc(zze<?> zzeVar);
    }

    public abstract class zzd implements GoogleApiClient.ConnectionCallbacks {
        public zzd() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            zzg.this.zzWL.lock();
            try {
                zzg.this.zzXx.onConnectionSuspended(i);
            } finally {
                zzg.this.zzWL.unlock();
            }
        }
    }

    interface zze<A extends Api.Client> {
        void cancel();

        void forceFailureUnlessReady(Status status);

        void zza(zzc zzcVar);

        void zzb(A a) throws DeadObjectException;

        Api.ClientKey<A> zzms();

        int zzmv();

        void zzr(Status status);
    }

    public zzg(Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, Api.zza<? extends zzps, zzpt> zzaVar, Map<Api<?>, Api.ApiOptions> map, Set<GoogleApiClient.ConnectionCallbacks> set, Set<GoogleApiClient.OnConnectionFailedListener> set2, int i, int i2) {
        this.mContext = context;
        this.zzXn = new com.google.android.gms.common.internal.zzj(looper, this.zzXD);
        this.zzWt = looper;
        this.zzXs = new zza(looper);
        this.zzWB = i;
        this.zzWC = i2;
        Iterator<GoogleApiClient.ConnectionCallbacks> it = set.iterator();
        while (it.hasNext()) {
            this.zzXn.registerConnectionCallbacks(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = set2.iterator();
        while (it2.hasNext()) {
            this.zzXn.registerConnectionFailedListener(it2.next());
        }
        Map<Api<?>, zze.zza> zznx = zzeVar.zznx();
        for (Api<?> api : map.keySet()) {
            Api.ApiOptions apiOptions = map.get(api);
            int i3 = zznx.get(api) != null ? zznx.get(api).zzZW ? 1 : 2 : 0;
            this.zzXb.put(api, Integer.valueOf(i3));
            this.zzXu.put(api.zzms(), api.zzmt() ? zza(api.zzmq(), apiOptions, context, looper, zzeVar, this.zzXC, zza(api, i3)) : zza(api.zzmp(), apiOptions, context, looper, zzeVar, this.zzXC, zza(api, i3)));
        }
        this.zzXa = zzeVar;
        this.zzWE = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.zzWL.lock();
        try {
            if (zzmO()) {
                connect();
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <C extends Api.Client, O> C zza(Api.zza<C, O> zzaVar, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return zzaVar.zza(context, looper, zzeVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private final GoogleApiClient.OnConnectionFailedListener zza(final Api<?> api, final int i) {
        return new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.common.api.zzg.4
            @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
            public void onConnectionFailed(ConnectionResult connectionResult) {
                zzg.this.zzXx.zza(connectionResult, api, i);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <C extends Api.zzb, O> zzz zza(Api.zzc<C, O> zzcVar, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zze zzeVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzz(context, looper, zzcVar.zzmu(), connectionCallbacks, onConnectionFailedListener, zzeVar, zzcVar.zzl(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzl zzlVar, final boolean z) {
        zzkl.zzabj.zzc(googleApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.google.android.gms.common.api.zzg.7
            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: zzm, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.isSuccess() && zzg.this.isConnected()) {
                    zzg.this.reconnect();
                }
                zzlVar.setResult(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void zzaY(int i) {
        this.zzWL.lock();
        try {
            this.zzXx.zzaV(i);
        } finally {
            this.zzWL.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzmP() {
        this.zzWL.lock();
        try {
            if (zzmR()) {
                connect();
            }
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        zzu.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzWL.lock();
        try {
            connect();
            while (isConnecting()) {
                try {
                    this.zzXm.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    connectionResult = new ConnectionResult(15, null);
                }
            }
            connectionResult = isConnected() ? ConnectionResult.zzVG : this.zzXy != null ? this.zzXy : new ConnectionResult(13, null);
            return connectionResult;
        } finally {
            this.zzWL.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        r0 = new com.google.android.gms.common.ConnectionResult(14, null);
     */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.common.ConnectionResult blockingConnect(long r7, java.util.concurrent.TimeUnit r9) {
        /*
            r6 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            com.google.android.gms.common.internal.zzu.zza(r0, r1)
            java.util.concurrent.locks.Lock r0 = r6.zzWL
            r0.lock()
            r6.connect()     // Catch: java.lang.Throwable -> L66
            long r0 = r9.toNanos(r7)     // Catch: java.lang.Throwable -> L66
        L1e:
            boolean r2 = r6.isConnecting()     // Catch: java.lang.Throwable -> L66
            r3 = 0
            if (r2 == 0) goto L4e
            java.util.concurrent.locks.Condition r2 = r6.zzXm     // Catch: java.lang.InterruptedException -> L3e java.lang.Throwable -> L66
            long r0 = r2.awaitNanos(r0)     // Catch: java.lang.InterruptedException -> L3e java.lang.Throwable -> L66
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 > 0) goto L1e
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch: java.lang.InterruptedException -> L3e java.lang.Throwable -> L66
            r1 = 14
            r0.<init>(r1, r3)     // Catch: java.lang.InterruptedException -> L3e java.lang.Throwable -> L66
        L38:
            java.util.concurrent.locks.Lock r1 = r6.zzWL
            r1.unlock()
            return r0
        L3e:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L66
            r0.interrupt()     // Catch: java.lang.Throwable -> L66
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch: java.lang.Throwable -> L66
            r1 = 15
            r0.<init>(r1, r3)     // Catch: java.lang.Throwable -> L66
            goto L38
        L4e:
            boolean r0 = r6.isConnected()     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L57
            com.google.android.gms.common.ConnectionResult r0 = com.google.android.gms.common.ConnectionResult.zzVG     // Catch: java.lang.Throwable -> L66
            goto L38
        L57:
            com.google.android.gms.common.ConnectionResult r0 = r6.zzXy     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L5e
            com.google.android.gms.common.ConnectionResult r0 = r6.zzXy     // Catch: java.lang.Throwable -> L66
            goto L38
        L5e:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch: java.lang.Throwable -> L66
            r1 = 13
            r0.<init>(r1, r3)     // Catch: java.lang.Throwable -> L66
            goto L38
        L66:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r6.zzWL
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzg.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzu.zza(isConnected(), "GoogleApiClient is not connected yet.");
        final zzl zzlVar = new zzl(this.zzWt);
        if (this.zzXu.containsKey(zzkl.zzNX)) {
            zza(this, zzlVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.common.api.zzg.5
                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle bundle) {
                    zzg.this.zza((GoogleApiClient) atomicReference.get(), zzlVar, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int i) {
                }
            };
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzkl.API).addConnectionCallbacks(connectionCallbacks).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.common.api.zzg.6
                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(ConnectionResult connectionResult) {
                    zzlVar.setResult(new Status(8));
                }
            }).setHandler(this.zzXs).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzlVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.zzWL.lock();
        try {
            this.zzXx.connect();
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        zzmR();
        zzaY(-1);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mState=").append((CharSequence) this.zzXx.getName());
        printWriter.append(" mResuming=").print(this.zzXp);
        printWriter.append(" mWorkQueue.size()=").print(this.zzXo.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.zzXA.size());
        String str2 = str + "  ";
        for (Api<?> api : this.zzXb.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.zzXu.get(api.zzms()).dump(str2, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        Api.ClientKey<?> zzms = api.zzms();
        this.zzWL.lock();
        try {
            if (!isConnected() && !zzmO()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zzXu.containsKey(zzms)) {
                this.zzWL.unlock();
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
            if (this.zzXu.get(zzms).isConnected()) {
                connectionResult = ConnectionResult.zzVG;
            } else if (this.zzXv.containsKey(zzms)) {
                connectionResult = this.zzXv.get(zzms);
            } else {
                Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult is not connected but is not present in the failed connections map");
                connectionResult = new ConnectionResult(8, null);
            }
            return connectionResult;
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzWt;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(Api<?> api) {
        Api.Client client = this.zzXu.get(api.zzms());
        if (client == null) {
            return false;
        }
        return client.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        return this.zzXx instanceof com.google.android.gms.common.api.zzd;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        return this.zzXx instanceof com.google.android.gms.common.api.zze;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zzXn.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzXn.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzXn.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzXn.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(FragmentActivity fragmentActivity) {
        if (this.zzWB >= 0) {
            zzm.zza(fragmentActivity).zzbb(this.zzWB);
        } else {
            if (this.zzWC < 0) {
                throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
            }
            zzn.zzb(fragmentActivity).zzbb(this.zzWC);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzXn.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzXn.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <C extends Api.Client> C zza(Api.ClientKey<C> clientKey) {
        C c = (C) this.zzXu.get(clientKey);
        zzu.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.Client, R extends Result, T extends zza.AbstractC0035zza<R, A>> T zza(T t) {
        zzu.zzb(t.zzms() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        zzu.zzb(this.zzXu.containsKey(t.zzms()), "GoogleApiClient is not configured to use the API required for this call.");
        this.zzWL.lock();
        try {
            return (T) this.zzXx.zza(t);
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(Api<?> api) {
        return this.zzXu.containsKey(api.zzms());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(Scope scope) {
        boolean z;
        this.zzWL.lock();
        try {
            if (isConnected()) {
                if (this.zzXw.contains(scope)) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.Client, T extends zza.AbstractC0035zza<? extends Result, A>> T zzb(T t) {
        zzu.zzb(t.zzms() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.zzWL.lock();
        try {
            if (zzmO()) {
                this.zzXo.add(t);
                while (!this.zzXo.isEmpty()) {
                    zze<A> zzeVar = (zze) this.zzXo.remove();
                    zzb(zzeVar);
                    zzeVar.zzr(Status.zzXR);
                }
            } else {
                t = (T) this.zzXx.zzb(t);
            }
            return t;
        } finally {
            this.zzWL.unlock();
        }
    }

    <A extends Api.Client> void zzb(zze<A> zzeVar) {
        this.zzXA.add(zzeVar);
        zzeVar.zza(this.zzXB);
    }

    void zze(ConnectionResult connectionResult) {
        this.zzWL.lock();
        try {
            this.zzXy = connectionResult;
            this.zzXx = new zzf(this);
            this.zzXx.begin();
            this.zzXm.signalAll();
        } finally {
            this.zzWL.unlock();
        }
    }

    void zzmK() {
        for (zze<?> zzeVar : this.zzXA) {
            zzeVar.zza(null);
            zzeVar.cancel();
        }
        this.zzXA.clear();
        Iterator<zzi<?>> it = this.zzXz.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.zzXz.clear();
        this.zzXw.clear();
    }

    void zzmL() {
        Iterator<Api.Client> it = this.zzXu.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
    }

    void zzmM() {
        this.zzWL.lock();
        try {
            this.zzXx = new com.google.android.gms.common.api.zze(this, this.zzXa, this.zzXb, this.zzWE, this.zzWL, this.mContext);
            this.zzXx.begin();
            this.zzXm.signalAll();
        } finally {
            this.zzWL.unlock();
        }
    }

    void zzmN() {
        this.zzWL.lock();
        try {
            zzmR();
            this.zzXx = new com.google.android.gms.common.api.zzd(this);
            this.zzXx.begin();
            this.zzXm.signalAll();
        } finally {
            this.zzWL.unlock();
        }
    }

    boolean zzmO() {
        return this.zzXp;
    }

    void zzmQ() {
        if (zzmO()) {
            return;
        }
        this.zzXp = true;
        if (this.zzXt == null) {
            this.zzXt = new zzb(this);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            this.mContext.getApplicationContext().registerReceiver(this.zzXt, intentFilter);
        }
        this.zzXs.sendMessageDelayed(this.zzXs.obtainMessage(1), this.zzXq);
        this.zzXs.sendMessageDelayed(this.zzXs.obtainMessage(2), this.zzXr);
    }

    boolean zzmR() {
        this.zzWL.lock();
        try {
            boolean z = false;
            if (zzmO()) {
                this.zzXp = false;
                this.zzXs.removeMessages(2);
                z = true;
                this.zzXs.removeMessages(1);
                if (this.zzXt != null) {
                    this.mContext.getApplicationContext().unregisterReceiver(this.zzXt);
                    this.zzXt = null;
                }
            }
            return z;
        } finally {
            this.zzWL.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzi<L> zzo(L l) {
        zzu.zzb(l, "Listener must not be null");
        this.zzWL.lock();
        try {
            zzi<L> zziVar = new zzi<>(this.zzWt, l);
            this.zzXz.add(zziVar);
            return zziVar;
        } finally {
            this.zzWL.unlock();
        }
    }
}
