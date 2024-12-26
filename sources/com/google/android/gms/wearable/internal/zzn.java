package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class zzn extends OutputStream {
    private volatile zzj zzaTY;
    private final OutputStream zzaUa;

    public zzn(OutputStream outputStream) {
        this.zzaUa = (OutputStream) com.google.android.gms.common.internal.zzu.zzu(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzj zzjVar = this.zzaTY;
        if (zzjVar == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzjVar.zzaTN, zzjVar.zzaTO);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.zzaUa.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            this.zzaUa.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        try {
            this.zzaUa.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            this.zzaUa.write(bArr);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            this.zzaUa.write(bArr, i, i2);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    zzr zzBb() {
        return new zzr() { // from class: com.google.android.gms.wearable.internal.zzn.1
            @Override // com.google.android.gms.wearable.internal.zzr
            public void zzb(zzj zzjVar) {
                zzn.this.zzc(zzjVar);
            }
        };
    }

    void zzc(zzj zzjVar) {
        this.zzaTY = zzjVar;
    }
}
