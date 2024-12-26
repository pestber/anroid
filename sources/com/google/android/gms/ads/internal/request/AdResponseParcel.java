package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;
import java.util.Collections;
import java.util.List;

@zzgd
/* loaded from: classes.dex */
public final class AdResponseParcel implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public String zzCI;
    public final long zzCJ;
    public final boolean zzCK;
    public final long zzCL;
    public final List<String> zzCM;
    public final String zzCN;
    public final long zzCO;
    public final String zzCP;
    public final boolean zzCQ;
    public final String zzCR;
    public final String zzCS;
    public final boolean zzCT;
    public final boolean zzCU;
    public final boolean zzCV;
    public final int zzCW;
    public LargeParcelTeleporter zzCX;
    public final boolean zzCu;
    public final boolean zzsp;
    public final List<String> zzxF;
    public final List<String> zzxG;
    public final long zzxJ;
    private AdRequestInfoParcel zzxm;
    public final String zzzG;

    public AdResponseParcel(int i) {
        this(12, null, null, null, i, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null);
    }

    public AdResponseParcel(int i, long j) {
        this(12, null, null, null, i, null, -1L, false, -1L, null, j, -1, null, -1L, null, false, null, null, false, false, false, true, false, 0, null);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, LargeParcelTeleporter largeParcelTeleporter) {
        StringParcel stringParcel;
        this.versionCode = i;
        this.zzzG = str;
        this.zzCI = str2;
        this.zzxF = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzxG = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzCJ = j;
        this.zzCK = z;
        this.zzCL = j2;
        this.zzCM = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzxJ = j3;
        this.orientation = i3;
        this.zzCN = str3;
        this.zzCO = j4;
        this.zzCP = str4;
        this.zzCQ = z2;
        this.zzCR = str5;
        this.zzCS = str6;
        this.zzCT = z3;
        this.zzsp = z4;
        this.zzCu = z5;
        this.zzCU = z6;
        this.zzCV = z7;
        this.zzCW = i4;
        this.zzCX = largeParcelTeleporter;
        if (this.zzCI != null || this.zzCX == null || (stringParcel = (StringParcel) this.zzCX.zza(StringParcel.CREATOR)) == null || TextUtils.isEmpty(stringParcel.zzfB())) {
            return;
        }
        this.zzCI = stringParcel.zzfB();
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2) {
        this(12, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, z6, i2, null);
        this.zzxm = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i2) {
        this(12, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i2, null);
        this.zzxm = adRequestInfoParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzxm != null && this.zzxm.versionCode >= 9 && !TextUtils.isEmpty(this.zzCI) && this.zzCI.length() > 76800) {
            this.zzCX = new LargeParcelTeleporter(new StringParcel(this.zzCI));
            this.zzCI = null;
        }
        zzh.zza(this, parcel, i);
    }
}
