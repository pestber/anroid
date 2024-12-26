package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
class zzdj {
    private static zzbw<zzag.zza> zza(zzbw<zzag.zza> zzbwVar) {
        try {
            return new zzbw<>(zzdf.zzI(zzeQ(zzdf.zzg(zzbwVar.getObject()))), zzbwVar.zzza());
        } catch (UnsupportedEncodingException e) {
            zzbg.zzb("Escape URI: unsupported encoding", e);
            return zzbwVar;
        }
    }

    private static zzbw<zzag.zza> zza(zzbw<zzag.zza> zzbwVar, int i) {
        String str;
        if (zzn(zzbwVar.getObject())) {
            switch (i) {
                case 12:
                    return zza(zzbwVar);
                default:
                    str = "Unsupported Value Escaping: " + i;
                    break;
            }
        } else {
            str = "Escaping can only be applied to strings.";
        }
        zzbg.zzaz(str);
        return zzbwVar;
    }

    static zzbw<zzag.zza> zza(zzbw<zzag.zza> zzbwVar, int... iArr) {
        for (int i : iArr) {
            zzbwVar = zza(zzbwVar, i);
        }
        return zzbwVar;
    }

    static String zzeQ(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(zzag.zza zzaVar) {
        return zzdf.zzl(zzaVar) instanceof String;
    }
}
