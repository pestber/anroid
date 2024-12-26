package com.google.android.gms.internal;

import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class zzku<K, V> {
    private int size;
    private final LinkedHashMap<K, V> zzabn;
    private int zzabo;
    private int zzabp;
    private int zzabq;
    private int zzabr;
    private int zzabs;
    private int zzabt;

    public zzku(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.zzabo = i;
        this.zzabn = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int zzc(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected V create(K k) {
        return null;
    }

    protected void entryRemoved(boolean z, K k, V v, V v2) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final V get(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.zzabn.get(k);
            if (v2 != null) {
                this.zzabs++;
                return v2;
            }
            this.zzabt++;
            V create = create(k);
            if (create == null) {
                return null;
            }
            synchronized (this) {
                this.zzabq++;
                v = (V) this.zzabn.put(k, create);
                if (v != null) {
                    this.zzabn.put(k, v);
                } else {
                    this.size += zzc(k, create);
                }
            }
            if (v != null) {
                entryRemoved(false, k, create, v);
                return v;
            }
            trimToSize(this.zzabo);
            return create;
        }
    }

    public final V put(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.zzabp++;
            this.size += zzc(k, v);
            put = this.zzabn.put(k, v);
            if (put != null) {
                this.size -= zzc(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.zzabo);
        return put;
    }

    public final synchronized int size() {
        return this.size;
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i;
        i = this.zzabs + this.zzabt;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.zzabo), Integer.valueOf(this.zzabs), Integer.valueOf(this.zzabt), Integer.valueOf(i != 0 ? (this.zzabs * 100) / i : 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0072, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trimToSize(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.size     // Catch: java.lang.Throwable -> L73
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.zzabn     // Catch: java.lang.Throwable -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L11
            int r0 = r4.size     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.size     // Catch: java.lang.Throwable -> L73
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.zzabn     // Catch: java.lang.Throwable -> L73
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.zzabn     // Catch: java.lang.Throwable -> L73
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L73
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L73
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L73
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L73
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L73
            java.util.LinkedHashMap<K, V> r2 = r4.zzabn     // Catch: java.lang.Throwable -> L73
            r2.remove(r1)     // Catch: java.lang.Throwable -> L73
            int r2 = r4.size     // Catch: java.lang.Throwable -> L73
            int r3 = r4.zzc(r1, r0)     // Catch: java.lang.Throwable -> L73
            int r2 = r2 - r3
            r4.size = r2     // Catch: java.lang.Throwable -> L73
            int r2 = r4.zzabr     // Catch: java.lang.Throwable -> L73
            r3 = 1
            int r2 = r2 + r3
            r4.zzabr = r2     // Catch: java.lang.Throwable -> L73
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L73
            r2 = 0
            r4.entryRemoved(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L73
            return
        L52:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.Class r2 = r4.getClass()     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L73
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L73
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L73
            throw r0     // Catch: java.lang.Throwable -> L73
        L73:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L73
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzku.trimToSize(int):void");
    }
}
