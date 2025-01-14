package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class WalletFragmentOptions implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentOptions> CREATOR = new zzb();
    private int mTheme;
    final int zzCY;
    private int zzaRH;
    private WalletFragmentStyle zzaSk;
    private int zzacS;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public Builder setEnvironment(int i) {
            WalletFragmentOptions.this.zzaRH = i;
            return this;
        }

        public Builder setFragmentStyle(int i) {
            WalletFragmentOptions.this.zzaSk = new WalletFragmentStyle().setStyleResourceId(i);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle walletFragmentStyle) {
            WalletFragmentOptions.this.zzaSk = walletFragmentStyle;
            return this;
        }

        public Builder setMode(int i) {
            WalletFragmentOptions.this.zzacS = i;
            return this;
        }

        public Builder setTheme(int i) {
            WalletFragmentOptions.this.mTheme = i;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.zzCY = 1;
    }

    WalletFragmentOptions(int i, int i2, int i3, WalletFragmentStyle walletFragmentStyle, int i4) {
        this.zzCY = i;
        this.zzaRH = i2;
        this.mTheme = i3;
        this.zzaSk = walletFragmentStyle;
        this.zzacS = i4;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzaRH = i2;
        walletFragmentOptions.zzaSk = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzaSk.zzaL(context);
        walletFragmentOptions.zzacS = i3;
        return walletFragmentOptions;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzaRH;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzaSk;
    }

    public int getMode() {
        return this.zzacS;
    }

    public int getTheme() {
        return this.mTheme;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public void zzaL(Context context) {
        if (this.zzaSk != null) {
            this.zzaSk.zzaL(context);
        }
    }
}
