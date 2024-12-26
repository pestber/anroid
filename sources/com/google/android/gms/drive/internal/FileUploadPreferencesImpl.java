package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;

/* loaded from: classes.dex */
public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
    public static final Parcelable.Creator<FileUploadPreferencesImpl> CREATOR = new zzae();
    final int zzCY;
    int zzafG;
    int zzafH;
    boolean zzafI;

    FileUploadPreferencesImpl(int i, int i2, int i3, boolean z) {
        this.zzCY = i;
        this.zzafG = i2;
        this.zzafH = i3;
        this.zzafI = z;
    }

    public static boolean zzcD(int i) {
        switch (i) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcE(int i) {
        switch (i) {
            case 256:
            case 257:
                return true;
            default:
                return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public int getBatteryUsagePreference() {
        if (zzcE(this.zzafH)) {
            return this.zzafH;
        }
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public int getNetworkTypePreference() {
        if (zzcD(this.zzafG)) {
            return this.zzafG;
        }
        return 0;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public boolean isRoamingAllowed() {
        return this.zzafI;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public void setBatteryUsagePreference(int i) {
        if (!zzcE(i)) {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        }
        this.zzafH = i;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public void setNetworkTypePreference(int i) {
        if (!zzcD(i)) {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        }
        this.zzafG = i;
    }

    @Override // com.google.android.gms.drive.FileUploadPreferences
    public void setRoamingAllowed(boolean z) {
        this.zzafI = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }
}
