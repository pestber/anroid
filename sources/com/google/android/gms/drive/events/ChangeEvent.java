package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Parcelable.Creator<ChangeEvent> CREATOR = new zza();
    final int zzCY;
    final DriveId zzacT;
    final int zzadN;

    ChangeEvent(int i, DriveId driveId, int i2) {
        this.zzCY = i;
        this.zzacT = driveId;
        this.zzadN = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.events.ResourceEvent
    public DriveId getDriveId() {
        return this.zzacT;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzadN & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzadN & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzadN & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", this.zzacT, Integer.valueOf(this.zzadN));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
