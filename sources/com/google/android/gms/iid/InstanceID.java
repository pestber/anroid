package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzawN = new HashMap();
    private static zzd zzawO;
    private static zzc zzawP;
    static String zzawT;
    Context mContext;
    KeyPair zzawQ;
    String zzawR;
    long zzawS;

    protected InstanceID(Context context, String str, Bundle bundle) {
        this.zzawR = "";
        this.mContext = context.getApplicationContext();
        this.zzawR = str;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            if (string == null) {
                string = "";
            }
            Context applicationContext = context.getApplicationContext();
            if (zzawO == null) {
                zzawO = new zzd(applicationContext);
                zzawP = new zzc(applicationContext);
            }
            zzawT = Integer.toString(zzau(applicationContext));
            instanceID = zzawN.get(string);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, string, bundle);
                zzawN.put(string, instanceID);
            }
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & MotionEventCompat.ACTION_MASK);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzau(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return 0;
        }
    }

    static String zzm(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzuf();
    }

    public void deleteToken(String str, String str2) throws IOException {
        zzb(str, str2, null);
    }

    public long getCreationTime() {
        String str;
        if (this.zzawS == 0 && (str = zzawO.get(this.zzawR, "cre")) != null) {
            this.zzawS = Long.parseLong(str);
        }
        return this.zzawS;
    }

    public String getId() {
        return zza(zzue());
    }

    public String getToken(String str, String str2) throws IOException {
        return getToken(str, str2, null);
    }

    public String getToken(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        String zzg = zzui() ? null : zzawO.zzg(this.zzawR, str, str2);
        if (zzg != null) {
            return zzg;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        String zzc = zzc(str, str2, bundle);
        if (zzc != null) {
            zzawO.zza(this.zzawR, str, str2, zzc, zzawT);
        }
        return zzc;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzawO.zzh(this.zzawR, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzawR) ? str : this.zzawR);
        if (!"".equals(this.zzawR)) {
            str = this.zzawR;
        }
        bundle.putString("X-subtype", str);
        zzawP.zzp(zzawP.zza(bundle, zzue()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzawR) ? str : this.zzawR;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzawP.zzp(zzawP.zza(bundle, zzue()));
    }

    KeyPair zzue() {
        if (this.zzawQ == null) {
            this.zzawQ = zzawO.zzdg(this.zzawR);
        }
        if (this.zzawQ == null) {
            this.zzawS = System.currentTimeMillis();
            this.zzawQ = zzawO.zze(this.zzawR, this.zzawS);
        }
        return this.zzawQ;
    }

    void zzuf() {
        this.zzawS = 0L;
        zzawO.zzdh(this.zzawR);
        this.zzawQ = null;
    }

    zzd zzug() {
        return zzawO;
    }

    zzc zzuh() {
        return zzawP;
    }

    boolean zzui() {
        String str;
        String str2 = zzawO.get("appVersion");
        if (str2 == null || !str2.equals(zzawT) || (str = zzawO.get("lastToken")) == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str)).longValue() > 604800;
    }
}
