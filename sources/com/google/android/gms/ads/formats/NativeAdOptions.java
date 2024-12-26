package com.google.android.gms.ads.formats;

/* loaded from: classes.dex */
public final class NativeAdOptions {
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zznS;
    private final int zznT;
    private final boolean zznU;

    public static final class Builder {
        private boolean zznS = false;
        private int zznT = 0;
        private boolean zznU = false;

        public NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public Builder setImageOrientation(int i) {
            this.zznT = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.zznU = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.zznS = z;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zznS = builder.zznS;
        this.zznT = builder.zznT;
        this.zznU = builder.zznU;
    }

    public int getImageOrientation() {
        return this.zznT;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zznU;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zznS;
    }
}
