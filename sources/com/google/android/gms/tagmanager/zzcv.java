package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
class zzcv {

    /* renamed from: com.google.android.gms.tagmanager.zzcv$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ SharedPreferences.Editor zzaNQ;

        AnonymousClass1(SharedPreferences.Editor editor) {
            this.zzaNQ = editor;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.zzaNQ.commit();
        }
    }

    static void zza(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        zza(edit);
    }

    static void zza(SharedPreferences.Editor editor) {
        editor.apply();
    }
}
