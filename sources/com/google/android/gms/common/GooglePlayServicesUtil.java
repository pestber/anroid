package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.zzc;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzlk;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";

    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzml();
    public static boolean zzVS = false;
    public static boolean zzVT = false;
    private static int zzVU = -1;
    private static final Object zzoW = new Object();
    private static String zzVV = null;
    private static Integer zzVW = null;
    static final AtomicBoolean zzVX = new AtomicBoolean();

    private static class zza extends Handler {
        private final Context zzqw;

        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zzqw = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzqw);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.zzqw);
                        break;
                    }
                    break;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                    break;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return zza(i, activity, null, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        Intent zzaT = zzaT(i);
        if (zzaT == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, zzaT, DriveFile.MODE_READ_ONLY);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
            try {
                try {
                    return new Scanner(openInputStream).useDelimiter("\\A").next();
                } finally {
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                }
            } catch (NoSuchElementException e) {
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        if (com.google.android.gms.common.internal.zzd.zzZR) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            zzaa(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzd zzmn = zzd.zzmn();
            if (!zzkz.zzbP(packageInfo.versionCode) && !zzkz.zzai(context)) {
                try {
                    zzc.zza zza2 = zzmn.zza(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), zzc.zzbk.zzVR);
                    if (zza2 == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (zzmn.zza(packageInfo, zza2) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    if (!zzh(context, GOOGLE_PLAY_STORE_PACKAGE)) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                        return 9;
                    }
                    Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
                    if (zzmn.zza(packageInfo, zzc.zzbk.zzVR) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                }
            } else if (zzmn.zza(packageInfo, zzc.zzbk.zzVR) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzkz.zzbN(packageInfo.versionCode) < zzkz.zzbN(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                    e2.printStackTrace();
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zza2 = zza(i, activity, fragment, i2, onCancelListener);
        boolean z = false;
        if (zza2 == null) {
            return false;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(zza2, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
            return true;
        }
        if (!zzlk.zzoR()) {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        ErrorDialogFragment.newInstance(zza2, onCancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (zzkz.zzai(context) && i == 2) {
            i = 42;
        }
        if (zze(context, i) || zzf(context, i)) {
            zzab(context);
        } else {
            zza(i, context);
        }
    }

    @Deprecated
    public static void zzY(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent zzaT = zzaT(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (zzaT != null) {
                throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zzaT);
            }
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zzkz.zzai(activity) && i == 2) {
            i = 42;
        }
        if (zzlk.zzoU()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zzf.zzb(activity, i, zzad(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent zzaT = zzaT(i);
        zzg zzgVar = fragment == null ? new zzg(activity, zzaT, i2) : new zzg(fragment, zzaT, i2);
        String zzh = zzf.zzh(activity, i);
        if (zzh != null) {
            builder.setPositiveButton(zzh, zzgVar);
        }
        String zzg = zzf.zzg(activity, i);
        if (zzg != null) {
            builder.setTitle(zzg);
        }
        return builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(int i, Context context) {
        zza(i, context, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(int r10, android.content.Context r11, java.lang.String r12) {
        /*
            android.content.res.Resources r0 = r11.getResources()
            java.lang.String r1 = zzad(r11)
            java.lang.String r2 = com.google.android.gms.common.internal.zzf.zzi(r11, r10)
            if (r2 != 0) goto L14
            int r2 = com.google.android.gms.R.string.common_google_play_services_notification_ticker
            java.lang.String r2 = r0.getString(r2)
        L14:
            java.lang.String r1 = com.google.android.gms.common.internal.zzf.zzc(r11, r10, r1)
            r3 = 0
            android.app.PendingIntent r4 = getErrorPendingIntent(r10, r11, r3)
            boolean r5 = com.google.android.gms.internal.zzkz.zzai(r11)
            r6 = 1
            if (r5 == 0) goto L74
            boolean r5 = com.google.android.gms.internal.zzlk.zzoV()
            com.google.android.gms.common.internal.zzu.zzU(r5)
            android.app.Notification$Builder r5 = new android.app.Notification$Builder
            r5.<init>(r11)
            int r7 = com.google.android.gms.R.drawable.common_ic_googleplayservices
            android.app.Notification$Builder r5 = r5.setSmallIcon(r7)
            r7 = 2
            android.app.Notification$Builder r5 = r5.setPriority(r7)
            android.app.Notification$Builder r5 = r5.setAutoCancel(r6)
            android.app.Notification$BigTextStyle r6 = new android.app.Notification$BigTextStyle
            r6.<init>()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.StringBuilder r2 = r7.append(r2)
            java.lang.String r7 = " "
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            android.app.Notification$BigTextStyle r1 = r6.bigText(r1)
            android.app.Notification$Builder r1 = r5.setStyle(r1)
            int r2 = com.google.android.gms.R.drawable.common_full_open_on_phone
            int r5 = com.google.android.gms.R.string.common_open_on_phone
            java.lang.String r0 = r0.getString(r5)
            android.app.Notification$Builder r0 = r1.addAction(r2, r0, r4)
        L6f:
            android.app.Notification r0 = r0.build()
            goto Ld4
        L74:
            int r5 = com.google.android.gms.R.string.common_google_play_services_notification_ticker
            java.lang.String r0 = r0.getString(r5)
            boolean r5 = com.google.android.gms.internal.zzlk.zzoR()
            r7 = 17301642(0x108008a, float:2.4979642E-38)
            if (r5 == 0) goto Lc1
            android.app.Notification$Builder r5 = new android.app.Notification$Builder
            r5.<init>(r11)
            android.app.Notification$Builder r5 = r5.setSmallIcon(r7)
            android.app.Notification$Builder r2 = r5.setContentTitle(r2)
            android.app.Notification$Builder r2 = r2.setContentText(r1)
            android.app.Notification$Builder r2 = r2.setContentIntent(r4)
            android.app.Notification$Builder r0 = r2.setTicker(r0)
            android.app.Notification$Builder r0 = r0.setAutoCancel(r6)
            boolean r2 = com.google.android.gms.internal.zzlk.zzoY()
            if (r2 == 0) goto La9
            r0.setLocalOnly(r6)
        La9:
            boolean r2 = com.google.android.gms.internal.zzlk.zzoV()
            if (r2 == 0) goto Lbc
            android.app.Notification$BigTextStyle r2 = new android.app.Notification$BigTextStyle
            r2.<init>()
            android.app.Notification$BigTextStyle r1 = r2.bigText(r1)
            r0.setStyle(r1)
            goto L6f
        Lbc:
            android.app.Notification r0 = r0.getNotification()
            goto Ld4
        Lc1:
            android.app.Notification r5 = new android.app.Notification
            long r8 = java.lang.System.currentTimeMillis()
            r5.<init>(r7, r0, r8)
            int r0 = r5.flags
            r0 = r0 | 16
            r5.flags = r0
            r5.setLatestEventInfo(r11, r2, r1, r4)
            r0 = r5
        Ld4:
            boolean r10 = zzaU(r10)
            if (r10 == 0) goto Le2
            java.util.concurrent.atomic.AtomicBoolean r10 = com.google.android.gms.common.GooglePlayServicesUtil.zzVX
            r10.set(r3)
            r10 = 10436(0x28c4, float:1.4624E-41)
            goto Le5
        Le2:
            r10 = 39789(0x9b6d, float:5.5756E-41)
        Le5:
            java.lang.String r1 = "notification"
            java.lang.Object r11 = r11.getSystemService(r1)
            android.app.NotificationManager r11 = (android.app.NotificationManager) r11
            if (r12 == 0) goto Lf3
            r11.notify(r12, r10, r0)
            goto Lf6
        Lf3:
            r11.notify(r10, r0)
        Lf6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtil.zza(int, android.content.Context, java.lang.String):void");
    }

    public static boolean zza(Context context, int i, String str) {
        if (zzlk.zzoX()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public static Intent zzaT(int i) {
        switch (i) {
            case 1:
            case 2:
                return zzm.zzcg("com.google.android.gms");
            case 3:
                return zzm.zzce("com.google.android.gms");
            case 42:
                return zzm.zznX();
            default:
                return null;
        }
    }

    private static boolean zzaU(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    private static void zzaa(Context context) {
        Integer num;
        synchronized (zzoW) {
            if (zzVV == null) {
                zzVV = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzVW = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                    } else {
                        zzVW = null;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                }
            } else if (!zzVV.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzVV + "' and this call used package '" + context.getPackageName() + "'.");
            }
            num = zzVW;
        }
        if (num == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
            throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

    private static void zzab(Context context) {
        zza zzaVar = new zza(context);
        zzaVar.sendMessageDelayed(zzaVar.obtainMessage(1), 120000L);
    }

    @Deprecated
    public static void zzac(Context context) {
        if (zzVX.getAndSet(true)) {
            return;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(10436);
        } catch (SecurityException e) {
        }
    }

    public static String zzad(Context context) {
        ApplicationInfo applicationInfo;
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    public static boolean zzae(Context context) {
        return zzlk.zzoZ() && context.getPackageManager().hasSystemFeature("com.google.sidewinder");
    }

    public static boolean zzb(PackageManager packageManager) {
        synchronized (zzoW) {
            if (zzVU == -1) {
                try {
                    if (zzd.zzmn().zza(packageManager.getPackageInfo("com.google.android.gms", 64), zzc.zzVK[1]) != null) {
                        zzVU = 1;
                    } else {
                        zzVU = 0;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    zzVU = 0;
                }
            }
        }
        return zzVU != 0;
    }

    @Deprecated
    public static boolean zzb(PackageManager packageManager, String str) {
        return zzd.zzmn().zzb(packageManager, str);
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzmm();
    }

    public static boolean zzd(Context context, int i) {
        return zza(context, i, "com.google.android.gms") && zzb(context.getPackageManager(), "com.google.android.gms");
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzh(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        if (i == 9) {
            return zzh(context, GOOGLE_PLAY_STORE_PACKAGE);
        }
        return false;
    }

    public static boolean zzh(Context context, String str) {
        boolean zzoZ = zzlk.zzoZ();
        PackageManager packageManager = context.getPackageManager();
        if (!zzoZ) {
            try {
                return packageManager.getApplicationInfo(str, 8192).enabled;
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            }
        }
        Iterator<PackageInstaller.SessionInfo> it = packageManager.getPackageInstaller().getAllSessions().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getAppPackageName())) {
                return true;
            }
        }
        return false;
    }

    private static int zzml() {
        return 7571000;
    }

    public static boolean zzmm() {
        return zzVS ? zzVT : "user".equals(Build.TYPE);
    }
}
