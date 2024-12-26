package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class zzbo extends zzbl {
    private MessageDigest zzrS;

    byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzj(zzbn.zzB(strArr[i]));
        }
        return bArr;
    }

    byte zzj(int i) {
        return (byte) (((i & ViewCompat.MEASURED_STATE_MASK) >> 24) ^ (((i & MotionEventCompat.ACTION_MASK) ^ ((65280 & i) >> 8)) ^ ((16711680 & i) >> 16)));
    }

    @Override // com.google.android.gms.internal.zzbl
    public byte[] zzy(String str) {
        byte[] zza = zza(str.split(" "));
        this.zzrS = zzcu();
        synchronized (this.zzqt) {
            if (this.zzrS == null) {
                return new byte[0];
            }
            this.zzrS.reset();
            this.zzrS.update(zza);
            byte[] digest = this.zzrS.digest();
            int i = 4;
            if (digest.length <= 4) {
                i = digest.length;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(digest, 0, bArr, 0, i);
            return bArr;
        }
    }
}
