package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.media.MediaRouter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class Permission implements SafeParcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new zzh();
    final int zzCY;
    private int zzadA;
    private String zzadB;
    private String zzadC;
    private int zzadD;
    private boolean zzadE;
    private String zzadz;

    Permission(int i, String str, int i2, String str2, String str3, int i3, boolean z) {
        this.zzCY = i;
        this.zzadz = str;
        this.zzadA = i2;
        this.zzadB = str2;
        this.zzadC = str3;
        this.zzadD = i3;
        this.zzadE = z;
    }

    public static boolean zzbZ(int i) {
        switch (i) {
            case 256:
            case 257:
            case MediaRouter.GlobalMediaRouter.CallbackHandler.MSG_ROUTE_REMOVED /* 258 */:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzca(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Permission permission = (Permission) obj;
        return zzt.equal(this.zzadz, permission.zzadz) && this.zzadA == permission.zzadA && this.zzadD == permission.zzadD && this.zzadE == permission.zzadE;
    }

    public int getRole() {
        if (zzca(this.zzadD)) {
            return this.zzadD;
        }
        return -1;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzadz, Integer.valueOf(this.zzadA), Integer.valueOf(this.zzadD), Boolean.valueOf(this.zzadE));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    public String zzpo() {
        if (zzbZ(this.zzadA)) {
            return this.zzadz;
        }
        return null;
    }

    public int zzpp() {
        if (zzbZ(this.zzadA)) {
            return this.zzadA;
        }
        return -1;
    }

    public String zzpq() {
        return this.zzadB;
    }

    public String zzpr() {
        return this.zzadC;
    }

    public boolean zzps() {
        return this.zzadE;
    }
}
