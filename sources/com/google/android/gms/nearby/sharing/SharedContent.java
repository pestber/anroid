package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SharedContent implements SafeParcelable {
    public static final Parcelable.Creator<SharedContent> CREATOR = new zzc();
    private final int versionCode;

    @Deprecated
    private String zzaGl;
    private ViewableItem[] zzaGm;
    private LocalContent[] zzaGn;

    private SharedContent() {
        this.versionCode = 2;
    }

    SharedContent(int i, String str, ViewableItem[] viewableItemArr, LocalContent[] localContentArr) {
        this.versionCode = i;
        this.zzaGl = str;
        this.zzaGm = viewableItemArr;
        this.zzaGn = localContentArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) obj;
        return zzt.equal(this.zzaGm, sharedContent.zzaGm) && zzt.equal(this.zzaGn, sharedContent.zzaGn) && zzt.equal(this.zzaGl, sharedContent.zzaGl);
    }

    public String getUri() {
        return this.zzaGl;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaGm, this.zzaGn, this.zzaGl);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.zzaGm) + ", localContents=" + Arrays.toString(this.zzaGn) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public ViewableItem[] zzxe() {
        return this.zzaGm;
    }

    public LocalContent[] zzxf() {
        return this.zzaGn;
    }
}
