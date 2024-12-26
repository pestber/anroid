package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ChangesAvailableEvent implements SafeParcelable, DriveEvent {
    public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new zzb();
    final int zzCY;
    final String zzOx;
    final ChangesAvailableOptions zzadO;

    ChangesAvailableEvent(int i, String str, ChangesAvailableOptions changesAvailableOptions) {
        this.zzCY = i;
        this.zzOx = str;
        this.zzadO = changesAvailableOptions;
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
        ChangesAvailableEvent changesAvailableEvent = (ChangesAvailableEvent) obj;
        return zzt.equal(this.zzadO, changesAvailableEvent.zzadO) && zzt.equal(this.zzOx, changesAvailableEvent.zzOx);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 4;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzadO, this.zzOx);
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", this.zzadO);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
