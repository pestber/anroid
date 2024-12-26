package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.internal.zzle;

/* loaded from: classes.dex */
public final class zzf {
    public static String zzb(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return zzle.zzb(resources) ? resources.getString(R.string.common_google_play_services_install_text_tablet, str) : resources.getString(R.string.common_google_play_services_install_text_phone, str);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_text, str);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_text, str);
            case 5:
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(R.string.common_google_play_services_unsupported_text, str);
            case 16:
                return resources.getString(R.string.common_google_play_services_api_unavailable_text, str);
            case 17:
                return resources.getString(R.string.common_google_play_services_sign_in_failed_text);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, str);
            case 42:
                return resources.getString(R.string.common_android_wear_update_text, str);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue);
        }
    }

    public static String zzc(Context context, int i, String str) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return zzle.zzb(resources) ? resources.getString(R.string.common_google_play_services_install_text_tablet, str) : resources.getString(R.string.common_google_play_services_install_text_phone, str);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_text, str);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_text, str);
            case 5:
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            case 7:
                return resources.getString(R.string.common_google_play_services_network_error_text);
            case 9:
                return resources.getString(R.string.common_google_play_services_unsupported_text, str);
            case 16:
                return resources.getString(R.string.common_google_play_services_api_unavailable_text, str);
            case 17:
                return resources.getString(R.string.common_google_play_services_sign_in_failed_text);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, str);
            case 42:
                return resources.getString(R.string.common_android_wear_notification_needs_update_text, str);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue);
        }
    }

    public static final String zzg(Context context, int i) {
        int i2;
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i2 = R.string.common_google_play_services_install_title;
                break;
            case 2:
                i2 = R.string.common_google_play_services_update_title;
                break;
            case 3:
                i2 = R.string.common_google_play_services_enable_title;
                break;
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                i2 = R.string.common_google_play_services_invalid_account_title;
                break;
            case 7:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                i2 = R.string.common_google_play_services_network_error_title;
                break;
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 9:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                i2 = R.string.common_google_play_services_unsupported_title;
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 11:
                str = "The application is not licensed to the user.";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 17:
                Log.e("GooglePlayServicesUtil", "The specified account could not be signed in.");
                i2 = R.string.common_google_play_services_sign_in_failed_title;
                break;
            case 18:
                i2 = R.string.common_google_play_services_updating_title;
                break;
            case 42:
                i2 = R.string.common_android_wear_update_title;
                break;
            default:
                str = "Unexpected error code " + i;
                Log.e("GooglePlayServicesUtil", str);
                return null;
        }
        return resources.getString(i2);
    }

    public static String zzh(Context context, int i) {
        int i2;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i2 = R.string.common_google_play_services_install_button;
                break;
            case 2:
            case 42:
                i2 = R.string.common_google_play_services_update_button;
                break;
            case 3:
                i2 = R.string.common_google_play_services_enable_button;
                break;
            default:
                i2 = android.R.string.ok;
                break;
        }
        return resources.getString(i2);
    }

    public static final String zzi(Context context, int i) {
        int i2;
        String str;
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                i2 = R.string.common_google_play_services_install_title;
                break;
            case 2:
                i2 = R.string.common_google_play_services_update_title;
                break;
            case 3:
                i2 = R.string.common_google_play_services_enable_title;
                break;
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
                i2 = R.string.common_google_play_services_invalid_account_title;
                break;
            case 7:
                Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
                i2 = R.string.common_google_play_services_network_error_title;
                break;
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 9:
                Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
                i2 = R.string.common_google_play_services_unsupported_title;
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 11:
                str = "The application is not licensed to the user.";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                Log.e("GooglePlayServicesUtil", str);
                return null;
            case 17:
                Log.e("GooglePlayServicesUtil", "The specified account could not be signed in.");
                i2 = R.string.common_google_play_services_sign_in_failed_title;
                break;
            case 18:
                i2 = R.string.common_google_play_services_updating_title;
                break;
            case 42:
                i2 = R.string.common_android_wear_update_title;
                break;
            default:
                str = "Unexpected error code " + i;
                Log.e("GooglePlayServicesUtil", str);
                return null;
        }
        return resources.getString(i2);
    }
}
