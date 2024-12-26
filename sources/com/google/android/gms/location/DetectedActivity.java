package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

/* loaded from: classes.dex */
public class DetectedActivity implements SafeParcelable {
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    private final int zzCY;
    int zzaxw;
    int zzaxx;
    public static final Comparator<DetectedActivity> zzaxv = new Comparator<DetectedActivity>() { // from class: com.google.android.gms.location.DetectedActivity.1
        @Override // java.util.Comparator
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }
    };
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();

    public DetectedActivity(int i, int i2) {
        this.zzCY = 1;
        this.zzaxw = i;
        this.zzaxx = i2;
    }

    public DetectedActivity(int i, int i2, int i3) {
        this.zzCY = i;
        this.zzaxw = i2;
        this.zzaxx = i3;
    }

    private int zzgp(int i) {
        if (i > 15) {
            return 4;
        }
        return i;
    }

    public static String zzgq(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 6:
            default:
                return Integer.toString(i);
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.zzaxx;
    }

    public int getType() {
        return zzgp(this.zzaxw);
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return "DetectedActivity [type=" + zzgq(getType()) + ", confidence=" + this.zzaxx + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        DetectedActivityCreator.zza(this, parcel, i);
    }
}
