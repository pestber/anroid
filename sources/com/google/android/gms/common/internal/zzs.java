package com.google.android.gms.common.internal;

import java.util.Iterator;

/* loaded from: classes.dex */
public class zzs {
    private final String separator;

    private zzs(String str) {
        this.separator = str;
    }

    public static zzs zzci(String str) {
        return new zzs(str);
    }

    public final String zza(Iterable<?> iterable) {
        return zza(new StringBuilder(), iterable).toString();
    }

    public final StringBuilder zza(StringBuilder sb, Iterable<?> iterable) {
        Iterator<?> it = iterable.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append(zzs(it.next()));
                if (!it.hasNext()) {
                    break;
                }
                sb.append(this.separator);
            }
        }
        return sb;
    }

    CharSequence zzs(Object obj) {
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
