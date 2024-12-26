package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public class zze extends zzfg.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzAE;
    zzh zzAF;
    private zzk zzAH;
    private Context zzAM;
    private zzfe zzAN;
    private zzf zzAO;
    private zzj zzAP;
    private String zzAQ = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzAF = zzh.zzy(this.mActivity.getApplicationContext());
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onActivityResult(int i, int i2, Intent intent) {
        int zzd;
        boolean z;
        if (i == 1001) {
            try {
                try {
                    zzd = zzo.zzbF().zzd(intent);
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Fail to process purchase result.");
                    this.mActivity.finish();
                }
                if (i2 == -1) {
                    zzo.zzbF();
                    if (zzd == 0) {
                        if (this.zzAH.zza(this.zzAQ, i2, intent)) {
                            z = true;
                            this.zzAN.recordPlayBillingResolution(zzd);
                            this.mActivity.finish();
                            zza(this.zzAN.getProductId(), z, i2, intent);
                        }
                        z = false;
                        this.zzAN.recordPlayBillingResolution(zzd);
                        this.mActivity.finish();
                        zza(this.zzAN.getProductId(), z, i2, intent);
                    }
                }
                this.zzAF.zza(this.zzAO);
                z = false;
                this.zzAN.recordPlayBillingResolution(zzd);
                this.mActivity.finish();
                zza(this.zzAN.getProductId(), z, i2, intent);
            } finally {
                this.zzAQ = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onCreate() {
        Activity activity;
        int zzgr;
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzAP = zzc.zzAA;
        this.zzAH = zzc.zzqe;
        this.zzAN = zzc.zzAy;
        this.zzAE = new zzb(this.mActivity.getApplicationContext());
        this.zzAM = zzc.zzAz;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            activity = this.mActivity;
            zzgr = zzo.zzbx().zzgq();
        } else {
            activity = this.mActivity;
            zzgr = zzo.zzbx().zzgr();
        }
        activity.setRequestedOrientation(zzgr);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.mActivity.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzAE.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzAE.zzK(iBinder);
        try {
            this.zzAQ = this.zzAH.zzfi();
            Bundle zzb = this.zzAE.zzb(this.mActivity.getPackageName(), this.zzAN.getProductId(), this.zzAQ);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int zzb2 = zzo.zzbF().zzb(zzb);
                this.zzAN.recordPlayBillingResolution(zzb2);
                zza(this.zzAN.getProductId(), false, zzb2, null);
                this.mActivity.finish();
            } else {
                this.zzAO = new zzf(this.zzAN.getProductId(), this.zzAQ);
                this.zzAF.zzb(this.zzAO);
                Activity activity = this.mActivity;
                IntentSender intentSender = pendingIntent.getIntentSender();
                Intent intent = new Intent();
                Integer num = 0;
                int intValue = num.intValue();
                Integer num2 = 0;
                int intValue2 = num2.intValue();
                Integer num3 = 0;
                activity.startIntentSenderForResult(intentSender, 1001, intent, intValue, intValue2, num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzAP != null) {
            this.zzAP.zza(str, z, i, intent, this.zzAO);
        }
    }
}
