package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class AncsNotificationParcelable implements SafeParcelable, com.google.android.gms.wearable.zzb {
    public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zze();
    private int mId;
    final int zzCY;
    private final String zzRx;
    private final String zzaEw;
    private final String zzaTu;
    private byte zzaTv;
    private byte zzaTw;
    private byte zzaTx;
    private byte zzaTy;
    private String zzadI;
    private final String zzadv;
    private final String zzaox;

    AncsNotificationParcelable(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, byte b, byte b2, byte b3, byte b4) {
        this.mId = i2;
        this.zzCY = i;
        this.zzaEw = str;
        this.zzaTu = str2;
        this.zzRx = str3;
        this.zzadv = str4;
        this.zzaox = str5;
        this.zzadI = str6;
        this.zzaTv = b;
        this.zzaTw = b2;
        this.zzaTx = b3;
        this.zzaTy = b4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) obj;
        if (this.zzaTy != ancsNotificationParcelable.zzaTy || this.zzaTx != ancsNotificationParcelable.zzaTx || this.zzaTw != ancsNotificationParcelable.zzaTw || this.zzaTv != ancsNotificationParcelable.zzaTv || this.mId != ancsNotificationParcelable.mId || this.zzCY != ancsNotificationParcelable.zzCY || !this.zzaEw.equals(ancsNotificationParcelable.zzaEw)) {
            return false;
        }
        if (this.zzaTu == null ? ancsNotificationParcelable.zzaTu == null : this.zzaTu.equals(ancsNotificationParcelable.zzaTu)) {
            return this.zzadI.equals(ancsNotificationParcelable.zzadI) && this.zzRx.equals(ancsNotificationParcelable.zzRx) && this.zzaox.equals(ancsNotificationParcelable.zzaox) && this.zzadv.equals(ancsNotificationParcelable.zzadv);
        }
        return false;
    }

    public String getDisplayName() {
        return this.zzadI == null ? this.zzaEw : this.zzadI;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.zzadv;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.zzCY * 31) + this.mId) * 31) + this.zzaEw.hashCode()) * 31) + (this.zzaTu != null ? this.zzaTu.hashCode() : 0)) * 31) + this.zzRx.hashCode()) * 31) + this.zzadv.hashCode()) * 31) + this.zzaox.hashCode()) * 31) + this.zzadI.hashCode()) * 31) + this.zzaTv) * 31) + this.zzaTw) * 31) + this.zzaTx) * 31) + this.zzaTy;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.zzCY + ", mId=" + this.mId + ", mAppId='" + this.zzaEw + "', mDateTime='" + this.zzaTu + "', mNotificationText='" + this.zzRx + "', mTitle='" + this.zzadv + "', mSubtitle='" + this.zzaox + "', mDisplayName='" + this.zzadI + "', mEventId=" + ((int) this.zzaTv) + ", mEventFlags=" + ((int) this.zzaTw) + ", mCategoryId=" + ((int) this.zzaTx) + ", mCategoryCount=" + ((int) this.zzaTy) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public String zzAU() {
        return this.zzaTu;
    }

    public String zzAV() {
        return this.zzRx;
    }

    public byte zzAW() {
        return this.zzaTv;
    }

    public byte zzAX() {
        return this.zzaTw;
    }

    public byte zzAY() {
        return this.zzaTx;
    }

    public byte zzAZ() {
        return this.zzaTy;
    }

    public String zzsK() {
        return this.zzaEw;
    }

    public String zzsb() {
        return this.zzaox;
    }
}
