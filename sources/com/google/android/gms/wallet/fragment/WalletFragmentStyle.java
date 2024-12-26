package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class WalletFragmentStyle implements SafeParcelable {
    public static final Parcelable.Creator<WalletFragmentStyle> CREATOR = new zzc();
    final int zzCY;
    Bundle zzaSm;
    int zzaSn;

    public WalletFragmentStyle() {
        this.zzCY = 1;
        this.zzaSm = new Bundle();
    }

    WalletFragmentStyle(int i, Bundle bundle, int i2) {
        this.zzCY = i;
        this.zzaSm = bundle;
        this.zzaSn = i2;
    }

    private void zza(TypedArray typedArray, int i, String str) {
        TypedValue peekValue;
        if (this.zzaSm.containsKey(str) || (peekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.zzaSm.putLong(str, Dimension.zza(peekValue));
    }

    private void zza(TypedArray typedArray, int i, String str, String str2) {
        TypedValue peekValue;
        if (this.zzaSm.containsKey(str) || this.zzaSm.containsKey(str2) || (peekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        if (peekValue.type < 28 || peekValue.type > 31) {
            this.zzaSm.putInt(str2, peekValue.resourceId);
        } else {
            this.zzaSm.putInt(str, peekValue.data);
        }
    }

    private void zzb(TypedArray typedArray, int i, String str) {
        TypedValue peekValue;
        if (this.zzaSm.containsKey(str) || (peekValue = typedArray.peekValue(i)) == null) {
            return;
        }
        this.zzaSm.putInt(str, peekValue.data);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WalletFragmentStyle setBuyButtonAppearance(int i) {
        this.zzaSm.putInt("buyButtonAppearance", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i) {
        this.zzaSm.putLong("buyButtonHeight", Dimension.zzjx(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonHeight(int i, float f) {
        this.zzaSm.putLong("buyButtonHeight", Dimension.zza(i, f));
        return this;
    }

    public WalletFragmentStyle setBuyButtonText(int i) {
        this.zzaSm.putInt("buyButtonText", i);
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i) {
        this.zzaSm.putLong("buyButtonWidth", Dimension.zzjx(i));
        return this;
    }

    public WalletFragmentStyle setBuyButtonWidth(int i, float f) {
        this.zzaSm.putLong("buyButtonWidth", Dimension.zza(i, f));
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundColor(int i) {
        this.zzaSm.remove("maskedWalletDetailsBackgroundResource");
        this.zzaSm.putInt("maskedWalletDetailsBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsBackgroundResource(int i) {
        this.zzaSm.remove("maskedWalletDetailsBackgroundColor");
        this.zzaSm.putInt("maskedWalletDetailsBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundColor(int i) {
        this.zzaSm.remove("maskedWalletDetailsButtonBackgroundResource");
        this.zzaSm.putInt("maskedWalletDetailsButtonBackgroundColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonBackgroundResource(int i) {
        this.zzaSm.remove("maskedWalletDetailsButtonBackgroundColor");
        this.zzaSm.putInt("maskedWalletDetailsButtonBackgroundResource", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsButtonTextAppearance(int i) {
        this.zzaSm.putInt("maskedWalletDetailsButtonTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsHeaderTextAppearance(int i) {
        this.zzaSm.putInt("maskedWalletDetailsHeaderTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoImageType(int i) {
        this.zzaSm.putInt("maskedWalletDetailsLogoImageType", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsLogoTextColor(int i) {
        this.zzaSm.putInt("maskedWalletDetailsLogoTextColor", i);
        return this;
    }

    public WalletFragmentStyle setMaskedWalletDetailsTextAppearance(int i) {
        this.zzaSm.putInt("maskedWalletDetailsTextAppearance", i);
        return this;
    }

    public WalletFragmentStyle setStyleResourceId(int i) {
        this.zzaSn = i;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public int zza(String str, DisplayMetrics displayMetrics, int i) {
        return this.zzaSm.containsKey(str) ? Dimension.zza(this.zzaSm.getLong(str), displayMetrics) : i;
    }

    public void zzaL(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.zzaSn <= 0 ? R.style.WalletFragmentDefaultStyle : this.zzaSn, R.styleable.WalletFragmentStyle);
        zza(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonWidth, "buyButtonWidth");
        zza(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonHeight, "buyButtonHeight");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonText, "buyButtonText");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_buyButtonAppearance, "buyButtonAppearance");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsTextAppearance, "maskedWalletDetailsTextAppearance");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance, "maskedWalletDetailsHeaderTextAppearance");
        zza(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground, "maskedWalletDetailsBackgroundColor", "maskedWalletDetailsBackgroundResource");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance, "maskedWalletDetailsButtonTextAppearance");
        zza(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonBackground, "maskedWalletDetailsButtonBackgroundColor", "maskedWalletDetailsButtonBackgroundResource");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor, "maskedWalletDetailsLogoTextColor");
        zzb(obtainStyledAttributes, R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType, "maskedWalletDetailsLogoImageType");
        obtainStyledAttributes.recycle();
    }
}
