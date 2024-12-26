package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzjr;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/* loaded from: classes.dex */
public final class GoogleAuthUtil {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";

    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    private static final ComponentName zzOB = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName zzOC = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        Context applicationContext = context.getApplicationContext();
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        zzY(applicationContext);
        Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
        zzk zzah = zzk.zzah(applicationContext);
        try {
            if (!zzah.zza(zzOB, zzaVar, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service with the given context.");
            }
            try {
                Bundle zza = zzau.zza.zza(zzaVar.zzmh()).zza(str, bundle);
                String string = zza.getString("Error");
                if (zza.getBoolean("booleanResult")) {
                } else {
                    throw new GoogleAuthException(string);
                }
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            }
        } finally {
            zzah.zzb(zzOB, zzaVar, "GoogleAuthUtil");
        }
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        zzu.zzh(str, "accountName must be provided");
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        Context applicationContext = context.getApplicationContext();
        zzY(applicationContext);
        com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
        zzk zzah = zzk.zzah(applicationContext);
        try {
            if (!zzah.zza(zzOB, zzaVar, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service with the given context.");
            }
            try {
                return zzau.zza.zza(zzaVar.zzmh()).zza(new AccountChangeEventsRequest().setAccountName(str).setEventIndex(i)).getEvents();
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            }
        } finally {
            zzah.zzb(zzOB, zzaVar, "GoogleAuthUtil");
        }
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        zzu.zzh(str, "accountName must be provided");
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        zzY(context.getApplicationContext());
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zza(context, account, str, bundle).getString("authtoken");
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        zzi(intent);
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putParcelable("callback_intent", intent);
        bundle2.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle2);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        Bundle bundle3 = bundle == null ? new Bundle() : bundle;
        Bundle bundle4 = bundle2 == null ? new Bundle() : bundle2;
        ContentResolver.validateSyncExtrasBundle(bundle4);
        bundle3.putString("authority", str2);
        bundle3.putBundle("sync_extras", bundle4);
        bundle3.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle3);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, GOOGLE_ACCOUNT_TYPE), str2, bundle, str3, bundle2);
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken(GOOGLE_ACCOUNT_TYPE, str);
    }

    private static void zzY(Context context) throws GoogleAuthException {
        try {
            GooglePlayServicesUtil.zzY(context);
        } catch (GooglePlayServicesNotAvailableException e) {
            throw new GoogleAuthException(e.getMessage());
        } catch (GooglePlayServicesRepairableException e2) {
            throw new GooglePlayServicesAvailabilityException(e2.getConnectionStatusCode(), e2.getMessage(), e2.getIntent());
        }
    }

    public static Bundle zza(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        Context applicationContext = context.getApplicationContext();
        zzu.zzbZ("Calling this from your main thread can lead to deadlock");
        zzY(applicationContext);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
            bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
        }
        com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
        zzk zzah = zzk.zzah(applicationContext);
        try {
            if (!zzah.zza(zzOB, zzaVar, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service with the given context.");
            }
            try {
                Bundle zza = zzau.zza.zza(zzaVar.zzmh()).zza(account, str, bundle2);
                if (zza == null) {
                    Log.w("GoogleAuthUtil", "Binder call returned null.");
                    throw new GoogleAuthException("ServiceUnavailable");
                }
                if (!TextUtils.isEmpty(zza.getString("authtoken"))) {
                    return zza;
                }
                String string = zza.getString("Error");
                Intent intent = (Intent) zza.getParcelable("userRecoveryIntent");
                if (zzbv(string)) {
                    throw new UserRecoverableAuthException(string, intent);
                }
                if (zzbu(string)) {
                    throw new IOException(string);
                }
                throw new GoogleAuthException(string);
            } catch (RemoteException e) {
                Log.i("GoogleAuthUtil", "GMS remote exception ", e);
                throw new IOException("remote exception");
            } catch (InterruptedException e2) {
                throw new GoogleAuthException("Interrupted");
            }
        } finally {
            zzah.zzb(zzOB, zzaVar, "GoogleAuthUtil");
        }
    }

    private static String zzb(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            String token = getToken(context, account, str, bundle);
            GooglePlayServicesUtil.zzac(context);
            return token;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtil.zzac(context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }

    private static boolean zzbu(String str) {
        return "NetworkError".equals(str) || "ServiceUnavailable".equals(str) || "Timeout".equals(str);
    }

    private static boolean zzbv(String str) {
        return "BadAuthentication".equals(str) || "CaptchaRequired".equals(str) || "DeviceManagementRequiredOrSyncDisabled".equals(str) || "NeedPermission".equals(str) || "NeedsBrowser".equals(str) || "UserCancel".equals(str) || "AppDownloadRequired".equals(str) || zzjr.DM_SYNC_DISABLED.zzld().equals(str) || zzjr.DM_ADMIN_BLOCKED.zzld().equals(str) || zzjr.DM_ADMIN_PENDING_APPROVAL.zzld().equals(str) || zzjr.DM_STALE_SYNC_REQUIRED.zzld().equals(str) || zzjr.DM_DEACTIVATED.zzld().equals(str) || zzjr.DM_REQUIRED.zzld().equals(str) || zzjr.THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.zzld().equals(str);
    }

    private static void zzi(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
        try {
            Intent.parseUri(intent.toUri(1), 1);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }
}
