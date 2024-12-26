package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public class zza {
    public boolean zza(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzk zzkVar) {
        int i;
        String message;
        if (adLauncherIntentInfoParcel == null) {
            message = "No intent data for launcher overlay.";
        } else {
            Intent intent = new Intent();
            if (TextUtils.isEmpty(adLauncherIntentInfoParcel.zzzf)) {
                message = "Open GMSG did not contain a URL.";
            } else {
                if (TextUtils.isEmpty(adLauncherIntentInfoParcel.mimeType)) {
                    intent.setData(Uri.parse(adLauncherIntentInfoParcel.zzzf));
                } else {
                    intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.zzzf), adLauncherIntentInfoParcel.mimeType);
                }
                intent.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.packageName)) {
                    intent.setPackage(adLauncherIntentInfoParcel.packageName);
                }
                if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.zzzg)) {
                    String[] split = adLauncherIntentInfoParcel.zzzg.split("/", 2);
                    if (split.length < 2) {
                        message = "Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.zzzg;
                    } else {
                        intent.setClassName(split[0], split[1]);
                    }
                }
                String str = adLauncherIntentInfoParcel.zzzh;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i = Integer.parseInt(str);
                    } catch (NumberFormatException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not parse intent flags.");
                        i = 0;
                    }
                    intent.addFlags(i);
                }
                try {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("Launching an intent: " + intent.toURI());
                    context.startActivity(intent);
                    if (zzkVar != null) {
                        zzkVar.zzaO();
                    }
                    return true;
                } catch (ActivityNotFoundException e2) {
                    message = e2.getMessage();
                }
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(message);
        return false;
    }
}
