package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

/* loaded from: classes.dex */
public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String zzavK = "google.com/iid";
    private static String zzawW = "CMD";
    MessengerCompat zzawU = new MessengerCompat(new Handler(Looper.getMainLooper()) { // from class: com.google.android.gms.iid.InstanceIDListenerService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            InstanceIDListenerService.this.zza(message, MessengerCompat.zzc(message));
        }
    });
    BroadcastReceiver zzawV = new BroadcastReceiver() { // from class: com.google.android.gms.iid.InstanceIDListenerService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            InstanceIDListenerService.this.zzn(intent);
            InstanceIDListenerService.this.stop();
        }
    };
    int zzawX;
    int zzawY;

    static void zza(Context context, zzd zzdVar) {
        zzdVar.zzul();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzawW, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(Message message, int i) {
        zzc.zzaw(this);
        getPackageManager();
        if (i == zzc.zzaxf || i == zzc.zzaxe) {
            zzn((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaxe + " appid=" + zzc.zzaxf);
        }
    }

    static void zzav(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzawW, "SYNC");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            return null;
        }
        return this.zzawU.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzawV, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        unregisterReceiver(this.zzawV);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        zzgn(i2);
        if (intent == null) {
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                zzn(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    public void onTokenRefresh() {
    }

    void stop() {
        synchronized (this) {
            this.zzawX--;
            if (this.zzawX == 0) {
                stopSelf(this.zzawY);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzawX + " " + this.zzawY);
            }
        }
    }

    public void zzab(boolean z) {
        onTokenRefresh();
    }

    void zzgn(int i) {
        synchronized (this) {
            this.zzawX++;
            if (i > this.zzawY) {
                this.zzawY = i;
            }
        }
    }

    public void zzn(Intent intent) {
        InstanceID zza;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            zza = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            zza = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzawW);
        if (intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR) == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") == null) {
                if ("RST".equals(stringExtra2)) {
                    zza.zzuf();
                } else {
                    if (!"RST_FULL".equals(stringExtra2)) {
                        if ("SYNC".equals(stringExtra2)) {
                            zza.zzug().zzdi(stringExtra);
                            zzab(false);
                            return;
                        } else {
                            if ("PING".equals(stringExtra2)) {
                                try {
                                    GoogleCloudMessaging.getInstance(this).send(zzavK, zzc.zzuk(), 0L, intent.getExtras());
                                    return;
                                } catch (IOException e) {
                                    Log.w("InstanceID", "Failed to send ping response");
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    if (zza.zzug().isEmpty()) {
                        return;
                    } else {
                        zza.zzug().zzul();
                    }
                }
                zzab(true);
                return;
            }
            zzd zzug = zza.zzug();
            if (stringExtra == null) {
                stringExtra = "";
            }
            zzug.zzdi(stringExtra);
        } else if (Log.isLoggable("InstanceID", 3)) {
            Log.d("InstanceID", "Register result in service " + stringExtra);
        }
        zza.zzuh().zzr(intent);
    }
}
