package com.google.android.gms.wearable;

import java.io.IOException;

/* loaded from: classes.dex */
public class ChannelIOException extends IOException {
    private final int zzaSO;
    private final int zzaSP;

    public ChannelIOException(String str, int i, int i2) {
        super(str);
        this.zzaSO = i;
        this.zzaSP = i2;
    }

    public int getAppSpecificErrorCode() {
        return this.zzaSP;
    }

    public int getCloseReason() {
        return this.zzaSO;
    }
}
