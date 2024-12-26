package com.google.android.gms.internal;

/* loaded from: classes.dex */
public final class zzlm {
    private static int zza(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        int length = stackTraceElementArr2.length;
        int length2 = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            length2--;
            if (length2 < 0 || length - 1 < 0 || !stackTraceElementArr2[length].equals(stackTraceElementArr[length2])) {
                break;
            }
            i++;
        }
        return i;
    }

    public static String zzpa() {
        StringBuilder sb = new StringBuilder();
        Throwable th = new Throwable();
        StackTraceElement[] stackTrace = th.getStackTrace();
        sb.append("Async stack trace:");
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("\n\tat ").append(stackTraceElement);
        }
        Throwable cause = th.getCause();
        while (cause != null) {
            sb.append("\nCaused by: ");
            sb.append(cause);
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            int zza = zza(stackTrace2, stackTrace);
            for (int i = 0; i < stackTrace2.length - zza; i++) {
                sb.append("\n\tat " + stackTrace2[i]);
            }
            if (zza > 0) {
                sb.append("\n\t... " + zza + " more");
            }
            cause = cause.getCause();
            stackTrace = stackTrace2;
        }
        return sb.toString();
    }
}
