package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

/* loaded from: classes.dex */
public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final LatLng northeast;
    public final LatLng southwest;
    private final int zzCY;

    public static final class Builder {
        private double zzaDn = Double.POSITIVE_INFINITY;
        private double zzaDo = Double.NEGATIVE_INFINITY;
        private double zzaDp = Double.NaN;
        private double zzaDq = Double.NaN;

        private boolean zzg(double d) {
            double d2 = this.zzaDp;
            double d3 = this.zzaDq;
            double d4 = this.zzaDp;
            return d2 <= d3 ? d4 <= d && d <= this.zzaDq : d4 <= d || d <= this.zzaDq;
        }

        public LatLngBounds build() {
            zzu.zza(!Double.isNaN(this.zzaDp), "no included points");
            return new LatLngBounds(new LatLng(this.zzaDn, this.zzaDp), new LatLng(this.zzaDo, this.zzaDq));
        }

        public Builder include(LatLng latLng) {
            this.zzaDn = Math.min(this.zzaDn, latLng.latitude);
            this.zzaDo = Math.max(this.zzaDo, latLng.latitude);
            double d = latLng.longitude;
            if (!Double.isNaN(this.zzaDp)) {
                if (!zzg(d)) {
                    if (LatLngBounds.zzb(this.zzaDp, d) < LatLngBounds.zzc(this.zzaDq, d)) {
                        this.zzaDp = d;
                    }
                }
                return this;
            }
            this.zzaDp = d;
            this.zzaDq = d;
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        zzu.zzb(latLng, "null southwest");
        zzu.zzb(latLng2, "null northeast");
        zzu.zzb(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.zzCY = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double zzb(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double zzc(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean zzf(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean zzg(double d) {
        return this.southwest.longitude <= this.northeast.longitude ? this.southwest.longitude <= d && d <= this.northeast.longitude : this.southwest.longitude <= d || d <= this.northeast.longitude;
    }

    public boolean contains(LatLng latLng) {
        return zzf(latLng.latitude) && zzg(latLng.longitude);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        if (d3 > d2) {
            d2 += 360.0d;
        }
        return new LatLng(d, (d2 + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (!zzg(d3)) {
            if (zzb(d2, d3) < zzc(d, d3)) {
                d2 = d3;
            } else {
                d = d3;
            }
        }
        return new LatLngBounds(new LatLng(min, d2), new LatLng(max, d));
    }

    public String toString() {
        return zzt.zzt(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
