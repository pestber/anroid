package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.zznq;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class zznq<T extends zznq> {
    public static String zzD(Map map) {
        return zza(map, 1);
    }

    private static String zza(Object obj, int i) {
        if (i > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuffer stringBuffer = new StringBuffer();
            if (i > 0) {
                stringBuffer.append("[");
            }
            int length = stringBuffer.length();
            for (Object obj2 : (List) obj) {
                if (stringBuffer.length() > length) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(zza(obj2, i + 1));
            }
            if (i > 0) {
                stringBuffer.append("]");
            }
            return stringBuffer.toString();
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        boolean z = false;
        int i2 = 0;
        for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
            String zza = zza(entry.getValue(), i + 1);
            if (!TextUtils.isEmpty(zza)) {
                if (i > 0 && !z) {
                    stringBuffer2.append("{");
                    i2 = stringBuffer2.length();
                    z = true;
                }
                if (stringBuffer2.length() > i2) {
                    stringBuffer2.append(", ");
                }
                stringBuffer2.append((String) entry.getKey());
                stringBuffer2.append('=');
                stringBuffer2.append(zza);
            }
        }
        if (z) {
            stringBuffer2.append("}");
        }
        return stringBuffer2.toString();
    }

    public static String zzy(Object obj) {
        return zza(obj, 0);
    }

    public abstract void zza(T t);
}
