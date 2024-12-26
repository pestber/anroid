package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class zzt {

    public static final class zza {
        private final Object zzGE;
        private final List<String> zzabb;

        private zza(Object obj) {
            this.zzGE = zzu.zzu(obj);
            this.zzabb = new ArrayList();
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.zzGE.getClass().getSimpleName()).append('{');
            int size = this.zzabb.size();
            for (int i = 0; i < size; i++) {
                append.append(this.zzabb.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }

        public zza zzg(String str, Object obj) {
            this.zzabb.add(((String) zzu.zzu(str)) + "=" + String.valueOf(obj));
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzt(Object obj) {
        return new zza(obj);
    }
}
