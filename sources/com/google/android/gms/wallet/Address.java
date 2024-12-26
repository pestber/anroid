package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
/* loaded from: classes.dex */
public final class Address implements SafeParcelable {
    public static final Parcelable.Creator<Address> CREATOR = new zza();
    String name;
    private final int zzCY;
    String zzEr;
    String zzaQd;
    String zzaQe;
    String zzawA;
    String zzawB;
    String zzawC;
    String zzawH;
    String zzawJ;
    boolean zzawK;
    String zzawL;

    Address() {
        this.zzCY = 1;
    }

    Address(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.zzCY = i;
        this.name = str;
        this.zzawA = str2;
        this.zzawB = str3;
        this.zzawC = str4;
        this.zzEr = str5;
        this.zzaQd = str6;
        this.zzaQe = str7;
        this.zzawH = str8;
        this.zzawJ = str9;
        this.zzawK = z;
        this.zzawL = str10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzawA;
    }

    public String getAddress2() {
        return this.zzawB;
    }

    public String getAddress3() {
        return this.zzawC;
    }

    public String getCity() {
        return this.zzaQd;
    }

    public String getCompanyName() {
        return this.zzawL;
    }

    public String getCountryCode() {
        return this.zzEr;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.zzawJ;
    }

    public String getPostalCode() {
        return this.zzawH;
    }

    public String getState() {
        return this.zzaQe;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean isPostBox() {
        return this.zzawK;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
