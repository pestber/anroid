package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GeofencingRequest implements SafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zza();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    private final int zzCY;
    private final List<ParcelableGeofence> zzaxJ;
    private final int zzaxK;

    public static final class Builder {
        private final List<ParcelableGeofence> zzaxJ = new ArrayList();
        private int zzaxK = 5;

        public static int zzgr(int i) {
            return i & 7;
        }

        public Builder addGeofence(Geofence geofence) {
            zzu.zzb(geofence, "geofence can't be null.");
            zzu.zzb(geofence instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            this.zzaxJ.add((ParcelableGeofence) geofence);
            return this;
        }

        public Builder addGeofences(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence geofence : list) {
                    if (geofence != null) {
                        addGeofence(geofence);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest build() {
            zzu.zzb(!this.zzaxJ.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzaxJ, this.zzaxK);
        }

        public Builder setInitialTrigger(int i) {
            this.zzaxK = zzgr(i);
            return this;
        }
    }

    GeofencingRequest(int i, List<ParcelableGeofence> list, int i2) {
        this.zzCY = i;
        this.zzaxJ = list;
        this.zzaxK = i2;
    }

    private GeofencingRequest(List<ParcelableGeofence> list, int i) {
        this(1, list, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzaxJ);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaxK;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public List<ParcelableGeofence> zzun() {
        return this.zzaxJ;
    }
}
