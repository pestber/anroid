package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes.dex */
public final class ProgressEvent implements DriveEvent {
    public static final Parcelable.Creator<ProgressEvent> CREATOR = new zzh();
    final int zzCY;
    final int zzSq;
    final DriveId zzacT;
    final long zzaeg;
    final long zzaeh;
    final int zzwS;

    ProgressEvent(int i, DriveId driveId, int i2, long j, long j2, int i3) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzwS = i2;
        this.zzaeg = j;
        this.zzaeh = j2;
        this.zzSq = i3;
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
        ProgressEvent progressEvent = (ProgressEvent) obj;
        return zzt.equal(this.zzacT, progressEvent.zzacT) && this.zzwS == progressEvent.zzwS && this.zzaeg == progressEvent.zzaeg && this.zzaeh == progressEvent.zzaeh;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return this.zzSq;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzacT, Integer.valueOf(this.zzwS), Long.valueOf(this.zzaeg), Long.valueOf(this.zzaeh));
    }

    public String toString() {
        return String.format("ProgressEvent[DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", this.zzacT, Integer.valueOf(this.zzwS), Long.valueOf(this.zzaeg), Long.valueOf(this.zzaeh));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
