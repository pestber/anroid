package com.google.android.gms.internal;

import com.android.volley.toolbox.HttpHeaderParser;
import com.google.android.gms.internal.zzb;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

/* loaded from: classes.dex */
public class zzx {
    public static String zza(Map<String, String> map) {
        return zzb(map, "ISO-8859-1");
    }

    public static zzb.zza zzb(zzi zziVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zziVar.zzA;
        String str = map.get("Date");
        long zzg = str != null ? zzg(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",");
            z = false;
            j = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get("Expires");
        long zzg2 = str3 != null ? zzg(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long zzg3 = str4 != null ? zzg(str4) : 0L;
        String str5 = map.get("ETag");
        if (i != 0) {
            long j5 = currentTimeMillis + (j * 1000);
            j3 = z ? j5 : (j2 * 1000) + j5;
            j4 = j5;
        } else {
            j3 = 0;
            if (zzg <= 0 || zzg2 < zzg) {
                j4 = 0;
            } else {
                j4 = (zzg2 - zzg) + currentTimeMillis;
                j3 = j4;
            }
        }
        zzb.zza zzaVar = new zzb.zza();
        zzaVar.data = zziVar.data;
        zzaVar.zzb = str5;
        zzaVar.zzf = j4;
        zzaVar.zze = j3;
        zzaVar.zzc = zzg;
        zzaVar.zzd = zzg3;
        zzaVar.zzg = map;
        return zzaVar;
    }

    public static String zzb(Map<String, String> map, String str) {
        String str2 = map.get(HttpHeaderParser.HEADER_CONTENT_TYPE);
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long zzg(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0L;
        }
    }
}
