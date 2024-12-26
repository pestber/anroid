package com.google.android.gms.internal;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.internal.zzb;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzv implements com.google.android.gms.internal.zzb {
    private final int zzaA;
    private final Map<String, zza> zzax;
    private long zzay;
    private final File zzaz;

    static class zza {
        public long zzaB;
        public String zzaC;
        public String zzb;
        public long zzc;
        public long zzd;
        public long zze;
        public long zzf;
        public Map<String, String> zzg;

        private zza() {
        }

        public zza(String str, zzb.zza zzaVar) {
            this.zzaC = str;
            this.zzaB = zzaVar.data.length;
            this.zzb = zzaVar.zzb;
            this.zzc = zzaVar.zzc;
            this.zzd = zzaVar.zzd;
            this.zze = zzaVar.zze;
            this.zzf = zzaVar.zzf;
            this.zzg = zzaVar.zzg;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zzaVar = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zzaVar.zzaC = zzv.zzd(inputStream);
            zzaVar.zzb = zzv.zzd(inputStream);
            if (zzaVar.zzb.equals("")) {
                zzaVar.zzb = null;
            }
            zzaVar.zzc = zzv.zzc(inputStream);
            zzaVar.zzd = zzv.zzc(inputStream);
            zzaVar.zze = zzv.zzc(inputStream);
            zzaVar.zzf = zzv.zzc(inputStream);
            zzaVar.zzg = zzv.zze(inputStream);
            return zzaVar;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzaC);
                zzv.zza(outputStream, this.zzb == null ? "" : this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(outputStream, this.zzf);
                zzv.zza(this.zzg, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zzaVar = new zzb.zza();
            zzaVar.data = bArr;
            zzaVar.zzb = this.zzb;
            zzaVar.zzc = this.zzc;
            zzaVar.zzd = this.zzd;
            zzaVar.zze = this.zze;
            zzaVar.zzf = this.zzf;
            zzaVar.zzg = this.zzg;
            return zzaVar;
        }
    }

    private static class zzb extends FilterInputStream {
        private int zzaD;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzaD = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzaD++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzaD += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzax = new LinkedHashMap(16, 0.75f, true);
        this.zzay = 0L;
        this.zzaz = file;
        this.zzaA = i;
    }

    private void removeEntry(String str) {
        zza zzaVar = this.zzax.get(str);
        if (zzaVar != null) {
            this.zzay -= zzaVar.zzaB;
            this.zzax.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 8) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 16) & MotionEventCompat.ACTION_MASK);
        outputStream.write((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zzaVar) {
        if (this.zzax.containsKey(str)) {
            this.zzay += zzaVar.zzaB - this.zzax.get(str).zzaB;
        } else {
            this.zzay += zzaVar.zzaB;
        }
        this.zzax.put(str, zzaVar);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            zza(outputStream, 0);
            return;
        }
        zza(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            zza(outputStream, entry.getKey());
            zza(outputStream, entry.getValue());
        }
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return ((zza(inputStream) & 255) << 0) | 0 | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((255 & zza(inputStream)) << 56);
    }

    private void zzc(int i) {
        if (this.zzay + i < this.zzaA) {
            return;
        }
        int i2 = 0;
        if (zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
        }
        long j = this.zzay;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, zza>> it = this.zzax.entrySet().iterator();
        while (it.hasNext()) {
            zza value = it.next().getValue();
            if (zzf(value.zzaC).delete()) {
                this.zzay -= value.zzaB;
            } else {
                zzs.zzb("Could not delete cache entry for key=%s, filename=%s", value.zzaC, zze(value.zzaC));
            }
            it.remove();
            i2++;
            if (this.zzay + r2 < this.zzaA * 0.9f) {
                break;
            }
        }
        if (zzs.DEBUG) {
            zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> emptyMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized zzb.zza zza(String str) {
        zzb zzbVar;
        zza zzaVar = this.zzax.get(str);
        zzb zzbVar2 = null;
        byte b = 0;
        if (zzaVar == null) {
            return null;
        }
        try {
            File zzf = zzf(str);
            try {
                zzbVar = new zzb(new FileInputStream(zzf));
            } catch (IOException e) {
                e = e;
                zzbVar = null;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        zzbVar2.close();
                    } catch (IOException e2) {
                        return null;
                    }
                }
                throw th;
            }
            try {
                zza.zzf(zzbVar);
                zzb.zza zzb2 = zzaVar.zzb(zza(zzbVar, (int) (zzf.length() - zzbVar.zzaD)));
                try {
                    zzbVar.close();
                    return zzb2;
                } catch (IOException e3) {
                    return null;
                }
            } catch (IOException e4) {
                e = e4;
                zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                remove(str);
                if (zzbVar != null) {
                    try {
                        zzbVar.close();
                    } catch (IOException e5) {
                        return null;
                    }
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza() {
        if (!this.zzaz.exists()) {
            if (!this.zzaz.mkdirs()) {
                zzs.zzc("Unable to create cache dir %s", this.zzaz.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.zzaz.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zza zzf = zza.zzf(bufferedInputStream2);
                        zzf.zzaB = file.length();
                        zza(zzf.zzaC, zzf);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        bufferedInputStream = bufferedInputStream2;
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
            }
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza(String str, zzb.zza zzaVar) {
        zzc(zzaVar.data.length);
        File zzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzf);
            zza zzaVar2 = new zza(str, zzaVar);
            if (!zzaVar2.zza(fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zzaVar.data);
            fileOutputStream.close();
            zza(str, zzaVar2);
        } catch (IOException e) {
            if (zzf.delete()) {
                return;
            }
            zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
        }
    }

    public File zzf(String str) {
        return new File(this.zzaz, zze(str));
    }
}
