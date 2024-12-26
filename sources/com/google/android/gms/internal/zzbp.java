package com.google.android.gms.internal;

import java.util.PriorityQueue;

/* loaded from: classes.dex */
public class zzbp {

    public static class zza {
        final long value;
        final String zzrT;

        zza(long j, String str) {
            this.value = j;
            this.zzrT = str;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof zza) && ((zza) obj).value == this.value;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    static long zza(int i, int i2, long j, long j2, long j3) {
        return ((((((j + 1073807359) - ((j2 * ((i + 2147483647L) % 1073807359)) % 1073807359)) % 1073807359) * j3) % 1073807359) + ((i2 + 2147483647L) % 1073807359)) % 1073807359;
    }

    static long zza(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        if (i == 1) {
            return j;
        }
        return (i % 2 == 0 ? zza((j * j) % 1073807359, i / 2) : j * (zza((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }

    static String zza(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i4 = i3 - 1;
            if (i >= i4) {
                stringBuffer.append(strArr[i4]);
                return stringBuffer.toString();
            }
            stringBuffer.append(strArr[i]);
            stringBuffer.append(' ');
            i++;
        }
    }

    static void zza(int i, long j, String str, PriorityQueue<zza> priorityQueue) {
        zza zzaVar = new zza(j, str);
        if ((priorityQueue.size() != i || priorityQueue.peek().value <= zzaVar.value) && !priorityQueue.contains(zzaVar)) {
            priorityQueue.add(zzaVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zza> priorityQueue) {
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), priorityQueue);
        long zza2 = zza(16785407L, i2 - 1);
        long j = zzb;
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            j = zza(zzbn.zzB(strArr[i3 - 1]), zzbn.zzB(strArr[(i3 + i2) - 1]), j, zza2, 16785407L);
            zza(i, j, zza(strArr, i3, i2), priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzB = (zzbn.zzB(strArr[i]) + 2147483647L) % 1073807359;
        for (int i3 = i + 1; i3 < i + i2; i3++) {
            zzB = (((zzB * 16785407) % 1073807359) + ((zzbn.zzB(strArr[i3]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzB;
    }
}
