package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LocationSettingsRequest implements SafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzg();
    private final int zzCY;
    private final List<LocationRequest> zzamw;
    private final boolean zzayb;
    private final boolean zzayc;
    private final boolean zzayd;

    public static final class Builder {
        private final ArrayList<LocationRequest> zzaye = new ArrayList<>();
        private boolean zzayb = false;
        private boolean zzayc = false;
        private boolean zzayd = false;

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.zzaye.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.zzaye.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzaye, this.zzayb, this.zzayc, this.zzayd);
        }

        public Builder setAlwaysShow(boolean z) {
            this.zzayb = z;
            return this;
        }

        public Builder setNeedBle(boolean z) {
            this.zzayc = z;
            return this;
        }
    }

    LocationSettingsRequest(int i, List<LocationRequest> list, boolean z, boolean z2, boolean z3) {
        this.zzCY = i;
        this.zzamw = list;
        this.zzayb = z;
        this.zzayc = z2;
        this.zzayd = z3;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, boolean z3) {
        this(2, list, z, z2, z3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public List<LocationRequest> zzrj() {
        return Collections.unmodifiableList(this.zzamw);
    }

    public boolean zzup() {
        return this.zzayb;
    }

    public boolean zzuq() {
        return this.zzayc;
    }

    public boolean zzur() {
        return this.zzayd;
    }
}
