package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class GcmListenerService extends Service {
    private int zzavB;
    private final Object zzqt = new Object();
    private int zzavC = 0;

    /* renamed from: com.google.android.gms.gcm.GcmListenerService$2, reason: invalid class name */
    class AnonymousClass2 extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ Intent val$intent;

        AnonymousClass2(Intent intent) {
            this.val$intent = intent;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            GcmListenerService.this.zzk(this.val$intent);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzk(Intent intent) {
        char c;
        try {
            if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
                String stringExtra = intent.getStringExtra("message_type");
                if (stringExtra == null) {
                    stringExtra = GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE;
                }
                switch (stringExtra.hashCode()) {
                    case -2062414158:
                        if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 102161:
                        if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE)) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 814694033:
                        if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case 814800675:
                        if (stringExtra.equals(GoogleCloudMessaging.MESSAGE_TYPE_SEND_EVENT)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                switch (c) {
                    case 0:
                        zzs(intent.getExtras());
                        break;
                    case 1:
                        onDeletedMessages();
                        break;
                    case 2:
                        onMessageSent(intent.getStringExtra("google.message_id"));
                        break;
                    case 3:
                        onSendError(intent.getStringExtra("google.message_id"), intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR));
                        break;
                    default:
                        Log.w("GcmListenerService", "Received message with unknown type: " + stringExtra);
                        break;
                }
                synchronized (this.zzqt) {
                    this.zzavC--;
                    if (this.zzavC == 0) {
                        zzgf(this.zzavB);
                    }
                }
            }
        } finally {
            GcmReceiver.completeWakefulIntent(intent);
        }
    }

    private void zzs(Bundle bundle) {
        bundle.remove("message_type");
        bundle.remove("android.support.content.wakelockid");
        if (zza.zzt(bundle)) {
            zza.zzar(this).zzu(bundle);
            return;
        }
        String string = bundle.getString("from");
        bundle.remove("from");
        onMessageReceived(string, bundle);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String str, Bundle bundle) {
    }

    public void onMessageSent(String str) {
    }

    public void onSendError(String str, String str2) {
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int i, int i2) {
        synchronized (this.zzqt) {
            this.zzavB = i2;
            this.zzavC++;
        }
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.google.android.gms.gcm.GcmListenerService.1
            @Override // java.lang.Runnable
            public void run() {
                GcmListenerService.this.zzk(intent);
            }
        });
        return 3;
    }

    boolean zzgf(int i) {
        return stopSelfResult(i);
    }
}
