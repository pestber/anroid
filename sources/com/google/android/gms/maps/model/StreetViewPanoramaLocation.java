package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

/* loaded from: classes.dex */
public class StreetViewPanoramaLocation implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    public final StreetViewPanoramaLink[] links;
    public final String panoId;
    public final LatLng position;
    private final int zzCY;

    StreetViewPanoramaLocation(int i, StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.zzCY = i;
        this.links = streetViewPanoramaLinkArr;
        this.position = latLng;
        this.panoId = str;
    }

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this(1, streetViewPanoramaLinkArr, latLng, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.panoId.equals(streetViewPanoramaLocation.panoId) && this.position.equals(streetViewPanoramaLocation.position);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.position, this.panoId);
    }

    public String toString() {
        return zzt.zzt(this).zzg("panoId", this.panoId).zzg("position", this.position.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
