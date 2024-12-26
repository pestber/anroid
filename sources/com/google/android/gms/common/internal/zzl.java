package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
final class zzl extends zzk implements Handler.Callback {
    private final Handler mHandler;
    private final HashMap<zza, zzb> zzaaL = new HashMap<>();
    private final com.google.android.gms.common.stats.zzb zzaaM = com.google.android.gms.common.stats.zzb.zzoO();
    private final long zzaaN = 5000;
    private final Context zzqw;

    private static final class zza {
        private final ComponentName zzaaO;
        private final String zzuO;

        public zza(ComponentName componentName) {
            this.zzuO = null;
            this.zzaaO = (ComponentName) zzu.zzu(componentName);
        }

        public zza(String str) {
            this.zzuO = zzu.zzcj(str);
            this.zzaaO = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return zzt.equal(this.zzuO, zzaVar.zzuO) && zzt.equal(this.zzaaO, zzaVar.zzaaO);
        }

        public int hashCode() {
            return zzt.hashCode(this.zzuO, this.zzaaO);
        }

        public String toString() {
            return this.zzuO == null ? this.zzaaO.flattenToString() : this.zzuO;
        }

        public Intent zznV() {
            return this.zzuO != null ? new Intent(this.zzuO).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzaaO);
        }
    }

    private final class zzb {
        private IBinder zzZQ;
        private ComponentName zzaaO;
        private boolean zzaaR;
        private final zza zzaaS;
        private final zza zzaaP = new zza();
        private final Set<ServiceConnection> zzaaQ = new HashSet();
        private int mState = 2;

        public class zza implements ServiceConnection {
            public zza() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzl.this.zzaaL) {
                    zzb.this.zzZQ = iBinder;
                    zzb.this.zzaaO = componentName;
                    Iterator it = zzb.this.zzaaQ.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                    }
                    zzb.this.mState = 1;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzl.this.zzaaL) {
                    zzb.this.zzZQ = null;
                    zzb.this.zzaaO = componentName;
                    Iterator it = zzb.this.zzaaQ.iterator();
                    while (it.hasNext()) {
                        ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zzaVar) {
            this.zzaaS = zzaVar;
        }

        public IBinder getBinder() {
            return this.zzZQ;
        }

        public ComponentName getComponentName() {
            return this.zzaaO;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzaaR;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzl.this.zzaaM.zza(zzl.this.zzqw, serviceConnection, str, this.zzaaS.zznV());
            this.zzaaQ.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzaaQ.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzl.this.zzaaM.zzb(zzl.this.zzqw, serviceConnection);
            this.zzaaQ.remove(serviceConnection);
        }

        public void zzcc(String str) {
            this.zzaaR = zzl.this.zzaaM.zza(zzl.this.zzqw, str, this.zzaaS.zznV(), this.zzaaP, 129);
            if (this.zzaaR) {
                this.mState = 3;
            } else {
                try {
                    zzl.this.zzaaM.zza(zzl.this.zzqw, this.zzaaP);
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public void zzcd(String str) {
            zzl.this.zzaaM.zza(zzl.this.zzqw, this.zzaaP);
            this.zzaaR = false;
            this.mState = 2;
        }

        public boolean zznW() {
            return this.zzaaQ.isEmpty();
        }
    }

    zzl(Context context) {
        this.zzqw = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    private boolean zza(zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzu.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzaaL) {
            zzb zzbVar = this.zzaaL.get(zzaVar);
            if (zzbVar == null) {
                zzbVar = new zzb(zzaVar);
                zzbVar.zza(serviceConnection, str);
                zzbVar.zzcc(str);
                this.zzaaL.put(zzaVar, zzbVar);
            } else {
                this.mHandler.removeMessages(0, zzbVar);
                if (!zzbVar.zza(serviceConnection)) {
                    zzbVar.zza(serviceConnection, str);
                    switch (zzbVar.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzbVar.getComponentName(), zzbVar.getBinder());
                            break;
                        case 2:
                            zzbVar.zzcc(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zzaVar);
                }
            }
            isBound = zzbVar.isBound();
        }
        return isBound;
    }

    private void zzb(zza zzaVar, ServiceConnection serviceConnection, String str) {
        zzu.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzaaL) {
            zzb zzbVar = this.zzaaL.get(zzaVar);
            if (zzbVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zzaVar);
            }
            if (!zzbVar.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zzaVar);
            }
            zzbVar.zzb(serviceConnection, str);
            if (zzbVar.zznW()) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzbVar), this.zzaaN);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                zzb zzbVar = (zzb) message.obj;
                synchronized (this.zzaaL) {
                    if (zzbVar.zznW()) {
                        if (zzbVar.isBound()) {
                            zzbVar.zzcd("GmsClientSupervisor");
                        }
                        this.zzaaL.remove(zzbVar.zzaaS);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.common.internal.zzk
    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzk
    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    @Override // com.google.android.gms.common.internal.zzk
    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzk
    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
