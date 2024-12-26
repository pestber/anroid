package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public class zzk {
    private final String zzsU;

    public zzk(String str) {
        this.zzsU = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        String str2;
        if (str != null && intent != null) {
            String zze = zzo.zzbF().zze(intent);
            String zzf = zzo.zzbF().zzf(intent);
            if (zze != null && zzf != null) {
                if (!str.equals(zzo.zzbF().zzai(zze))) {
                    str2 = "Developer payload not match.";
                } else {
                    if (this.zzsU == null || zzl.zzc(this.zzsU, zze, zzf)) {
                        return true;
                    }
                    str2 = "Fail to verify signature.";
                }
                com.google.android.gms.ads.internal.util.client.zzb.zzaC(str2);
                return false;
            }
        }
        return false;
    }

    public String zzfi() {
        return zzo.zzbv().zzgn();
    }
}
