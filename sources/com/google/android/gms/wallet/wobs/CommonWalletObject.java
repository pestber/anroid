package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CommonWalletObject implements SafeParcelable {
    public static final Parcelable.Creator<CommonWalletObject> CREATOR = new com.google.android.gms.wallet.wobs.zza();
    String name;
    int state;
    private final int zzCY;
    String zzaQN;
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
    String zzhI;

    public final class zza {
        private zza() {
        }

        public CommonWalletObject zzAO() {
            return CommonWalletObject.this;
        }

        public zza zzff(String str) {
            CommonWalletObject.this.zzhI = str;
            return this;
        }
    }

    CommonWalletObject() {
        this.zzCY = 1;
        this.zzaQU = zzkx.zzoP();
        this.zzaQW = zzkx.zzoP();
        this.zzaQZ = zzkx.zzoP();
        this.zzaRb = zzkx.zzoP();
        this.zzaRc = zzkx.zzoP();
        this.zzaRd = zzkx.zzoP();
    }

    CommonWalletObject(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, ArrayList<WalletObjectMessage> arrayList, TimeInterval timeInterval, ArrayList<LatLng> arrayList2, String str9, String str10, ArrayList<LabelValueRow> arrayList3, boolean z, ArrayList<UriData> arrayList4, ArrayList<TextModuleData> arrayList5, ArrayList<UriData> arrayList6) {
        this.zzCY = i;
        this.zzhI = str;
        this.zzaQT = str2;
        this.name = str3;
        this.zzaQN = str4;
        this.zzaQP = str5;
        this.zzaQQ = str6;
        this.zzaQR = str7;
        this.zzaQS = str8;
        this.state = i2;
        this.zzaQU = arrayList;
        this.zzaQV = timeInterval;
        this.zzaQW = arrayList2;
        this.zzaQX = str9;
        this.zzaQY = str10;
        this.zzaQZ = arrayList3;
        this.zzaRa = z;
        this.zzaRb = arrayList4;
        this.zzaRc = arrayList5;
        this.zzaRd = arrayList6;
    }

    public static zza zzAN() {
        CommonWalletObject commonWalletObject = new CommonWalletObject();
        commonWalletObject.getClass();
        return new zza();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzhI;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        com.google.android.gms.wallet.wobs.zza.zza(this, parcel, i);
    }
}
