package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.media.MediaRouteProviderProtocol;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";

    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";

    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";

    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";

    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    static GoogleCloudMessaging zzavS;
    private PendingIntent zzavT;
    private Context zzpH;
    public static int zzavP = 5000000;
    public static int zzavQ = 6500000;
    public static int zzavR = 7000000;
    private static final AtomicInteger zzavV = new AtomicInteger(1);
    private final BlockingQueue<Intent> zzavW = new LinkedBlockingQueue();
    private Map<String, Handler> zzavU = Collections.synchronizedMap(new HashMap());
    final Messenger zzavX = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.google.android.gms.gcm.GoogleCloudMessaging.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || !(message.obj instanceof Intent)) {
                Log.w(GoogleCloudMessaging.INSTANCE_ID_SCOPE, "Dropping invalid message");
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                GoogleCloudMessaging.this.zzavW.add(intent);
            } else {
                if (GoogleCloudMessaging.this.zzl(intent)) {
                    return;
                }
                intent.setPackage(GoogleCloudMessaging.this.zzpH.getPackageName());
                GoogleCloudMessaging.this.zzpH.sendBroadcast(intent);
            }
        }
    });

    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (zzavS == null) {
                zzavS = new GoogleCloudMessaging();
                zzavS.zzpH = context.getApplicationContext();
            }
            googleCloudMessaging = zzavS;
        }
        return googleCloudMessaging;
    }

    static String zza(Intent intent, String str) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR);
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private void zza(String str, String str2, long j, int i, Bundle bundle) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zzm(intent);
        intent.setPackage(zzas(this.zzpH));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        if (!zzas(this.zzpH).contains(".gsf")) {
            this.zzpH.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        Bundle bundle2 = new Bundle();
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof String) {
                bundle2.putString("gcm." + str3, (String) obj);
            }
        }
        bundle2.putString("google.to", str);
        bundle2.putString("google.message_id", str2);
        InstanceID.getInstance(this.zzpH).zzc(INSTANCE_ID_SCOPE, "upstream", bundle2);
    }

    public static String zzas(Context context) {
        return zzc.zzaw(context);
    }

    public static int zzat(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzas(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzl(Intent intent) {
        Handler remove;
        String stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR)) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra == null || (remove = this.zzavU.remove(stringExtra)) == null) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.obj = intent;
        return remove.sendMessage(obtain);
    }

    private String zztS() {
        return "google.rpc" + String.valueOf(zzavV.getAndIncrement());
    }

    public void close() {
        zzavS = null;
        zza.zzavF = null;
        zztT();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra != null ? stringExtra : MESSAGE_TYPE_MESSAGE;
    }

    @Deprecated
    public synchronized String register(String... strArr) throws IOException {
        String zzc = zzc(strArr);
        Bundle bundle = new Bundle();
        if (zzas(this.zzpH).contains(".gsf")) {
            bundle.putString("legacy.sender", zzc);
            return InstanceID.getInstance(this.zzpH).getToken(zzc, INSTANCE_ID_SCOPE, bundle);
        }
        bundle.putString("sender", zzc);
        return zza(zzx(bundle), "registration_id");
    }

    public void send(String str, String str2, long j, Bundle bundle) throws IOException {
        zza(str, str2, j, -1, bundle);
    }

    public void send(String str, String str2, Bundle bundle) throws IOException {
        send(str, str2, -1L, bundle);
    }

    @Deprecated
    public synchronized void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        InstanceID.getInstance(this.zzpH).deleteInstanceID();
    }

    String zzc(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    synchronized void zzm(Intent intent) {
        if (this.zzavT == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzavT = PendingIntent.getBroadcast(this.zzpH, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzavT);
    }

    synchronized void zztT() {
        if (this.zzavT != null) {
            this.zzavT.cancel();
            this.zzavT = null;
        }
    }

    @Deprecated
    Intent zzx(Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (zzat(this.zzpH) < 0) {
            throw new IOException("Google Play Services missing");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(zzas(this.zzpH));
        zzm(intent);
        intent.putExtra("google.message_id", zztS());
        intent.putExtras(bundle);
        intent.putExtra("google.messenger", this.zzavX);
        this.zzpH.startService(intent);
        try {
            return this.zzavW.poll(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IOException(e.getMessage());
        }
    }
}
