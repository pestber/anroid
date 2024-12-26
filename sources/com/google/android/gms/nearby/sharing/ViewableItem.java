package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ViewableItem implements SafeParcelable {
    public static final Parcelable.Creator<ViewableItem> CREATOR = new zzf();
    private final int versionCode;
    private String[] zzaGo;

    private ViewableItem() {
        this.versionCode = 1;
    }

    ViewableItem(int i, String[] strArr) {
        this.versionCode = i;
        this.zzaGo = strArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewableItem) {
            return zzt.equal(this.zzaGo, ((ViewableItem) obj).zzaGo);
        }
        return false;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaGo);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.zzaGo) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String[] zzxg() {
        return this.zzaGo;
    }
}
