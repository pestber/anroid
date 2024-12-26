package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class zzmw<T extends Result> implements PendingResult<T> {
    private final T zzakV;

    zzmw(T t) {
        this.zzakV = t;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void addBatchCallback(PendingResult.BatchCallback batchCallback) {
        batchCallback.zzs(this.zzakV.getStatus());
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public T await() {
        return this.zzakV;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public T await(long j, TimeUnit timeUnit) {
        return this.zzakV;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        return false;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void setResultCallback(ResultCallback<T> resultCallback) {
        resultCallback.onResult(this.zzakV);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void setResultCallback(ResultCallback<T> resultCallback, long j, TimeUnit timeUnit) {
        resultCallback.onResult(this.zzakV);
    }
}
