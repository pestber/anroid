package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes.dex */
public final class zzrg {
    private final ByteBuffer zzaVT;

    public static class zza extends IOException {
        zza(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private zzrg(ByteBuffer byteBuffer) {
        this.zzaVT = byteBuffer;
    }

    private zzrg(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    public static int zzA(int i, int i2) {
        return zzkM(i) + zzkJ(i2);
    }

    public static zzrg zzA(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static int zzB(int i, int i2) {
        return zzkM(i) + zzkK(i2);
    }

    public static int zzC(byte[] bArr) {
        return zzkO(bArr.length) + bArr.length;
    }

    public static int zzY(long j) {
        return zzab(j);
    }

    public static int zzZ(long j) {
        return zzab(zzad(j));
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += zza(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i2 + 4294967296L));
    }

    private static int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new IllegalArgumentException("Unpaired surrogate at index " + i);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        return r8 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int zza(java.lang.CharSequence r6, byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzrg.zza(java.lang.CharSequence, byte[], int, int):int");
    }

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (!byteBuffer.hasArray()) {
            zzb(charSequence, byteBuffer);
            return;
        }
        try {
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    public static int zzab(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static long zzad(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzas(boolean z) {
        return 1;
    }

    public static int zzb(int i, double d) {
        return zzkM(i) + zzi(d);
    }

    public static int zzb(int i, zzrn zzrnVar) {
        return (zzkM(i) * 2) + zzd(zzrnVar);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzkM(i) + zzC(bArr);
    }

    public static zzrg zzb(byte[] bArr, int i, int i2) {
        return new zzrg(bArr, i, i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    private static void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            char c = charAt;
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i = (charAt >>> 6) | 960;
                } else {
                    if (charAt >= 55296 && 57343 >= charAt) {
                        int i3 = i2 + 1;
                        if (i3 != charSequence.length()) {
                            char charAt2 = charSequence.charAt(i3);
                            if (Character.isSurrogatePair(charAt, charAt2)) {
                                int codePoint = Character.toCodePoint(charAt, charAt2);
                                byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put((byte) ((codePoint & 63) | 128));
                                i2 = i3;
                                i2++;
                            } else {
                                i2 = i3;
                            }
                        }
                        throw new IllegalArgumentException("Unpaired surrogate at index " + (i2 - 1));
                    }
                    byteBuffer.put((byte) ((charAt >>> '\f') | 480));
                    i = ((charAt >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) i);
                c = (charAt & '?') | 128;
            }
            byteBuffer.put((byte) c);
            i2++;
        }
    }

    public static int zzc(int i, float f) {
        return zzkM(i) + zzj(f);
    }

    public static int zzc(int i, zzrn zzrnVar) {
        return zzkM(i) + zze(zzrnVar);
    }

    public static int zzc(int i, boolean z) {
        return zzkM(i) + zzas(z);
    }

    public static int zzd(int i, long j) {
        return zzkM(i) + zzY(j);
    }

    public static int zzd(zzrn zzrnVar) {
        return zzrnVar.zzBV();
    }

    public static int zze(int i, long j) {
        return zzkM(i) + zzZ(j);
    }

    public static int zze(zzrn zzrnVar) {
        int zzBV = zzrnVar.zzBV();
        return zzkO(zzBV) + zzBV;
    }

    public static int zzfj(String str) {
        int zza2 = zza(str);
        return zzkO(zza2) + zza2;
    }

    public static int zzi(double d) {
        return 8;
    }

    public static int zzj(float f) {
        return 4;
    }

    public static int zzk(int i, String str) {
        return zzkM(i) + zzfj(str);
    }

    public static int zzkJ(int i) {
        if (i >= 0) {
            return zzkO(i);
        }
        return 10;
    }

    public static int zzkK(int i) {
        return zzkO(zzkQ(i));
    }

    public static int zzkM(int i) {
        return zzkO(zzrq.zzD(i, 0));
    }

    public static int zzkO(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzkQ(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public void zzB(byte[] bArr) throws IOException {
        zzkN(bArr.length);
        zzD(bArr);
    }

    public int zzBG() {
        return this.zzaVT.remaining();
    }

    public void zzBH() {
        if (zzBG() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void zzC(int i, int i2) throws IOException {
        zzkN(zzrq.zzD(i, i2));
    }

    public void zzD(byte[] bArr) throws IOException {
        zzc(bArr, 0, bArr.length);
    }

    public void zzW(long j) throws IOException {
        zzaa(j);
    }

    public void zzX(long j) throws IOException {
        zzaa(zzad(j));
    }

    public void zza(int i, double d) throws IOException {
        zzC(i, 1);
        zzh(d);
    }

    public void zza(int i, zzrn zzrnVar) throws IOException {
        zzC(i, 2);
        zzc(zzrnVar);
    }

    public void zza(int i, byte[] bArr) throws IOException {
        zzC(i, 2);
        zzB(bArr);
    }

    public void zzaa(long j) throws IOException {
        while (((-128) & j) != 0) {
            zzkL((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        zzkL((int) j);
    }

    public void zzac(long j) throws IOException {
        zzkL(((int) j) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 8)) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 16)) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 24)) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 32)) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 40)) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 48)) & MotionEventCompat.ACTION_MASK);
        zzkL(((int) (j >> 56)) & MotionEventCompat.ACTION_MASK);
    }

    public void zzar(boolean z) throws IOException {
        zzkL(z ? 1 : 0);
    }

    public void zzb(byte b) throws IOException {
        if (!this.zzaVT.hasRemaining()) {
            throw new zza(this.zzaVT.position(), this.zzaVT.limit());
        }
        this.zzaVT.put(b);
    }

    public void zzb(int i, float f) throws IOException {
        zzC(i, 5);
        zzi(f);
    }

    public void zzb(int i, long j) throws IOException {
        zzC(i, 0);
        zzW(j);
    }

    public void zzb(int i, String str) throws IOException {
        zzC(i, 2);
        zzfi(str);
    }

    public void zzb(int i, boolean z) throws IOException {
        zzC(i, 0);
        zzar(z);
    }

    public void zzb(zzrn zzrnVar) throws IOException {
        zzrnVar.zza(this);
    }

    public void zzc(int i, long j) throws IOException {
        zzC(i, 0);
        zzX(j);
    }

    public void zzc(zzrn zzrnVar) throws IOException {
        zzkN(zzrnVar.zzBU());
        zzrnVar.zza(this);
    }

    public void zzc(byte[] bArr, int i, int i2) throws IOException {
        if (this.zzaVT.remaining() < i2) {
            throw new zza(this.zzaVT.position(), this.zzaVT.limit());
        }
        this.zzaVT.put(bArr, i, i2);
    }

    public void zzfi(String str) throws IOException {
        try {
            int zzkO = zzkO(str.length());
            if (zzkO != zzkO(str.length() * 3)) {
                zzkN(zza(str));
                zza(str, this.zzaVT);
                return;
            }
            int position = this.zzaVT.position();
            this.zzaVT.position(position + zzkO);
            zza(str, this.zzaVT);
            int position2 = this.zzaVT.position();
            this.zzaVT.position(position);
            zzkN((position2 - position) - zzkO);
            this.zzaVT.position(position2);
        } catch (BufferOverflowException e) {
            throw new zza(this.zzaVT.position(), this.zzaVT.limit());
        }
    }

    public void zzh(double d) throws IOException {
        zzac(Double.doubleToLongBits(d));
    }

    public void zzi(float f) throws IOException {
        zzkP(Float.floatToIntBits(f));
    }

    public void zzkH(int i) throws IOException {
        if (i >= 0) {
            zzkN(i);
        } else {
            zzaa(i);
        }
    }

    public void zzkI(int i) throws IOException {
        zzkN(zzkQ(i));
    }

    public void zzkL(int i) throws IOException {
        zzb((byte) i);
    }

    public void zzkN(int i) throws IOException {
        while ((i & (-128)) != 0) {
            zzkL((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        zzkL(i);
    }

    public void zzkP(int i) throws IOException {
        zzkL(i & MotionEventCompat.ACTION_MASK);
        zzkL((i >> 8) & MotionEventCompat.ACTION_MASK);
        zzkL((i >> 16) & MotionEventCompat.ACTION_MASK);
        zzkL((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    public void zzy(int i, int i2) throws IOException {
        zzC(i, 0);
        zzkH(i2);
    }

    public void zzz(int i, int i2) throws IOException {
        zzC(i, 0);
        zzkI(i2);
    }
}
