package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzgd
/* loaded from: classes.dex */
public final class zzhp extends zzhh {
    private final Context mContext;
    private final String zzF;
    private String zzFP;
    private final String zzqr;

    public zzhp(Context context, String str, String str2) {
        this.zzFP = null;
        this.mContext = context;
        this.zzqr = str;
        this.zzF = str2;
    }

    public zzhp(Context context, String str, String str2, String str3) {
        this.zzFP = null;
        this.mContext = context;
        this.zzqr = str;
        this.zzF = str2;
        this.zzFP = str3;
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        StringBuilder append;
        String message;
        StringBuilder append2;
        try {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Pinging URL: " + this.zzF);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.zzF).openConnection();
            try {
                if (TextUtils.isEmpty(this.zzFP)) {
                    com.google.android.gms.ads.internal.zzo.zzbv().zza(this.mContext, this.zzqr, true, httpURLConnection);
                } else {
                    com.google.android.gms.ads.internal.zzo.zzbv().zza(this.mContext, this.zzqr, true, httpURLConnection, this.zzFP);
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Received non-success response code " + responseCode + " from pinging URL: " + this.zzF);
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e) {
            append = new StringBuilder().append("Error while pinging URL: ").append(this.zzF).append(". ");
            message = e.getMessage();
            append2 = append.append(message);
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(append2.toString());
        } catch (IndexOutOfBoundsException e2) {
            append2 = new StringBuilder().append("Error while parsing ping URL: ").append(this.zzF).append(". ").append(e2.getMessage());
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(append2.toString());
        } catch (RuntimeException e3) {
            append = new StringBuilder().append("Error while pinging URL: ").append(this.zzF).append(". ");
            message = e3.getMessage();
            append2 = append.append(message);
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(append2.toString());
        }
    }
}
