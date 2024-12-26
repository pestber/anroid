package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class AbstractPendingResult<R extends Result> implements PendingResult<R> {
    protected final CallbackHandler<R> mHandler;
    private boolean zzL;
    private ResultCallback<R> zzWd;
    private volatile R zzWe;
    private volatile boolean zzWf;
    private boolean zzWg;
    private ICancelToken zzWh;
    private final Object zzWb = new Object();
    private final CountDownLatch zzoD = new CountDownLatch(1);
    private final ArrayList<PendingResult.BatchCallback> zzWc = new ArrayList<>();

    public static class CallbackHandler<R extends Result> extends Handler {
        public static final int CALLBACK_ON_COMPLETE = 1;
        public static final int CALLBACK_ON_TIMEOUT = 2;

        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        protected void deliverResultCallback(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                AbstractPendingResult.zzb(r);
                throw e;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    deliverResultCallback((ResultCallback) pair.first, (Result) pair.second);
                    break;
                case 2:
                    ((AbstractPendingResult) message.obj).forceFailureUnlessReady(Status.zzXS);
                    break;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    break;
            }
        }

        public void removeTimeoutMessages() {
            removeMessages(2);
        }

        public void sendResultCallback(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void sendTimeoutResultCallback(AbstractPendingResult<R> abstractPendingResult, long j) {
            sendMessageDelayed(obtainMessage(2, abstractPendingResult), j);
        }
    }

    protected AbstractPendingResult(Looper looper) {
        this.mHandler = new CallbackHandler<>(looper);
    }

    protected AbstractPendingResult(CallbackHandler<R> callbackHandler) {
        this.mHandler = (CallbackHandler) zzu.zzb(callbackHandler, "CallbackHandler must not be null");
    }

    private void zza(R r) {
        this.zzWe = r;
        this.zzWh = null;
        this.zzoD.countDown();
        Status status = this.zzWe.getStatus();
        if (this.zzWd != null) {
            this.mHandler.removeTimeoutMessages();
            if (!this.zzL) {
                this.mHandler.sendResultCallback(this.zzWd, zzmo());
            }
        }
        Iterator<PendingResult.BatchCallback> it = this.zzWc.iterator();
        while (it.hasNext()) {
            it.next().zzs(status);
        }
        this.zzWc.clear();
    }

    static void zzb(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("AbstractPendingResult", "Unable to release " + result, e);
            }
        }
    }

    private R zzmo() {
        R r;
        synchronized (this.zzWb) {
            zzu.zza(!this.zzWf, "Result has already been consumed.");
            zzu.zza(isReady(), "Result is not ready.");
            r = this.zzWe;
            this.zzWe = null;
            this.zzWd = null;
            this.zzWf = true;
        }
        onResultConsumed();
        return r;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addBatchCallback(PendingResult.BatchCallback batchCallback) {
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        synchronized (this.zzWb) {
            if (isReady()) {
                batchCallback.zzs(this.zzWe.getStatus());
            } else {
                this.zzWc.add(batchCallback);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        zzu.zza(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        zzu.zza(!this.zzWf, "Result has already been consumed");
        try {
            this.zzoD.await();
        } catch (InterruptedException e) {
            forceFailureUnlessReady(Status.zzXQ);
        }
        zzu.zza(isReady(), "Result is not ready.");
        return zzmo();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        zzu.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        try {
            if (!this.zzoD.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.zzXS);
            }
        } catch (InterruptedException e) {
            forceFailureUnlessReady(Status.zzXQ);
        }
        zzu.zza(isReady(), "Result is not ready.");
        return zzmo();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zzWb) {
            if (!this.zzL && !this.zzWf) {
                if (this.zzWh != null) {
                    try {
                        this.zzWh.cancel();
                    } catch (RemoteException e) {
                    }
                }
                zzb(this.zzWe);
                this.zzWd = null;
                this.zzL = true;
                zza(createFailedResult(Status.zzXT));
            }
        }
    }

    protected abstract R createFailedResult(Status status);

    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zzWb) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zzWg = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzWb) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzoD.getCount() == 0;
    }

    protected void onResultConsumed() {
    }

    protected final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zzWb) {
            this.zzWh = iCancelToken;
        }
    }

    public final void setResult(R r) {
        synchronized (this.zzWb) {
            if (!this.zzWg && !this.zzL) {
                zzu.zza(!isReady(), "Results have already been set");
                zzu.zza(!this.zzWf, "Result has already been consumed");
                zza(r);
                return;
            }
            zzb(r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback) {
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        synchronized (this.zzWb) {
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.mHandler.sendResultCallback(resultCallback, zzmo());
            } else {
                this.zzWd = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        zzu.zza(!this.zzWf, "Result has already been consumed.");
        synchronized (this.zzWb) {
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.mHandler.sendResultCallback(resultCallback, zzmo());
            } else {
                this.zzWd = resultCallback;
                this.mHandler.sendTimeoutResultCallback(this, timeUnit.toMillis(j));
            }
        }
    }
}
