package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class zzj implements Handler.Callback {
    private final Handler mHandler;
    private final zza zzaaC;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaaD = new ArrayList<>();
    final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaaE = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzaaF = new ArrayList<>();
    private volatile boolean zzaaG = false;
    private final AtomicInteger zzaaH = new AtomicInteger(0);
    private boolean zzaaI = false;
    private final Object zzqt = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzlM();
    }

    public zzj(Looper looper, zza zzaVar) {
        this.zzaaC = zzaVar;
        this.mHandler = new Handler(looper, this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
        synchronized (this.zzqt) {
            if (this.zzaaG && this.zzaaC.isConnected() && this.zzaaD.contains(connectionCallbacks)) {
                connectionCallbacks.onConnected(this.zzaaC.zzlM());
            }
        }
        return true;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzu.zzu(connectionCallbacks);
        synchronized (this.zzqt) {
            contains = this.zzaaD.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzu.zzu(onConnectionFailedListener);
        synchronized (this.zzqt) {
            contains = this.zzaaF.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzu.zzu(connectionCallbacks);
        synchronized (this.zzqt) {
            if (this.zzaaD.contains(connectionCallbacks)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + connectionCallbacks + " is already registered");
            } else {
                this.zzaaD.add(connectionCallbacks);
            }
        }
        if (this.zzaaC.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzu.zzu(onConnectionFailedListener);
        synchronized (this.zzqt) {
            if (this.zzaaF.contains(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + onConnectionFailedListener + " is already registered");
            } else {
                this.zzaaF.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzu.zzu(connectionCallbacks);
        synchronized (this.zzqt) {
            if (!this.zzaaD.remove(connectionCallbacks)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + connectionCallbacks + " not found");
            } else if (this.zzaaI) {
                this.zzaaE.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzu.zzu(onConnectionFailedListener);
        synchronized (this.zzqt) {
            if (!this.zzaaF.remove(onConnectionFailedListener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + onConnectionFailedListener + " not found");
            }
        }
    }

    public void zzbu(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.zzqt) {
            this.zzaaI = true;
            ArrayList arrayList = new ArrayList(this.zzaaD);
            int i2 = this.zzaaH.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzaaG || this.zzaaH.get() != i2) {
                    break;
                } else if (this.zzaaD.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzaaE.clear();
            this.zzaaI = false;
        }
    }

    public void zzg(Bundle bundle) {
        synchronized (this.zzqt) {
            boolean z = true;
            zzu.zzU(!this.zzaaI);
            this.mHandler.removeMessages(1);
            this.zzaaI = true;
            if (this.zzaaE.size() != 0) {
                z = false;
            }
            zzu.zzU(z);
            ArrayList arrayList = new ArrayList(this.zzaaD);
            int i = this.zzaaH.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.zzaaG || !this.zzaaC.isConnected() || this.zzaaH.get() != i) {
                    break;
                } else if (!this.zzaaE.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzaaE.clear();
            this.zzaaI = false;
        }
    }

    public void zzh(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.zzqt) {
            ArrayList arrayList = new ArrayList(this.zzaaF);
            int i = this.zzaaH.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener) it.next();
                if (this.zzaaG && this.zzaaH.get() == i) {
                    if (this.zzaaF.contains(onConnectionFailedListener)) {
                        onConnectionFailedListener.onConnectionFailed(connectionResult);
                    }
                }
                return;
            }
        }
    }

    public void zznT() {
        this.zzaaG = false;
        this.zzaaH.incrementAndGet();
    }

    public void zznU() {
        this.zzaaG = true;
    }
}
