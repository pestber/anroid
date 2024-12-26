package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class zzbl {
    private static MessageDigest zzrK = null;
    protected Object zzqt = new Object();

    protected MessageDigest zzcu() {
        synchronized (this.zzqt) {
            if (zzrK != null) {
                return zzrK;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzrK = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException e) {
                }
            }
            return zzrK;
        }
    }

    abstract byte[] zzy(String str);
}
