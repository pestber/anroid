package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* loaded from: classes.dex */
public class zza extends zzd {
    public static boolean zzJk;
    private AdvertisingIdClient.Info zzJl;
    private final zzaj zzJm;
    private String zzJn;
    private boolean zzJo;
    private Object zzJp;

    zza(zzf zzfVar) {
        super(zzfVar);
        this.zzJo = false;
        this.zzJp = new Object();
        this.zzJm = new zzaj(zzfVar.zzhP());
    }

    private boolean zza(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String str = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zziP = zzhV().zziP();
        synchronized (this.zzJp) {
            if (!this.zzJo) {
                this.zzJn = zzhF();
                this.zzJo = true;
            } else if (TextUtils.isEmpty(this.zzJn)) {
                if (info != null) {
                    str = info.getId();
                }
                if (str == null) {
                    return zzaS(id + zziP);
                }
                this.zzJn = zzaR(str + zziP);
            }
            String zzaR = zzaR(id + zziP);
            if (TextUtils.isEmpty(zzaR)) {
                return false;
            }
            if (zzaR.equals(this.zzJn)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.zzJn)) {
                zzaT("Resetting the client id because Advertising Id changed.");
                zziP = zzhV().zziQ();
                zza("New client Id", zziP);
            }
            return zzaS(id + zziP);
        }
    }

    private static String zzaR(String str) {
        MessageDigest zzbl = zzam.zzbl("MD5");
        if (zzbl == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzbl.digest(str.getBytes())));
    }

    private boolean zzaS(String str) {
        try {
            String zzaR = zzaR(str);
            zzaT("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzaR.getBytes());
            openFileOutput.close();
            this.zzJn = zzaR;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private synchronized AdvertisingIdClient.Info zzhD() {
        if (this.zzJm.zzv(1000L)) {
            this.zzJm.start();
            AdvertisingIdClient.Info zzhE = zzhE();
            if (!zza(this.zzJl, zzhE)) {
                zzaX("Failed to reset client id on adid change. Not using adid");
                zzhE = new AdvertisingIdClient.Info("", false);
            }
            this.zzJl = zzhE;
        }
        return this.zzJl;
    }

    public String zzhC() {
        zzia();
        AdvertisingIdClient.Info zzhD = zzhD();
        String id = zzhD != null ? zzhD.getId() : null;
        if (TextUtils.isEmpty(id)) {
            return null;
        }
        return id;
    }

    protected AdvertisingIdClient.Info zzhE() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException e) {
            zzaW("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (!zzJk) {
                zzJk = true;
                zzd("Error getting advertiser id", th);
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileNotFoundException] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    protected String zzhF() {
        String e = "gaClientIdData";
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzaW("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                e = e;
            } else if (read <= 0) {
                zzaT("Hash file is empty.");
                openFileInput.close();
                e = e;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                } catch (FileNotFoundException e2) {
                    e = e2;
                } catch (IOException e3) {
                    e = e3;
                    str = str2;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile(e);
                    return str;
                }
                str = str2;
                e = e;
            }
        } catch (FileNotFoundException e4) {
        } catch (IOException e5) {
            e = e5;
        }
        return str;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
    }

    public boolean zzhy() {
        zzia();
        if (zzhD() != null) {
            return !r0.isLimitAdTrackingEnabled();
        }
        return false;
    }
}
