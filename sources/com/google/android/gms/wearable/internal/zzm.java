package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class zzm extends InputStream {
    private final InputStream zzaTX;
    private volatile zzj zzaTY;

    public zzm(InputStream inputStream) {
        this.zzaTX = (InputStream) com.google.android.gms.common.internal.zzu.zzu(inputStream);
    }

    private int zzjX(int i) throws ChannelIOException {
        zzj zzjVar;
        if (i != -1 || (zzjVar = this.zzaTY) == null) {
            return i;
        }
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzjVar.zzaTN, zzjVar.zzaTO);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.zzaTX.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzaTX.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.zzaTX.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.zzaTX.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return zzjX(this.zzaTX.read());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return zzjX(this.zzaTX.read(bArr));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        return zzjX(this.zzaTX.read(bArr, i, i2));
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.zzaTX.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        return this.zzaTX.skip(j);
    }

    zzr zzBb() {
        return new zzr() { // from class: com.google.android.gms.wearable.internal.zzm.1
            @Override // com.google.android.gms.wearable.internal.zzr
            public void zzb(zzj zzjVar) {
                zzm.this.zza(zzjVar);
            }
        };
    }

    void zza(zzj zzjVar) {
        this.zzaTY = (zzj) com.google.android.gms.common.internal.zzu.zzu(zzjVar);
    }
}
