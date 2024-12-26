package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.reward.RewardedVideoAd;

/* loaded from: classes.dex */
public class MobileAds {

    public static final class Settings {
        private final zzab zznR = new zzab();

        public String getTrackingId() {
            return this.zznR.getTrackingId();
        }

        public boolean isGoogleAnalyticsEnabled() {
            return this.zznR.isGoogleAnalyticsEnabled();
        }

        public Settings setGoogleAnalyticsEnabled(boolean z) {
            this.zznR.zzl(z);
            return this;
        }

        public Settings setTrackingId(String str) {
            this.zznR.zzN(str);
            return this;
        }

        zzab zzaG() {
            return this.zznR;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzaa.zzcP().getRewardedVideoAdInstance(context);
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    public static void initialize(Context context, String str, Settings settings) {
        zzaa.zzcP().zza(context, str, settings == null ? null : settings.zzaG());
    }
}
