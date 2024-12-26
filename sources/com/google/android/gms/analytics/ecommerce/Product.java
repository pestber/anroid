package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzc;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zznq;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class Product {
    Map<String, String> zzJj = new HashMap();

    void put(String str, String str2) {
        zzu.zzb(str, "Name should be non-null");
        this.zzJj.put(str, str2);
    }

    public Product setBrand(String str) {
        put("br", str);
        return this;
    }

    public Product setCategory(String str) {
        put("ca", str);
        return this;
    }

    public Product setCouponCode(String str) {
        put("cc", str);
        return this;
    }

    public Product setCustomDimension(int i, String str) {
        put(zzc.zzY(i), str);
        return this;
    }

    public Product setCustomMetric(int i, int i2) {
        put(zzc.zzZ(i), Integer.toString(i2));
        return this;
    }

    public Product setId(String str) {
        put("id", str);
        return this;
    }

    public Product setName(String str) {
        put("nm", str);
        return this;
    }

    public Product setPosition(int i) {
        put("ps", Integer.toString(i));
        return this;
    }

    public Product setPrice(double d) {
        put("pr", Double.toString(d));
        return this;
    }

    public Product setQuantity(int i) {
        put("qt", Integer.toString(i));
        return this;
    }

    public Product setVariant(String str) {
        put("va", str);
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
