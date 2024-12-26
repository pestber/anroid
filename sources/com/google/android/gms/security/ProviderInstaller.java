package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzu;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final Object zzoW = new Object();
    private static Method zzaJM = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzu.zzb(context, "Context must not be null");
        GooglePlayServicesUtil.zzY(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (zzoW) {
            try {
                try {
                    if (zzaJM == null) {
                        zzaD(remoteContext);
                    }
                    zzaJM.invoke(null, remoteContext);
                } catch (Exception e) {
                    Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                    throw new GooglePlayServicesNotAvailableException(8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener providerInstallListener) {
        zzu.zzb(context, "Context must not be null");
        zzu.zzb(providerInstallListener, "Listener must not be null");
        zzu.zzbY("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() { // from class: com.google.android.gms.security.ProviderInstaller.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public Integer doInBackground(Void... voidArr) {
                int connectionStatusCode;
                try {
                    ProviderInstaller.installIfNeeded(context);
                    connectionStatusCode = 0;
                } catch (GooglePlayServicesNotAvailableException e) {
                    connectionStatusCode = e.errorCode;
                } catch (GooglePlayServicesRepairableException e2) {
                    connectionStatusCode = e2.getConnectionStatusCode();
                }
                return Integer.valueOf(connectionStatusCode);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: zze, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Integer num) {
                if (num.intValue() == 0) {
                    providerInstallListener.onProviderInstalled();
                } else {
                    providerInstallListener.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.zzaT(num.intValue()));
                }
            }
        }.execute(new Void[0]);
    }

    private static void zzaD(Context context) throws ClassNotFoundException, NoSuchMethodException {
        zzaJM = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
    }
}
