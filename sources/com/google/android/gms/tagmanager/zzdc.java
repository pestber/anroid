package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

/* loaded from: classes.dex */
class zzdc {
    private Context mContext;
    private Tracker zzIq;
    private GoogleAnalytics zzIs;

    static class zza implements Logger {
        zza() {
        }

        private static int zzja(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                case 6:
                default:
                    return 3;
            }
        }

        @Override // com.google.android.gms.analytics.Logger
        public void error(Exception exc) {
            zzbg.zzb("", exc);
        }

        @Override // com.google.android.gms.analytics.Logger
        public void error(String str) {
            zzbg.zzaz(str);
        }

        @Override // com.google.android.gms.analytics.Logger
        public int getLogLevel() {
            return zzja(zzbg.getLogLevel());
        }

        @Override // com.google.android.gms.analytics.Logger
        public void info(String str) {
            zzbg.zzaA(str);
        }

        @Override // com.google.android.gms.analytics.Logger
        public void setLogLevel(int i) {
            zzbg.zzaC("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        @Override // com.google.android.gms.analytics.Logger
        public void verbose(String str) {
            zzbg.zzaB(str);
        }

        @Override // com.google.android.gms.analytics.Logger
        public void warn(String str) {
            zzbg.zzaC(str);
        }
    }

    zzdc(Context context) {
        this.mContext = context;
    }

    private synchronized void zzeH(String str) {
        if (this.zzIs == null) {
            this.zzIs = GoogleAnalytics.getInstance(this.mContext);
            this.zzIs.setLogger(new zza());
            this.zzIq = this.zzIs.newTracker(str);
        }
    }

    public Tracker zzeG(String str) {
        zzeH(str);
        return this.zzIq;
    }
}
