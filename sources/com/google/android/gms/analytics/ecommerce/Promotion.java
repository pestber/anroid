package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> zzJj = new HashMap();

    void put(String str, String str2) {
        zzu.zzb(str, "Name should be non-null");
        this.zzJj.put(str, str2);
    }

    public Promotion setCreative(String str) {
        put("cr", str);
        return this;
    }

    public Promotion setId(String str) {
        put("id", str);
        return this;
    }

    public Promotion setName(String str) {
        put("nm", str);
        return this;
    }

    public Promotion setPosition(String str) {
        put("ps", str);
        return this;
    }

    public String toString() {
        return zznq.zzD(this.zzJj);
    }

    public Map<String, String> zzaQ(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.zzJj.entrySet()) {
            hashMap.put(str + entry.getKey(), entry.getValue());
        }
        return hashMap;
    }
}
