package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzks<K, V> extends zzkw<K, V> implements Map<K, V> {
    zzkv<K, V> zzabl;

    private zzkv<K, V> zzog() {
        if (this.zzabl == null) {
            this.zzabl = new zzkv<K, V>() { // from class: com.google.android.gms.internal.zzks.1
                @Override // com.google.android.gms.internal.zzkv
                protected void colClear() {
                    zzks.this.clear();
                }

                @Override // com.google.android.gms.internal.zzkv
                protected Object colGetEntry(int i, int i2) {
                    return zzks.this.mArray[(i << 1) + i2];
                }

                @Override // com.google.android.gms.internal.zzkv
                protected Map<K, V> colGetMap() {
                    return zzks.this;
                }

                @Override // com.google.android.gms.internal.zzkv
                protected int colGetSize() {
                    return zzks.this.mSize;
                }

                @Override // com.google.android.gms.internal.zzkv
                protected int colIndexOfKey(Object obj) {
                    zzks zzksVar = zzks.this;
                    return obj == null ? zzksVar.indexOfNull() : zzksVar.indexOf(obj, obj.hashCode());
                }

                @Override // com.google.android.gms.internal.zzkv
                protected int colIndexOfValue(Object obj) {
                    return zzks.this.indexOfValue(obj);
                }

                @Override // com.google.android.gms.internal.zzkv
                protected void colPut(K k, V v) {
                    zzks.this.put(k, v);
                }

                @Override // com.google.android.gms.internal.zzkv
                protected void colRemoveAt(int i) {
                    zzks.this.removeAt(i);
                }

                @Override // com.google.android.gms.internal.zzkv
                protected V colSetValue(int i, V v) {
                    return zzks.this.setValueAt(i, v);
                }
            };
        }
        return this.zzabl;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return zzog().getEntrySet();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return zzog().getKeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return zzog().getValues();
    }
}
