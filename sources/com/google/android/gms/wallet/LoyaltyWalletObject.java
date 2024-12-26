package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<LoyaltyWalletObject> CREATOR = new zzj();
    int state;
    private final int zzCY;
    String zzaBb;
    String zzaQM;
    String zzaQN;
    String zzaQO;
    String zzaQP;
    String zzaQQ;
    String zzaQR;
    String zzaQS;
    String zzaQT;
    ArrayList<WalletObjectMessage> zzaQU;
    TimeInterval zzaQV;
    ArrayList<LatLng> zzaQW;
    String zzaQX;
    String zzaQY;
    ArrayList<LabelValueRow> zzaQZ;
    boolean zzaRa;
    ArrayList<UriData> zzaRb;
    ArrayList<TextModuleData> zzaRc;
    ArrayList<UriData> zzaRd;
    LoyaltyPoints zzaRe;
    String zzhI;

    LoyaltyWalletObject() {
        this.zzCY = 4;
        this.zzaQU = zzkx.zzoP();
        this.zzaQW = zzkx.zzoP();
        this.zzaQZ = zzkx.zzoP();
        this.zzaRb = zzkx.zzoP();
        this.zzaRc = zzkx.zzoP();
        this.zzaRd = zzkx.zzoP();
    }

    LoyaltyWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i2, ArrayList<WalletObjectMessage> arrayList, TimeInterval timeInterval, ArrayList<LatLng> arrayList2, String str11, String str12, ArrayList<LabelValueRow> arrayList3, boolean z, ArrayList<UriData> arrayList4, ArrayList<TextModuleData> arrayList5, ArrayList<UriData> arrayList6, LoyaltyPoints loyaltyPoints) {
        this.zzCY = i;
        this.zzhI = str;
        this.zzaQM = str2;
        this.zzaQN = str3;
        this.zzaQO = str4;
        this.zzaBb = str5;
        this.zzaQP = str6;
        this.zzaQQ = str7;
        this.zzaQR = str8;
        this.zzaQS = str9;
        this.zzaQT = str10;
        this.state = i2;
        this.zzaQU = arrayList;
        this.zzaQV = timeInterval;
        this.zzaQW = arrayList2;
        this.zzaQX = str11;
        this.zzaQY = str12;
        this.zzaQZ = arrayList3;
        this.zzaRa = z;
        this.zzaRb = arrayList4;
        this.zzaRc = arrayList5;
        this.zzaRd = arrayList6;
        this.zzaRe = loyaltyPoints;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.zzaQM;
    }

    public String getAccountName() {
        return this.zzaBb;
    }

    public String getBarcodeAlternateText() {
        return this.zzaQP;
    }

    public String getBarcodeType() {
        return this.zzaQQ;
    }

    public String getBarcodeValue() {
        return this.zzaQR;
    }

    public String getId() {
        return this.zzhI;
    }

    public String getIssuerName() {
        return this.zzaQN;
    }

    public String getProgramName() {
        return this.zzaQO;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
