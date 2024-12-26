package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import java.io.IOException;

/* loaded from: classes.dex */
class zza {
    private static Object zzaKl = new Object();
    private static zza zzaKm;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzFZ;
    private volatile AdvertisingIdClient.Info zzJl;
    private volatile long zzaKh;
    private volatile long zzaKi;
    private volatile long zzaKj;
    private InterfaceC0239zza zzaKk;
    private final zzlb zzpw;

    /* renamed from: com.google.android.gms.tagmanager.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC0239zza {
        AdvertisingIdClient.Info zzyg();
    }

    private zza(Context context) {
        this(context, null, zzld.zzoQ());
    }

    zza(Context context, InterfaceC0239zza interfaceC0239zza, zzlb zzlbVar) {
        this.zzaKh = 900000L;
        this.zzaKi = 30000L;
        this.mClosed = false;
        this.zzaKk = new InterfaceC0239zza() { // from class: com.google.android.gms.tagmanager.zza.1
            @Override // com.google.android.gms.tagmanager.zza.InterfaceC0239zza
            public AdvertisingIdClient.Info zzyg() {
                String str;
                try {
                    return AdvertisingIdClient.getAdvertisingIdInfo(zza.this.mContext);
                } catch (GooglePlayServicesNotAvailableException e) {
                    str = "GooglePlayServicesNotAvailableException getting Advertising Id Info";
                    zzbg.zzaC(str);
                    return null;
                } catch (GooglePlayServicesRepairableException e2) {
                    str = "GooglePlayServicesRepairableException getting Advertising Id Info";
                    zzbg.zzaC(str);
                    return null;
                } catch (IOException e3) {
                    str = "IOException getting Ad Id Info";
                    zzbg.zzaC(str);
                    return null;
                } catch (IllegalStateException e4) {
                    str = "IllegalStateException getting Advertising Id Info";
                    zzbg.zzaC(str);
                    return null;
                } catch (Exception e5) {
                    str = "Unknown exception. Could not get the Advertising Id Info.";
                    zzbg.zzaC(str);
                    return null;
                }
            }
        };
        this.zzpw = zzlbVar;
        this.mContext = context != null ? context.getApplicationContext() : context;
        if (interfaceC0239zza != null) {
            this.zzaKk = interfaceC0239zza;
        }
        this.zzFZ = new Thread(new Runnable() { // from class: com.google.android.gms.tagmanager.zza.2
            @Override // java.lang.Runnable
            public void run() {
                zza.this.zzye();
            }
        });
    }

    static zza zzaE(Context context) {
        if (zzaKm == null) {
            synchronized (zzaKl) {
                if (zzaKm == null) {
                    zzaKm = new zza(context);
                    zzaKm.start();
                }
            }
        }
        return zzaKm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzye() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.zzJl = this.zzaKk.zzyg();
                Thread.sleep(this.zzaKh);
            } catch (InterruptedException e) {
                zzbg.zzaA("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void zzyf() {
        if (this.zzpw.currentTimeMillis() - this.zzaKj < this.zzaKi) {
            return;
        }
        interrupt();
        this.zzaKj = this.zzpw.currentTimeMillis();
    }

    void interrupt() {
        this.zzFZ.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        zzyf();
        if (this.zzJl == null) {
            return true;
        }
        return this.zzJl.isLimitAdTrackingEnabled();
    }

    void start() {
        this.zzFZ.start();
    }

    public String zzyd() {
        zzyf();
        if (this.zzJl == null) {
            return null;
        }
        return this.zzJl.getId();
    }
}
