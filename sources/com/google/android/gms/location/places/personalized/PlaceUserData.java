package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.location.places.personalized.internal.TestDataImpl;
import java.util.List;

/* loaded from: classes.dex */
public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int zzCY;
    private final String zzOx;
    private final List<TestDataImpl> zzaBj;
    private final List<PlaceAlias> zzaBk;
    private final List<HereContent> zzaBl;
    private final String zzazK;

    PlaceUserData(int i, String str, String str2, List<TestDataImpl> list, List<PlaceAlias> list2, List<HereContent> list3) {
        this.zzCY = i;
        this.zzOx = str;
        this.zzazK = str2;
        this.zzaBj = list;
        this.zzaBk = list2;
        this.zzaBl = list3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) obj;
        return this.zzOx.equals(placeUserData.zzOx) && this.zzazK.equals(placeUserData.zzazK) && this.zzaBj.equals(placeUserData.zzaBj) && this.zzaBk.equals(placeUserData.zzaBk) && this.zzaBl.equals(placeUserData.zzaBl);
    }

    public String getPlaceId() {
        return this.zzazK;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOx, this.zzazK, this.zzaBj, this.zzaBk, this.zzaBl);
    }

    public String toString() {
        return zzt.zzt(this).zzg("accountName", this.zzOx).zzg("placeId", this.zzazK).zzg("testDataImpls", this.zzaBj).zzg("placeAliases", this.zzaBk).zzg("hereContents", this.zzaBl).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public String zzvb() {
        return this.zzOx;
    }

    public List<PlaceAlias> zzvc() {
        return this.zzaBk;
    }

    public List<HereContent> zzvd() {
        return this.zzaBl;
    }

    public List<TestDataImpl> zzve() {
        return this.zzaBj;
    }
}
