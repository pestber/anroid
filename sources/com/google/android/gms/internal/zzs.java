package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class zzs {
    public static String TAG = "Volley";
    public static boolean DEBUG = Log.isLoggable(TAG, 2);

    static class zza {
        public static final boolean zzak = zzs.DEBUG;
        private final List<C0168zza> zzal = new ArrayList();
        private boolean zzam = false;

        /* renamed from: com.google.android.gms.internal.zzs$zza$zza, reason: collision with other inner class name */
        private static class C0168zza {
            public final String name;
            public final long time;
            public final long zzan;

            public C0168zza(String str, long j, long j2) {
                this.name = str;
                this.zzan = j;
                this.time = j2;
            }
        }

        zza() {
        }

        private long zzx() {
            if (this.zzal.size() == 0) {
                return 0L;
            }
            return this.zzal.get(this.zzal.size() - 1).time - this.zzal.get(0).time;
        }

        protected void finalize() throws Throwable {
            if (this.zzam) {
                return;
            }
            zzd("Request on the loose");
            zzs.zzc("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void zza(String str, long j) {
            if (this.zzam) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.zzal.add(new C0168zza(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void zzd(String str) {
            this.zzam = true;
            long zzx = zzx();
            if (zzx <= 0) {
                return;
            }
            long j = this.zzal.get(0).time;
            zzs.zzb("(%-4d ms) %s", Long.valueOf(zzx), str);
            for (C0168zza c0168zza : this.zzal) {
                long j2 = c0168zza.time;
                zzs.zzb("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0168zza.zzan), c0168zza.name);
                j = j2;
            }
        }
    }

    public static void zza(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, zzd(str, objArr));
        }
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr), th);
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(TAG, zzd(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(TAG, zzd(str, objArr));
    }

    private static String zzd(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClass().equals(zzs.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }
}
