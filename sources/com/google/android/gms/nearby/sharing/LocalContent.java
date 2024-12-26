package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class LocalContent implements SafeParcelable {
    public static final Parcelable.Creator<LocalContent> CREATOR = new zzb();
    private int type;
    private final int versionCode;
    private String zzaGk;

    private LocalContent() {
        this.versionCode = 1;
    }

    LocalContent(int i, int i2, String str) {
        this.versionCode = i;
        this.type = i2;
        this.zzaGk = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LocalContent)) {
            return false;
        }
        LocalContent localContent = (LocalContent) obj;
        return zzt.equal(Integer.valueOf(this.type), Integer.valueOf(localContent.type)) && zzt.equal(this.zzaGk, localContent.zzaGk);
    }

    public int getType() {
        return this.type;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.type), this.zzaGk);
    }

    public String toString() {
        return "LocalContent[contentUri=" + this.zzaGk + ", type=" + (this.type == 1 ? "PUBLIC_CONTENT" : "APP_CONTENT") + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public String zzxd() {
        return this.zzaGk;
    }
}
