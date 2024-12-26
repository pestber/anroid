package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzk();
    private final String mTag;
    final int zzCY;
    private final String zzazK;
    private final String zzazL;

    PlaceReport(int i, String str, String str2, String str3) {
        this.zzCY = i;
        this.zzazK = str;
        this.mTag = str2;
        this.zzazL = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzi(str, str2, "unknown");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static boolean zzdo(String str) {
        char c;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzu.zzcj(str);
        zzu.zzcj(str2);
        zzu.zzcj(str3);
        zzu.zzb(zzdo(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzt.equal(this.zzazK, placeReport.zzazK) && zzt.equal(this.mTag, placeReport.mTag) && zzt.equal(this.zzazL, placeReport.zzazL);
    }

    public String getPlaceId() {
        return this.zzazK;
    }

    public String getSource() {
        return this.zzazL;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzazK, this.mTag, this.zzazL);
    }

    public String toString() {
        zzt.zza zzt = zzt.zzt(this);
        zzt.zzg("placeId", this.zzazK);
        zzt.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzazL)) {
            zzt.zzg("source", this.zzazL);
        }
        return zzt.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
