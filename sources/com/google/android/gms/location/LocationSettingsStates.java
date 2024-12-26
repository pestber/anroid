package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public final class LocationSettingsStates implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzi();
    private final int zzCY;
    private final boolean zzayg;
    private final boolean zzayh;
    private final boolean zzayi;
    private final boolean zzayj;
    private final boolean zzayk;
    private final boolean zzayl;
    private final boolean zzaym;

    LocationSettingsStates(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.zzCY = i;
        this.zzayg = z;
        this.zzayh = z2;
        this.zzayi = z3;
        this.zzayj = z4;
        this.zzayk = z5;
        this.zzayl = z6;
        this.zzaym = z7;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean isBlePresent() {
        return this.zzayl;
    }

    public boolean isBleUsable() {
        return this.zzayi;
    }

    public boolean isGpsPresent() {
        return this.zzayj;
    }

    public boolean isGpsUsable() {
        return this.zzayg;
    }

    public boolean isLocationPresent() {
        return this.zzayj || this.zzayk;
    }

    public boolean isLocationUsable() {
        return this.zzayg || this.zzayh;
    }

    public boolean isNetworkLocationPresent() {
        return this.zzayk;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzayh;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public boolean zzus() {
        return this.zzaym;
    }
}
