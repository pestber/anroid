package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;

/* loaded from: classes.dex */
public class GcmReceiver extends WakefulBroadcastReceiver {
    private static String zzavK = "google.com/iid";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction()) || zzavK.equals(intent.getStringExtra("from"))) {
            intent.setAction("com.google.android.gms.iid.InstanceID");
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if ("com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            zzc(context, intent);
        } else {
            startWakefulService(context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    public void zzc(Context context, Intent intent) {
        startWakefulService(context, intent);
    }
}
