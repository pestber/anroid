package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class zzg<T> extends zzb<T> {
    private T zzYM;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.zzb, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzYq);
        }
        this.zzYq++;
        if (this.zzYq == 0) {
            this.zzYM = this.zzYp.get(0);
            if (!(this.zzYM instanceof zzc)) {
                throw new IllegalStateException("DataBuffer reference of type " + this.zzYM.getClass() + " is not movable");
            }
        } else {
            ((zzc) this.zzYM).zzbf(this.zzYq);
        }
        return this.zzYM;
    }
}
