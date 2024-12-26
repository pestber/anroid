package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants;

/* loaded from: classes.dex */
public final class UserAddress implements SafeParcelable {
    public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();
    String name;
    private final int zzCY;
    String zzEr;
    String zzawA;
    String zzawB;
    String zzawC;
    String zzawD;
    String zzawE;
    String zzawF;
    String zzawG;
    String zzawH;
    String zzawI;
    String zzawJ;
    boolean zzawK;
    String zzawL;
    String zzawM;

    UserAddress() {
        this.zzCY = 1;
    }

    UserAddress(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14) {
        this.zzCY = i;
        this.name = str;
        this.zzawA = str2;
        this.zzawB = str3;
        this.zzawC = str4;
        this.zzawD = str5;
        this.zzawE = str6;
        this.zzawF = str7;
        this.zzawG = str8;
        this.zzEr = str9;
        this.zzawH = str10;
        this.zzawI = str11;
        this.zzawJ = str12;
        this.zzawK = z;
        this.zzawL = str13;
        this.zzawM = str14;
    }

    public static UserAddress fromIntent(Intent intent) {
        if (intent == null || !intent.hasExtra(AddressConstants.Extras.EXTRA_ADDRESS)) {
            return null;
        }
        return (UserAddress) intent.getParcelableExtra(AddressConstants.Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.zzawD;
    }

    public String getAddress5() {
        return this.zzawE;
    }

    public String getAdministrativeArea() {
        return this.zzawF;
    }

    public String getCompanyName() {
        return this.zzawL;
    }

    public String getCountryCode() {
        return this.zzEr;
    }

    public String getEmailAddress() {
        return this.zzawM;
    }

    public String getLocality() {
        return this.zzawG;
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

    public String getSortingCode() {
        return this.zzawI;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean isPostBox() {
        return this.zzawK;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
