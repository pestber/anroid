package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgd
/* loaded from: classes.dex */
public class zzbi {
    private int zzrt;
    private final Object zzqt = new Object();
    private List<zzbh> zzru = new LinkedList();

    public boolean zza(zzbh zzbhVar) {
        synchronized (this.zzqt) {
            return this.zzru.contains(zzbhVar);
        }
    }

    public boolean zzb(zzbh zzbhVar) {
        synchronized (this.zzqt) {
            Iterator<zzbh> it = this.zzru.iterator();
            while (it.hasNext()) {
                zzbh next = it.next();
                if (zzbhVar != next && next.zzci().equals(zzbhVar.zzci())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public void zzc(zzbh zzbhVar) {
        synchronized (this.zzqt) {
            if (this.zzru.size() >= 10) {
                com.google.android.gms.ads.internal.util.client.zzb.zzay("Queue is full, current size = " + this.zzru.size());
                this.zzru.remove(0);
            }
            int i = this.zzrt;
            this.zzrt = i + 1;
            zzbhVar.zzg(i);
            this.zzru.add(zzbhVar);
        }
    }

    public zzbh zzco() {
        synchronized (this.zzqt) {
            zzbh zzbhVar = null;
            if (this.zzru.size() == 0) {
                com.google.android.gms.ads.internal.util.client.zzb.zzay("Queue empty");
                return null;
            }
            if (this.zzru.size() < 2) {
                zzbh zzbhVar2 = this.zzru.get(0);
                zzbhVar2.zzcj();
                return zzbhVar2;
            }
            int i = Integer.MIN_VALUE;
            for (zzbh zzbhVar3 : this.zzru) {
                int score = zzbhVar3.getScore();
                if (score > i) {
                    zzbhVar = zzbhVar3;
                    i = score;
                }
            }
            this.zzru.remove(zzbhVar);
            return zzbhVar;
        }
    }
}
