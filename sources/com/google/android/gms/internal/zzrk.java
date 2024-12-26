package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class zzrk implements Cloneable {
    private zzri<?, ?> zzaWb;
    private Object zzaWc;
    private List<zzrp> zzaWd = new ArrayList();

    zzrk() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzB()];
        zza(zzrg.zzA(bArr));
        return bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzrk)) {
            return false;
        }
        zzrk zzrkVar = (zzrk) obj;
        if (this.zzaWc != null && zzrkVar.zzaWc != null) {
            if (this.zzaWb != zzrkVar.zzaWb) {
                return false;
            }
            return !this.zzaWb.zzaVV.isArray() ? this.zzaWc.equals(zzrkVar.zzaWc) : this.zzaWc instanceof byte[] ? Arrays.equals((byte[]) this.zzaWc, (byte[]) zzrkVar.zzaWc) : this.zzaWc instanceof int[] ? Arrays.equals((int[]) this.zzaWc, (int[]) zzrkVar.zzaWc) : this.zzaWc instanceof long[] ? Arrays.equals((long[]) this.zzaWc, (long[]) zzrkVar.zzaWc) : this.zzaWc instanceof float[] ? Arrays.equals((float[]) this.zzaWc, (float[]) zzrkVar.zzaWc) : this.zzaWc instanceof double[] ? Arrays.equals((double[]) this.zzaWc, (double[]) zzrkVar.zzaWc) : this.zzaWc instanceof boolean[] ? Arrays.equals((boolean[]) this.zzaWc, (boolean[]) zzrkVar.zzaWc) : Arrays.deepEquals((Object[]) this.zzaWc, (Object[]) zzrkVar.zzaWc);
        }
        if (this.zzaWd != null && zzrkVar.zzaWd != null) {
            return this.zzaWd.equals(zzrkVar.zzaWd);
        }
        try {
            return Arrays.equals(toByteArray(), zzrkVar.toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    int zzB() {
        if (this.zzaWc != null) {
            return this.zzaWb.zzQ(this.zzaWc);
        }
        Iterator<zzrp> it = this.zzaWd.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().zzB();
        }
        return i;
    }

    /* renamed from: zzBM, reason: merged with bridge method [inline-methods] */
    public final zzrk clone() {
        Object clone;
        zzrk zzrkVar = new zzrk();
        try {
            zzrkVar.zzaWb = this.zzaWb;
            if (this.zzaWd == null) {
                zzrkVar.zzaWd = null;
            } else {
                zzrkVar.zzaWd.addAll(this.zzaWd);
            }
            if (this.zzaWc != null) {
                if (this.zzaWc instanceof zzrn) {
                    clone = ((zzrn) this.zzaWc).clone();
                } else if (this.zzaWc instanceof byte[]) {
                    clone = ((byte[]) this.zzaWc).clone();
                } else {
                    int i = 0;
                    if (this.zzaWc instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.zzaWc;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzrkVar.zzaWc = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.zzaWc instanceof boolean[]) {
                        clone = ((boolean[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof int[]) {
                        clone = ((int[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof long[]) {
                        clone = ((long[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof float[]) {
                        clone = ((float[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof double[]) {
                        clone = ((double[]) this.zzaWc).clone();
                    } else if (this.zzaWc instanceof zzrn[]) {
                        zzrn[] zzrnVarArr = (zzrn[]) this.zzaWc;
                        zzrn[] zzrnVarArr2 = new zzrn[zzrnVarArr.length];
                        zzrkVar.zzaWc = zzrnVarArr2;
                        while (i < zzrnVarArr.length) {
                            zzrnVarArr2[i] = zzrnVarArr[i].clone();
                            i++;
                        }
                    }
                }
                zzrkVar.zzaWc = clone;
            }
            return zzrkVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    void zza(zzrg zzrgVar) throws IOException {
        if (this.zzaWc != null) {
            this.zzaWb.zza(this.zzaWc, zzrgVar);
            return;
        }
        Iterator<zzrp> it = this.zzaWd.iterator();
        while (it.hasNext()) {
            it.next().zza(zzrgVar);
        }
    }

    void zza(zzrp zzrpVar) {
        this.zzaWd.add(zzrpVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T zzb(zzri<?, T> zzriVar) {
        if (this.zzaWc == null) {
            this.zzaWb = zzriVar;
            this.zzaWc = zzriVar.zzx(this.zzaWd);
            this.zzaWd = null;
        } else if (this.zzaWb != zzriVar) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return (T) this.zzaWc;
    }
}
