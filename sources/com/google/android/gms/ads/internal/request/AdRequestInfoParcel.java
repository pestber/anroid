package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;
import java.util.Collections;
import java.util.List;

@zzgd
/* loaded from: classes.dex */
public final class AdRequestInfoParcel implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final boolean zzCA;
    public final int zzCB;
    public final String zzCC;
    public final long zzCD;
    public final String zzCE;
    public final List<String> zzCF;
    public final List<String> zzCG;
    public final Bundle zzCl;
    public final AdRequestParcel zzCm;
    public final PackageInfo zzCn;
    public final String zzCo;
    public final String zzCp;
    public final String zzCq;
    public final Bundle zzCr;
    public final int zzCs;
    public final Bundle zzCt;
    public final boolean zzCu;
    public final Messenger zzCv;
    public final int zzCw;
    public final int zzCx;
    public final float zzCy;
    public final String zzCz;
    public final String zzpF;
    public final String zzpG;
    public final VersionInfoParcel zzpJ;
    public final AdSizeParcel zzpN;
    public final NativeAdOptionsParcel zzqb;
    public final List<String> zzqd;

    @zzgd
    public static final class zza {
        public final ApplicationInfo applicationInfo;
        public final boolean zzCA;
        public final int zzCB;
        public final long zzCD;
        public final String zzCE;
        public final List<String> zzCF;
        public final List<String> zzCG;
        public final Bundle zzCl;
        public final AdRequestParcel zzCm;
        public final PackageInfo zzCn;
        public final String zzCp;
        public final String zzCq;
        public final Bundle zzCr;
        public final int zzCs;
        public final Bundle zzCt;
        public final boolean zzCu;
        public final Messenger zzCv;
        public final int zzCw;
        public final int zzCx;
        public final float zzCy;
        public final String zzCz;
        public final String zzpF;
        public final String zzpG;
        public final VersionInfoParcel zzpJ;
        public final AdSizeParcel zzpN;
        public final NativeAdOptionsParcel zzqb;
        public final List<String> zzqd;

        public zza(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, VersionInfoParcel versionInfoParcel, Bundle bundle2, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i, int i2, float f, String str4, boolean z2, int i3, long j, String str5, List<String> list3, String str6, NativeAdOptionsParcel nativeAdOptionsParcel) {
            List<String> list4;
            this.zzCl = bundle;
            this.zzCm = adRequestParcel;
            this.zzpN = adSizeParcel;
            this.zzpG = str;
            this.applicationInfo = applicationInfo;
            this.zzCn = packageInfo;
            this.zzCp = str2;
            this.zzCq = str3;
            this.zzpJ = versionInfoParcel;
            this.zzCr = bundle2;
            this.zzCu = z;
            this.zzCv = messenger;
            this.zzCw = i;
            this.zzCx = i2;
            this.zzCy = f;
            if (list == null || list.size() <= 0) {
                this.zzCs = 0;
                list4 = null;
                this.zzqd = null;
            } else {
                this.zzCs = 3;
                this.zzqd = list;
                list4 = list2;
            }
            this.zzCG = list4;
            this.zzCt = bundle3;
            this.zzCz = str4;
            this.zzCA = z2;
            this.zzCB = i3;
            this.zzCD = j;
            this.zzCE = str5;
            this.zzCF = list3;
            this.zzpF = str6;
            this.zzqb = nativeAdOptionsParcel;
        }
    }

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, Messenger messenger, int i3, int i4, float f, String str5, boolean z2, int i5, String str6, long j, String str7, List<String> list2, String str8, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list3) {
        this.versionCode = i;
        this.zzCl = bundle;
        this.zzCm = adRequestParcel;
        this.zzpN = adSizeParcel;
        this.zzpG = str;
        this.applicationInfo = applicationInfo;
        this.zzCn = packageInfo;
        this.zzCo = str2;
        this.zzCp = str3;
        this.zzCq = str4;
        this.zzpJ = versionInfoParcel;
        this.zzCr = bundle2;
        this.zzCs = i2;
        this.zzqd = list;
        this.zzCG = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzCt = bundle3;
        this.zzCu = z;
        this.zzCv = messenger;
        this.zzCw = i3;
        this.zzCx = i4;
        this.zzCy = f;
        this.zzCz = str5;
        this.zzCA = z2;
        this.zzCB = i5;
        this.zzCC = str6;
        this.zzCD = j;
        this.zzCE = str7;
        this.zzCF = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzpF = str8;
        this.zzqb = nativeAdOptionsParcel;
    }

    public AdRequestInfoParcel(Bundle bundle, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, Messenger messenger, int i2, int i3, float f, String str5, boolean z2, int i4, String str6, long j, String str7, List<String> list3, String str8, NativeAdOptionsParcel nativeAdOptionsParcel) {
        this(10, bundle, adRequestParcel, adSizeParcel, str, applicationInfo, packageInfo, str2, str3, str4, versionInfoParcel, bundle2, i, list, bundle3, z, messenger, i2, i3, f, str5, z2, i4, str6, j, str7, list3, str8, nativeAdOptionsParcel, list2);
    }

    public AdRequestInfoParcel(zza zzaVar, String str, String str2) {
        this(zzaVar.zzCl, zzaVar.zzCm, zzaVar.zzpN, zzaVar.zzpG, zzaVar.applicationInfo, zzaVar.zzCn, str, zzaVar.zzCp, zzaVar.zzCq, zzaVar.zzpJ, zzaVar.zzCr, zzaVar.zzCs, zzaVar.zzqd, zzaVar.zzCG, zzaVar.zzCt, zzaVar.zzCu, zzaVar.zzCv, zzaVar.zzCw, zzaVar.zzCx, zzaVar.zzCy, zzaVar.zzCz, zzaVar.zzCA, zzaVar.zzCB, str2, zzaVar.zzCD, zzaVar.zzCE, zzaVar.zzCF, zzaVar.zzpF, zzaVar.zzqb);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
