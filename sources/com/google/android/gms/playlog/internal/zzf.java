package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.playlog.internal.zza;
import com.google.android.gms.playlog.internal.zzb;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zzf extends zzi<zza> {
    private final String zzMZ;
    private final zzd zzaGW;
    private final zzb zzaGX;
    private boolean zzaGY;
    private final Object zzqt;

    public zzf(Context context, Looper looper, zzd zzdVar, com.google.android.gms.common.internal.zze zzeVar) {
        super(context, looper, 24, zzdVar, zzdVar, zzeVar);
        this.zzMZ = context.getPackageName();
        this.zzaGW = (zzd) zzu.zzu(zzdVar);
        this.zzaGW.zza(this);
        this.zzaGX = new zzb();
        this.zzqt = new Object();
        this.zzaGY = true;
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaGX.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        String str;
        try {
            zzxp();
            zznM().zza(this.zzMZ, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            str = "Couldn't send log event.  Will try caching.";
            Log.e("PlayLoggerImpl", str);
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            str = "Service was disconnected.  Will try caching.";
            Log.e("PlayLoggerImpl", str);
            zzc(playLoggerContext, logEvent);
        }
    }

    private void zzxp() {
        LogEvent logEvent;
        com.google.android.gms.common.internal.zzb.zzU(!this.zzaGY);
        if (this.zzaGX.isEmpty()) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<zzb.zza> it = this.zzaGX.zzxn().iterator();
            PlayLoggerContext playLoggerContext = null;
            while (it.hasNext()) {
                zzb.zza next = it.next();
                if (next.zzaGM != null) {
                    zznM().zza(this.zzMZ, next.zzaGK, zzrn.zzf(next.zzaGM));
                } else {
                    if (next.zzaGK.equals(playLoggerContext)) {
                        logEvent = next.zzaGL;
                    } else {
                        if (!arrayList.isEmpty()) {
                            zznM().zza(this.zzMZ, playLoggerContext, arrayList);
                            arrayList.clear();
                        }
                        playLoggerContext = next.zzaGK;
                        logEvent = next.zzaGL;
                    }
                    arrayList.add(logEvent);
                }
            }
            if (!arrayList.isEmpty()) {
                zznM().zza(this.zzMZ, playLoggerContext, arrayList);
            }
            this.zzaGX.clear();
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
        }
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected String getServiceDescriptor() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }

    @Override // com.google.android.gms.common.internal.zzi
    protected String getStartServiceAction() {
        return "com.google.android.gms.playlog.service.START";
    }

    public void start() {
        synchronized (this.zzqt) {
            if (!isConnecting() && !isConnected()) {
                this.zzaGW.zzaj(true);
                zznJ();
            }
        }
    }

    public void stop() {
        synchronized (this.zzqt) {
            this.zzaGW.zzaj(false);
            disconnect();
        }
    }

    void zzak(boolean z) {
        synchronized (this.zzqt) {
            boolean z2 = this.zzaGY;
            this.zzaGY = z;
            if (z2 && !this.zzaGY) {
                zzxp();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzqt) {
            if (this.zzaGY) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzi
    /* renamed from: zzdq, reason: merged with bridge method [inline-methods] */
    public zza zzT(IBinder iBinder) {
        return zza.AbstractBinderC0231zza.zzdp(iBinder);
    }
}
