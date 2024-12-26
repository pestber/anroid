package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class CampaignTrackingService extends Service {
    private static Boolean zzIe;
    private Handler mHandler;

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.mHandler = handler2;
        return handler2;
    }

    public static boolean zzU(Context context) {
        zzu.zzu(context);
        if (zzIe != null) {
            return zzIe.booleanValue();
        }
        boolean zza = zzam.zza(context, (Class<? extends Service>) CampaignTrackingService.class);
        zzIe = Boolean.valueOf(zza);
        return zza;
    }

    private void zzhd() {
        try {
            synchronized (CampaignTrackingReceiver.zzoW) {
                PowerManager.WakeLock wakeLock = CampaignTrackingReceiver.zzIc;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzf.zzV(this).zzhQ().zzaT("CampaignTrackingService is starting up");
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzf.zzV(this).zzhQ().zzaT("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, final int i2) {
        String stringExtra;
        zzhd();
        zzf zzV = zzf.zzV(this);
        final zzaf zzhQ = zzV.zzhQ();
        if (zzV.zzhR().zziW()) {
            zzhQ.zzaX("Unexpected installation campaign (package side)");
            stringExtra = null;
        } else {
            stringExtra = intent.getStringExtra("referrer");
        }
        final Handler handler = getHandler();
        if (TextUtils.isEmpty(stringExtra)) {
            if (!zzV.zzhR().zziW()) {
                zzhQ.zzaW("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzV.zzhS().zze(new Runnable() { // from class: com.google.android.gms.analytics.CampaignTrackingService.1
                @Override // java.lang.Runnable
                public void run() {
                    CampaignTrackingService.this.zza(zzhQ, handler, i2);
                }
            });
            return 2;
        }
        int zzja = zzV.zzhR().zzja();
        if (stringExtra.length() > zzja) {
            zzhQ.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzja));
            stringExtra = stringExtra.substring(0, zzja);
        }
        zzhQ.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), stringExtra);
        zzV.zzhl().zza(stringExtra, new Runnable() { // from class: com.google.android.gms.analytics.CampaignTrackingService.2
            @Override // java.lang.Runnable
            public void run() {
                CampaignTrackingService.this.zza(zzhQ, handler, i2);
            }
        });
        return 2;
    }

    protected void zza(final zzaf zzafVar, Handler handler, final int i) {
        handler.post(new Runnable() { // from class: com.google.android.gms.analytics.CampaignTrackingService.3
            @Override // java.lang.Runnable
            public void run() {
                boolean stopSelfResult = CampaignTrackingService.this.stopSelfResult(i);
                if (stopSelfResult) {
                    zzafVar.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }
}
