package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.File;

/* loaded from: classes.dex */
public class zzac {
    public static zzl zza(Context context) {
        return zza(context, null);
    }

    public static zzl zza(Context context, zzy zzyVar) {
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            String str = packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        if (zzyVar == null) {
            zzyVar = new zzz();
        }
        zzl zzlVar = new zzl(new zzv(file), new zzt(zzyVar));
        zzlVar.start();
        return zzlVar;
    }
}
