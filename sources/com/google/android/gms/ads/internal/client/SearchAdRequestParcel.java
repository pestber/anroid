package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;

@zzgd
/* loaded from: classes.dex */
public final class SearchAdRequestParcel implements SafeParcelable {
    public static final zzae CREATOR = new zzae();
    public final int backgroundColor;
    public final int versionCode;
    public final int zzth;
    public final int zzti;
    public final int zztj;
    public final int zztk;
    public final int zztl;
    public final int zztm;
    public final int zztn;
    public final String zzto;
    public final int zztp;
    public final String zztq;
    public final int zztr;
    public final int zzts;
    public final String zztt;

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.zzth = i2;
        this.backgroundColor = i3;
        this.zzti = i4;
        this.zztj = i5;
        this.zztk = i6;
        this.zztl = i7;
        this.zztm = i8;
        this.zztn = i9;
        this.zzto = str;
        this.zztp = i10;
        this.zztq = str2;
        this.zztr = i11;
        this.zzts = i12;
        this.zztt = str3;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.zzth = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zzti = searchAdRequest.getBackgroundGradientBottom();
        this.zztj = searchAdRequest.getBackgroundGradientTop();
        this.zztk = searchAdRequest.getBorderColor();
        this.zztl = searchAdRequest.getBorderThickness();
        this.zztm = searchAdRequest.getBorderType();
        this.zztn = searchAdRequest.getCallButtonColor();
        this.zzto = searchAdRequest.getCustomChannels();
        this.zztp = searchAdRequest.getDescriptionTextColor();
        this.zztq = searchAdRequest.getFontFace();
        this.zztr = searchAdRequest.getHeaderTextColor();
        this.zzts = searchAdRequest.getHeaderTextSize();
        this.zztt = searchAdRequest.getQuery();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }
}
