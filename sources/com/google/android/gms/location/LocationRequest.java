package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import android.support.v7.internal.widget.ActivityChooserView;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.quest.Quests;

/* loaded from: classes.dex */
public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int zzCY;
    boolean zzamB;
    long zzaxU;
    long zzaxV;
    int zzaxW;
    float zzaxX;
    long zzaxY;
    long zzaxz;

    public LocationRequest() {
        this.zzCY = 1;
        this.mPriority = 102;
        this.zzaxU = 3600000L;
        this.zzaxV = 600000L;
        this.zzamB = false;
        this.zzaxz = Long.MAX_VALUE;
        this.zzaxW = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.zzaxX = 0.0f;
        this.zzaxY = 0L;
    }

    LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.zzCY = i;
        this.mPriority = i2;
        this.zzaxU = j;
        this.zzaxV = j2;
        this.zzamB = z;
        this.zzaxz = j3;
        this.zzaxW = i3;
        this.zzaxX = f;
        this.zzaxY = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzK(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzgu(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /* 104 */:
            case PRIORITY_NO_POWER /* 105 */:
                return;
            case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
            case Quests.SELECT_RECENTLY_FAILED /* 103 */:
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzgv(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case Quests.SELECT_COMPLETED_UNCLAIMED /* 101 */:
            case Quests.SELECT_RECENTLY_FAILED /* 103 */:
            default:
                return "???";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /* 104 */:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /* 105 */:
                return "PRIORITY_NO_POWER";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.zzaxU == locationRequest.zzaxU && this.zzaxV == locationRequest.zzaxV && this.zzamB == locationRequest.zzamB && this.zzaxz == locationRequest.zzaxz && this.zzaxW == locationRequest.zzaxW && this.zzaxX == locationRequest.zzaxX;
    }

    public long getExpirationTime() {
        return this.zzaxz;
    }

    public long getFastestInterval() {
        return this.zzaxV;
    }

    public long getInterval() {
        return this.zzaxU;
    }

    public long getMaxWaitTime() {
        long j = this.zzaxY;
        return j < this.zzaxU ? this.zzaxU : j;
    }

    public int getNumUpdates() {
        return this.zzaxW;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaxX;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaxU), Long.valueOf(this.zzaxV), Boolean.valueOf(this.zzamB), Long.valueOf(this.zzaxz), Integer.valueOf(this.zzaxW), Float.valueOf(this.zzaxX));
    }

    public LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaxz = Long.MAX_VALUE;
        } else {
            this.zzaxz = elapsedRealtime + j;
        }
        if (this.zzaxz < 0) {
            this.zzaxz = 0L;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long j) {
        this.zzaxz = j;
        if (this.zzaxz < 0) {
            this.zzaxz = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long j) {
        zzK(j);
        this.zzamB = true;
        this.zzaxV = j;
        return this;
    }

    public LocationRequest setInterval(long j) {
        zzK(j);
        this.zzaxU = j;
        if (!this.zzamB) {
            this.zzaxV = (long) (this.zzaxU / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long j) {
        zzK(j);
        this.zzaxY = j;
        return this;
    }

    public LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.zzaxW = i;
        return this;
    }

    public LocationRequest setPriority(int i) {
        zzgu(i);
        this.mPriority = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f) {
        zzd(f);
        this.zzaxX = f;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(zzgv(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaxU + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzaxV + "ms");
        if (this.zzaxY > this.zzaxU) {
            sb.append(" maxWait=");
            sb.append(this.zzaxY + "ms");
        }
        if (this.zzaxz != Long.MAX_VALUE) {
            long elapsedRealtime = this.zzaxz - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.zzaxW != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzaxW);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.zza(this, parcel, i);
    }
}
