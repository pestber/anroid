package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.internal.zzu;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = zzx.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzx zznK;

    public static final class Builder {
        private final zzx.zza zznL = new zzx.zza();

        public Builder addCategoryExclusion(String str) {
            this.zznL.zzK(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zznL.zzb(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.zznL.zzb(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zznL.zzb(str, zzs.zzci(",").zza(list));
            }
            return this;
        }

        public Builder addKeyword(String str) {
            this.zznL.zzE(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zznL.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zznL.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zznL.zzF(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.zznL.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            zzu.zzb(str, "Content URL must be non-null.");
            zzu.zzh(str, "Content URL must be non-empty.");
            zzu.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zznL.zzH(str);
            return this;
        }

        public Builder setGender(int i) {
            this.zznL.zzm(i);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zznL.zza(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean z) {
            this.zznL.zzj(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.zznL.zzI(str);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zznL.zzJ(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zznL.zzk(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zznK = new zzx(builder.zznL);
    }

    public static void updateCorrelator() {
        zzx.updateCorrelator();
    }

    public Date getBirthday() {
        return this.zznK.getBirthday();
    }

    public String getContentUrl() {
        return this.zznK.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zznK.getCustomEventExtrasBundle(cls);
    }

    public Bundle getCustomTargeting() {
        return this.zznK.getCustomTargeting();
    }

    public int getGender() {
        return this.zznK.getGender();
    }

    public Set<String> getKeywords() {
        return this.zznK.getKeywords();
    }

    public Location getLocation() {
        return this.zznK.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.zznK.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zznK.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zznK.getNetworkExtrasBundle(cls);
    }

    public String getPublisherProvidedId() {
        return this.zznK.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.zznK.isTestDevice(context);
    }

    public zzx zzaF() {
        return this.zznK;
    }
}
